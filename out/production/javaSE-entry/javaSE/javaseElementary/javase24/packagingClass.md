基本类型包装类

java并不是纯面向对象的语言 虽然java语言是一个面向对象的语言 但是java中的基本数据类型不是面向对象的 在学习泛型和集合之前 基本类型的包装类是一定要讲解的内容

我们的基本类型 如果想通过对象的形式去使用它们 java提供的基本类包装类 使得java能够更好的体现面向对象的思想 同时也使得基本类能够支持对象操作:

     > byte -> Byte
     > boolean -> Boolean
     > short -> Short
     > char -> Character
     > int -> Integer
     > long -> Long
     > float -> Float
     > double -> Double

包装类实际上就是将我们的基本数据类型 封装成一个类(运用了封装的思想):

                 private final int value; // Integer内部其实本质还是存了一个基本类型的数据 但是我们不能直接操作

                 public Integer(int value) {
                     this.value = value;
                 }

现在我们操作的就是Integer对象而不是一个int基本类型了:

                 public static void main(String[] args) {

                     Integer i = 1; // 包装类型可以直接接收对应类的数据 并变为一个对象
                     System.out.println(i + i); // 包装类型可以直接被当做一个基本类型进行操作

                 }

自动装箱和拆箱

那么为什么包装类型能直接使用一个具体值来赋值呢 其实依靠的是自动装箱和拆箱机制:

                 Integer i = 1; // 其实这里只要是简写了而已
                 Integer i = Integer.valueOf(1); // 编译后真正的样子

调用valueOf来生成一个Integer对象:

                 public static Integer valueOf(int i) {
                     if (i >= IntegerCache.low && i <= IntegerCache.high) // 注意: java为了优化 有一个缓存机制 如果是在-128-127之间的数会直接使用已缓存好的对象 而不是再去创建新的(面试常考)
                         return IntegerCache.cache[i + (-IntegerCache.low)];
                     return new Integer(i); // 返回一个新创建好的对象
                 }

而如果使用包装类来进行运算 或是赋值给一个基本类型变量 会进行自动拆箱:

                 Integer i = Integer.valueOf(1);
                 int a = i; // 简写
                 int a = i.intValue(); // 编译后实际的的代码

                 long c = i.longValue(); // 其他类型也有

既然现在是包装类型了 那么我们还能使用==来判断两个数是否相等吗?

                 Integer i1 = 28914;
                 Integer i2 = 28914;
                 System.out.println(i1 == i2); // 实际上判断的是两个对象是否为同一个对象(内存地址是否相同)
                 System.out.println(i1.equals(i2)); // 这个才是真正的值判断

注意: IntegerCache带来的影响

思考: 下面这种情况结果会是什么?

                 public static void main(String[] args) {

                     Integer i1 = 28914;
                     Integer i2 = 28914;
                     System.out.println(i1+1 == i2+1);

                 }

在集合类的学习中 我们还会继续用到我们的包装类型