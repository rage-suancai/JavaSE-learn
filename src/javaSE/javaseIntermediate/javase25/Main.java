package javaSE.javaseIntermediate.javase25;

import javaSE.javaseIntermediate.javase11.LinkedStack;

/**
 * 集合类编程实战
 *
 * 本题来自LeetCode: 20.有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串s 判断字符串是否有效
 *
 * 有效字符串需满足:
 *
 *      1.左括号必须用相同类型的右括号闭合
 *      2.左括号必须以正确的顺序闭合
 *
 * 示例1:
 *
 *                  输入: s = "()"
 *                  输出: true
 *
 * 示例2:
 *
 *                  输入: s = "()[]{}"
 *                  输出: true
 *
 * 示例3:
 *
 *                  输入: s = "(]"
 *                  输出: false
 *
 * 示例4:
 *
 *                  输入: s = "([)]"
 *                  输出: false
 *
 * 示例5:
 *
 *                  输入: s = "{[]}"
 *                  输出: true
 *
 * 题干很明确 就是需要我们去对这些括号完成匹配 如果给定字符串中的括号无法完成一一匹配的话 那么就表示匹配失败
 * 实际上这种问题我们就可以利用前面学习的栈这种数据结构来解决 我们可以将所有括号的左半部分放入栈中 当遇到右半部分时
 * 进行匹配 如果匹配失败 那么就失败 如果匹配成功 那么就消耗一个左半部分 直到括号消耗完毕
 */
public class Main {

    public boolean isValid(String s) {

        LinkedStack<Character> stack = new LinkedStack<>();

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else if (stack.isEmpty()) return false;
                Character ch = stack.pop();
                if (c == ')' && ch != '(') return false;
                if (c == ']' && ch != '[') return false;
                if (c == '}' && ch != '{') return false;
        }
        return stack.isEmpty();

    }

}
