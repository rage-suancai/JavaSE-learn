java泛型

在前面我们学习了最重要的类和对象 了解了面向对象编程的思想 注意 非常重要 面向对象是必须要深入理解和掌握的内容
不能草草结束 在本章节 我们还会继续深入了解 从泛型开始 再到数据结构 最后再开始我们的集合类学习 循序渐进

泛型

为了统计学生成绩 要求设计一个Score对象 包括课程名称 课程号 课程成绩 但是成绩分为两种 一种是以优秀、良好、合格 来作为结果 还有一种就是 60.0、75.5、92.5
这样的数字分数 可能高等数学这门课是以数字成绩进行结算 而计算机网络实验这门课是以等级进行结算 这两种分数类型都有可能出现 那么现在该如何去设计这样的一个Score类呢?

现在的问题就是 成绩可能是String类型 也可能是Integer类型 如何才能很好的去存可能出现的两种类型呢？

                 public class Score {

                     String name;
                     String id;
                     Object score; // 因为Object是所有类型的父类 因此既可以存放Integer也可能存放String

                     public Score(String name, String id, Object score) {

                         this.name = name;
                         this.id = id;
                         this.score = score;

                     }

                 }

以上的方法虽然很好地解决了多种类型存储问题 但是Object类型在编译阶段并不具有良好的类型判断能力 很容易出现以下的情况:

                 public static void main(String[] args) {

                     Score score = new Score("数据结构与算法基础", "1", "优秀");

                     // ....

                     Integer number = (Integer) score.score; // 获取成绩需要进行强制类型转换 虽然并不是一开始的类型 但是编译不会报错

                 }

                 // 运行时出现异常
                 Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast tojava.lang.Integer
	                 at javaSE.javase5.Main.main(Main.java:46)

使用Object类型作为引用 取值只能进行强制类型转换 显然无法在编译期确定类型是否安全 项目中代码量非常之大
进行类型比较又会导致额外的开销和增加代码量 如果不经比较就很容易出现类型转换异常 代码的健壮性有所欠缺

所以说这种解决办法虽然可行 但并不是最好的方案

为了解决以上问题 JDK1.5新增了泛型 它能够在编译阶段就检查类型安全 大大提升开发效率: