* 类型转换
* 
* 隐式类型转换
* 
* 隐式类型转换支持字节数小的类型自动转换为字节数大的类型 整数类型自动转换为小数类型 转换规则如下:
* 
*      > byte -> short(char) -> int -> float -> double
*
* 问题: 为什么long比float大 还能转换为float呢 小数的存储规则让float最大值比long还大 只是可能会丢失某些位上的精度
*
* 所以 如下的代码就能够正常运行:
* 
*                  byte a = 9;
*                  short b = a;
*                  int i = b;
*                  long l = i;
*                  float f = l;
*                  double d = f;
*                  System.out.println(d); // 输出9.0
*
* 显示类型转换
* 
* 显示类型转换也叫强制类型转换 也就是说 违反隐式类型转换的规则 牺牲精度强行进行类型转换:
* 
*                  int a = 128;
*                  byte b = (byte) a;
*                  System.out.println(b); // 输出-128
*
* 为什么结果是-128 精度丢失了:
* 
*      > int类型的128表示: 00000000 00000000 00000000 10000000
*      > byte类型转换后表示: xxxxxxxx xxxxxxxx xxxxxxxx 10000000 => -128
*
* 数据类型自动提升
* 
* 在参与运算时(也可以位于表达式中时 自增自减除外) 所有的byte型 short型和char的值将被提升倒int型:
* 
*                  byte b = 105;
*                  b = b + 1; // 报错
*                  System.out.println(b);
*
* 这个特性是由java虚拟机规范定义的 也就是为了提高运行的效率 其他的特性还有:
* 
*      > 如果一个操作数是long型 计算结果就是long型
*      > 如果一个操作数是float型 计算结果就是float型
*      > 如果一个操作数是double型 计算结果就是double型