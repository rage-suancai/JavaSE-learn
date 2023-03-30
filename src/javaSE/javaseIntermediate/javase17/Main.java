package javaSE.javaseIntermediate.javase17;

import java.util.ArrayList;
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

        List<List<String>> list = new LinkedList<>();

        list.add(new LinkedList<>());
        System.out.println(list.get(0).isEmpty());

    }

    public static void main(String[] args) {

        // test1();
        // test2();
        test3();

    }

}
