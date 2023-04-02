package javaSE.javaseSenior.javase22;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class Main {

    static void test1() {

        /*try {
            Class<?> clazz = Class.forName("javase25.entity.Student");
            //Field name = clazz.getDeclaredField("name");
            Field age = clazz.getDeclaredField("age");
            age.setAccessible(true);
            System.out.println(age.get(new Student("马牛逼", 20)));
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }*/

        try {
            Integer i = new Integer(88);
            Field value = Integer.class.getDeclaredField("value");
            value.setAccessible(true);
            //System.out.println(value.get(i));
            value.set(i, 99);
            System.out.println(i);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

    }

    static void test2() {

        /*try {
            Student student = new Student("马牛逼", 20);
            Field age = Student.class.getDeclaredField("age");
            age.setAccessible(true);
            age.set(student, 30);
            student.javase26.test();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }*/

        try {
            Integer i = 10;
            Field field = Integer.class.getDeclaredField("value");
            Field modifiers = Field.class.getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            modifiers.setInt(field, field.getModifiers() &~ Modifier.FINAL);
            field.setAccessible(true);
            field.set(i, 100);
            System.out.println(i);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

    }

    static void test3() {

        try {
            ArrayList<String> i = new ArrayList<>();
            Field field = ArrayList.class.getDeclaredField("size");
            field.setAccessible(true);
            field.set(i, 10);
            i.add("测试");
            System.out.println(i.size());
            i.remove(10);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
    }

}
