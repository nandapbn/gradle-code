package reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public class Sample {

    @Table(name = "Jedi")
    static class Jedi {
        @Column(name = "Kodi")
        String attackType;

        public String getAttackType() {
            return attackType;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Table {
        String name();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Column {
        String name();
    }

    public static void main(String[] args) {
        System.out.println(Jedi.class.getAnnotation(Table.class).name());
        // System.out.println(Jedi.class.getAnnotation(Column.class).name());

        Arrays.stream(Jedi.class.getDeclaredFields())
                .forEach(field -> {
                    if (field.getName().equals("attackType")) {
                        System.out.println(field.getAnnotation(Column.class).name());
                    }
                });
    }
}