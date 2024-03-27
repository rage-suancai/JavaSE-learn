package javaSE.ActualCombat3.Calculator;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static Deque<Character> opr = new LinkedList<>();
    private static Deque<Double> number = new LinkedList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String formula = scanner.nextLine();

        char[] str = formula.toCharArray();
        int i = 0;
        while(i < str.length) {
            char symbol = str[i];
            if(isOpr(symbol)) {
                Character peek = opr.peek();
                while(peek != null && isHigherPro(peek,symbol)) {
                    cal(); peek = opr.peek();
                }
                opr.push(symbol); ++i;
            } else {
                double num = 0, small = 0;
                int times = 1; boolean flag = false;
                while(i <= str.length-1 && !isOpr(str[i])) {
                    if(str[i] == '.') {
                        flag = true;
                    } else {
                        if (flag) {
                            double val = (str[i] - '0');
                            for (int j = 0; j < times; j++) val /= 10.0;
                            ++times; small += val;
                        } else {
                            num = num * 10 + (str[i] - '0');
                        }
                    }
                    ++i;
                }
                number.push(num + small);
            }
        }

        while(!opr.isEmpty()) cal();
        System.out.println(number.peek());

    }

    private static void cal() {

        double var1 = number.pop(); double var2 = number.pop(); char symbol = opr.pop();
        switch(symbol) {
            case '+': number.push(var1+var2); break;
            case '-': number.push(var1-var2); break;
            case '*': number.push(var1*var2); break;
            case '/': number.push(var1/var2); break;
        }

    }

    private static boolean isOpr(char symbol) {
        return symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/';
    }
    private static boolean isHigherPro(char peek, char symbol) {
        return (peek =='*' || peek == '/') || (symbol == '+' || symbol == '-');
    }

}
