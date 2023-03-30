package javaSE.javaseIntermediate.javase19;

import java.util.*;

/**
 * @author YXS
 * @PackageName: javaSE.javaseIntermediate.javase19
 * @ClassName: Main
 * @Desription:
 * @date 2023/3/30 11:48
 */
public class Main {

    static void test1() {

        List<String> list = Arrays.asList("A", "B", "C");

        /*Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());*/

        // for (String s : list) System.out.println(s);

        list.forEach(System.out::println);

    }

    static void test2() {

        MyIterable myIterable = new MyIterable();
        for (String s : myIterable) System.out.println(s);

    }

    static void test3() {

        ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ListIterator<String> iterator = list.listIterator();

        iterator.next();
        iterator.set("X");
        System.out.println(list);

    }

    public static void main(String[] args) {

        // test1();
        // test2();
        test3();

    }

}
