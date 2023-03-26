枚举类
假设现在我们想给小明添加一个状态(跑步 学习 睡觉) 外部可以实时获取小明的状态:

                 public class Student {

                     private final String name;
                     private final int age;
                     private String status;

                     public Student(String name, int age) {
                         this.name = name;
                         this.age = age;
                     }

                     public String getStatus() {
                         return status;
                     }

                     public void setStatus(String status) {
                         this.status = status;
                     }

                 }

但是这样会出现一个问题 如果我们仅仅是存储字符串 似乎外部可以不按照我们规则 传入一些其他的字符串 这显然是不够严谨的

有没有一种办法 能够更好地去实现这样的状态标记呢 我们希望开发者拿到使用的就是我们定义好的状态 我们可以使用枚举类:

                 public enum Status {
                     RUNNING, STUDY, SLEEP; // 直接写每个状态的名字即可 分号可以不不打 但是推荐打上
                 }

使用枚举类也非常方便 我们只需要直接访问即可:

                 public class Student {

                     private final String name;
                     private final int age;
                     private Status status;

                     // ...

                     public Student(String name, int age) {
                         this.name = name;
                         this.age = age;
                     }

                     public Status getStatus() {
                         return status;
                     }

                     public void setStatus(Status status) { // 不再是String 而是我们指定的枚举类型
                         this.status = status;
                     }

                 }

                 public static void main(String[] args) {

                     Student student = new Student("yxs", 19);

                     student.setStatus(Status.SLEEP);
                     System.out.println(student.getStatus());

                 }

枚举类型使用起来就非常方便了 其实枚举类型的本质就是一个普通的类 但是它继承自Enum类
我们定义的每一个状态其实就是一个public static final的Status类型成员变量:

                 // Compiled from "Status.java"
                 public static class com.test.Status extends java.lang.Enum<com.test.Status> {

                     public final class com.test.Status RUNNING;
                     public final class com.test.Status STUDY;
                     public final class com.test.Status SLEEP;
                     public static com.test.Status[] values();
                     public static com.test.Status valueOf(java.lang.String);
                     static {};

                 }

既然枚举类型是普通的类 那么我们也可以给枚举类型添加独有的成员方法:

                 public enum Status {

                     RUNNING("跑步"), STUDY("学习"), SLEEP("睡觉"); // 无参构造方法被覆盖 篡创建枚举需要添加参数(本质就是调用的构造方法)

                     private final String name; // 枚举的成员变量

                     Status(String name) { // 覆盖原有的构造方法(默认private 只能内部使用)
                         this.name = name;
                     }

                     public String getName() { // 获取封装的成员变量
                         return name;
                     }

                 }

                 public static void main(String[] args) {

                     Student student = new Student("yxs", 19);

                     student.setStatus(Status.SLEEP);
                     System.out.println(student.getStatus().getName());

                 }

枚举类还自带一些继承下来的实用方法:

                 Status.valueOf("") // 将名称相同的字符串转换为枚举
                 Status.values() // 快速获取所有的枚举