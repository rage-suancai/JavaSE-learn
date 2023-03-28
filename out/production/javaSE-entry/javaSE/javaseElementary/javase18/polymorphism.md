多态

多态是同一个行为具有多个不同表现形式或形态的能力 也就是同样的方法 由于实现类不同 执行结果也不同

方法的重写

我们之前学习了方法的重载 方法的重写和重载是不一样的 重载是原有的方法逻辑不变的情况下 支持更多参数的实现 而重写是直接覆盖原有方法:

                 // 父类中的study
                 public void study() {
                     System.out.println("学习");
                 }

                 // 子类中的study
                 @Override // 声明这个方法是重写的 但是可以不要 我们现阶段不接触
                 public void study() {
                     System.out.println("给你看点好康的");
                 }

再次定义同样的方法后 父类的方法就被覆盖 子类还可以给父类方法提升访问权限:

                 public static void main(String[] args) {

                     SportsStudent sportsStudent = new SportsStudent("yxs", 19);
                     sportsStudent.study(); // 输出子类定义的内容

                 }

思考: 静态方法能被重写吗

当我们在重写方法时 不仅想使用我们自己的逻辑 同时还希望执行父类的逻辑(也就是调用父类的方法)怎么办呢:

                 @Override
                 public void study() {

                     super.study();
                     System.out.println("给你看点好康的...");

                 }

同理 如果想访问父类的成员变量 也可以使用super关键字来访问 注意: 子类可以具有和父类相同的成员变量 而在方法默认是: 形参列表中 > 当前类的成员变量 > 父类成员变量:

                 public void setTest(int test) {

                     test = 1;
                     this.test = 1;
                     super.test = 1;

                 }

在谈类型转换

我们曾经学习过基本数据类型的类型转换 支持一种数据类型转换为另一种数据类型 而我们的类也是支持类型转换的(仅限于存在亲缘关系的类之间进行转换) 比如子类可以直接向上转型:

                 Student student = new SportStudent("yxs", 19); // 父类变量引用子类实例
                 student.study(); // 得到依然是具有实现的结果 而不是当前类型的结果

我们也可以把已经明确是由哪个类实现的父类引用 强制转换为对应的类型:

                 Student student = new SportsStudent("yxs", 19); // 是由SportsStudent进行实现的
                 // ... do something

                 SportsStudent sportsStudent = (SportStudent)student; // 让它变成一个具体的子类
                 sportsStudent.sport(); // 调用具体实现类的方法

这样的类型转换称为向下转型

instanceof关键字

那么我们如果只是得到一个父类引用 但是不知道它到底是哪一个子类的实现怎么办? 我们可以使用instanceof关键字来实现 它能够进行类型判断:

                 public static void test(Student student) {

                     if (student instanceof SportsStudent) {
                         SportsStudent sportsStudent = (SportsStudent) student;
                         sportsStudent.exercise();
                     }else if(student instanceof ArtStudent) {
                         ArtStudent artStudent = (ArtStudent) student;
                         artStudent.art();
                     }

                 }

通过进行类型判断 我们就可以明确类的具体实现到底是哪个类

思考: student instanceof Student的结果是什么?