运算符

赋值和算术运算符

赋值运算符 = 是最常用的运算符 其实就是将我们等号右边的结果 传递个等号左边的变量 例如:

                 int a = 10;
                 int b = 1 + 8;
                 int c = 5;

算数运算符也就是我们在小学阶段学习的 + - * / % 分别代表加减乘除还有取余 例如:

                 int a = 2;
                 int b = 3;
                 int c = a * b; // 结果为6

需要注意的是 +还可以用作字符串连接符使用:

                 System.out.println("yxs" + "nb") // yxsnb

当然 字符串可以自己连接其他类型 但是会全部当做字符串处理:

                 int a = 7, b = 15;
                 System.out.println("yxs" + a + b); // yxs715

算术运算符还包括++和--也就是自增和自减 以自增为例:

                 int a = 10;
                 a++;
                 System.out.println(a); // 输出为11

自增自减运算符放在变量的前后的返回值是有区别的:

                 int a = 10;
                 System.out.println(a++); // 10(先返回值 再自增)
                 System.out.println(a); // 11

                 int a = 10;
                 int b = 2;
                 System.out.println(b++ + a++); // 猜猜看结果是多少

为了使得代码更简洁 你还可以使用扩展的赋值运算符 包括 += -= /= *= %= 自增自减类似 先执行运算 再返回结果 同时自身改变:

                 int a = 10;
                 System.out.println(a += 2); // 等价于 a = a + 2

关系运算符

关系运算符的结果只能是布尔类型 也就是要么为真要么为假 关系运算符包括:

                 > < = // 大于小于等于
                 >= <= != // 大于等于 小于等于 不等于

关系运算符一般只用于基本数据类型的比较 运算结果只能是boolean:

                 int a = 10;
                 int b = 2;
                 boolean x = a > b;
                 System.out.println(x) // 结果为true

逻辑运算符
逻辑运算符两边只能是boolean类型或是关系/逻辑运算表达式 返回值只能是boolean类型 逻辑运算符包括:

                 && // 与运算 要求两边同时为true才能返回true
                 || // 或运算 要求两边至少有一个为true 才能返回true
                 ! // 非运算 一般放在表达式最前面 表达式用括号括起来 表示对表达式的结果进行反转

实际案例来看看:

                 int a = 10;
                 int b = 2;
                 boolean x = a > b && a < b; // 怎么可能同时满足呢
                 System.out.println(x); // false

                 int a = 10;
                 int b = 2;
                 boolean x = a > b || a <= b; // 一定有一个满足
                 System.out.println(x); // true

                 int a = 10;
                 int b = 2;
                 boolean x = !(a > b); // 对结果进行反转 本来应该是true
                 System.out.println(x); // false

位运算符:

                 & // 按位与 注意: 返回的是运算后的同类型值 不是boolean
                 | // 按位或
                 ^ // 按位异或
                 ~ // 按位非

按位运算实际上是根据值的二进制编码来计算结果 例如按位与 以4bit为例:

0101 & 0100 = 0100(只有同时为1对应位才得1):

                 int a = 7, b = 15;
                 System.out.println(a & b); // 结果为7

三目运算符

三目运算符其实是为了简化代码为生 可以根据条件是否满足来决定返回值 格式如下:

                 int a = 7, b = 15;
                 String str = a > b ? "行" : "不行"; // 判断条件(只能boolean 或返回boolean的表达式) ? 满足的返回值 : 不满足的返回值
                 System.out.println("汉堡做的行不行? " + str); // 汉堡做的行不行? 不行

理解三目运算符 就很容易理解后面的if-else语句了