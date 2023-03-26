package javaSE.javaseIntermediate.javase7;

import javaSE.javase5.Score2;

/**
 * 泛型引用
 * 可以看到我们在定义一个泛型类的引用时 需要在后面指出此类型:
 *                  Score<Integer> score; // 声明泛型为Integer类型
 *
 * 如果不希望指定类型 或是希望此引用类型可以引用任意泛型的Score类对象 可以使用?通配符 来表示自动匹配任意的可用类型:
 *                  Score<?> score; // score可用引用任意的Score类型对象了
 *
 * 那么使用通配符之后 得到的泛型成员变量会是声明类型呢?
 *                  Object o = score.getScore(); // 只能变为Object
 *
 * 因为使用了通配符 编译器就无法进行类型推断 所以只能使用原始类型
 *
 * 在学习了泛型的界限后 我们还会继续了解通配符的使用
 *
 * 泛型的界限
 * 现在有一个新的需求 现在没有String类型的成绩了 但是成绩依然可能是整数 也可能是小数 这时我们不希望用户将泛型指定为除数字类型外的其他类型 我们就需要使用到泛型的上界定义:
 *                  public class Score<T extends Number> { // 设定泛型上界 必须是Number的子类
 *
 *                      private final String name;
 *                      private final String id;
 *                      private T score;
 *
 *                      public Score(String name, String id, T score) {
 *                          this.name = name;
 *                          this.id = id;
 *                          this.score = score;
 *                      }
 *
 *                      public T getScore() {
 *                          return score;
 *                      }
 *
 *                  }
 *
 * 通过extends关键字进行上界限定 只有指定类型或指定类型的子类才能作为类型参数
 *
 * 同样的 泛型通配符也支持泛型的界限:
 *                  Score<? extends Number> score; // 限定为匹配Number及其子类的类型
 *
 * 同理 既然泛型有上限 那么也有下限:
 *                  Score<? super Integer> score; // 限定为匹配Number及其父类
 *
 * 通过super关键字进行下界限定 只有指定类型或指定的父类才能作为类型参数
 *
 * 那么限定了上界后 我们再来使用这个对象的泛型成员 会变成什么类型呢?
 *                  Score<? extends Number> score = new Score<>("数据结构与算法", "1", 10);
 *                  Number o = score.getScore(); // 得到的结果为上界类型
 *
 * 也就是说 一旦我们指定了上界后 编译器就将范围从原始类型Object提升到我们指定的上界Number 但是依然无法明确具体类型 思考: 那么如果定义下界呢?
 *
 * 那么既然我们可以给泛型类限定上界 现在我们来看编译后结果呢:
 *                  // 使用javap -l 进行反编译
 *                  public class javaSE.javase7.Score<T extends java.lang.Number> {
 *                    public javaSE.javase7.Score(java.lang.String, java.lang.String, T);
 *                      LineNumberTable:
 *                        line 10: 0
 *                        line 11: 4
 *                        line 12: 9
 *                        line 13: 14
 *                        line 14: 19
 *                      LocalVariableTable:
 *                        Start  Length  Slot  Name   Signature
 *                            0      20     0  this   LjavaSE/javase7/Score;
 *                            0      20     1  name   Ljava/lang/String;
 *                            0      20     2    id   Ljava/lang/String;
 *                            0      20     3 score   Ljava/lang/Number; // 可用看到score的类型直接被编译为Number类
 *
 *                    public T getScore();
 *                      LineNumberTable:
 *                        line 17: 0
 *                      LocalVariableTable:
 *                        Start  Length  Slot  Name   Signature
 *                            0       5     0  this   LjavaSE/javase7/Score;
 *                  }
 *
 * 因此 一旦确立上限后 编译器会自动将类型提升到上限类型
 *
 * 钻石运算符
 * 我们发现每次创建泛型对象都需要在前后都标明类型 但是实际上后面的类型声明是可用去掉的 因为我们在传入参数类型的引用时 就已经明确了类型 因此JDK1.7提供了钻石运算符来简化代码:
 *                  Score<Integer> score = new Score<Integer>("数据结构与算法", "1", 10); // 1.7之前
 *                  Score<Integer> score = new Score<>("数据结构与算法", "1", 10); // 1.7之后
 */
public class Main {

    public static void main(String[] args) {

        /*Score2<?> s1 = new Score2<Integer>("数据结构与算法", "1", 100);
        Score2<?> s2 = new Score2<String>("数据结构与算法", "2", "优秀");*/

        /*Score<String> score = new Score<String>("数据结构与算法", "1", 100);
        Score<Integer> score = new Score<Integer>("数据结构与算法", "1", 100);*/

        //Score<? extends Number> score = new Score<>("", "", 100);


    }

}
