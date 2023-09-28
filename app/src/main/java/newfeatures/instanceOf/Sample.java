package newfeatures.instanceOf;


abstract class File {

}


class MusicFile extends File {
    @Override
    public String toString() {
        return "This is music file";
    }
}



public class Sample {

    private static void instanceOfExample() {
        File f = new MusicFile();
        useInstanceOf(f);
    }

    private static void useInstanceOf(File f) {

        if (f instanceof MusicFile m) {
            System.out.println(m);
        }
    }


    public static void main(String[] args) {
        instanceOfExample();
    }
}
