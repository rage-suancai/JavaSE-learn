package javaSE.javaseSenior.javase3;

import java.io.*;

public class Main {

    static void test1() {

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("javase26.test.txt"))) {
            System.out.println((char) bufferedInputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void test2() {

        /*try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("javase26.test.txt"))) {
            bufferedInputStream.mark(1);
            System.out.println((char) bufferedInputStream.read());
            //System.out.println((char) bufferedInputStream.read());
            bufferedInputStream.reset();
            System.out.println((char) bufferedInputStream.read());
            //System.out.println((char) bufferedInputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("javase26.test.txt"), 1)) {
            bufferedInputStream.mark(1);
            System.out.println((char) bufferedInputStream.read());
            System.out.println((char) bufferedInputStream.read());
            bufferedInputStream.reset();
            System.out.println((char) bufferedInputStream.read());
            System.out.println((char) bufferedInputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void test3() {

        try (BufferedOutputStream bufferedInputStream = new BufferedOutputStream(new FileOutputStream("javase26.test.txt"))) {
            bufferedInputStream.write("yxsnb".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void test4() {

        /*try (BufferedReader reader = new BufferedReader(new FileReader("javase26.test.txt"))) {
            System.out.println((char) reader.read());
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("javase26.test.txt"))) {
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void test5() {

        /*try (BufferedReader reader = new BufferedReader(new FileReader("javase26.test.txt"))) {
            reader
                    .lines()
                    .limit(2)
                    .distinct()
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try (BufferedReader reader = new BufferedReader(new FileReader("javase26.test.txt"))) {
            reader.mark(1);
            System.out.println((char) reader.read());
            System.out.println((char) reader.read());
            reader.reset();
            System.out.println((char) reader.read());
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try (BufferedWriter reader = new BufferedWriter(new FileWriter("javase26.test.txt"))) {
            reader.newLine();
            reader.write("汉堡做的行不行");
            reader.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        test5();
    }

}
