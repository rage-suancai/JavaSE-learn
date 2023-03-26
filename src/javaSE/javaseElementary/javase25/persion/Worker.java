package javaSE.javaseElementary.javase25.persion;

public class Worker extends Person{

    public Worker(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("工人正在吃饭...");
    }

    @Override
    public void run() {
        System.out.println("工人正在跑步...");
    }

    @Override
    public void study() {
        System.out.println("工人正在学习...");
    }

}
