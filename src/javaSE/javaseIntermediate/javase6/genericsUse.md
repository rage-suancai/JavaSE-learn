泛型的使用

泛型类

泛型其实就一个待定类型 我们可以使用一个特殊的名字表示泛型 泛型在定义时并不明确是什么类型 而是需要到使用时才会确定对应的泛型类型

我们可以将一个类定义为一个泛型类:

                    public class Score<T> { //泛型类需要使用<> 我们需要在里面添加1 - N个类型变量

                        String name;
                        String id;
                        T value; // T会根据使用时提供的类型自动变成对应类型
                    
                        public Score(String name, String id, T value) { //这里T可以是任何类型 但是一旦确定 那么就不能修改了
                            this.name = name;
                            this.id = id;
                            this.value = value;
                        }

                    }

我们来看看这是如何使用的:

                    public static void main(String[] args) {

                        Score<String> score = new Score<String>("计算机网络", "EP074512", "优秀");
                        // 因为现在有了类型变量 在使用时同样需要跟上<>并在其中填写明确要使用的类型
                        // 这样我们就可以根据不同的类型进行选择了
                        String value = score.value; // 一旦类型明确 那么泛型就变成对应的类型了
                        System.out.println(value);

                    }

泛型将数据类型的确定控制在了编译阶段 在编写代码的时候就能明确泛型的类型 如果类型不符合
将无法通过编译 因为是具体使用对象时才会明确具体类型 所以说静态方法中是不能用的

        https://fast.itbaima.net/2022/09/27/RCqAhvMGzNwfH7J.png

只不过这里需要注意一下 我们在方法中使用待确定类型的变量时 因为此时并不明确具体是什么类型
那么默认会认为这个变量是一个Object类型的变量 因为无论具体类型是什么 一定是Object类的子类

        https://fast.itbaima.net/2022/09/26/gkFs35US9rxo7f2.png

我们可以对其进行强制类型转换 但是实际上没多大必要:

                    public void test(T t){
                        String str = (String) t; //都明确要用String了 那这里定义泛型不是多此一举吗
                    }

因为泛型本身就是对某些待定类型的简单处理 如果都明确要使用什么类型了 那大可不必使用泛型 还有 不能通过这个不确定的类型变量就去直接创建对象和对应的数组

        https://fast.itbaima.net/2022/09/27/RlHYhPSUJ5ICswG.png

注意 具体类型不同的泛型类变量 不能使用不同的变量进行接收:

        https://fast.itbaima.net/2022/09/25/jhekq9ZKHoiT2yI.png

如果要让某个变量支持引用确定了任意类型的泛型 那么可以使用?通配符:

                    public static void main(String[] args) {

                        Test<?> test = new Test<Integer>();
                        test = new Test<String>();
                        Object o = test.value; // 但是注意 如果使用通配符 那么由于类型不确定 所以说具体类型同样会变成Object

                    }

当然 泛型变量不止可以只有一个 如果需要使用多个的话 我们也可以定义多个:

                    public class Test<A, B, C> { //多个类型变量使用逗号隔开

                        public A a;
                        public B b;
                        public C c;

                    }

那么在使用时 就需要将这三种类型都进行明确指定:

                    public static void main(String[] args) {

                        Test<String, Integer, Character> test = new Test<>(); // 使用钻石运算符可以省略其中的类型
                        test.a = "lbwnb";
                        test.b = 10;
                        test.c = '淦';

                    }

是不是感觉好像还是挺简单的? 只要是在类中 都可以使用类型变量:

                    public class Test<T>{
    
                        private T value;
                    
                        public void setValue(T value) {
                            this.value = value;
                        }
                    
                        public T getValue() {
                            return value;
                        }

                    }

只不过 泛型只能确定为一个引用类型 基本类型是不支持的:

                    public class Test<T>{
                        public T value;
                    }

        https://fast.itbaima.net/2022/09/26/TI6tWwj4vXFdenr.png

如果要存放基本数据类型的值 我们只能使用对应的包装类:

                    public static void main(String[] args) {
                        Test<Integer> test = new Test<>();
                    }

通过使用泛型 我们就可以将某些不明确的类型在具体使用时再明确