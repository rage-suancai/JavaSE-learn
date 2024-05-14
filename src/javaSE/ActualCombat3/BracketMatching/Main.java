package javaSE.ActualCombat3.BracketMatching;

import javaSE.DataStructure.Stack;

public class Main {

    public static void main(String[] args) {



    }

    private boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            if (stack.isEmpty()) return false;
            Character ch = stack.pop();
            if (c == ')' && ch != '(') return false;
            if (c == ']' && ch != '[') return false;
            if (c == '}' && ch != '{') return false;
        }
        return stack.isEmpty();

    }

}
