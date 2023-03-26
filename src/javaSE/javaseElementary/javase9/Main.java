package javaSE.javaseElementary.javase9;

public class Main {

    static void test1() {

        /*String a = "yxs", b = "nb";
        String l = a + b;
        System.out.println(l);*/

        StringBuilder builder = new StringBuilder();
        builder
                .append("y")
                .append("x")
                .append("s");
        String str = builder.toString();
        System.out.println(str);

    }

    public static void main(String[] args) {
        test1();
    }

}
