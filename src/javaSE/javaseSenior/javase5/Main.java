package javaSE.javaseSenior.javase5;

import java.io.*;

public class Main {

    static void test1() {

        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("javase26.test.txt"))) {
            writer.write("叶");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStreamReader reader = new InputStreamReader(new FileInputStream("javase26.test.txt"))) {
            System.out.println((char) reader.read());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void test2() {

        try (PrintStream stream = new PrintStream(new FileOutputStream("javase26.test.txt"))) {
            stream.println("yxsnb");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //test1();
        test2();
    }

}
