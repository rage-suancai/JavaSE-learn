## 环境安装与IDEA使用
前面我们介绍了Java语言 以及其本身的一些性质 这一部分我们就开始进行学习环境安装(这一部分请务必跟着操作 不要自作主张地去操作 一开始就出问题其实是最劝退新手的)

### JDK下载与安装
首先我们来介绍一下JDK和JRE 各位小伙伴一定要能够区分这两者才可以
- **JRE(Java Runtime Environment)**: Java的运行环境 安装了运行环境之后 Java程序才可以运行 一般不做开发 只是需要运行Java程序直接按照JRE即可
- **JDK(Java Development Kit)**: 包含JRE 并且还附带了大量开发者工具 我们学习Java程序开发就使用JDK即可

它们的关系如下:

<img src="https://image.itbaima.cn/markdown/2022/09/16/MpGWrh5xZdI3bCJ.png"/>

那么现在我们就去下载JDK吧 这里推荐安装免费的ZuluJDK: https://www.azul.com/downloads/?version=java-8-lts&package=jdk

在这里选择自己的操作系统对应的安装包:

<img src="https://image.itbaima.cn/markdown/2022/09/16/thaGoKI8pXA7Vl6.png"/>

比如Windows下 我们就选择.msi的安装包即可(MacOS、Linux下同样选择对应的即可)

<img src="https://image.itbaima.cn/markdown/2022/09/16/vjc62OFaqmAegCh.png"/>

下载完成后 我们直接双击安装:

<img src="https://image.itbaima.cn/markdown/2022/09/16/Loi3Ru7FAWHP6vN.png"/>

注意 这里不建议各位小伙伴去修改安装的位置! 新手只建议安装到默认位置(不要总担心C盘不够 该装的还是要装 尤其是这种环境
实在装不下就去将其他磁盘的空间分到C盘一部分) 如果是因为没有安装到默认位置出现了任何问题 你要是找不到大佬问的话 又得重新来一遍 就很麻烦

剩下的我们只需要一路点击Next即可 安装完成之后 我们打开CMD命令窗口(MacOS下直接打开"终端")来验证一下
(要打开CMD命令窗口 Windows11可以直接在下面的搜索框搜索cmd即可 或者直接在文件资源管理器路径栏输入cmd也可以)

我们直接输入java命令即可:

<img src="https://image.itbaima.cn/markdown/2022/09/16/ROD3vkzwT8yFqrc.png"/>

如果能够直接输出内容 说明环境已经安装成功了 正常情况下已经配置好了 我们不需要手动去配置什么环境变量 所以说安装好就别管了

输入`java -version`可以查看当前安装的JDK版本:

<img src="https://image.itbaima.cn/markdown/2022/09/16/cPpCTOf9zZsWSw8.png"/>

只要是1.8.0就没问题了 后面的小版本号可能你们会比我的还要新

这样我们就完成了Java环境的安装 我们可以来体验一下编写并且编译运行一个简单的Java程序 我们新建一个文本文档
命名为`Main.txt`(如果没有显示后缀名 需要在文件资源管理器中开启一下)然后用记事本打开 输入以下内容:

```java
                        public class Main {
    
                            public static void main(String[] args) {
                                System.out.println("Fuck World!");
                            }
                                
                        }
```

现在看不懂没关系 直接用就行 我们后面会一点一点讲解的

编辑好之后 保存退出 接着我们将文件的后缀名称修改为`.java`这是Java源程序文件的后缀名称:

<img src="https://image.itbaima.cn/markdown/2022/09/16/MAPh4aLSwHuRNlU.png"/>

此时我们打开CMD 注意要先进入到对应的路径下 比如我们现在的路径:

<img src="https://image.itbaima.cn/markdown/2022/09/16/8A4oq7XdeLthpmg.png"/>

我们使用`cd`命令先进入到这个目录下:

<img src="https://image.itbaima.cn/markdown/2022/09/16/HifR7pVSmqbP4Kh.png"/>

要编译一个Java程序 我们需要使用`javac`命令来进行:

<img src="https://image.itbaima.cn/markdown/2022/09/16/IPofZRshyuwgciU.png"/>

执行后 可以看到目录下多出来了一个`.class`文件:

<img src="https://image.itbaima.cn/markdown/2022/09/16/UdEJQL6WvIBFXf1.png"/>

这样我们就成功编译了一个Java程序 然后我们就可以将其交给JVM运行了 我们直接使用`java`命令即可:

<img src="https://image.itbaima.cn/markdown/2022/09/16/esLwPFcOj87MrWo.png"/>

注意 不要加上后缀名称 直接输入文件名字即可 可以看到打印了一个Fuck World!字样 我们的第一个Java程序就可以运行了

### IDEA安装与使用
前面我们介绍了JDK开发环境的安装以及成功编译运行了我们的第一个Java程序

但是我们发现 如果我们以后都使用记事本来进行Java程序开发的话 是不是效率太低了点? 我们还要先编辑 然后要改后缀 还要敲命令来编译
有没有更加方便一点的写代码的工具呢? 这里我们要介绍的: IntelliJ IDEA(这里不推荐各位小伙伴使用Eclipse 因为操作上没有IDEA这么友好)

IDEA准确来说是一个集成开发环境(IDE) 它集成了大量的开发工具 编写代码的错误检测, 代码提示, 一键完成编译运行等 非常方便

下载地址: https://www.jetbrains.com.cn/idea/ (如果你之前学习C语言程序设计篇使用过CLion 你会发现界面一模一样 这样就能方便你快速上手)

<img src="https://image.itbaima.cn/markdown/2022/09/16/UfIQzAXBS7TePm9.png"/>

我们直接点击下载即可:

<img src="https://image.itbaima.cn/markdown/2022/09/16/sifjSGwLxYhHgKR.png"/>

这个软件本身是付费的 比较贵 而且最近还涨价了 不过这里我们直接下载面的社区版本就行了(JavaSE学习阶段不需要终极版 但是建议有条件的还是申请一个
因为后面JavaWeb开始就需要终极版了 学生和教师可以直接免费申请一年的使用许可 并且每个学期都可以续一年)

下载好之后 直接安装即可 这个不强制要求安装到C盘 自己随意 但是注意路径中不要出现中文

<img src="https://image.itbaima.cn/markdown/2022/09/16/jd64AxEfmQXWTNl.png"/>

这里勾选一下创建桌面快捷方式就行

<img src="https://image.itbaima.cn/markdown/2022/09/16/buv9QmapGCENcXn.png"/>

安装完成后 我们直接打开就可以了:

<img src="https://image.itbaima.cn/markdown/2022/09/16/rihpxBbQz9jlZWU.png"/>

此时界面是全英文 如果各位小伙伴看得惯 可以直接使用全英文的界面(使用英文界面可以认识更多的专业术语词汇 但是可能看起来没中文那么直观
而且IDEA本身功能就比较多 英语不好的小伙伴就很头疼) 这里还是建议英语不好的小伙伴使用中文界面 要使用中文只需要安装中文插件即可:

<img src="https://image.itbaima.cn/markdown/2022/09/16/tW4UPnpaFsfDB9r.png"/>

我们打开Plugins插件这一栏 然后直接在插件市场里面搜索Chinese 可以找到一个中文语言包的插件 我们直接Install安装即可 安装完成后点击重启 现在就是中文页面了:

<img src="https://image.itbaima.cn/markdown/2022/09/16/UFka83Se97COoJK.png"/>

如果各位小伙伴不喜欢黑色主题 也可以修改为白色主题 只需要在自定义中进行修改即可 一共四种主题

如果你之前使用过其他IDE编写代码 这里还支持按键映射(采用其他IDE的快捷键方案) 有需要的可以自己修改一下:

<img src="https://image.itbaima.cn/markdown/2022/09/16/3wbt7QhZmq9EKgY.png"/>

接下来 我们来看看如何使用IDEA编写Java程序 IDEA是以项目的形式对一个Java程序进行管理的 所以说我们直接创建一个新的项目 点击新建项目:

<img src="https://image.itbaima.cn/markdown/2022/09/16/4qvjxmozBaJgOuH.png"/>

此时来到创建页面:

<img src="https://image.itbaima.cn/markdown/2022/09/16/ldzGSmYBkr7uO3c.png"/>

- 名称: 你的Java项目的名称 随便起就行 尽量只带英文字母和数字 不要出现特殊字符和中文
- 位置: 项目的存放位置 可以自己根据情况修改 同样的 路径中不要出现中文
- 语言: IDEA支持编写其他语言的项目 但是这里我们直接选择Java就行了
- 构建系统: 在JavaSE阶段一律选择IntelliJ就行了 Maven我们会在JavaWeb之后进行讲解 Gradle会在安卓开发教程中介绍
- JDK: 就是我们之前安装好的JDK 如果是默认路径安装 这里会自动识别(所以说不要随便去改 不然这些地方就很麻烦)

当然 如果JDK这里没有自动识别到 那么就手动添加一下:

<img src="https://image.itbaima.cn/markdown/2022/09/16/fDJKB6M3TlWizoQ.png"/>

没问题之后 我们直接创建项目:

<img src="https://image.itbaima.cn/markdown/2022/09/16/aQDnYVx6cZhlRUv.png"/>

进入之后 可以看到已经自动帮助我们创建好了一个`java`源文件 跟我们之前的例子是一样的 要编译运行我们的Java程序 只需要直接点击左边的三角形(启动按钮)即可:

<img src="https://image.itbaima.cn/markdown/2022/09/16/nyWCev6SNkH9oMm.png"/>

点击之后 会在下方自动开始构建:

<img src="https://image.itbaima.cn/markdown/2022/09/16/3791Nedvu8RQxSc.png"/>

完成之后 就可以在控制台看到输出的内容了:

<img src="https://image.itbaima.cn/markdown/2022/09/16/l8G5MwfLJHq3eQD.png"/>

我们可以看到新增加了一个`out`目录 这里面就是刚刚编译好的`.class`文件:

<img src="https://image.itbaima.cn/markdown/2022/09/16/49ywZ8bEQtYdLBP.png"/>

IDEA非常强大 即使是编译之后的二进制文件 也可以反编译回原代码的样子:

<img src="https://image.itbaima.cn/markdown/2022/09/16/DeaO9P8mLRA2uHb.png"/>

如果我们想写一个新的Java项目 可以退出当前项目重新创建:

<img src="https://image.itbaima.cn/markdown/2022/09/16/sIw3ZcarNuA4TS8.png"/>

此时项目列表中就有我们刚刚创建的Java项目了:

<img src="https://image.itbaima.cn/markdown/2022/09/16/urQkEzWw5JOAGLo.png"/>

如果你还想探索IDEA的其他功能 可以点击欢迎页最下方的学习:

<img src="https://image.itbaima.cn/markdown/2022/09/16/MdGZgaBPyqfeIxX.png"/>

会有一个专门的引导教程项目 来教你如何使用各项功能:

<img src="https://image.itbaima.cn/markdown/2022/09/16/I1PcHasEzyxw8eL.png"/>

### IDEA新UI介绍和外观设置
IDEA在2022年开启了界面新UI的测试 并将在年底前实装 所以说我们将老UI界面改为新的UI界面进行介绍(如果已经是新UI的样式 那么就不需要像下面一样开启了)

我们随便进入一个项目 然后双击Shift出现搜索框(这个搜索框很好用 什么都能搜) 输入`registry`:

<img src="https://image.itbaima.cn/markdown/2022/09/16/gXNG9fqzHJiWtlU.png"/>

找到`ide.experimental.ui` 将其勾选上 然后重启IDEA就变成新的UI样式了(你不说这是IDEA我还以为是VS呢)

<img src="https://image.itbaima.cn/markdown/2022/09/16/4urncqfwQFG3pCT.png"/>

这里介绍一下新UI的各个功能 首先是运行项目 依然是点击左侧三角形:

<img src="https://image.itbaima.cn/markdown/2022/09/16/MwEkSagiTDZIL3y.png"/>

在第一次运行后 会自动生成一个运行配置 我们也可以直接点击右上角的运行:

<img src="https://image.itbaima.cn/markdown/2022/09/16/gtVmywzIBP5io1X.png"/>

效果是一样的 都可以编译运行Java项目 上面一排工具栏被丢到了一个菜单里面:

<img src="https://image.itbaima.cn/markdown/2022/09/16/UvednOgYZ3MEhBH.png"/>

如果各位小伙伴觉得代码字体太小了 可以在设置中进行调整:

<img src="https://image.itbaima.cn/markdown/2022/09/16/3zbAx94vJ5NihtY.png"/>

IDEA的所有通知都可以在通知中查看:

<img src="https://image.itbaima.cn/markdown/2022/09/16/18aOSWXMhZnwPeq.png"/>

我们来看右下角 第一个三角形图标是运行的结果:

<img src="https://image.itbaima.cn/markdown/2022/09/16/4IdVS8mrxnezkqE.png"/>

第二栏是终端(其实就是内嵌的一个CMD命令窗口) 可以自由敲命令 默认是位于项目根目录下:

<img src="https://image.itbaima.cn/markdown/2022/09/16/CN9YwJ4LyxWGOIE.png"/>

至此 学习前准备就完成了 从下面开始 我们将正式进入到Java语言的学习中