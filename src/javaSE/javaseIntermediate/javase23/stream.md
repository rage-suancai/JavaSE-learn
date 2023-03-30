Stream流

Java8 API添加了一个新的抽象称为流Stream 可以让你以一种声明的方式处理数据 Stream使用一种类似用SQL语句从数据库查询数据的直观方式来提供一种对Java集合运算和表达的高阶抽象
StreamAPI可以极大提高Java程序员的生产力 让程序员写出高效率、干净、简洁的代码 这种风格将要处理的元素集合看作一种流 流在管道中传输 并且可以在管道的节点上进行处理 
比如筛选 排序 聚合等 元素流在管道中经过中间操作(intermediate operation)的处理 最后由最终操作(terminal operation)得到前面处理的结果:

        https://fast.itbaima.net/2022/10/03/r4AtmVRZ51y7uxd.png

它看起来就像一个工厂的流水线一样 我们就可以把一个Stream当做流水线处理:

                    public static void main(String[] args) {

                        List<String> list = new ArrayList<>();
                        list.add("A");
                        list.add("B");
                        list.add("C");
                      
                        // 移除为B的元素
                        Iterator<String> iterator = list.iterator();
                        while (iterator.hasNext()){
                            if(iterator.next().equals("B")) iterator.remove();
                        }
                      
                        // Stream操作
                        list = list // 链式调用
                                .stream() // 获取流
                                .filter(e -> !e.equals("B")) // 只允许所有不是B的元素通过流水线
                                .collect(Collectors.toList()); // 将流水线中的元素重新收集起来 变回List
                        System.out.println(list);

                    }

可能从上述例子中还不能感受到流处理带来的便捷 我们通过下面这个例子来感受一下:

                    public static void main(String[] args) {

                        List<Integer> list = new ArrayList<>();
                        list.add(1);
                        list.add(2);
                        list.add(3);
                        list.add(3);
                    
                        list = list
                                .stream()
                                      .distinct() // 去重(使用equals判断)
                                .sorted((a, b) -> b - a) // 进行倒序排列
                                .map(e -> e+1) // 每个元素都要执行+1操作
                                .limit(2) // 只放行前两个元素
                                .collect(Collectors.toList());
                    
                        System.out.println(list);

                    }

当遇到大量的复杂操作时 我们就可以使用Stream来快速编写代码 这样不仅代码量大幅度减少，而且逻辑也更加清晰明了（如果你学习过SQL的话，你会发现它更像一个Sql语句）

                    public static void main(String[] args) {

                        List<Integer> list = new ArrayList<>();
                        list.add(1);
                        list.add(2);
                        list.add(3);
                        list.add(3);
                    
                        list = list
                                .stream()
                                .distinct() // 去重（使用equals判断）
                                .sorted((a, b) -> b - a) // 进行倒序排列
                                .map(e -> e+1) // 每个元素都要执行+1操作
                                .limit(2) // 只放行前两个元素
                                .collect(Collectors.toList());
                    
                        System.out.println(list);

                    }

当遇到大量的复杂操作时 我们就可以使用Stream来快速编写代码 这样不仅代码量大幅度减少 而且逻辑也更加清晰明了(如果你学习过SQL的话 你会发现它更像一个Sql语句)

注意: 不能认为每一步是直接依次执行的 我们可以断点测试一下:

                    List<Integer> list = new ArrayList<>();
                    list.add(1);
                    list.add(2);
                    list.add(3);
                    list.add(3);
                    
                    list = list
                            .stream()
                            .distinct() // 断点
                            .sorted((a, b) -> b - a)
                            .map(e -> {
                                System.out.println(">>> "+e); // 断点
                                return e+1;
                            })
                            .limit(2) // 断点
                            .collect(Collectors.toList());

实际上 stream会先记录每一步操作 而不是直接开始执行内容 当整个链式调用完成后 才会依次进行 也就是说需要的时候 工厂的机器才会按照预定的流程启动

接下来 我们用一堆随机数来进行更多流操作的演示:

                    public static void main(String[] args) {

                        Random random = new Random(); // 没想到吧 Random支持直接生成随机数的流
                        random
                                .ints(-100, 100) // 生成 -100~100 之间的随机int型数字(本质上是一个IntStream)
                                .limit(10) // 只获取前10个数字(这是一个无限制的流 如果不加以限制 将会无限进行下去)
                                .filter(i -> i < 0) // 只保留小于0的数字
                                .sorted() // 默认从小到大排序
                                .forEach(System.out::println); // 依次打印

                    }

我们可以生成一个统计实例来帮助我们快速进行统计:

                    public static void main(String[] args) {

                        Random random = new Random(); // Random是一个随机数工具类
                        IntSummaryStatistics statistics = random
                                .ints(0, 100)
                                .limit(100)
                                .summaryStatistics(); // 获取语法统计实例
                        System.out.println(statistics.getMax()); // 快速获取最大值
                        System.out.println(statistics.getCount()); // 获取数量
                        System.out.println(statistics.getAverage()); // 获取平均值

                    }

普通的List只需要一个方法就可以直接转换到方便好用的IntStream了:

                    public static void main(String[] args) {

                        List<Integer> list = new ArrayList<>();
                        list.add(1);
                        list.add(1);
                        list.add(2);
                        list.add(3);
                        list.add(4);
                        list.stream()
                                .mapToInt(i -> i) // 将每一个元素映射为Integer类型(这里因为本来就是Integer)
                                .summaryStatistics();

                    }

我们还可以通过flat来对整个流进行进一步细分:

                    public static void main(String[] args) {

                        List<String> list = new ArrayList<>();
                        list.add("A,B");
                        list.add("C,D");
                        list.add("E,F"); // 我们想让每一个元素通过 进行分割 变成独立的6个元素
                        list = list
                                .stream() // 生成流
                                .flatMap(e -> Arrays.stream(e.split(","))) // 分割字符串并生成新的流
                                .collect(Collectors.toList()) // 汇成新的List
                        System.out.println(list); // 得到结果

                    }

我们也可以只通过Stream来完成所有数字的和 使用reduce方法:

                    public static void main(String[] args) {

                        List<Integer> list = new ArrayList<>();
                        list.add(1);
                        list.add(2);
                        list.add(3);
                        int sum = list
                                .stream()
                                .reduce((a, b) -> a + b) // 计算规则为: a是上一次计算的值 b是当前要计算的参数 这里是求和
                                .get(); // 我们发现得到的是一个Optional类实例 通过get方法返回得到的值
                        System.out.println(sum);

                    }

可能 作为新手来说 一次性无法接受这么多内容 但是在各位以后的开发中 就会慢慢使用到这些东西了