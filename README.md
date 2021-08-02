<center>

<img src="https://gitee.com/ShaoxiongDu/imageBed/raw/master/info.jpg" style="width:700px" >
</center>
<br>
<div align="center">

<h2><a href="jvmstudy.top" target="_blank">  官网 jvmstudy.top（阅读体验更好）</a></h2>

    <img src="https://img.shields.io/badge/JVM-类加载子系统-blue">
    <img src="https://img.shields.io/badge/JVM-运行时数据区-yellow">
    <img src="https://img.shields.io/badge/JVM-执行引擎-green">
    <img src="https://img.shields.io/badge/JVM-垃圾回收机制-red">
    <img src="https://img.shields.io/badge/JVM-性能优化-purple">
    <img src="https://img.shields.io/badge/JVM-高效并发-pink">
    <img src="https://img.shields.io/badge/LICENSE-MIT-orange">
    <img src="https://visitor-badge.glitch.me/badge?page_id=shaoxiongdu.JVMStudy">

</div>

[![Stargazers over time](https://starchart.cc/shaoxiongdu/JVMStudy.svg)](https://github.com/shaoxiongdu/JVMStudy)

## 思维导图 

![JVMStudy](docs/JVMStudy.png)

## 清单 

### 1. 类加载子系统

- [1-类加载子系统概述](./01-类加载子系统/01-类加载子系统.md)
- [2-类加载过程](./01-类加载子系统/02-类加载过程.md)
- [3-类加载器分类](./01-类加载子系统/03-类加载器的分类.md)
- [4-类加载器的常用方法](./01-类加载子系统/04-类加载器的常用方法.md)
- [5-双亲委派机制](./01-类加载子系统/05-双亲委派机制.md)
- [6-沙箱安全机制](./01-类加载子系统/06-沙箱安全机制.md)

### 2.  运行时数据区 

- [1-运行时数据区的内部结构](./02-运行时数据区/01-运行时数据区内部结构.md)
- [2-程序计数器(PC寄存器)](./02-运行时数据区/02-程序计数器(PC寄存器).md)
- [3-虚拟机栈](./02-运行时数据区/03-虚拟机栈.md)
- [4-本地方法接口](02-运行时数据区/04-本地方法接口.md)
- [5-本地方法栈](02-运行时数据区/05-本地方法栈.md)
- [6-堆](02-运行时数据区/06-堆.md)
- [7-方法区](02-运行时数据区/07-方法区.md)
- [8-对象的实例化内存布局与访问定位+直接内存](02-运行时数据区/08-对象的实例化内存布局与访问定位+直接内存.md)
- [9-字符串常量池](02-运行时数据区/09-字符串常量池.md)

### 3. 执行引擎

- [1-执行引擎](./03-JVM执行引擎/01-JVM执行引擎.md)
- [2-前端编译与优化](03-JVM执行引擎/01-JVM执行引擎.md)
- [3-后端编译与优化](03-JVM执行引擎/01-JVM执行引擎.md)

### 4. 垃圾回收机制
- [1-概述](./04-垃圾回收机制/01-垃圾回收概述.md)
- [2-常见算法](./04-垃圾回收机制/02-垃圾回收相关算法.md)
- [3-垃圾回收相关概念](./04-垃圾回收机制/03-垃圾回收相关概念.md)
- [4-垃圾回收器](./04-垃圾回收机制/04-垃圾回收器.md)

### 5. 性能优化与调优

- [1-性能优化概述](05-性能优化/01-性能优化概述.md)
- [2-JVM监控及诊断工具-命令行篇](./05-性能优化/02-JVM监控及诊断工具-命令行篇.md)
- [3-JVM监控及诊断工具-GUI篇](./05-性能优化/03-JVM监控及诊断工具-GUI篇.md)
- [4-JVM运行时参数](./05-性能优化/04-JVM运行时参数.md)
- [5-分析GC日志](./05-性能优化/05-分析GC日志.md)

### 6. 高效并发

- [1-Java内存模型](./06-高效并发/01-Java内存模型.md)
- [2-Java与线程](./06-高效并发/02-Java线程.md)
- [3-线程安全](./06-高效并发/04-线程安全.md)
- [4-锁优化](./06-高效并发/05-锁优化.md)

## 参考文献

> ### 1.Oracle官网JVM规范
>
> - [JDK1.8的JVM规范](https://docs.oracle.com/javase/specs/jvms/se8/html/)
> - [JDK1.7的JVM规范](https://docs.oracle.com/javase/specs/jvms/se7/html)
> - [JDK1.6的JVM规范](https://docs.oracle.com/javase/specs/jvms/se6/html)
>
> ### 2.参考书籍
>
> 《深入理解JVM虚拟机》 周志明 著
> 
> 《Java虚拟机规范》[詹姆斯·高斯林 (James Gosling)](https://book.douban.com/search/詹姆斯·高斯林)
> 
> 《Java语言规范》
> 
> 《垃圾回收算法手册：自动内存管理的艺术》
> 
> 《Virtual Machines: Versatile Platforms for System and Processes》
> 
> 《Java性能优化权威指南》 [Charlie Hunt](https://book.douban.com/search/CharlieHunt) 著

## 反馈及改进

如果您在学习的时候遇到了任何问题，或者清单有任何可以改进的地方，

非常欢迎提出`issues`,看到就会回馈.并且将您添加到项目贡献者列表中。

## 参与贡献（非常欢迎！）

1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request，填写必要信息。
5. 等待审核即可。通过之后会邮件通知您。

## 许可证

在 MIT 许可下分发。有关更多信息，请参阅[`LICENSE`](./LICENSE)。

## 致谢

>  1. 感谢尚硅谷提供的在线课程视频资料 [在线课程](https://www.bilibili.com/video/BV1PJ411n7xZ)
>  2. 感谢JetBrains提供的配套开发环境许可证 [官方网站](https://www.jetbrains.com/)
>  3. 感谢Gitee提供的图床平台 [相关地址](https://gitee.com/ShaoxiongDu/imageBed)
>  4. 感谢GitHub提供仓库存储数据
>  5. 感谢在线站点生成器 [docsify](https://docsify.js.org/) 提供的在线站点生成功能

## 更多开源项目推荐

### 【Github推荐】 持续分享好玩，有趣，又沙雕的开源项目!   欢迎关注 !

> ![Github推荐](https://gitee.com/ShaoxiongDu/imageBed/raw/master/GithubShareQR.jpg)


