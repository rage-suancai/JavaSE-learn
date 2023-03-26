package javaSE.javaseIntermediate.javase6;

import javaSE.javase5.Score2;

/**
 * 泛型的使用
 * 泛型类
 * 上一节我们已经提到泛型类的定义 实际上就是普通的类多了一个类型参数 也就是在使用时需要指定具体的泛型类型
 * 泛型的名称一般取单个大写字母 比如T代表Type 也就是类型的英文单纯首字母 当然也可以添加数字和其他的字符
 *                  public class Score<T> { // 将Score转换为泛型类<T>
 *                      String name;
 *                      String id;
 *                      T score; // T为泛型 根据用户提供的类型自动变成对应类型
 *
 *                      public Score(String name, String id, T score) { // 提供的score类型即为T代表的类型
 *                          this.name = name;
 *                          this.id = id;
 *                          this.score = score;
 *                      }
 *
 *                  }
 *
 * 在一个普通类型中定义泛型 泛型T称为参数化类型 在定义泛型类的引用时 需要明确指出类型:
 *                  Score<String> score = new Score<String>("数据结构与算法基础", "1", "优秀");
 *
 * 此时类中的泛型T已经被替换为String了 在我们获取此对象的泛型属性时 编译器会直接告诉我们类型:
 *                  Integer i = score.score; // 编译不通过 因为成员变量score明确为String类型
 *
 * 注意: 泛型只能用于对象属性 也就是非静态的成员变量才能使用:
 *                  static T score; // 错误 不能在静态成员上定义
 *
 * 由此可见 泛型是只有在创建对象后编译器才能明确泛型类型 而静态类型是类所具有的属性 不足以使得编译器完成类型推断
 *
 * 同样的 静态方法无法直接使用类定义的泛型(注意: 是无法直接使用 静态方法可以使用泛型)
 *
 * 泛型无法使用基本类型 如果需要使用基本类型 只能使用基本类型的包装类进行替换
 *                  Score<double> score = new Score<double>("数据结构与算法基础", "1", 90.5); // 编译不通过
 *
 * 那么为什么泛型无法使用基本类型呢 回想上一节提到的类型擦除 其实就很好理解了 由于JVM没有泛型概念 因此泛型最后还是会被编译器编译为Object
 * 并采用强制类型转换的形式进行类型匹配 而我们的基本数据类型和引用类型之间无法进行类型转换 所以只能使用基本类型的包装类来处理
 *
 * 类的泛型方法
 * 泛型方法的使用也很简单 我们只需要把它当作一个未知的类型来使用即可:
 *                  public T getScore() { // 若方法的返回值类型为泛型 那么编译器会自动进行推断
 *                      return score;
 *                  }
 *
 *                  public void setScore(T score) { // 若方法的形式参数为泛型 那么实参只能是定义时的类型
 *                      this.score = score;
 *                  }
 *
 * 自定义泛型方法
 * 那么如果我们想在静态方法中使用泛型呢 首先我们要明确之前为什么无法使用泛型 因为之前我们的泛型定义是在类上的 只有明确具体的类型在能开始使用
 * 也就是创建对象时完成类型确定 但是静态方法不需要依附于对象 那么只能在使用时再来确定了 所以静态方法可以使用泛型 但是需要单独定义:
 *                  public static <E> void test(E e) { // 在方法定义前声明泛型
 *                      System.out.println(e);
 *                  }
 *
 * 同理 成员方法也能自行定义泛型 再实际使用时再进行类型确定:
 *                  public <E> void test(E e) {
 *                      System.out.println(e);
 *                  }
 *
 * 其实 无论是泛型还是泛型方法 再使用时一定要能够进行类型推断 明确类型才行
 *
 * 注意: 一定要区分类定义的泛型和方法前定义的泛型
 */
public class Main {

    static <E> void test(E e) {
        System.out.println(e);
    }

    public static void main(String[] args) {

        //Score2<int> score2 = new Score2<int>("数据结构与算法基础", "1", 1);

        test(100.0);
        test("Fuck World");

    }

}
