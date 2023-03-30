package javaSE.javaseIntermediate.javase24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author YXS
 * @PackageName: javaSE.javaseIntermediate.javase24
 * @ClassName: Main
 * @Desription:
 * @date 2023/3/30 22:53
 */
public class Main {

    static void test1() {

        /*List<Integer> list = Arrays.asList(1, 3, 5, 2, 9, 0);
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));*/

        /*List<Integer> list = Arrays.asList(2, 3, 8, 9, 10, 13);
        System.out.println(Collections.binarySearch(list, 8));*/

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Collections.fill(list, 8);
        System.out.println(list);

    }

    static void test2() {

        /*List list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        list.add("aaa");
        System.out.println(list);*/

        List list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        list = Collections.checkedList(list, Integer.class);
        list.add("aaa");
        System.out.println(list);

    }

    public static void main(String[] args) {

        // test1();
        test2();

    }

}
