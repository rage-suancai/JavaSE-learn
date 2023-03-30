package javaSE.javaseIntermediate.javase27;

import java.util.Arrays;

/**
 * 集合类编程实战
 *
 * 字符串匹配(KMP算法)
 *
 * 现在给定一个主字符串和一个子字符串 请判断主字符串是否包含子字符串
 *
 * 例如主字符串: ABCABCDHI 子字符串: ABCD 因此主字符串包含此字符串 | 主字符串: ABCABCUISA 子字符串: ABCD 则不包含
 */
public class Main {

    public static void main(String[] args) {

        char[] str = "abababaaababaa".toCharArray();
        char[] sub = "ababaaababaa".toCharArray();

        int[] next = new int[sub.length];
        int i = 1, j;
        while (i < next.length) {
            j = i - 1;
            while (true) {
                if (next[j] == 0 || sub[i - 1] == sub[next[j] - 1]) {
                    next[i] = next[j] + 1;
                    break;
                }
                j = next[j] - 1;
            }
            i++;
        }

        System.out.println("序列为: " + Arrays.toString(sub));
        System.out.println("Next数组: " + Arrays.toString(next));
        System.out.println();

        i = 0;
        j = 0;
        while (i < str.length) {
            if (str[i] == sub[j]) {
                i++;
                j++;
            } else {
                if (j == 0) i++;
                else j = next[j] - 1;
            }
            if (j == sub.length) {
                System.out.println("匹配成功");
                break;
            }
        }

    }
}
