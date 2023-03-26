package javaSE.javaseElementary.javase25;

import javaSE.javaseElementary.javase25.persion.Exam;
import javaSE.javaseElementary.javase25.persion.Person;

/**
 * 面向对象编程实战
 *
 * 虽然我们学习了编程 但是我们不能一股脑的所有问题都照着编程的思维去解决 编程只是解决问题的一种手段
 * 灵活的运用我们所学的知识 才是解决问题的最好办法 比如 求1到100所有的数的和:
 *
 *                  int sum = 0;
 *                  for (int i = 1; i <= 100; i++) // for循环暴力求解 简单 但是效率似乎低了一些
 *                      sum += i;
 *                  System.out.println(sum);
 *
 *                  System.out.println((1 + 100) * 50); // 高斯求和公式 利用数学公式 瞬间计算结果
 *
 * 说到最后 其实数学逻辑思维才是解决问题的最终办法
 *
 * 对象设计(面向对象 多态运用)
 *
 *      > 设计一个Person抽象类 包含吃饭运动学习三种行为 分为工人 学生 老师三种职业
 *      > 设计一个接口 只有老师和学生会考试
 *      > 设计一个方法 模拟让人类进入考场 要求只有考试资格的才能考试
 */
public class Main {

    private static void test(Person person) {

        if (person instanceof Exam) {
            Exam e = (Exam) person;
            e.exam();
        }

    }

    public static void main(String[] args) {



    }

}
