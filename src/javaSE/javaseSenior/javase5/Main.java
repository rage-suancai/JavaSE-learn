package javaSE.javaseSenior.javase5;

import javaSE.javaseSenior.javase5.people.People;

import java.io.*;

public class Main {

    static void test1() {

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("text.txt"));
             DataInputStream dataInputStream = new DataInputStream(new FileInputStream("text.txt"))) {

            dataOutputStream.writeFloat(1.58F);
            System.out.println(dataInputStream.readFloat());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void test2() {

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("output.txt"));
             ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("output.txt"))) {

            People people = new People("yxs");
            outputStream.writeObject(people);
            outputStream.flush();
            people = (People) inputStream.readObject();
            System.out.println(people.name);
            System.out.println(people.age);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //test1();
        test2();
    }

}
