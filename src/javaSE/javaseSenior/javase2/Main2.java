package javaSE.javaseSenior.javase2;

import java.io.*;
import java.util.Arrays;

public class Main2 {

    static void test1() {

        File file = new File("javase26.test.txt");
        System.out.println(file.exists());
        System.out.println(file.length());
        System.out.println(file.isDirectory());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());

    }

    static void test2() {

        File file = new File("/");
        System.out.println(Arrays.toString(file.list()));
        for (File f : file.listFiles()) {
            System.out.println(f.getAbsolutePath());
        }

    }

    static void test3() {

        File file = new File("javase26.test.txt");
        try (FileInputStream inputStream = new FileInputStream(file)) {
            System.out.println(inputStream.available());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void test4() {

        File file = new File("YXS/");
        File target = new File("newYXS/");
        target.mkdir();
        for (File f : file.listFiles()) {
            try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(f));
                 BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(target.getPath() + f.getName()))) {

                byte[] bytes = new byte[1024];
                int tmp;
                while ((tmp = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, tmp);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        test4();
    }

}
