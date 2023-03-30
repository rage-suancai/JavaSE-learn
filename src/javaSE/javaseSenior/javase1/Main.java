package javaSE.javaseSenior.javase1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void test1() {

        /*try {
            FileInputStream inputStream = new FileInputStream("javase26.test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        /*FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("javase26.test.txt");
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/

        try (FileInputStream inputStream = new FileInputStream("javase26.test.txt")){

        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    static void test2() {

        /*try (FileInputStream inputStream = new FileInputStream("javase26.test.txt")){
            System.out.println((char) inputStream.read());
            System.out.println((char) inputStream.read());
            System.out.println((char) inputStream.read());
            System.out.println(inputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try (FileInputStream inputStream = new FileInputStream("javase26.test.txt")){
            int tmp;
            while ((tmp = inputStream.read()) != -1) {
                System.out.println((char) tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try (FileInputStream inputStream = new FileInputStream("javase26.test.txt")) {
            System.out.println(inputStream.available());
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void test3() {

        /*try (FileInputStream inputStream = new FileInputStream("javase26.test.txt")) {
            byte[] bytes = new byte[inputStream.available()];
            System.out.println(inputStream.read(bytes));
            //System.out.println(inputStream.read(bytes, 1, 2));
            System.out.println(new String(bytes));
        }catch (IOException e) {
            e.printStackTrace();
        }*/

        try (FileInputStream inputStream = new FileInputStream("javase26.test.txt")) {
            System.out.println(inputStream.skip(1));
            System.out.println((char) inputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void test4() {

        /*try (FileOutputStream outputStream = new FileOutputStream("output.txt")) {
            outputStream.write('N');
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try (FileOutputStream outputStream = new FileOutputStream("output.txt")) {
            outputStream.write("yxsnb".getBytes());
            outputStream.write("yxsnb".getBytes(), 0, 1);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try (FileOutputStream outputStream = new FileOutputStream("output.txt", true)) {
            outputStream.write("lb".getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try (FileOutputStream outputStream = new FileOutputStream("output.txt", true)) {
            FileInputStream inputStream = new FileInputStream("javase26.test.txt");
            byte[] bytes = new byte[10];
            int tmp;
            while ((tmp = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0 ,tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        test4();
    }

}
