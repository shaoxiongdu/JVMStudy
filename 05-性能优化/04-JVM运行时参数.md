# JVM运行时参数

## 1.  JVM参数选项类型

- ### 标准参数选项

  - 比较稳定 以 - 开头

    ```java
        -d32          使用 32 位数据模型 (如果可用)
        -d64          使用 64 位数据模型 (如果可用)
        -server       选择 "server" VM
                      默认 VM 是 server.
    
        -cp <目录和 zip/jar 文件的类搜索路径>
        -classpath <目录和 zip/jar 文件的类搜索路径>
                      用 ; 分隔的目录, JAR 档案
                      和 ZIP 档案列表, 用于搜索类文件。
        -D<名称>=<值>
                      设置系统属性
        -verbose:[class|gc|jni]
                      启用详细输出
        -version      输出产品版本并退出
        -version:<值>
                      警告: 此功能已过时, 将在
                      未来发行版中删除。
                      需要指定的版本才能运行
        -showversion  输出产品版本并继续
        -jre-restrict-search | -no-jre-restrict-search
                      警告: 此功能已过时, 将在
                      未来发行版中删除。
                      在版本搜索中包括/排除用户专用 JRE
        -? -help      输出此帮助消息
        -X            输出非标准选项的帮助
        -ea[:<packagename>...|:<classname>]
        -enableassertions[:<packagename>...|:<classname>]
                      按指定的粒度启用断言
        -da[:<packagename>...|:<classname>]
        -disableassertions[:<packagename>...|:<classname>]
                      禁用具有指定粒度的断言
        -esa | -enablesystemassertions
                      启用系统断言
        -dsa | -disablesystemassertions
                      禁用系统断言
        -agentlib:<libname>[=<选项>]
                      加载本机代理库 <libname>, 例如 -agentlib:hprof
                      另请参阅 -agentlib:jdwp=help 和 -agentlib:hprof=help
        -agentpath:<pathname>[=<选项>]
                      按完整路径名加载本机代理库
        -javaagent:<jarpath>[=<选项>]
                      加载 Java 编程语言代理, 请参阅 java.lang.instrument
        -splash:<imagepath>
                      使用指定的图像显示启动屏幕
    ```

    有关详细信息, 请参阅 http://www.oracle.com/technetwork/java/javase/documentation/index.html。

- ### -X参数选项

  ```java
      -Xmixed           混合模式执行（默认）
      -Xint             仅解释模式执行
      -Xbootclasspath:<用 ; 分隔的目录和 zip/jar 文件>
                        设置引导类和资源的搜索路径
      -Xbootclasspath/a:<用 ; 分隔的目录和 zip/jar 文件>
                        附加在引导类路径末尾
      -Xbootclasspath/p:<用 ; 分隔的目录和 zip/jar 文件>
                        置于引导类路径之前
      -Xdiag            显示附加诊断消息
      -Xnoclassgc        禁用类垃圾收集
      -Xincgc           启用增量垃圾收集
      -Xloggc:<file>    将 GC 状态记录在文件中（带时间戳）
      -Xbatch           禁用后台编译
      -Xms<size>        设置初始 Java 堆大小
      -Xmx<size>        设置最大 Java 堆大小
      -Xss<size>        设置 Java 线程堆栈大小
      -Xprof            输出 cpu 分析数据
      -Xfuture          启用最严格的检查，预计会成为将来的默认值
      -Xrs              减少 Java/VM 对操作系统信号的使用（请参阅文档）
      -Xcheck:jni       对 JNI 函数执行其他检查
      -Xshare:off       不尝试使用共享类数据
      -Xshare:auto      在可能的情况下使用共享类数据（默认）
      -Xshare:on        要求使用共享类数据，否则将失败。
      -XshowSettings    显示所有设置并继续
      -XshowSettings:system
                        （仅限 Linux）显示系统或容器
                        配置并继续
      -XshowSettings:all
                        显示所有设置并继续
      -XshowSettings:vm 显示所有与 vm 相关的设置并继续
      -XshowSettings:properties
                        显示所有属性设置并继续
      -XshowSettings:locale
                        显示所有与区域设置相关的设置并继续
  ```

  -X 选项是非标准选项。如有更改，恕不另行通知。

- ### -XX参数选项

  #### 分类

  - 布尔类型 : -XX +<option> 启用     -XX -<option> 停用
  - 非布尔类型：-XX:name=value

## 2. 添加JVM参数选项

- ### IDEA：    

  - 点击配置运行环境，打开VM选项即可输入

  ![image-20210711205033973](https://images-1301128659.cos.ap-beijing.myqcloud.com/MacBookPro202208051424366.png)

- ### 运行jar包： 

  - java <参数> -jar demo.jar

- ### 通过Tomcat运行：    

  - catalina.bat中添加：set "JAVA_OPTS=-Xms100m -Xmx100m"

## 3. 常用的JVM参数选项

### 打印设置的参数

- -XX:+PrintCommandLineFlags 表示程序运行前打印出JVM参数
- -XX:+PrintFlagsInitial 表示打印出所有参数的默认值
- -XX:+PrintFlagsFinal 打印出最终的参数值
- -XX:+PrintVMOptions 打印JVM的参数

### 栈

- -Xss128k

### 堆

- -Xms600m    设置堆的初始大小
- -Xmx600m   设置堆的最大大小
- -XX:NewSize=1024m  设置年轻代的初始大小
- -XX:MaxNewSize=1024m  设置年轻代的最大值
- -XX:SurvivorRatio=8 伊甸园和幸存者的比例
- -XX:NewRatio=4 设置老年代和新生代的比例
- -XX:MaxTenuringThreshold=15 设置晋升老年代的年龄条件

### 方法区

- 永久代
  - -XX:PermSize=256m 设置永久代初始大小
  - -XX:MaxPernSize=256m 设置永久代的最大大小
- 元空间
  - -XX:MetasapceSize=256m 设置初始元空间大小
  - -XX:MaxMatespaceSize=256m 设置最大元空间大小 默认无限制

### 直接内存

- -XX:MaxDirectMemorySize  设置直接内存的容量，默认与堆最大值一样。

