package javaSE.ActualCombat2.BubbleSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr = new int[]{3, 5, 7, 2, 9, 0, 6, 1, 8, 4};
        sort(arr); System.out.println(Arrays.toString(arr));

    }

    private static void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
        }

    }

}
