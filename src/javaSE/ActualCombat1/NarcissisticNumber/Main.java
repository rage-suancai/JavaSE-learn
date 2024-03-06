package javaSE.ActualCombat1.NarcissisticNumber;

/**
 * 求1000以内的水仙花数:
 * 打印1000以内所有满足水仙花的数 "水仙花数"是指一个三位数其各位数字的立方和等于该数本身 例如: 153是"水仙花数" 因为: 153 = 1^3 + 5^5 + 3^3
 */
public class Main {

    public static void main(String[] args) {

        for (int i = 153; i < 1000; ++i) {

            int a = i, sum = 0;
            while (a > 0) {
                int b = a % 10;
                sum += b * b * b;
                a /= 10;
            }
            if (sum == i) System.out.println(i + "是水仙花数");

        }

    }

}
