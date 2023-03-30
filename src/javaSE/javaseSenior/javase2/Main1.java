package javaSE.javaseSenior.javase2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main1 {

    static void test1() {

        try (FileReader reader = new FileReader("javase26.test.txt")) {
            reader.skip(1);
            System.out.println((char) reader.read());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void test2() {

        try (FileReader reader = new FileReader("javase26.test.txt")) {
            char[] str = new char[4];
            reader.read(str);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void test3() {

        /*try (FileWriter writer = new FileWriter("output.txt")) {
            System.out.println(writer.getEncoding());
            writer.write('牛');
            writer.write('牛');
            // writer.append('牛');
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try (FileReader reader = new FileReader("javase26.test.txt");
             FileWriter writer = new FileWriter("output.txt")) {

            char[] chars = new char[10];
            int tmp;
            while ((tmp = reader.read(chars)) != -1) {
                writer.write(chars, 0, tmp);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        // test1();
        //test2();
        test3();
    }

}
