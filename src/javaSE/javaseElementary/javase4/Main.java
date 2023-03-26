package javaSE.javaseElementary.javase4;

/**
 * 对象设计练习:
 *
 *      > 学生应该具有以下属性: 名字 年龄
 *      > 学生应该具有以下行为: 学习 运动 说话
 */
public class Main {

    public static void main(String[] args) {

        Student student = new Student();
        student.name = "瑞克";
        student.age = 22;

        student.study();
        student.sport();
        student.speak("正在说话...");

    }

}
