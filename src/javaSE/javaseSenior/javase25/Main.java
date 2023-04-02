package javaSE.javaseSenior.javase25;

import java.lang.annotation.Annotation;

@Test("Fuck World")
public class Main {

    /*@Test()
    static void test1() {

    }*/

    /*@Test({"value1", "value2"})
    static void test2() {

    }*/

    @Test("Fuck World")
    static void test3() {

    }

    public static void main(String[] args) throws NoSuchMethodException {

        //test1();

        Class<Main> mainClass = Main.class;

        /*Test annotation1 = mainClass.getAnnotation(Test.class);
        System.out.println(annotation1.value());*/

        /*Method method = mainClass.getDeclaredMethod("test3");
        Test annotation2 = method.getAnnotation(Test.class);
        System.out.println(annotation2.value());*/

        /*for (Annotation annotation : mainClass.getAnnotations()) {
            System.out.println(annotation.annotationType());
            System.out.println(annotation instanceof Test);
            Test test = (Test) annotation;
            System.out.println(test.value());
        }*/

        for (Annotation annotation : mainClass.getDeclaredMethod("test3").getAnnotations()) {
            System.out.println(annotation.annotationType());
            System.out.println(annotation instanceof Test);
            Test test = (Test) annotation;
            System.out.println(test.value());
        }

    }

}
