数组类型

假设出现一种情况 我想记录100个数字 定义100个变量还可行吗?

                 index 0    1    2    3    4    5
           ElementData 1    2    3    0    0    0

我们可以使用到数组 数组是相同类型数据的有序集合 数组可以代表任何相同类型的一组内容(包括引用类型和基本类型)
其中存放的每一个数据称为数组的一个元素 数组下标是从0开始 也就是第一个元素的索引是0:

                 int[] arr = new int[10]; // 需要new关键字来创建
                 String[] arr2 = new String[10];

数组本身也是类(编程不可见 C++写的) 不是基本数据类型:

                 int[] arr = new int[10];
                 System.out.println(arr.length); // 数组有成员变量
                 System.out.println(arr.toString()); // 数组有成员方法

一维数组

一维数组中 元素是依次排列的(线性) 每个数组元素可以通过下标来访问 声明格式如下:

                 类型[] 变量名称 = new 类型[数组大小];
                 类型 变量名称[] = new 类型[数组大小]; // 支持C语言样式 但不推荐

                 类型[] 变量名称 = new 类型[]{...}; // 静态初始化(直接指定值和大小)
                 类型[] 变量名称 = {...}; // 同上 但是只能在定义时赋值

创建出来的数组每个元素都有默认值(规则和类的成员变量一样 C语言创建的数组需要手动设置默认值) 我们可以通过下标去访问:

                 int[] arr = new int[10];
                 arr[0] = 626;
                 System.out.println(arr[0]);
                 System.out.println(arr[1]);

我们可以通过数组变量名称.length来获取当前数组长度:

                 int[] arr = new int[] {1, 2, 3};
                 System.out.println(arr.length); // 打印length成员变量的值

数组在创建时 就固定长度 不可更改 访问超出数组长度的内容 会出现错误:

                 String[] arr = new String[10]
                 System.out.println(arr[11]); // 出现异常

                 Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 11 out of bounds for length 10

思考: 能不能直接修改length的值来实现动态扩容呢?

                 int[] arr = new int[]{1, 2, 3};
                 arr.length = 10;

数据做实参 因为数组也是类 所以形参得到的是数组的引用而不是复制的数组 操作的依然是数组对象本身:

                 static void test1() {
                     int[] arr = new int[] {1, 2, 3};
                     test(arr);
                     System.out.println(arr[0]);
                 }

                 private static void test(int[] arr) {
                     arr[0] = 2934;
                 }

数组的遍历

我们很容易就联想到for循环:

                 int[] arr = new int[] {1, 2, 3};
                 for (int i = 0; i < arr.length; ++i) {
                     System.out.println(arr[i]);
                 }

foreach

传统for循环虽然可控性高 但是不够省事 要写一大堆东西 有没有一种省事的写法呢?

                 int[] arr = new int[] {1, 2, 3};
                 for (int i : arr) {
                     System.out.println(i);
                 }

foreach属于增强型的for循环 它使得代码更加简洁 同时我们能直接拿到数组中的每一个数字