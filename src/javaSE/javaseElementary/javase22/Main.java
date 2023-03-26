package javaSE.javaseElementary.javase22;

import javaSE.javaseElementary.javase22.service.Eat;

public class Main {

    public static void main(String[] args) {

        int c = 10;
        /*Eat eat1 = new Eat() {

            @Override
            public String eat(int i) {
                return null;
            }

        };*/

        Eat eat = i -> c + "";

    }

}
