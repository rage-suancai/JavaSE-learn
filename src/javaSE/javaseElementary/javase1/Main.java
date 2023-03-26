package javaSE.javaseElementary.javase1;

import java.util.Scanner;

public class Main {

    static void test1() {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("你输入了: " + str);
        sc.close();

    }

    public static void main(String[] args) {
        test1();
    }

}
