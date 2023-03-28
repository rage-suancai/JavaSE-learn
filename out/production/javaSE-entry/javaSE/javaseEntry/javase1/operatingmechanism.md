Java程序基础

首先我们还是从最基本的Java程序基础开始讲解

程序代码基本结构

还记得我们之前使用的示例代码吗?

                    public class Main {
                        public static void main(String[] args) {
                            System.out.println("Hello World!");
                        }
                    }

这段代码要实现的功能很简单 就是将 Hello World 输出到控制台就行

由于我们还没有学习到类的相关性质 所以在第二章之前 各位小伙伴直接记住固定模式即可 首先我们创建的源文件名称需要为Main.java然后编写的代码第一行:

                    public class Main {

                    }

注意需要区分大小写 Java语言严格区分大小写 如果我们没有按照规则来编写 那么就会出现红色波浪线报错:

        https://fast.itbaima.net/2022/09/16/5mpBD1JyjCMGgnO.png

只要源代码中存在报错的地方 就无法正常完成编译得到二进制文件 会提示构建失败:

        https://fast.itbaima.net/2022/09/16/x5PjR9OAGMCQtS6.png

注意: 最后还有一个花括号 并且此花括号是成对出现的 一一对应

所以说各位小伙伴在编写代码时一定要注意大小写 然后第二行 准确的说是最外层花括号内部就是:

                    public static void main(String[] args) {

                    }

这是我们整个Java程序的入口点 我们称为主方法(如果你学习过C肯定能够联想到主函数 只不过Java中不叫函数 叫方法)
最后也会有一个花括号成对出现 而在主方法的花括号中编写的代码 就是按照从上往下的顺序依次执行的

比如我们之前编写的:

                    System.out.println("Hello World!");

这段代码的意思就是将双引号括起来的内容(字符串 我们会在后面进行讲解)输出(打印)到控制台上 可以看到最后还加上了一个;符号
表示这一句代码结束 我们每一段代码结束时都需要加上一个分号表示这一句的结束 就像我们写作文一样

比如下面的代码 我们就可以实现先打印Hello World! 然后再打印YYDS!到控制台

                    public class Main {
                        public static void main(String[] args) {
                            System.out.println("Hello World!");
                            System.out.println("YYDS!");
                        }
                    }

效果如下:

        https://fast.itbaima.net/2022/09/16/GLZdxf6B3Agu98N.png

如果两段代码没有加上分号分割 那么编译器会认为这两段代码是同一句代码中的 即使出现换行或者是空格:

        https://fast.itbaima.net/2022/09/16/ErQnpo2DVw7mJks.png

这里IDEA很聪明 会提醒我们这里少加了分号 所以说这个IDEA能够在初期尽可能地帮助新手

再比如下面的代码:

        https://fast.itbaima.net/2022/09/16/sDcuan8MJ92l3P1.png

        https://fast.itbaima.net/2022/09/16/i1VFk6RUtp8XfMr.png

这里我们尝试在中途换行和添加空格 因为没有添加分号 所以说编译器依然会认为是一行代码 因此编译不会出现错误
能够正常通过 当然 为了代码写得工整和规范 我们一般不会随意进行换行编写或者是添加没必要的空格

同样的 如果添加了分号 即使在同一行 也会被认为是两句代码:

        https://fast.itbaima.net/2022/09/16/XopC59keJiMWjmd.png

如果在同一行就是从左往右的顺序 得到的结果跟上面是一样的

注释

我们在编写代码时 可能有些时候需要标记一下这段代码表示什么意思:

        https://fast.itbaima.net/2022/09/16/8Mzo36BbYVuRgm9.png

但是如果直接写上文字的话 会导致编译不通过 因为这段文字也会被认为是程序的一部分

这种情况 我们就可以告诉编译器 这段文字是我们做的笔记 并不是程序的一部分 那么要怎么告诉编译器这不是代码呢? 很简单 我们只需要在前面加上双斜杠就可以了

        https://fast.itbaima.net/2022/09/16/N4rZHt6onGfXuhg.png

添加双斜杠之后(自动变成了灰色)后续的文本内容只要没有发生换行 那么都会被认为是一段注释 并不属于程序 在编译时会被直接忽略 之后这段注释也不会存在于程序中 但是一旦发生换行那就不行了

        https://fast.itbaima.net/2022/09/16/GiUMCmXewanWJSN.png

那要是此时注释很多 一行写不完 我们想要编写很多行的注释呢? 我们可以使用多行注释标记:

                    public class Main {
                        public static void main(String[] args) {

                            /*
                                这里面的内容
                                无论多少行
                                都可以
                             */
                            System.out.println("Hello World!");

                        }
                    }

多行可以使用 /* 和 */ 的组合来囊括需要编写的注释内容

当然还有一种方式就是使用/**来进行更加详细的文档注释:

        https://fast.itbaima.net/2022/09/16/sFhkS2ezONjZvMK.png

这种注释可以用来自动生成文档 当我们鼠标移动到Main上时 会显示相关的信息 我们可以自由添加一些特殊的注释 比如作者 时间等信息 也可以是普通的文字信息