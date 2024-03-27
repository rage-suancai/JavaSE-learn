package javaSE.ActualCombat2.FrogJumpingSteps;

public class Main {

    public static void main(String[] args) {

        //System.out.println(jumping1(6));
        System.out.println(jumping2(6));

    }

    private static int jumping1(int n) {

        int[] arr = new int[n + 1];
        arr[0] = 1; arr[1] = 1;

        for (int i = 2; i <= n; ++i)
            arr[i] = arr[i - 1] + arr[i - 2];
        return arr[n];

    }

    private static int jumping2(int n) {

        if (n == 0 || n == 1) return 1;
        return jumping2(n - 1) + jumping2(n - 2);

    }

}
