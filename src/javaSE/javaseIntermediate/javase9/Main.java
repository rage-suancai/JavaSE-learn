package javaSE.javaseIntermediate.javase9;

public class Main {

    static ArrayList<String> list = new ArrayList<>();

    static void test1() {

        list.add("AAA", 0);
        list.add("BBB", 1);
        System.out.println(list);

    }

    static void test2() {

        for (int i = 0; i <= 30; i++) {
            list.add(i + "", i);
        }
        System.out.println(list);

    }

    static void test3() {

        list.add("AAA", 0);
        list.add("BBB", 1);
        list.add("CCC", 2);
        list.remove(2);
        System.out.println(list);

    }

    static void test4() {

        list.add("AAA", 0);
        list.add("BBB", 1);
        list.add("CCC", 2);
        System.out.println(list.get(1));

    }

    public static void main(String[] args) {

        // test1();
        // test2();
        // test3();
        test4();

    }

}
