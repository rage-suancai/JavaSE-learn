类的基本结构

为了快速掌握 我们自己创建一个自己的类 创建的类文件名称应该和类名一致

成员变量

在类中 可以包含许多的成员变量 也叫成员属性 成员字段(field)通过 . 来访问我们类中的成员变量 我们可以通过类创建的对象来访问和修改这些变量 成员变量是属于对象的:

                 public class Student {
                     String name;
                     int age;
                 }

                 Student student = new Student();
                 student.name = "奥利给";
                 System.out.println(student.name);

成员变量默认带有初始值 也可以自己定义初始值