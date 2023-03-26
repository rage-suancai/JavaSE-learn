package javaSE.javaseElementary.javase4;

public class Student {
    String name;
    int age;

    void study() {
        System.out.println(name + "在学习中...");
    }

    void sport() {
        System.out.println(name + "在运动中...");
    }

    void speak(String word) {
        System.out.println(name + ": " + word);
    }
}
