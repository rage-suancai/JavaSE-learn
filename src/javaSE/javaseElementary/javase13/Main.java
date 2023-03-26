package javaSE.javaseElementary.javase13;

public class Main {

    static void test1() {

        int[][] arr = {{1, 2}, {3, 4}, {5, 6}};
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 2; ++j) {
                System.out.println(arr[i][j]);
            }
        }

    }

    static void test2(String... arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        //test1();
        test2("AAA", "BBB", "CCC");
    }

}
