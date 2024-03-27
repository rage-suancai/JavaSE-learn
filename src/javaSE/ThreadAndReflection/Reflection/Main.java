package javaSE.ThreadAndReflection.Reflection;

import java.lang.reflect.*;

public class Main {

    private static Field field;

    public static void main(String[] args) throws Exception {

        //reflectionTest1();

        //reflectionTest2();

        //reflectionTest3();

        //reflectionTest4();

        reflectionTest5();

    }

    private static void reflectionTest1() throws Exception {

        /*Class<String> clazz1 = String.class;
        Class<?> clazz2 = Class.forName("java.lang.String");
        Class<?> clazz3 = new String("cpdd").getClass();

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);*/

        /*Class<?> clazz = int.class;
        System.out.println(clazz);*/

        /*Class<?> clazz = int.class;
        System.out.println(Integer.TYPE == int.class);*/

        Class<String[]> clazz = String[].class;
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getTypeName());
        System.out.println(clazz.getClassLoader());
        System.out.println(clazz.getTypeName());

    }

    private static void reflectionTest2() {

        /*String str = "";
        System.out.println(str instanceof String);*/

        /*String str = "";
        System.out.println(str.getClass() == String.class);*/

        /*Integer i = 10;
        i.getClass().asSubclass(Number.class);*/

        /*Integer i = 10;
        System.out.println(i.getClass().getSuperclass());*/

        /*Integer i = 10;
        Type type = i.getClass().getGenericSuperclass();
        System.out.println(type);
        System.out.println(type instanceof Class);*/

        Integer i = 10;
        for (Class<?> anInterface : i.getClass().getInterfaces()) {
            System.out.println(anInterface.getName());
        }
        for (Type genericInterface : i.getClass().getGenericInterfaces()) {
            System.out.println(genericInterface.getTypeName());
        }

    }

    private static void reflectionTest3() throws Exception {

        /*Class<Student> clazz = Student.class;
        Student student = clazz.newInstance();
        student.test();*/

        /*Class<Student> clazz = Student.class;
        Student student = clazz.getConstructor(String.class).newInstance("what's up");
        student.test();*/

        Class<Student> clazz = Student.class;
        Constructor<Student> constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Student student = constructor.newInstance("what's up");
        student.test();

    }
    private static class Student {

        public Student(String text) { }

        public void test() {
            System.out.println("萨日朗");
        }

    }

    private static void reflectionTest4() throws Exception {

        /*Class<?> clazz = Class.forName("javaSE.ThreadAndReflection.Reflection.Student");
        Object instance = clazz.getDeclaredConstructor().newInstance();
        Method method = clazz.getMethod("test", String.class);
        method.invoke(instance, " what's up");*/

        Class<?> clazz = Class.forName("javaSE.ThreadAndReflection.Reflection.Student");
        Object instance = clazz.getDeclaredConstructor().newInstance();
        Method method1 = clazz.getDeclaredMethod("test2", String.class);
        method1.setAccessible(true);
        method1.invoke(instance, " what's up");

    }

    private static void reflectionTest5() throws Exception {

        /*Class<?> clazz = Class.forName("javaSE.ThreadAndReflection.Reflection.Student");
        Object instance = clazz.getDeclaredConstructor().newInstance();
        Field field = clazz.getField("i");
        field.set(instance, 100);
        Method method = clazz.getMethod("test3");
        method.invoke(instance);*/

        Class<?> clazz = Class.forName("javaSE.ThreadAndReflection.Reflection.Student");
        Object instance = clazz.getDeclaredConstructor().newInstance();
        Field field = clazz.getDeclaredField("i");
        field.setAccessible(true);
        field.set(instance, 100);
        Method method = clazz.getDeclaredMethod("test3");
        method.invoke(instance);

    }

}
