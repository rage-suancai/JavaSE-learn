创建类对象

既然我们拿到了类的定义 那么是否可以通过Class对象来创建对象 调用方法 修改变量呢? 当然是可以的 那我们首先来探讨一下如何创建一个类的对象:

                    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

                        Class<Student> clazz = Student.class;
                        Student student = clazz.newInstance();
                        student.test();

                    }
                    
                    static class Student{

                        public void test(){
                            System.out.println("萨日朗");
                        }

                    }

通过使用newInstance()方法来创建对应类型的实例 返回泛型T 注意它会抛出InstantiationException和IllegalAccessException异常 那么什么情况下会出现异常呢?
    
                    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

                        Class<Student> clazz = Student.class;
                        Student student = clazz.newInstance();
                        student.test();

                    }
                    
                    static class Student{
                    
                        public Student(String text){
                            
                        }
                    
                        public void test(){
                            System.out.println("萨日朗");
                        }

                    }

当类默认的构造方法被带参构造覆盖时 会出现InstantiationException异常 因为newInstance()只适用于默认无参构造:

                    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

                        Class<Student> clazz = Student.class;
                        Student student = clazz.newInstance();
                        student.test();

                    }
                    
                    static class Student{
                    
                        private Student(){}
                    
                        public void test(){
                            System.out.println("萨日朗");
                        }

                    }

当默认无参构造的权限不是public时 会出现IllegalAccessException异常 表示我们无权去调用默认构造方法
在JDK9之后 不再推荐使用newInstance()方法了 而是使用我们接下来要介绍到的 通过获取构造器 来实例化对象:

                    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

                        Class<Student> clazz = Student.class;
                        Student student = clazz.getConstructor(String.class).newInstance("what's up");
                        student.test();

                    }
                    
                    static class Student{
                    
                        public Student(String str){}
                    
                        public void test(){
                            System.out.println("萨日朗");
                        }

                    }

我们发现 当访问权限不足时 会无法找到此构造方法 那么如何找到非public的构造方法呢?

                    Class<Student> clazz = Student.class;
                    Constructor<Student> constructor = clazz.getDeclaredConstructor(String.class);
                    constructor.setAccessible(true); // 修改访问权限
                    Student student = constructor.newInstance("what's up");
                    student.test();

使用getDeclaredConstructor()方法可以找到类中的非public构造方法 但是在使用之前 我们需要先修改访问权限 
在修改访问权限之后 就可以使用非public方法了(这意味着 反射可以无视权限修饰符访问类的内容)