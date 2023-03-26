package javaSE.javaseElementary.javase15;

/**
 * 实战: 三大基本排序算法(插入)
 *
 *                  int [] arr = {8, 5, 0, 1, 4, 9, 2, 3, 6, 7};
 */
public class Main {

    static void test(int[] arr) {

        for (int i = 0; i < arr.length; ++i) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = temp;

            /*for (int g = 0; g < arr.length; ++g) {
                System.out.print(arr[g] + " ");
            }
            System.out.println();*/

        }

    }

    public static void main(String[] args) {

        int [] arr = {8, 5, 0, 1, 4, 9, 2, 3, 6, 7};
        test(arr);

        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }

    }

}
