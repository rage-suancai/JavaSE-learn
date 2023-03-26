package javaSE.javaseElementary.javase25.persion;

public class Teacher extends Person implements Exam{

    public Teacher(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("老师正在吃饭...");
    }

    @Override
    public void run() {
        System.out.println("老师正在跑步...");
    }

    @Override
    public void study() {
        System.out.println("老师正在学习...");
    }

    @Override
    public void exam() {
        System.out.println("老师正在监考...");
    }

}
