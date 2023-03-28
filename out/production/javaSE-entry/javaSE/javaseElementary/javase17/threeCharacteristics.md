封装, 继承和多态

封装, 继承和多态是面向对象编程的三大特性

----

封装

封装的目的是为了保证变量的安全性 使用者不必在意具体实现细节 而只是通过接口即可访问类的成员 如果不进行封装 类中的实例变量可以直接查看和修改
可能给整个代码带来不好的影响 因此再缩写类时一般将成员变量私有化 外部类需要同getter和setter方法来查看和设置变量

设想: 学生小明已经创建成功 正常情况下能随便改他的名字和年龄吗?

                 public class Student {
                     private String name;
                     private int age;

                     public Student() {
                         this.name = name;
                         this.age = age;
                     }

                     public int getAge() {
                         return age;

                     }
                     public String getName() {
                         return name;
                     }

                 }

也就是说 外部现在只能通过调用我定义的方法来获取成员属性 而我们可以让这个方法中进行一些额外的操作 比如小明可以修改名字 但是名字中不能包含"小"这个字:

                 public void setName(String name) {
                     if(name.contains("小")) return;
                     this.name = name;
                 }

单独给外部开放设置名称的方法 因为我还需要做一些额外的处理 所以说不能给外部直接操作成员变量的权限

封装思想其实就是把实现细节给隐藏了 外部只需要知道这个方法是什么作用 而无需关心实现

封装就是通过访问权限控制来实现的

----

继承

继承属于非常重要的内容 在定义不同类的时候存在一些相同的属性 为了方便使用可以将这些共同属性抽象成一个父类
在定义其他子类时可以继承自该父类 减少代码的重复定义 子类可以使用父类中非私有的成员

现在学生分为两种 艺术学和体育生 他们都是学生的分支 但是他们都有自己的方法:

                 public class SportsStudent extends Student{ // 通过extends关键字来继承父类

                     public SportsStudent(String name, int age) {
                         super(name, age); // 必须先通过super关键字(指代父类) 实现父类的构造方法
                     }

                     public void exercise() {
                         System.out.println("我超勇的!");
                     }

                 }

                 public class ArtStudent extends Student{

                     public ArtStudent(String name, int age) {
                         super(name, age);
                     }

                     public void art() {
                         System.out.println("随手画个毕加索");
                     }

                 }

子类具有父类的全部属性 protected可见但外部无法使用(包括private属性 不可见 无法使用) 同时子类还能有自己的方法 继承只能继承一个父类 不支持多继承

每一个子类必须定义一个实现父类构造方法的构造方法 也就是需要在构造方法开始使用super() 如果父类使用的是默认构造方法 那么子类不用手动指明

所有类都默认继承自Object类 除非手动指定类型 但是依然改变不了最顶层的父类是Object类 所有类都包含Object类中的方法 比如:

                         SportsStudent sportsStudent = new SportsStudent("yxs", 20);
                         System.out.println(sportsStudent.hashCode()); // 求对象的hashcode 默认是对象的内存地址
                         System.out.println(sportsStudent.equals(sportsStudent)); // 比较对象是否相同 默认比较的是对象的内存地址 也减少等同于 ==
                         System.out.println(sportsStudent.toString()); // 将对象转换为字符串 默认生成对象的类名称 + hashcode

关于Object类的其他方法 我们会在java多线程中再来提及