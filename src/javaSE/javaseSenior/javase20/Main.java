package javaSE.javaseSenior.javase20;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    static void test1() {

        Class<Student> clazz = Student.class;
        try {
           Student student = clazz.newInstance();
           student.yes();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    static void test2() {

        /*Class<Student> clazz = Student.class;
        try {
            //Student student = clazz.getConstructor(String.class).newInstance("what's up");
            Student student = clazz.getConstructor(String.class, int.class).newInstance("what's up", 20);
            student.yes();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }*/

        Class<Student> clazz = Student.class;
        try {
            Constructor<Student> constructor = clazz.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);
            Student student = constructor.newInstance("what's up", 20);
            student.yes();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //test1();
        test2();
    }

}
