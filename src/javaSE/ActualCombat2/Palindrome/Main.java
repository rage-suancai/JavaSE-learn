package javaSE.ActualCombat2.Palindrome;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println(palindrome());

    }

    private static boolean palindrome() {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        char[] chars = str.toCharArray(); int i = 0;
        while (i < chars.length / 2) {
            if (chars[i] != chars[chars.length-1-i]) return false;
            ++i;
        }
        return true;

    }

}
