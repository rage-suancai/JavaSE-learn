package javaSE.ActualCombat2.SortAlgorithm;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr = new int[]{3, 5, 7, 2, 9, 0, 6, 1, 8, 4};

        // selectionSort(arr); System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length-1);
        for (int j : arr) System.out.print(j + " ");

    }

    private static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; ++i) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; ++j) {
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

    private static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; ++i) {
            int tmp = arr[i];
            int j = i-1;
            while(j >= 0 && tmp < arr[j]) {
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = tmp;
            /*for (int k = 0; k < arr.length; ++k) System.out.print(arr[k] + " ");
            System.out.println();*/
        }

    }

    private static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length-1; ++i) {
            int min = arr[i], pos = i;
            for (int j = i; j < arr.length; ++j) {
                if (arr[j] < min) {
                    min = arr[j];
                    pos = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = tmp;
        }

    }

    private static void quickSort(int[] arr, int start, int end) {

        if (start >= end) return;

        int base = arr[start], low = start, high = end;
        while (low < high) {
            while (low < high && base <= arr[high]) --high;
            arr[low] = arr[high];
            while (low < high && base >= arr[low]) ++low;
            arr[high] = arr[low];
        }
        arr[high] = base;

        quickSort(arr, start, high-1); quickSort(arr, high+1, end);

    }

}
