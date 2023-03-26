package javaSE.javaseElementary.javase2;

public class Main {

    static void test1() {

        Student student = new Student();
        student.name = "奥利给";
        student.age = 20;
        System.out.println(student.name);
        System.out.println(student.age);

    }

    public static void main(String[] args) {
        test1();

    }

}
