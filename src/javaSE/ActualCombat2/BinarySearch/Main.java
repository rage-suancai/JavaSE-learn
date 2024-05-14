package javaSE.ActualCombat2.BinarySearch;

public class Main {

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 6, 7, 8, 10, 11, 13, 15};
        //System.out.println(search1(arr, 11));
        System.out.println(search2(arr, 0, arr.length - 1, 11));

    }

    private static int search1(int[] arr, int target) {

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int i = arr[mid];
            if (i < target) left = mid + 1;
            else if (i > target) right = mid - 1;
            else return mid;
        }
        return -1;

    }

    private static int search2(int[] arr, int left, int right, int target) {

        if (left > right) return -1;
        int mid = (left + right) / 2;

        if (arr[mid] > target) return search2(arr, left, mid-1, target);
        else if (arr[mid] < target) return search2(arr, mid+1, right, target);
        else return mid;

    }

}
