package javaSE.ActualCombat4;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static class Book implements Serializable {

        private String title;
        private String author;
        private double price;

        private Book(String title, String author, double price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public void setAuthor(String author) {
            this.author = author;
        }
        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "《"+title+"》 作者: " +author+ "(" +price+"$)";
        }

    }

    private static List<Book> LIST;

    public static void main(String[] args) {

        System.out.println("正在初始化数据..."); load();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("================= 图书管理系统 =================");
            System.out.println("1. 录入书籍信息");
            System.out.println("2. 查阅书籍信息");
            System.out.println("3. 删除书籍信息");
            System.out.println("4. 修改书籍信息");
            System.out.println("0. 退出");
            System.out.println("==============================================");

            switch (scanner.nextInt()) {
                case 1: insert(scanner); break;
                case 2: select(); break;
                case 3: delete(scanner); break;
                case 4: update(scanner); break;
                case 0:
                    System.out.println("正在保存数据..."); save();
                    System.out.println("感谢您的使用!"); return;
            }
        }

    }

    private static void insert(Scanner scanner) {

        scanner.nextLine();
        System.out.println("请输入书籍的标题: ");
        String title = scanner.nextLine();
        System.out.println("请输入书籍的作者: ");
        String author = scanner.nextLine();
        System.out.println("请输入书籍的价格: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Book book = new Book(title, author, price);
        LIST.add(book); System.out.println("书籍信息添加成功!: " + book);

    }

    private static void select() {
        for (int i = 0; i < LIST.size(); ++i) System.out.println(i + "." + LIST.get(i));
    }

    private static void delete(Scanner scanner) {

        scanner.nextLine();
        System.out.println("请输入您要删除的书籍ID编号: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        while (index > LIST.size()-1 || index < 0) {
            System.out.print("没有对应的书籍 请重新输入!");
            index = scanner.nextInt(); scanner.nextLine();
        }
        LIST.remove(index); System.out.println("删除书籍信息成功!");

    }

    private static void update(Scanner scanner) {

        scanner.nextLine();
        System.out.println("请输入您要修改的书籍ID编号: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        while (index > LIST.size()-1 || index < 0) {
            System.out.print("没有对应的书籍 请重新输入!");
            index = scanner.nextInt(); scanner.nextLine();
        }
        Book book = LIST.get(index);
        System.out.println("请输入书籍的标题: ");
        book.setTitle(scanner.nextLine());
        System.out.println("请输入书籍的作者: ");
        book.setAuthor(scanner.nextLine());
        System.out.println("请输入书籍的价格: ");
        book.setPrice(scanner.nextDouble());
        scanner.nextLine();
        System.out.println("修改书籍信息成功!");

    }

    @SuppressWarnings("unchecked")
    private static void load() {

        File file = new File("IO/bookData");
        if (file.exists()) {
            try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file))) {
                LIST = (List<Book>) stream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            LIST = new LinkedList<>();
        }

    }
    private static void save() {

        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("IO/bookData"))) {
            stream.writeObject(LIST); stream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
