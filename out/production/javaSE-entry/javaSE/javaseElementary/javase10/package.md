包声明和导入

包其实就是用来区分类位置的东西 也可以用来将我们的类进行分类 类似于C++中的namespace:

                 package javaSE.javase10.entity;

                 public class Student {
                 }

包其实就是文件夹 比如: javaSE.javase10就是一个com文件夹中包含一个javase文件夹 再包含我们Student类

一般包按照个人或是公司域名的规则倒过来来写 顶级域名 一级域名 二级域名 com.java.xxxx

如果需要使用其他包里面的类 那么我们需要import(类似于C/C++中的include):

                 import com.test.Student

也可以导入包下的全部(一般导入会由编译器自带帮我们补全 但是一定要记得我们需要导包):

                 import com.test.*

java默认为我们导入了以下的包 不需要去声明:

                 import java.lang.*

静态导入

静态导入可以直接导入某个类的静态方法或者是静态变量 导入后 相当于这个方法或是类在定义在当前类中 可以直接调用该方法:

                 import static javaSE.javase10.entity.Student.a;

                 public class Main {
                     public static void main(String[] args) {
                         a();
                     }
                 }

静态导入不会进行类的初始化