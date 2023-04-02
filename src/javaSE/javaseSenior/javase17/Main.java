package javaSE.javaseSenior.javase17;

public class Main {

    static void test1() throws ClassNotFoundException {

        Class<String> clazz = String.class;
        Class<?> clazz2 = Class.forName("java.lang.String");
        Class<?> clazz3 = new String("cpdd").getClass();

        System.out.println(clazz == clazz2);
        System.out.println(clazz == clazz3);

    }

    static void test2() {

        /*Class<?> clazz = int.class;
        System.out.println(Integer.TYPE == int.class);*/

        System.out.println(Integer.TYPE == Integer.class);

    }

    static void test3() {

        Class<String[]> clazz = String[].class;
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getTypeName());
        System.out.println(clazz.getClassLoader());
        //System.out.println(clazz.cast(new Integer("10")));

    }

    public static void main(String[] args) throws ClassNotFoundException {

        //test1();
        //test2();
        test3();

    }

}
