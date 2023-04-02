package javaSE.javaseSenior.javase23;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class Main {

    static void test1() {

        System.out.println(Main.class.getClassLoader());
        System.out.println(Main.class.getClassLoader().getParent());
        System.out.println(Main.class.getClassLoader().getParent().getParent());
        System.out.println(String.class.getClassLoader());

    }

    static void test2() {

        try {
            MyClassLoader classLoader = new MyClassLoader();
            FileInputStream stream = new FileInputStream("Text.class");
            byte[] bytes = new byte[stream.available()];
            stream.read(bytes);
            Class<?> clazz = classLoader.defineClass("javase26.test.Text", bytes);
            System.out.println(clazz.getName());

            Method test = clazz.getMethod("test", String.class);
            Object o = clazz.newInstance();
            test.invoke(o, " xxxx");
        } catch (IOException | ReflectiveOperationException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        test1();
        //test2();
    }

    static class MyClassLoader extends ClassLoader {

        public Class<?> defineClass(String name, byte[] b) {
            return defineClass(name, b, 0, b.length);
        }

    }

}
