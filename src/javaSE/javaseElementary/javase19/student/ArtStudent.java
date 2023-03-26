package javaSE.javaseElementary.javase19.student;

public class ArtStudent extends Student {

    public ArtStudent(String name, int age) {
        super(name, age);
    }

    public void art() {
        System.out.println("随手画个毕加索");
    }

    @Override
    public void study() {
        System.out.println("?????");
    }

}
