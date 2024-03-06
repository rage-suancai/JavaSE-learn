package javaSE.ActualCombat1.FrogJumpingSteps;

/**
 * 青蛙跳台阶问题:
 * 一共有n个台阶 一只青蛙每次只能跳一阶或是二阶 那么一共有多少种跳到顶端的方案 例如: n=2 那么一共有两种方案 一次性跳两阶或是每次跳一阶
 * 动态规划: 其实 就是利用上次得到的结果 给下一次做参考 下一次就能利用上一次的结果快速得到结果 依此类推
 */
public class Main {

    public static void main(String[] args) {

        int n = 10;
        int[] arr = new int[n];

        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
            System.out.println("第" + (i + 1) + "阶有" + arr[i] + "种走法");
        }

    }

}
