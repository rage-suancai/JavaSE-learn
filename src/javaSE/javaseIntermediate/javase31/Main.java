package javaSE.javaseIntermediate.javase31;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 集合类编程实战
 *
 * 实现计算器
 *
 * 实现一个计算器 要求输入一个计算公式(含加减乘除运算符 没有负数但是有小数)得到结果 比如输入: 1 + 4 * 3 / 10 得到结果为: 2.2
 */
public class Main {

    private static void cal() {

        double a = number.pop();
        double b = number.pop();
        char c = opr.pop();

        switch (c) {
            case '+':
                number.push(b + a);
                break;
            case '-':
                number.push(b - a);
                break;
            case '*':
                number.push(b * a);
                break;
            case '/':
                number.push(b / a);
                break;
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String formula = scanner.nextLine();

        char[] str = formula.toCharArray();
        int i = 0;
        while (i < str.length) {
            char c = str[i];
            if (isOpr(c)) {
                Character peek = opr.peek();
                while (peek != null && isHigherPro(peek, c)) {
                    cal();
                    peek = opr.peek();
                }
                opr.push(c);
                i++;
            }else {
                double num = 0;
                double num2 = 0;
                int times = 1;
                boolean flag = false;
                while (i <= str.length - 1 && !isOpr(str[i])) {
                    if (str[i] == '.') {
                        flag = true;
                    }else {
                        if (flag) {
                            double val = (str[i] - '0');
                            for (int j = 0; j < times; j++) val /= 10.0;
                            times++;
                            num2 += val;
                        }else {
                            num = num * 10 + (str[i] - '0');
                        }
                    }
                    i++;
                }
                number.push(num+ num2);
            }
        }

        while (!opr.isEmpty()) cal();
        System.out.println(number.peek());

    }

    private static boolean isOpr(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    private static boolean isHigherPro(char peek, char c) {
        return (peek == '*' || peek == '/') || (c == '+' || c == '-');
    }

    private static Deque<Character> opr = new LinkedList<>();
    private static Deque<Double> number = new LinkedList<>();

}
