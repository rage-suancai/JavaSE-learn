package javaSE.javaseIntermediate.javase3;

public class Main {

    /*static int test(int a, int b) throws Exception {

        if (b == 0) throw new Exception("0不能做除数");
        return a/b;

    }
    public static void main(String[] args) throws Exception {

        /*try {
            test(1, 0);
        } catch(Exception e) {
            e.printStackTrace();
        }

        test(1, 0);

    }*/

    static int test(int a, int b) {

        try {
            if(b == 0) throw new Exception("0不能做除数");
        } catch(Exception e) {
            System.out.println("内层");
            return 0;
        }
        return a/b;

    }
    public static void main(String[] args) throws Exception{

        try {
            test(1, 0);
        } catch (Exception e) {
            System.out.println("外层");
        }

    }

}
