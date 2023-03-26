package javaSE.javaseElementary.javase25.persion;

public class Student extends Person implements Exam{

    public Student(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("学生正在吃饭...");
    }

    @Override
    public void run() {
        System.out.println("学生正在吃饭...");
    }

    @Override
    public void study() {
        System.out.println("学生正在吃饭...");
    }

    @Override
    public void exam() {
        System.out.println("学生正在考试...");
    }

}
