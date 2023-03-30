package javaSE.javaseIntermediate.javase18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static void test1() {

        // ArrayList<String> list = new ArrayList<>();
        List<String> list = new ArrayList<>();

        // list1.add("树脂888");

        list.add("科技与狠活");
        list.add("上头啊");
        System.out.println(list);

    }

    static void test2() {

        List<String> list = new ArrayList<>();

        /*list.add(10);
        list.remove((Integer) 10);
        System.out.println(list);*/

        /*list.add(new Integer(10));
        list.remove(new Integer(10));
        System.out.println(list);*/

        String str = "哟唉嘛干你";
        list.add(str);
        list.add(str);
        list.remove(str);
        System.out.println(list);

    }

    static void test3() {

        // List<List<String>> list = new LinkedList<>();
        // List<String> list = Arrays.asList("A", "B", "C");
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));

        /*list.add(new LinkedList<>());
        System.out.println(list.get(0).isEmpty());*/

        System.out.println(list);

    }

    static void test4() {

        List<String> list = new ArrayList<>() {{
            add("A");
            add("B");
            add("C");
        }};

        System.out.println(list);

    }

    public static void main(String[] args) {

        // test1();
        // test2();
        // test3();
        test4();

    }

}
