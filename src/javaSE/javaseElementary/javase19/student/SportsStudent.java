package javaSE.javaseElementary.javase19.student;

public class SportsStudent extends Student {

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

}
