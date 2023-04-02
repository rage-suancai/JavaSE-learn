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



    }

    public static void main(String[] args) throws ClassNotFoundException {

        test1();

    }

}
