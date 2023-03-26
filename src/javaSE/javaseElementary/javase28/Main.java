package javaSE.javaseElementary.javase28;

/**
 * 面向对象编程实战
 *
 * 0/1背包问题(回溯法 剪枝/动态规则规划)
 *
 * 给定n件物品 每一个物品的重量为 w[n] 每个物品的价值为 v[n] 现挑选物品放入背包中
 * 假定背包能承受的最大重量为 capacity 求装入物品的最大价值是多少?
 *
 *                  int[] w = {2, 3, 4, 5};
 *                  int[] v = {3, 4, 5, 6};
 *                  int capacity = 8;
 */
public class Main {

    static int[] w = {2, 3, 4, 5};
    static int[] v = {3, 4, 5, 6};
    static int capacity = 8;

    static int test1(int index, int weight) { // 回溯法

        if (index >= 4) return 0;
        if (capacity < weight + w[index]) return 0;

        return Math.max(v[index] + test1(index + 1, weight + w[index]), test1(index + 1, weight));

    }

    static void test2() { // 动态规则规划法

        int[][] arr = new int[5][capacity + 1];
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= capacity; j++) {

                if (w[i - 1] < j) {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - w[i - 1]] + v[i - 1]);
                } else {
                    arr[i][j] = arr[i - 1][j];
                }

            }
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        //System.out.println(test1(0, 0));

        test2();

    }

}
