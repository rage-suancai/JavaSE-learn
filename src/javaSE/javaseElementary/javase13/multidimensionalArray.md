二维数组

二维数组其实就是存放数组的数组 每一个元素都存放一个数组的引用 也就相当于变成了一个平面:

                 // 三行两列
                 int[][] arr = {{1, 2},
                                {3, 4},
                                {5, 6}};
                 System.out.println(arr[2][1])

二维数组的遍历同一维数组一样 只不过需要嵌套循环:

                 int[][] arr = {{1, 2}, {3, 4}, {5, 6}};
                 for (int i = 0; i < 3; ++i) {
                     for (int j = 0; j < 2; ++j) {
                         System.out.println(arr[i][j]);
                     }
                 }

多维数组

不止二维数组 还存在三维数组 也就是存放数组的数组的数组 原理同二维数组一样 逐级访问即可

可变长参数

可变长参数其实就是数组的一种应用 我们可以指定方法的形参为一个可变长参数 要求实参可以根据情况动态填入0个或多个 而不是固定的数量:

                 public static void main(String[] args) {
                     test2("AAA", "BBB", "CCC");
                 }

                 static void test2(String... arr) {
                     for (int i = 0; i < arr.length; i++) {
                         System.out.println(arr[i]);
                     }
                 }

由于是数组 所以说只能使用一种类型的可变长参数 并且可变长参数只能放在最后一位