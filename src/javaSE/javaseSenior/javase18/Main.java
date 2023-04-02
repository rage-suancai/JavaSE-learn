package javaSE.javaseSenior.javase18;

public class Main {

    static void test1() {

        try {
            Class<?> clazz1 = Class.forName("javase21.Student");
            Class<?> clazz2 = new Student().getClass();
            Class<Student> clazz3 = Student.class;

            System.out.println(clazz1 == clazz2);
            System.out.println(clazz1 == clazz3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    static void test2() {

        /*Class<?> clazz = Student.class;
        System.out.println(clazz.getName());*/

        /*Class<?> clazz = int.class;
        System.out.println(clazz);*/

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
        System.out.println(clazz.cast(new Integer("10")));

    }

    public static void main(String[] args) {

        //test1();
        //test2();
        test3();

    }

}
