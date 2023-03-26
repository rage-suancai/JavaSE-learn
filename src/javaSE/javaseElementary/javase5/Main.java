package javaSE.javaseElementary.javase5;

public class Main {

    static void test1() {

        /*Test test = new Test();

        int a1 = test.sum(10, 20);
        System.out.println(a1);

        double a2 = test.sum(1.8, 1.5);
        System.out.println(a2);*/

    }

    static void test2() {

        Test test = new Test();

        test.a(1);
        test.a(1.0);

        short s = 2;
        test.a(s);
        test.a(1.0F);

    }

    public static void main(String[] args) {
        //test1();
        test2();
    }

}
