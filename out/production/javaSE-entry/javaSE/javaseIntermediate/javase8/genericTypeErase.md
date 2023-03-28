类型擦除

前面我们已经了解如何使用泛型 那么泛型到底是如何实现的呢 程序编译之后的样子是什么样的?

                    public abstract class A <T>{
                        abstract T test(T t);
                    }

实际上在Java中并不是真的有泛型类型(为了兼容之前的Java版本)因为所有的对象都是属于一个普通的类型 一个泛型类型编译之后 实际上会直接使用默认的类型:

                    public abstract class A {
                        abstract Object test(Object t); // 默认就是Object
                    }

当然 如果我们给类型变量设定了上界 那么会从默认类型变成上界定义的类型:

                    public abstract class A <T extends Number>{ // 设定上界为Number
                        abstract T test(T t);
                    }

那么编译之后:

                    public abstract class A {
                        abstract Number test(Number t); // 上界Number 因为现在只可能出现Number的子类
                    }

因此 泛型其实仅仅是在编译阶段进行类型检查 当程序在运行时 并不会真的去检查对应类型 所以说哪怕是我们不去指定类型也可以直接使用

                    public static void main(String[] args) {
                        Test test = new Test(); // 对于泛型类Test 不指定具体类型也是可以的 默认就是原始类型
                    }

只不过此时编译器会给出警告:

        https://fast.itbaima.net/2022/09/27/kVCIg3TilOuLFmj.png

同样的 由于类型擦除 实际上我们在使用时 编译后的代码是进行了强制类型转换的:

                    public static void main(String[] args) {

                        A<String> a = new B();
                        String  i = a.test("10"); // 因为类型A只有返回值为原始类型Object的方法

                    }

实际上编译之后:

                    public static void main(String[] args) {

                        A a = new B();
                        String i = (String) a.test("10"); // 依靠强制类型转换完成的

                    }

不过 我们思考一个问题 既然继承泛型类之后可以明确具体类型 那么为什么@Override不会出现错误呢? 我们前面说了重写的条件是需要和父类的返回值类型和形参一致
而泛型默认的原始类型是Object类型 子类明确后变为其他类型 这显然不满足重写的条件 但是为什么依然能编译通过呢?

                    public class B extends A<String>{

                        @Override
                        String test(String s) {
                            return null;
                        }

                    }

我们来看看编译之后长啥样:

                    // Compiled from "B.java"
                    public class com.test.entity.B extends com.test.entity.A<java.lang.String> {

                        public com.test.entity.B();
                        java.lang.String test(java.lang.String);
                        java.lang.Object test(java.lang.Object); // 桥接方法 这才是真正重写的方法 但是使用时会调用上面的方法

                    }

通过反编译进行观察 实际上是编译器帮助我们生成了一个桥接方法用于支持重写:

                    public class B extends A {
    
                        public Object test(Object obj) { // 这才是重写的桥接方法
                            return this.test((Integer) obj); // 桥接方法调用我们自己写的方法
                        }
                        
                        public String test(String str) { // 我们自己写的方法
                            return null;
                        }

                    }

类型擦除机制其实就是为了方便使用后面集合类(不然每次都要强制类型转换)同时为了向下兼容采取的方案 因此 泛型的使用会有一些限制:

首先 在进行类型判断时 不允许使用泛型 只能使用原始类型

        https://fast.itbaima.net/2022/09/27/q7DQ9lAweJLOFky.png

只能判断是不是原始类型 里面的具体类型是不支持的:

                    Test<String> test = new Test<>();
                    System.out.println(test instanceof Test); // 在进行类型判断时 不允许使用泛型 只能使用原始类型

只不过只是把它当做泛型类型的数组还是可以用的:

        https://fast.itbaima.net/2022/09/27/upjWbyq9XC5FLDv.png