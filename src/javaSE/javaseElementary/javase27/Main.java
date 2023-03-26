package javaSE.javaseElementary.javase27;

/**
 * 面向对象编程实战
 *
 * 快速排序(排序算法 递归分治)
 *
 * (开始之前先介绍一下递归) 快速排序其实是一种排序执行效率很高的排序算法 它利用分治法来对待排序序列进行分治排序 它的思想主要是通过一趟排序将记录分隔成独立的两部分
 * 其中的一部分比关键字小 后面一部分比关键字大 然后再对这前后的两部分分别采用这种方式进行排序 通过递归的运算最终达到整个序列有序
 *
 * 快速排序就像它的名字一样 快速 在极端情况下 会退化成冒泡排序
 */
public class Main {

    static void quickSort(int[] arr, int start, int end) {

        if (start >= end) return;

        int k = arr[start], low = start, high = end;
        while (low < high) {

            while (low < high && k <= arr[high]) high--;
            arr[low] = arr[high];

            while (low < high && k >= arr[low]) low++;
            arr[high] = arr[low];

        }
        arr[high] = k;

        quickSort(arr, start, high - 1);
        quickSort(arr, high + 1, end);

    }

    public static void main(String[] args) {

        int[] arr = new int[] {9, 2, 1, 4, 5, 7, 8, 6, 3, 0};

        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}
