package javaSE.ActualCombat3.BackpackProblem;

public class Main {

    private static int[] w = {2,3,4,5};
    private static int[] v = {3,4,5,6};
    private static int capacity = 9;

    public static void main(String[] args) {

        //System.out.println(backtracking(0,0));

        dynamicPlanning();

    }

    private static int backtracking(int index, int weight) {

        if (index >= 4) return 0;
        if (capacity < weight + w[index]) return 0;
        return Math.max(v[index] + backtracking(index+1, weight+w[index]), backtracking(index+1, weight));

    }

    private static void dynamicPlanning() {

        int[][] arr = new int[5][capacity+1];
        for (int i = 1; i <= 4; ++i) {
            for (int j = 1; j <= capacity; ++j) {
                if (w[i-1] <= j) arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-w[i-1]] + v[i-1]);
                arr[i][j] = arr[i-1][j];
            }
        }
        for (int[] ints : arr) {
            for (int anInt : ints) System.out.print(anInt + " ");
            System.out.println();
        }

    }

}
