package javaSE.javaseEntry.javase7;

public class Main {

    static void test1() {

        /*int a = 1 + 8;
        System.out.println(a);*/

        /*int a = 2;
        int b = 3;
        int c = a * b;
        System.out.println(c);*/

        /*System.out.println("yxs" + "nb");

        int a = 7 , b = 15;
        System.out.println("yxs" + a + b);*/

        /*int a = 10;
        a++;
        System.out.println(a);*/

        /*int a = 10;
        System.out.println(a++);
        System.out.println(a);*/

        /*int a = 10;
        int b = 2;
        System.out.println(b++ + a++);*/

        /*int a = 10;
        System.out.println(a += 2);*/

        int a = 10;
        int b = 2;
        boolean x = a > b;
        System.out.println(x);

    }

    static void test2() {

        /*int a = 10;
        int b = 2;
        boolean x = a > b && a < b;
        System.out.println(x);*/

        /*int a = 10;
        int b = 2;
        boolean x = a > b || a <= b;
        System.out.println(x);*/

        /*int a = 10;
        int b = 2;
        boolean x = !(a > b);
        System.out.println(x);*/

        int a = 7, b = 15;
        System.out.println(a & b);

    }

    static void test3() {

        int a = 7, b = 15;
        String str = a > b ? "行" : "不行";
        System.out.println("汉堡做的行不行? " + str);

    }

    public static void main(String[] args) {
        // test1();
        //test2();
        test3();
    }

}
