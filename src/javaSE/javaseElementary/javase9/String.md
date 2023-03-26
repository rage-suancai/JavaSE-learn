String和StringBuilder类

字符串类是一个比较特殊的类 它是java中唯一重载运算符符的类(java不支持运算符重载 String是特例)

String的对象直接支持使用 + 或 += 运算符来进行拼接 并形成新的String对象(String的字符串是不可变的):

                 String a = "yxs", b = "nb";
                 String l = a + b;
                 System.out.println(l);

大量进行字符串的拼接似乎不太好 编译器是很聪明的 String的拼接有可能被编译器优化为StringBuilder来来减少对象创建(对象频繁创建时很费时间同时占内存的):

                 String result = "String" + "and"; // 会被优化成一句

                 String str1 = "String";
                 String str2 = "and";
                 String result = str1 + str2;
                 // 变量随时可变 在编译时无法确定result的值 那么只能在运行时再去确定

                 String str1 = "String";
                 String str2 = "and";
                 String result = (new StringBuilder(String.value0f(str1))).append(str2).toString();
                 // 使用StringBuilder 会采用类似于第一种实现 显然会更快

StringBuilder也是一个类 但是它能够存储可变长度的字符串:

                 StringBuilder builder = new StringBuilder();
                 builder
                         .append("y")
                         .append("x")
                         .append("s"); // 链式调用
                 String str = builder.toString();
                 System.out.println(str);