package javaSE.javaseIntermediate.javase6;

public class Main {

    static <E> void test(E e) {
        System.out.println(e);
    }

    public static void main(String[] args) {

        //Score2<int> score2 = new Score2<int>("数据结构与算法基础", "1", 1);

        test(100.0);
        test("Fuck World");

    }

}
