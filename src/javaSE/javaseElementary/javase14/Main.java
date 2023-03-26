package javaSE.javaseElementary.javase14;

/**
 * 实战: 三大基本排序算法(冒泡)
 * 现在我们有一个数组 但是数组里面的数据是乱序排列的 如何使它变得有序
 *
 *                  int [] arr = {8, 5, 0, 1, 4, 9, 2, 3, 6, 7};
 *
 * 排序是编程的一个重要技能 掌握排序算法 你的技术才能更上一层楼 很多项目都需要用到排序 三大排序算法:
 *
 *          > 冒泡排序: 冒牌排序就是冒泡 其实就是不断使得我们无序数组中的最大数向前移动 经历n轮循环逐渐将每一个数推向最前
 *          > 插入排序: 插入排序其实就是跟我们打牌是一样的 我们在摸牌的时候 牌堆是乱序的 但是我们一张一张摸到手中进行排序 使得它变成了有序的
 *          > 选择排序: 选择排序其实就是每次都选择当前数组中最大的数排到最前面
 */
public class Main {

    static void test(int[] arr) {

        for (int i = 0; i < arr.length - 1; ++i) {
            boolean b = true;
            for (int j = 0; j < arr.length - 1 - i; ++j) {
                if (arr[j] > arr[j+1]) {
                    b = false;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(b) break;
        }

    }

    public static void main(String[] args) {

        int[] arr = {8, 5, 0, 1, 4, 9, 2, 3, 6, 7};
        test(arr);

        for (int i = 0; i < arr.length; ++i) {
            System.out.print(i + " ");
        }

    }

}
