package javaSE.javaseIntermediate.javase11;

public class Main {

    static LinkedStack<String> stack = new LinkedStack<>();

    static void test1() {

        stack.push("AAA");
        stack.push("BBB");
        stack.push("CCC");
        while (!stack.isEmpty())
            System.out.println(stack.pop());

    }

    public static void main(String[] args) {

        test1();

    }

}
