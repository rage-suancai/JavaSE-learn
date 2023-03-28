package javaSE.javaseIntermediate.javase11;

public class Main {

    public static void main(String[] args) {

        ArrayStack<String> stack = new ArrayStack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack.pop());
        stack.push("D");

        System.out.println("debug");

    }

}
