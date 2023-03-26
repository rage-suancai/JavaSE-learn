package javaSE.javaseIntermediate.javase27;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 通过上面的例子 我们发现 Stream不喜欢直接给我们返回一个结果 而是通过Optional的方式 那么上面是Optional呢?
 *
 * Optional类是java8为了解决null值判断问题 使用Optional类可以避免显式的null值判断(null的防御性检查)
 * 避免null导致的NPE (NullPointerException) 总而言之 就是对控制的一个判断为了避免空指针异常
 *                  List<String> list = new ArrayList<>();
 *                  String str = null;
 *                  if (str != null) { // 当str不为空时添加元素到list中
 *                      list.add(str);
 *                  }
 *                  System.out.println(list);
 *
 * 有了Optional之后 我们就可以这样写:
 *                  String str = null;
 *                  Optional<String> optional = Optional.ofNullable(str); // 转换为Optional
 *                  optional.ifPresent(System.out::println); // 当存在时再执行方法
 *
 * 就类似于Kotlin中的:
 *                  var str : String? = null
 *                  str?.upperCase()
 *
 * 我们可以选择直接get或是当值为null时 获取备选值:
 *                  String str = null;
 *                  Optional<String> optional = Optional.ofNullable(str); // 转换为Optional(可空)
 *                  System.out.println(optional.orElse("yxsnb"));
 *                  System.out.println(optional.get()); // 这样会直接抛异常
 *
 * 同样的 Optional也支持过滤操作和映射操作 不过是对于单对象而言:
 *                  String str = "A";
 *                  Optional<String> optional = Optional.ofNullable(str); // 转换为Optional(可空)
 *                  System.out.println(optional.filter(s -> s.equals("B")).get()); // 被过滤了 此时元素为null 获取时报错
 *
 *                  String str = "A";
 *                  Optional<String> optional = Optional.ofNullable(str); // 转换为Optional(可空)
 *                  System.out.println(optional.map(s -> s + "A").get()); // 在尾部追加一个A
 *
 * 其他操作自动学了解
 */
public class Main {

    static void test1() {

        List<String> list = new ArrayList<>();
        String str = null;
        if (str != null) {
            list.add(str);
        }
        System.out.println(list);

    }

    static void test2() {

        /*String str = null;
        Optional<String> optional = Optional.ofNullable(str);
        optional.ifPresent(System.out::println);*/

        /*String str = null;
        Optional<String> optional = Optional.ofNullable(str);
        System.out.println(optional.orElse("yxsnb"));
        System.out.println(optional.get());*/

        /*String str = "A";
        Optional<String> optional = Optional.ofNullable(str);
        System.out.println(optional.filter(s -> s.equals("B")).get());*/

        String str = "A";
        Optional<String> optional = Optional.ofNullable(str);
        System.out.println(optional.map(s -> s + "A").get());

    }

    public static void main(String[] args) {
        //test1();
        test2();
    }

}
