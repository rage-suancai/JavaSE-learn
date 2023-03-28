package javaSE.javaseIntermediate.javase5;

public class Main {

    static void test1() {

        Score1 score1 = new Score1("数据结构", "1", "优秀");
        Score1 score2 = new Score1("数据结构", "2", 100.0);

        String str1 = (String) score1.score;
        Double str2 = (Double) score2.score;
        System.out.println(str1);
        System.out.println(str2);

    }

    static void test2() {

        Score2<Double> score1 = new Score2<Double>("数据结构与算法基础", "1", 100.0);
        Score2<String> score2 = new Score2<String>("数据结构与算法基础", "2", "优秀");

        Double str1 = score1.score;
        String str2 = score2.score;
        System.out.println(str1);
        System.out.println(str2);

        // Integer i = score2.score;

    }

    public static void main(String[] args) {
        //test1();
        test2();
    }

}
