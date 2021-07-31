> 文章已同步至GitHub开源项目: [JVM底层原理解析](https://github.com/shaoxiongdu/JVMStudy)

# Java内存模型

​	JVM虚拟机规范中曾经试图定义一种Java内存模型，来屏蔽掉各种硬件和操作系统的内存访问差异，以实现让Java程序在各种平台下都可以达到一致性的内存访问效果。

​	然而定义这样一套内存模型并非很容易，这个模型必须足够严谨，才能让Java的并发内存访问操作不会有歧义。但是也必须足够宽松，这样使得虚拟机的具体实现能够有自由的发挥空间来利用各种硬件的优势。经过长时间的验证和弥补，到了JDK1.5（实现了JSR133规范）之后，Java内存模型才终于成熟起来了。

## 主内存和工作内存

​	Java内存模型规定了所有的变量都存储在`主内存`(Main Memory)中，每条线程都有自己的`工作内存`（Work Memory）

- 工作内存中保存了被该线程使用的变量的主内存副本，
- 线程对变量的读写操作必须在工作内存中进行。
- 而不能直接访问主内存的数据。
- 不同的线程也不能互相读写对方的工作内存，线程之间的变量传递必须通过主内存传递。

![image-20210731210337786](https://gitee.com/ShaoxiongDu/imageBed/raw/master//images/image-20210731210337786.png)

## 主内存和工作内存的交互

### Java内存模型定义了如下八种操作(每一种操作都是`原子的`，`不可再分`的)

- `lock 锁定`： 作用于主内存，将一个变量标识为线程独占状态
- `unlock: 解锁` ： 作用于主内存，将一个线程独占状态的变量释放
- `read 读取` ： 从主内存读取数据到工作内存，便于之后的load操作
- `load 载入`：  把read读取操作从主内存中得到的变量放入工作内存的变量副本中
- `use 使用`： 将工作内存中的变量传递给执行引擎   当虚拟机遇到一个需要使用变量值的字节码时，执行此操作
- `assign赋值`： 将执行引擎中的值赋给工作内存的变量。 当虚拟机遇到一个赋值操作时，执行此操作
- `store存储`： 将工作内存的值传递到主内存 ，便于之后的write操作
- `write写入`：将store存储操作中从工作内存中获取的变量写入到主内存中

### 举例：

- 如果要把一个变量从主内存拷贝到工作内存，则依次执行read读取操作, load载入操作
- 如果要把一个变量从工作内存写入到主内存，则依次执行store存储操作，write写入操作

### 上述的8种操作必须满足以下规则：

- 不允许read和load、store和write操作之一单独出现。也就是说不允许一个变量从主内存读取但是工作内存不接受，也不允许工作内存发起回写请求但是主内存不接受。
- 不允许一个线程丢弃它的最近assign的操作，即变量在工作内存中改变了之后必须同步到主内存中。
- 不允许一个线程无原因地（没有发生过任何assign操作）把数据从工作内存同步回主内存中。
- 一个新的变量只能在主内存中诞生，不允许在工作内存中直接使用一个未被初始化（load或assign）的变量。即就是对一个变量实施use和store操作之前，必须先执行过了assign和load操作。
- 一个变量在同一时刻只允许一条线程对其进行lock操作，但lock操作可以被同一条线程重复执行多次，多次执行lock后，只有执行相同次数的unlock操作，变量才会被解锁。lock和unlock必须成对出现
- 如果对一个变量执行lock操作，将会清空工作内存中此变量的值，在执行引擎使用这个变量前需要重新执行load或assign操作初始化变量的值
- 如果一个变量事先没有被lock操作锁定，则不允许对它执行unlock操作；也不允许去unlock一个被其他线程锁定的变量。
- 对一个变量执行unlock操作之前，必须先把此变量同步到主内存中（执行store和write操作）。

## volatile特殊规则

​	volatile可以说是Java虚拟机提供的最轻量级的同步机制。但是它并不容易被正确，完整的理解。

​	Java内存模型中规定

​	当一个变量被定义为`volatile`之后，表示着线程工作内存无效，对此值的读写操作都会直接作用在主内存上，

因此它具备对所有线程的`立即可见性`。

1. ### 保证此变量对所有线程的`立即可见性`

   ​	当变量的值被修改之后，新值对于其他线程是立即可知的。普通变量并不能做到这一点，因为普通变量的值在线程之间的传递是要进过主内存来完成的。比如当线程A对变量进行了回写操作，线程B只有在A回写完成之后，在对主内存操作，新值才对B是可见的。在A回写到主内存的过程中，B读取的依旧是旧值。

   ​	但是这并不可以推导出`基于volatile变量的运算在并发下是安全的`，因为在Java中的运算操作符并不是`原子性`的。这导致了`volatile变量在并发下运算是不安全`的。

   通过代码验证`volatile变量在并发下运算是不安全`

   首先我们创建20个线程，每个线程对volatile变量进行1000次的自增操作。

   ```java
   /**
    * @作者: 写Bug的小杜 【email@shaoxiongdu.cn】
    * @时间: 2021/07/31
    * @描述: 通过代码验证 【volatile变量在并发下运算是不安全】
    */
   public class VolatileTest {
   
       //volatile修饰的count
       private static volatile int count = 0;
   
       //count自增方法
       public static void increment(){
           count++;
       }
   
       public static void main(String[] args) {
   
           //对count进行递增1000次操作的可运行接口
           Runnable runnable = new Runnable() {
               @Override
               public void run() {
                   System.out.println(Thread.currentThread().getName() + "线程开始对count进行递增操作");
                   for (int i = 0; i < 1000; i++) {
                       increment();
                   }
                   System.out.println(Thread.currentThread().getName() + "线程对count递增操作结束");
               }
           };
   
           // 创建20个线程并启动
           for (int i = 0; i < 20; i++) {
   
               Thread thread = new Thread(runnable);
               thread.setName((i+1) + "号线程");
               thread.start();
   
           }
   
           while (Thread.activeCount() > 2){
               //主线程回到就绪状态
               Thread.yield();
           }
   
           System.out.println("所有线程结束,count = " + count);
   
   
       }
   
   
   }
   ```

   如果此程序在并发下是安全的，那么count的值最后肯定是20*1000 = 20000；也就是说，如果运行结果为20000，那么`volatile变量在并发下运算是安全的`

   通过多次运行程序，我们发现，count的值永远比20000小。

   ![image-20210731215601479](https://gitee.com/ShaoxiongDu/imageBed/raw/master//images/image-20210731215601479.png)

   那么，这是为什么呢？

   我们将上方的代码进行反编译，然后分析increment方法的字节码指令。

   ```java
   0 getstatic #2 <cn/shaoxiongdu/chapter6/VolatileTest.count : I>
   3 iconst_1
   4 iadd
   5 putstatic #2 <cn/shaoxiongdu/chapter6/VolatileTest.count : I>
   8 return
   ```

   我们可以发现，一行count++代码被分为 4行字节码文件去执行。通过对字节码的分析，我们发现，

   当偏移量为0的字节码getStatic将count的值从局部变量表取到操作数栈顶的时候，`volatile`保证了此时count的值是正确的，但是在执行iconst_1, iadd这些操作的时候，其他线程已经把count的值改变了，此时，操作数栈顶的count为过期的数据，所以putStatic字节码指令就有可能将较小的值同步到主内存中。因此最终的值会比20000稍微小。

   也就是说，`volatile变量在并发下运算是不安全的` 。

   在并发环境下，volatile的变量只是对全部线程即时可见的，如果要进行写的操作，还是要通过加锁来解决。



​	



> 文章已同步至GitHub开源项目: [JVM底层原理解析](https://github.com/shaoxiongdu/JVMStudy)
