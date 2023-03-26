package javaSE.javaseEntry.javase9;

public class Main {

    static void test1() {

        for (int i = 0; i <= 10; ++i) {
            System.out.println("Fuck World");
        }

    }

    static void test2() {

        /*int i = 0;
        while (i < 10) {
            ++i;
        }*/

        do {
            System.out.println("Fuck World");
        } while (false);

    }

    public static void main(String[] args) {
        //test1();
        test2();
    }

}
