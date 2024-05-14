package javaSE.CollectionClasses.IO;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        // byteStreamsTest();

        // characterStreamTest();

        // FileClassTest();

        // bufferTheStream();

        // conversionStreamTest();

        // printStreamTest();

        // dataStreamTest();

        objectStreamTest();

    }

    private static void byteStreamsTest() {

        /*try(FileInputStream inputStream = new FileInputStream("IO/byteStreams.txt")) {
            int tmp;
            while((tmp = inputStream.read()) != -1) System.out.println((char) tmp);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }*/

        /*try(FileInputStream inputStream = new FileInputStream("IO/byteStreams.txt")) {
            System.out.println(inputStream.available());
        } catch(IOException e) {
            throw new RuntimeException(e);
        }*/

        /*try(FileInputStream inputStream = new FileInputStream("IO/byteStreams.txt")) {
            byte[] bytes = new byte[inputStream.available()];
            System.out.println(inputStream.read(bytes));
            System.out.println(new String(bytes));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }*/

        /*try(FileInputStream inputStream = new FileInputStream("IO/byteStreams.txt")) {
            System.out.println(inputStream.skip(1));
            System.out.println((char) inputStream.read());
        } catch(IOException e) {
            throw new RuntimeException(e);
        }*/

        /*try(FileOutputStream outputStream = new FileOutputStream("IO/byteOutput.txt")) {
            outputStream.write('c');
            outputStream.write("lbwnb".getBytes());
            outputStream.write("lbwnb".getBytes(), 0, 1);
            outputStream.flush();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }*/

        /*try(FileOutputStream outputStream = new FileOutputStream("IO/byteOutput.txt")) {
            outputStream.write('c');
            outputStream.write("lbwnb".getBytes());
            outputStream.write("lbwnb".getBytes(), 0, 1);
            outputStream.flush();
        } catch(IOException e) {
           throw new RuntimeException(e);
        }*/

        /*try(FileOutputStream outputStream = new FileOutputStream("IO/byteOutput.txt", true)) {
            outputStream.write("lb".getBytes());
            outputStream.flush();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }*/

        try(FileOutputStream outputStream = new FileOutputStream("IO/byteOutput.txt");
            FileInputStream inputStream = new FileInputStream("IO/yteStreams.txt")) {
            byte[] bytes = new byte[10];
            int tmp;
            while((tmp = inputStream.read(bytes)) != -1) outputStream.write(bytes, 0 , tmp);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void characterStreamTest() {

        /*try (FileReader reader = new FileReader("IO/characterStreams.txt")) {
            reader.skip(1);
            System.out.println((char) reader.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        /*try (FileReader reader = new FileReader("IO/characterStreams.txt")) {
            char[] str = new char[10]; reader.read(str);
            System.out.println((str));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try (FileWriter writer = new FileWriter("IO/charOutput.txt")) {
            writer.getEncoding();
            writer.write('牛'); writer.append('牛'); writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void FileClassTest() {

        /*File file = new File("IO/charOutput.txt");
        System.out.println(file.exists());
        System.out.println(file.length());
        System.out.println(file.isDirectory());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());*/

        /*File file = new File("IO/charOutput.txt");
        System.out.println(Arrays.toString(file.list()));
        for (File f : file.listFiles()) System.out.println();*/

        File file = new File("IO/charOutput.txt");
        try(FileInputStream inputStream = new FileInputStream(file)) {
            System.out.println(inputStream.available());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void bufferTheStream() {

        /*try(BufferedInputStream stream = new BufferedInputStream(new FileInputStream("IO/bufferStreams.txt"))) {
            stream.mark(1);
            System.out.println((char) stream.read());
            System.out.println((char) stream.read());
            stream.reset();
            System.out.println((char) stream.read());
            System.out.println((char) stream.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        /*try(BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("IO/bufferStreams.txt"))) {
            stream.write("lbwnb".getBytes()); stream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        /*try(BufferedReader reader = new BufferedReader(new FileReader("IO/bufferStreams.txt"))) {
            System.out.println((char) reader.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        /*try(BufferedReader reader = new BufferedReader(new FileReader("IO/bufferStreams.txt"))) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        /*try(BufferedReader reader = new BufferedReader(new FileReader("IO/bufferStreams.txt"))) {
            reader
                    .lines()
                    .limit(2)
                    .distinct()
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        /*try(BufferedReader reader = new BufferedReader(new FileReader("IO/bufferStreams.txt"))) {
            reader.mark(1);
            System.out.println((char) reader.read());
            reader.reset();
            System.out.println((char) reader.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        try(BufferedWriter reader = new BufferedWriter(new FileWriter("IO/bufferOutput.txt"))) {
            reader.newLine();
            reader.write("汉堡做滴彳亍不彳亍");
            reader.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void conversionStreamTest() {

        /*try(OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(("")))) {
            writer.write("lbwnb");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        try(InputStreamReader reader = new InputStreamReader(new FileInputStream(("")))) {
            System.out.println((char) reader.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void printStreamTest() {

        try(PrintStream stream = new PrintStream(new FileOutputStream(""))) {
            stream.println("lbwnb");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void dataStreamTest() {

        /*try(DataInputStream dataInputStream = new DataInputStream(new FileInputStream("IO/dataStreams.txt"))) {
            System.out.println(dataInputStream.readBoolean());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        try(DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(""))) {
            dataOutputStream.writeBoolean(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void objectStreamTest() {

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("IO/objectOutPut.txt"));
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("IO/objectOutPut.txt"))) {

            People people = new People("lbw");
            outputStream.writeObject(people); outputStream.flush();

            people = (People) inputStream.readObject();
            System.out.println(people.name);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    static class People implements Serializable {

        String name;

        public People(String name) {
            this.name = name;
        }

    }



}
