package javaSE.javaseElementary.javase16;

/**
 * 实战: 三大基本排序算法(选择)
 *
 *                  int [] arr = {8, 5, 0, 1, 4, 9, 2, 3, 6, 7};
 */
public class Main {

    static void test(int[] arr) {

        for (int i = 0; i < arr.length - 1; ++i) {
            int min = arr[i], pos = i;
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[j] < min) {
                    min = arr[j];
                    pos = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = temp;

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
