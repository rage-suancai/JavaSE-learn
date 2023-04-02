package javaSE.javaseSenior.javase18;

import java.lang.reflect.Type;

public class Main {

    static void test1() {

        /*String str = "";
        System.out.println(str instanceof String);*/

        /*String str = "";
        System.out.println(str.getClass() == String.class);*/

        Integer i = 10;
        i.getClass().asSubclass(Number.class);

    }

    static void test2() {

        /*Integer i = 10;
        System.out.println(i.getClass().getSuperclass());*/

        /*Integer i = 10;
        Type type = i.getClass().getGenericSuperclass();
        System.out.println(type);
        System.out.println(type instanceof Class);*/

        Integer i = 10;
        for (Class<?> anInterface : i.getClass().getInterfaces())
            System.out.println(anInterface.getName());
        for (Type genericInterface : i.getClass().getGenericInterfaces())
            System.out.println(genericInterface.getTypeName());

    }

    public static void main(String[] args) {

        //test1();
        test2();

    }

}
