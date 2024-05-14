package javaSE.ObjectOriented.exception;

public class TestEp {

    public static void main(String[] args) {

        //test1();
        //test2();
        test3();

    }

    private static void test1() {

        try {
           Object object = null; object.toString();
        } catch(NullPointerException e) {

        }
        System.out.println("程序继续正常运行");

    }

    private static void test2() {

        try {
            Object object = null; object.toString();
        } catch(NullPointerException e) {
            e.printStackTrace();
            System.out.println("异常错误信息: " + e.getMessage());
        }
        System.out.println("程序继续正常运行");

    }

    private static void test3() {

        try {
            int[] arr = new int[1]; arr[1] = 100;
        } catch(RuntimeException e) {
            System.out.println("捕获到异常");
        }

    }

}
