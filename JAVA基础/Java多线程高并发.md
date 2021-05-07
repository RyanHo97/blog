# Java多线程高并发

前言

视频名称：Java多线程实战精讲-带你一次搞明白Java多线程高并发

视频地址：https://www.bilibili.com/video/BV1Rv411y7MU

笔记作者：ryanho97（何宇）

笔记时间：2021/04/30

## 正文

### 一、线程概述

#### 1.线程相关概念

**进程**

​	进程（Process）是计算机中的程序关于某数据集合上的一次运行活动，是操作系统进行资源分配与调度的基本单位。

​	可以把进程简单的理解为正在操作系统中运行的一个程序。



**线程**

​	线程（Thread）是进程的一个执行单元。

​	 一个线程就是进程中一个单一顺序的控制流，进程的一个执行分支。

​	进程是线程的容器，一个进程至少有一个线程，一个进程中也可以有多个线程。

​	在操作系统中是以进程为单位分配资源，如虚拟存储空间，文件描述符等。每个线程都有各自的线程栈，自己的寄存器环境，自己线程本地存储。



**主线程与子线程**

​	JVM启动时会创建一个主线程，该主线程负责执行main方法。主线程就是运行main方法的线程。

​	Java中的线程不孤立的，线程之间存在一些联系。如果在A线程中创建了B线程，称B线程为A线程的子线程，相应的A线程就是B线程的父线程。



**串行，并发与并行**

- 串行（Sequential），先做任务A，完成后再做任务B，完成后再做任务C。
- 并发（Concurrent），先做任务A，准备了五分钟后，在等待A完成的这段时间内就开始做任务B，任务B准备了2分钟，在等待B完成的过程中开始做任务C，10分钟后任务C结束。
- 并行（Parallel），三个任务同时开始，总耗时取决于需要时间最长的那个任务。



**总结：**

并发可以提高以事物的处理效率，即一段时间内可以处理或者完成更多的事情。

并行是一种更为严格，理想的并发。

从硬件角度来说，如果单核CPU，一个处理器一次只能执行一个线程的情况下，处理器可以使用时间片轮转技术，可以让CPU快速的在各个线程之间进行切换，对于用户来说，感觉是三个线程在同时执行。如果是多核心CPU，可以为不同的线程分配不同的CPU内核。



#### 2.线程的创建与启动

​	在Java中，创建一个线程就是创建一个Thread类（子类）的对象（实例）。

​	Thread类有两个常用的构造方法：Thread
()与Thread(Runnable)。对应的创建线程的两种方式：

​	定义Thread类的子类

​	定义一个Runnable接口的实现类

​	这两种创建线程的方式没有本质的区别



Thread方式示例

```java
package com.ryan.createthread.p1;

//1.定义类继承Thread
//作者：Ryanho97
public class MyThread extends Thread{
    //2.重写Thread父类中的run()
    //run()方法体中的代码就是子线程要执行的任务
    @Override
    public void run(){
        System.out.println("这是子线程打印的内容");
    }


}

```



测试类：

```java
package com.ryan.createthread.p1;

public class Test {
    public static void main(String[] args) {
        System.out.println("JVM启动main线程，main线程执行main方法");
        //3.创建子线程对象
        MyThread thread = new MyThread();
        //4.启动线程   注意：start()方法调用结束并不意味着子程序开始运行
        thread.start();
        //调用线程的start()方法来启动线程，启动线程的实质就是请求JVM运行相应的线程，这个线程具体在什么时候运行由线程调度器（Scheduler）决定。
        //新开启的线程会执行run()方法
        //如果开启了多个线程，start()调用的顺序并不一定就是线程启动的顺序
        //多线程运行结果与代码执行顺序或调用顺序无关
        System.out.println("main线程后面其他的代码...");
    }
}

```



证明：多线程运行结果随机性

```java
package com.ryan.createthread.p2;

public class MyThread2 extends Thread {

    @Override
    public void run(){
        try {
            for (int i = 1;i <= 10;i++){
                System.out.println("sub thread:"+i);
                int time = (int) (Math.random()*1000);
                Thread.sleep(time);    //线程睡眠，单位是毫秒，1秒 = 1000毫秒
            }
        } catch (InterruptedException e) {  //Ctrl+Alt+T 生成
            e.printStackTrace();
        }
    }
}

```



测试类

```java
package com.ryan.createthread.p2;

public class Test {
    public static void main(String[] args) {

        MyThread2 thread2 = new MyThread2();
        thread2.start();    //开启子线程

        //当前main线程
        try {
            for (int i = 1;i <= 10;i++){
                System.out.println("main--"+i);
                int time = (int) (Math.random()*1000);
                Thread.sleep(time);    //线程睡眠，单位是毫秒，1秒 = 1000毫秒
            }
        } catch (InterruptedException e) {  //Ctrl+Alt+T 生成
            e.printStackTrace();
        }

    }
}

```



Runnable方式示例

```java
package com.ryan.createthread.p3;

/**
 * Author:Ryanho97.github.io
 * Create: 14:34  2021/4/30
 * 当线程类已经有父类了，就不能用继承Thread类的形式创建线程，可以使用实现Runnable接口的形式
 * 1.定义类实现Runnable接口
 */
public class MyRunnable implements Runnable{
    //2.重写Runnable接口中的抽象方法run()，run()方法就是子线程要执行的代码
    @Override
    public void run(){
        for (int i = 1; i <=100 ; i++) {
            System.out.println("sub thread -- >" + i);
        }
    }
}

```



测试类

```java
package com.ryan.createthread.p3;

/**
 * Author:Ryanho97.github.io
 * Create: 14:33  2021/4/30
 * 测试实现Runnable接口的形式创建线程
 */
public class Test {
    public static void main(String[] args) {
        //3.创建Runnable接口的实现类对象
        MyRunnable myRunnable = new MyRunnable();
        //4.创建线程对象
        Thread thread = new Thread(myRunnable);
        //5.开启线程
        thread.start();

        for (int i = 1; i <=100 ; i++) {
            System.out.println("main==>" + i);
        }

        //有时调用Thread(Runnable)构造方法时，实参也会传递匿名内部类对象
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=100 ; i++) {
                    System.out.println("sub --------------------->" + i);
                }
            }
        });
        thread2.start();
    }
}

```



#### 3.线程的常用方法

3.1 currentThread()方法

Thread.currentThread()方法可以获得当前线程

Java中的任何一段代码都是执行在某个线程当中的。执行当前代码的线程就是当前线程

同一段代码可能被不同的线程执行，因此当前线程是相对的，Thread.currentThread()方法的返回值是在代码实际运行时候的线程对象



定义线程类

```java
package com.ryan.threadmethod;

/**
 * Author:Ryanho97.github.io
 * Create: 14:54  2021/4/30
 * 定义线程类
 *     分别在构造方法中和run方法中打印当前线程
 */
public class SubThread1 extends Thread{
    public SubThread1(){
        System.out.println("构造方法打印当前线程名称：" + Thread.currentThread().getName());
    }

    @Override
    public void run(){
        System.out.println("run方法打印当前线程名称：" + Thread.currentThread().getName());
    }
}

```



测试类

```java
package com.ryan.threadmethod;

/**
 * Author:Ryanho97.github.io
 * Create: 14:55  2021/4/30
 *
 */
public class Test01CurrentThread {
    public static void main(String[] args) {
        System.out.println("main方法中打印当前线程" + Thread.currentThread().getName());

        //创建子线程，调用SubThread1()构造方法，在main线程中调用构造方法，所以构造方法中的当前线程就是main线程
        SubThread1 t1 = new SubThread1();
        //t1.start();    //启动子线程，子线程会调用run()方法，所以run()方法中的当前线程就是Thread-0

        t1.run();    //在main方法中直接调用run()方法，没有开启新的线程，所以在run方法中的当前线程就是main线程
    }
}

```

3.2 currentThread的一个复杂案例

定义线程类

```java
package com.ryan.threadmethod;

/**
 * Author:Ryanho97.github.io
 * Create: 14:30  2021/5/7
 */
public class SubThread2 extends Thread {
    public SubThread2(){
        System.out.println("构造方法中，Thread.currentThread().getName() :"+Thread.currentThread().getName());
        System.out.println("构造方法中，this.getName()："+this.getName());
    }

    @Override
    public void run() {
        System.out.println("run方法中，Thread.currentThread().getName() :"+Thread.currentThread().getName());
        System.out.println("run方法中，this.getName()："+this.getName());
    }
}
```

测试类

```java
package com.ryan.threadmethod;

/**
 * Author:Ryanho97.github.io
 * Create: 14:38  2021/5/7
 */
public class Test02CurrentThread {
    public static void main(String[] args) throws InterruptedException {
        //创建子线程对象
        SubThread2 t2 = new SubThread2();
        t2.setName("t2");  //设置线程的名称
        t2.start();

        //
        Thread.sleep(500);  //main线程睡眠500毫秒

        //Thread(Runnable)构造方法形参是Runnable接口，调用时传递的实参是接口的实现类对象
        Thread t3 = new Thread(t2);
        t3.start();
    }
}
```



3.3 setName()/getName()

thread.setName(线程名称)，设置线程名称

thread.getName()，返回线程名称

通过设置线程名称，有助于程序调试，提高程序的可读性，建议为每个线程都设置一个能够体现线程功能的名称



3.4 isAlive()

thread.isAlive()判断当前线程是否处于活动状态

活动状态就是线程已启动并且尚未终止

定义线程类

```java
package com.ryan.threadmethod.p2IsAlive;

/**
 * Author:Ryanho97.github.io
 * Create: 14:54  2021/5/7
 */
public class SubThread3 extends Thread {
    @Override
    public void run() {
        System.out.println("run方法，isalive"+this.isAlive());  //运行状态，true
    }
}
```

测试类

```java
package com.ryan.threadmethod.p2IsAlive;

/**
 * Author:Ryanho97.github.io
 * Create: 14:54  2021/5/7
 * 测试线程的活动状态
 */
public class Test {
    public static void main(String[] args) {
        SubThread3 t3 = new SubThread3();
        System.out.println("begin==" + t3.isAlive());  //false，在启动线程之前
        t3.start();
        System.out.println("end==" + t3.isAlive());  //结果不一定，打印这一行时，如果t3线程还没结束就返回true，如果t3线程已结束，返回false
    }
}
```




