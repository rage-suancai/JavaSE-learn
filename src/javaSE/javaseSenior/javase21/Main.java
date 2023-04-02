package javaSE.javaseSenior.javase21;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main {

    static void test1() {

        /*try {
            Class<?> clazz = Class.forName("javase24.entity.Student");
            Object instance = clazz.newInstance();
            Method method = clazz.getMethod("yes", String.class);

            method.invoke(instance, " what's up");
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }*/

        /*try {
            Class<Student> clazz = Student.class;
            Method method = clazz.getDeclaredMethod("yes");
            method.setAccessible(true);
            method.invoke(new Student("马牛逼", 20));
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }*/

        try {
            Class<?> clazz = Class.forName("javase24.entity.Student");
            Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
            constructor.setAccessible(true);
            Object o = constructor.newInstance("马牛逼", 20);
            Method method = clazz.getMethod("yes");
            //Method method = clazz.getDeclaredMethod("yes");
            //method.setAccessible(true);
            System.out.println(method.invoke(o));
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

    }

    static void test2() {

        try {
            Class<?> clazz = Class.forName("javase24.entity.Student");
            Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
            Object o = constructor.newInstance("马牛逼", 20);
            Method method = clazz.getMethod("yes", String.class);
            for (Class<?> parameterType : method.getParameterTypes()) {
                System.out.println(parameterType);
            }
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //test1();
        test2();
    }

}
