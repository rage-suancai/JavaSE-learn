package javaSE.Generics;

public class Main {

    public static void main(String[] args) {

        Score<String> score = new Score<String>("计算机网络", "EP074512", "优秀");

        String value = score.value; System.out.println(value);

    }

}
