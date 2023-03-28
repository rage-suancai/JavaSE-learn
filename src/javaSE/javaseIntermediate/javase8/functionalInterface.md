函数式接口

学习了泛型 我们来介绍一下再JDK 1.8中新增的函数式接口

函数式接口就是JDK1.8专门为我们提供好的用于Lambda表达式的接口 这些接口都可以直接使用Lambda表达式 非常方便 这里我们主要介绍一下四个主要的函数式接口:

Supplier供给型函数式接口: 这个接口是专门用于供给使用的，其中只有一个get方法用于获取需要的对象

                    @FunctionalInterface // 函数式接口都会打上这样一个注解
                    public interface Supplier<T> {
                        T get(); // 实现此方法 实现供给功能
                    }

比如我们要实现一个专门供给Student对象Supplier 就可以使用:

                    public class Student {
                        public void hello(){
                            System.out.println("我是学生！");
                        }
                    }

                    // 专门供给Student对象的Supplier
                    private static final Supplier<Student> STUDENT_SUPPLIER = Student::new;

                    public static void main(String[] args) {

                        Student student = STUDENT_SUPPLIER.get();
                        student.hello();

                    }

Consumer消费型函数式接口: 这个接口专门用于消费某个对象的

                    @FunctionalInterface
                    public interface Consumer<T> {
                        void accept(T t); // 这个方法就是用于消费的 没有返回值
                    
                        default Consumer<T> andThen(Consumer<? super T> after) { // 这个方法便于我们连续使用此消费接口
                            Objects.requireNonNull(after);
                            return (T t) -> { accept(t); after.accept(t); };
                        }
                    }

使用起来也是很简单的:

                    // 专门消费Student对象的Consumer
                    private static final Consumer<Student> STUDENT_CONSUMER = student -> System.out.println(student+" 真好吃！");

                    public static void main(String[] args) {

                        Student student = new Student();
                        STUDENT_CONSUMER.accept(student);

                    }

当然 我们也可以使用andThen方法继续调用:

                    public static void main(String[] args) {

                        Student student = new Student();
                        STUDENT_CONSUMER // 我们可以提前将消费之后的操作以同样的方式预定好
                                .andThen(stu -> System.out.println("我是吃完之后的操作!")) 
                                .andThen(stu -> System.out.println("好了好了 吃饱了！"))
                                .accept(student); // 预定好之后 再执行

                    }

这样 就可以在消费之后进行一些其他的处理了 使用很简洁的代码就可以实现:

        https://fast.itbaima.net/2022/09/27/Pu1jGzKNSvnV9YZ.png

Function函数型函数式接口: 这个接口消费一个对象 然后会向外供给一个对象(前两个的融合体)

                    @FunctionalInterface
                    public interface Function<T, R> {
                    R apply(T t);   // 这里一共有两个类型参数 其中一个是接受的参数类型 还有一个是返回的结果类型
                    
                        default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
                            Objects.requireNonNull(before);
                            return (V v) -> apply(before.apply(v));
                        }
                    
                        default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
                            Objects.requireNonNull(after);
                            return (T t) -> after.apply(apply(t));
                        }
                    
                        static <T> Function<T, T> identity() {
                            return t -> t;
                        }
                    }

这个接口方法有点多 我们一个一个来看 首先还是最基本的apply方法 这个是我们需要实现的:

                    // 这里实现了一个简单的功能 将传入的int参数转换为字符串的形式
                    private static final Function<Integer, String> INTEGER_STRING_FUNCTION = Object::toString;

                    public static void main(String[] args) {

                        String str = INTEGER_STRING_FUNCTION.apply(10);
                        System.out.println(str);

                    }

我们可以使用compose将指定函数式的结果作为当前函数式的实参:

                    public static void main(String[] args) {
                        String str = INTEGER_STRING_FUNCTION
                                .compose((String s) -> s.length())   // 将此函数式的返回值作为当前实现的实参
                                .apply("lbwnb");   // 传入上面函数式需要的参数
                        System.out.println(str);
                    }

相反的 andThen可以将当前实现的返回值进行进一步的处理 得到其他类型的值:

                    public static void main(String[] args) {

                        Boolean str = INTEGER_STRING_FUNCTION
                                .andThen(String::isEmpty) // 在执行完后 返回值作为参数执行andThen内的函数式 最后得到的结果就是最终的结果了
                                .apply(10);
                        System.out.println(str);

                    }

比较有趣的是 Function中还提供了一个将传入参数原样返回的实现:

                    public static void main(String[] args) {

                        Function<String, String> function = Function.identity(); // 原样返回
                        System.out.println(function.apply("不会吧不会吧 不会有人听到现在还是懵逼的吧"));

                    }

Predicate断言型函数式接口: 接收一个参数 然后进行自定义判断并返回一个boolean结果

                    @FunctionalInterface
                    public interface Predicate<T> {
                    boolean test(T t); // 这个方法就是我们要实现的
                    
                        default Predicate<T> and(Predicate<? super T> other) {
                            Objects.requireNonNull(other);
                            return (t) -> test(t) && other.test(t);
                        }
                    
                        default Predicate<T> negate() {
                            return (t) -> !test(t);
                        }
                    
                        default Predicate<T> or(Predicate<? super T> other) {
                            Objects.requireNonNull(other);
                            return (t) -> test(t) || other.test(t);
                        }
                    
                        static <T> Predicate<T> isEqual(Object targetRef) {
                            return (null == targetRef)
                                    ? Objects::isNull
                                    : object -> targetRef.equals(object);
                        }

                    }

我们可以来编写一个简单的例子:

                    public class Student {
                        public int score;
                    }

                    private static final Predicate<Student> STUDENT_PREDICATE = student -> student.score >= 60;

                    public static void main(String[] args) {

                        Student student = new Student();
                        student.score = 80;
                        if(STUDENT_PREDICATE.test(student)) { // test方法的返回值是一个boolean结果
                            System.out.println("及格了 真不错 今晚奖励自己一次");
                        } else {
                            System.out.println("不是 Java都考不及格? 隔壁初中生都在打ACM了");
                        }

                    }

我们也可以使用组合条件判断:

                    public static void main(String[] args) {

                        Student student = new Student();
                        student.score = 80;
                        boolean b = STUDENT_PREDICATE
                                .and(stu -> stu.score > 90) // 需要同时满足这里的条件 才能返回true
                                .test(student);
                        if(!b) System.out.println("Java到现在都没考到90分? 你的室友都拿国家奖学金了");

                    }

同样的 这个类型提供了一个对应的实现 用于判断两个对象是否相等:

                    public static void main(String[] args) {

                        Predicate<String> predicate = Predicate.isEqual("Hello World"); // 这里传入的对象会和之后的进行比较
                        System.out.println(predicate.test("Hello World"));

                    }

通过使用这四个核心的函数式接口 我们就可以使得代码更加简洁 具体的使用场景会在后面讲解