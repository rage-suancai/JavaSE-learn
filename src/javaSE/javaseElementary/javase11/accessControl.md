访问控制

java支持对类属性访问的保护 也就是说 不希望外部类访问类中的属性或是方法 只允许内部调用 这种情况我们就需要用到权限控制符:

                             private     default     protected     public
             同一类             yes         yes          yes          yes
             同一包中的类        no          yes          yes          yes
             子类               no          no          yes          yes
             其他包中的类        no          no           no           yes

权限控制符可以声明在方法 成员变量 类前面 一旦声明private 只能类内部访问:

                 public class Student {
                     private int a = 10; // 具有私有访问权限 只能类内部访问
                 }

                 public static void main(String[] args) {
                     Student student = new Student();
                     System.out.println(student.a); // 还可以访问吗
                 }

和文件名称相同的类 只能是public 并且一个java文件中只能有一个public.class:

                 // Student.java
                 public class Student {

                 }
                 class Test { // 不能添加权限修饰符 只能是default

                 }