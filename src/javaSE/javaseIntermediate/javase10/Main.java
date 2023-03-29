package javaSE.javaseIntermediate.javase10;

public class Main {

    static LinkedList<String> list = new LinkedList<>();
    static void test1() {

        list.add("AAA", 0);
        list.add("BBB", 1);
        list.add("CCC", 2);
        System.out.println(list);

    }

    static void test2() {

        list.add("AAA", 0);
        list.add("BBB", 1);
        list.add("CCC", 2);
        list.remove(1);
        System.out.println(list);

    }

    static void test3() {

        list.add("AAA", 0);
        list.add("BBB", 1);
        list.add("CCC", 2);
        System.out.println(list.get(1));
        System.out.println(list.size());

    }

    public static void main(String[] args) {

        // test1();
        // test2();
        test3();

    }

}
