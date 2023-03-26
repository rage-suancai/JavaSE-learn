package javaSE.javaseEntry.javase8;

public class Main {

    static void test1() {

        /*int a = 3;
        if (a > 1) {
            System.out.println("ok");
        } else {
            System.out.println("no");
        }*/

        /*int a = 3;
        if(a > 1) {
            System.out.println("ok");
        } else if(a < 1) {
            System.out.println("no");
        }*/

        int a = 3;
        if (a > 1) {
            if (a < 1) {
                System.out.println("ok");
            } else {
                System.out.println("no");
            }
        }

    }

    static void test2() {

        int a = 3;
        switch (a) {
            case 3:
                System.out.println("nice");
                break;
            case 10:
                System.out.println("nice2");
                break;
            case 9:
                System.out.println("nice3");
                break;
        }

    }

    public static void main(String[] args) {
        //test1();
        test2();
    }

}
