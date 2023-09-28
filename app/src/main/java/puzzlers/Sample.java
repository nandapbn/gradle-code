package puzzlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Sample {

    private static void stringArray() {
        String[] stringArray = { "one", "two", "three" };
        var stringList = Arrays.asList(stringArray);

        int[] intArray = { 1, 2, 3 };
        var intList = Arrays.asList(intArray);

        System.out.print(stringList.contains("one") + " , ");
        System.out.println(intList.contains(1));
    }

    private static void sublist() {

        var ints = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        var sublist = ints.subList(0, 0);

        System.out.print(sublist + " ");
        sublist.addAll(List.of(10, 11, 12));
        System.out.println(ints);
    }

    private static void streamPuzzle() {
        try {
            String[] ints = { "a", "b", "c", null };

            var strings1 = Stream.of(ints).toList();
            System.out.println(strings1.size());

            var strings2 = List.of(ints);
            System.out.println(strings2.size());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static void removeIfNull() {
        try {
            String[] ints = { "a", "b", "c", null };

            List<String> strings = Arrays.asList(ints);
            strings.removeIf(Objects::isNull);
            System.out.print(strings.size());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static void mapOps() {
        try {
            var map = new HashMap<Integer, String>();
            map.put(4, null);
            System.out.print(map.getOrDefault(4, "four") + ", ");

            map.putIfAbsent(4, "four");
            System.out.println(map.get(4));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static void multiMap() {
        try {
            var nums = List.of(-1, 0, 1);
            var map = new HashMap<Integer, List<Integer>>();
            nums.forEach(num -> map.computeIfAbsent(num, initialCapacity -> new ArrayList<Integer>(initialCapacity))
                    .add(num));
            System.out.println(map.get(0));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        stringArray();
        sublist();
        streamPuzzle();
        removeIfNull();
        mapOps();
        multiMap();
    }
}
