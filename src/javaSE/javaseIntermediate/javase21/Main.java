package javaSE.javaseIntermediate.javase21;

import java.util.*;

/**
 * @author YXS
 * @PackageName: javaSE.javaseIntermediate.javase21
 * @ClassName: Main
 * @Desription:
 * @date 2023/3/30 16:29
 */
public class Main {

    static void test1() {

        HashSet<String> set = new HashSet<>();

        /*System.out.println(set.add("AAA"));
        System.out.println(set.add("AAA"));
        System.out.println(set);*/

        System.out.println(set.add("AAA"));
        System.out.println(set.remove("AAA"));
        System.out.println(set);

    }

    static void test2() {

        /*Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList("A", "0", "-", "+"));
        System.out.println(set);*/

        Set<String> set = new LinkedHashSet<>();
        set.addAll(Arrays.asList("A", "0", "-", "+"));
        System.out.println(set);

    }

    static void test3() {

        /*TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        System.out.println(set);*/

        TreeSet<Integer> set = new TreeSet<>((a, b) -> b - a);
        set.add(1);
        set.add(3);
        set.add(2);
        System.out.println(set);

    }

    public static void main(String[] args) {

        // test1();
        // test2();
        test3();

    }

}
