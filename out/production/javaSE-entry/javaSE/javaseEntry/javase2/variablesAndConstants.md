变量与常量

我们的程序不可能永远都只进行上面那样的简单打印操作 有些时候可能需要计算某些数据 此时我们就需要用到变量了

那么 什么是变量呢? 我们在数学中其实已经学习过变量了:

        变量 指值可以变的量 变量以非数字的符号来表达 一般用拉丁字母 变量的用处在于能一般化描述指令的方式
        结果只能使用真实的值指令只能应用于某些情况下 变量能够作为某特定种类的值中任何一个的保留器

比如一个公式 x^2 + 6 = 22 此时x就是一个变量 变量往往代表着某个值 比如这里的x就代表的是4这个值
在Java中 我们也可以让变量去代表一个具体的值 并且变量的值是可以发生变化的

要声明一个变量 我们需要使用以下格式:

                    [数据类型] [变量名称];

这里的数据类型我们会在下章节开始逐步讲解 比如整数就是int类型 不同类型的变量可以存储不同的类型的值
后面的变量名称顾名思义 就像x一样 这个名称我们可以随便起一个 但是注意要满足以下要求:

    > 标识符可以由大小写字母 数字 下划线()和美元符($)组成 但是不能以数字开头
    > 变量不能重复定义 大小写敏感 比如A和a就是两个不同的变量
    > 不能有空格 @ # + - / 等符号
    > 应该使用有意义的名称 达到见名知意的目的(一般我们采用英文单词) 最好以小写字母开头
    > 不可以是 true 和 false
    > 不能与Java语言的关键字或是基本数据类型重名 关键字列表如下:

            https://fast.itbaima.net/2023/03/01/I6nCh49qzyvoZBm.png

当然各位小伙伴没必要刻意去进行记忆 我们会在学习的过程中逐步认识到这些关键字 新手要辨别一个单词是否为关键字 只需要通过IDEA的高亮颜色进行区分即可 比如:

        https://fast.itbaima.net/2022/09/16/qtsjIhSGQoxBYVM.png

深色模式下 关键字会高亮为橙色 浅色模式下会高亮为深蓝色 普通的代码都是正常的灰白色

比如现在我们想要定义一个变量a 那么就可以这样编写:

                    public class Main {

                        public static void main(String[] args) {
                            int a; // 声明一个整数类型变量a
                        }

                    }

但是这个变量一开始没有任何值 比如现在我们要让这个变量表示10 那么就可以将10赋值给这个变量:

                    public static void main(String[] args) {
                        int a = 10; // 直接在定义变量后面添加 = 10 表示这个变量的初始值为10 这里的10就是一个常量数字
                    }

或者我们可以在使用时再对其进行赋值:

                    public static void main(String[] args) {
                        int a;
                        a = 10; // 使用时再赋值也可以
                    }

是不是感觉跟数学差不多? 这种写法对于我们人来说 实际上是很好理解的 意思表达很清晰

我们可以一次性定义多个变量 比如现在我们想定义两个int类型的变量:

                    public static void main(String[] args) {
                        int a, b; // 定义变量a和变量b 中间使用逗号隔开就行了
                    }

或者两个变量单独声明也可以:

                    public static void main(String[] args) {
                        int a; // 分两句进行声明
                        int b;
                    }

为了更直观地查看变量的值 我们可以直接将变量的值也给打印到控制台:

                    public static void main(String[] args) {

                        int a = 666;
                        System.out.println(a); // 之前我们在小括号写的是"" 现在我们直接将变量给进去就可以打印变量的值了
                        System.out.println(888); // 甚至直接输出一个常量值都可以

                    }

得到结果:

        https://fast.itbaima.net/2022/09/16/3nUAHINdXMmlxvJ.png

变量的值也可以在中途进行修改:

                    public static void main(String[] args) {

                        int a = 666;
                        a = 777;
                        System.out.println(a); // 这里打印得到的值就是777了

                    }

变量的值也可以直接指定为其他变量的值:

                    public static void main(String[] args) {

                        int a = 10;
                        int b = a; // 直接让b等于a 那么a的值就会给到b
                        System.out.println(b); // 这里输出的就是10了

                    }

我们还可以让变量与数值之间做加减法(运算符会在后面详细介绍):

                    public static void main(String[] args) {

                        int a = 9; // a初始值为9
                        a = a + 1; // a = a + 1也就是将a+1的结果赋值给a 跟数学是一样的 很好理解对吧
                        System.out.println(a); // 最后得到的结果就是10了

                    }

有时候我们希望变量的值一直保持不变 我们就可以将其指定为常量 这里我们介绍Java中第一个需要认识的关键字:

                    public static void main(String[] args) {

                        final int a = 666; // 在变量前面添加final关键字 表示这是一个常量
                        a = 777; // 常量的值不允许发生修改

                    }

编译时出现:

        https://fast.itbaima.net/2022/09/16/kT46yi8KNOLWlp3.png

常量的值只有第一次赋值可以修改 其他任何情况下都不行:

                    public static void main(String[] args) {

                        final int a;
                        a = 777; // 第一次赋值

                    }

至此 Java的基础语法部分介绍完毕 下一部分我们将开始介绍Java中的几大基本数据类型