package javaSE.javaseElementary.javase20.student;


import javaSE.javaseElementary.javase20.service.Eat;

public class SportsStudent extends Student implements Eat {

    public SportsStudent(String name, int age) {
        super(name, age);
    }

    public void exercise() {

        System.out.println("我超勇的!");

    }

    @Override
    public void study() {
        System.out.println("给你看点好康的...");
    }

    @Override
    public void eat() {
        System.out.println("一日三餐没烦恼");
    }

}
