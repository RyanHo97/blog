# Java多线程 _ JUC

## 笔记相关

课程：2019_06版-juc-尚硅谷周阳

地址：https://www.bilibili.com/video/BV1jy4y1k7AP

笔记作者：Ryanho97

笔记时间：2021/2/7





## 正文

### 1.JUC介绍

JUC=java.util.concurrent

在并发编程中使用的工具类



主要是三个包构成：

java.util.concurrent

java.util.concurrent.atomic

java.util.concurrent.locks



复习进程线程

1.进程/线程是什么？

进程：进程是一个具有一定独立功能的程序关于某个数据集合的一次运行活动。它是操作系统动态执行的基本单元，在传统的操作系统中，进程既是基本的分配单元，也是基本的执行单元。

线程：通常在一个进程中可以包含若干个线程，当然一个进程中至少有一个线程，不然没有存在的意义。线程可以利用进程所拥有的资源，在引入线程的操作系统中，通常都是把进程作为分配资源的基本单位，而把线程作为独立运行和独立调度的基本单位，由于线程比进程更小，基本上不拥有系统资源，故对它的调度所付出的开销就会小得多，能更高效的提高系统多个程序间并发执行的程度。	



2.并发/并行是什么？

引用知乎：https://www.zhihu.com/question/33515481

你吃饭吃到一半，电话来了，你一直到吃完了以后才去接，这就说明你不支持并发也不支持并行。
你吃饭吃到一半，电话来了，你停了下来接了电话，接完后继续吃饭，这说明你支持并发。
你吃饭吃到一半，电话来了，你一边打电话一边吃饭，这说明你支持并行。

并发的关键是你有处理多个任务的能力，不一定要同时。
并行的关键是你有同时处理多个任务的能力。

所以我认为它们最关键的点就是：是否是『同时』。







### 2.卖票复习



代码示例

```java
package com.atguigu.sh.juc;

class Ticket //资源类
{
    private int number=30;

    public synchronized void saleTicket()
    {
        if (number>0)
        {
            System.out.println(Thread.currentThread().getName()+"\t卖出第："+(number--)+"\t还剩下："+number);
        }
    }
}
/*
    题目：三个售票员    卖出  30张票

    多线程编程的企业级套路+模板

    1.  在高内聚低耦合的前提下，线程  操作（对外暴露的调用方法）  资源类
 */


public class SaleTicket {

    public static void main(String[] args) throws Exception     //main一切程序入口
    {
        Ticket ticket = new Ticket();

        //Thread(Runnable target, String name) 分配一个新的 Thread对象。

        //使用了匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=40;i++){
                    ticket.saleTicket();
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=40;i++){
                    ticket.saleTicket();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=40;i++){
                    ticket.saleTicket();
                }
            }
        },"C").start();

    }

}
```



### 3.卖票改写为LambdaExpress

1.引入java.util.concurrent.locks

凡是接口，则必有实现类

- - java.util.concurrent.locks.ReentrantLock 

  - 一个可重入互斥[`Lock`](../../../../java/util/concurrent/locks/Lock.html)具有与使用`synchronized`方法和语句访问的隐式监视锁相同的基本行为和语义，但具有扩展功能。





```java
class X {
    private final ReentrantLock lock = new ReentrantLock();
    // ...

    public void m() {
        lock.lock();    // block until condition holds
        try {
            // ... method body
            } finally {
            lock.unlock();
        }
    }
}
```





t1.start()就绪



2.⭐线程状态

| Thread.State  | 线程状态 |
| ------------- | -------- |
| NEW           | 新建     |
| RUNNABLE      | 就绪     |
| BLOCKED       | 阻塞     |
| WAITING       | 等待     |
| TIMED_WAITING | 超时等待 |
| TERMINATED    | 终止     |



**①初始(NEW)**：新创建了一个线程对象，但还没有调用start()方法。
②**运行(RUNNABLE)**：Java线程中将就绪（ready）和运行中（running）两种状态笼统的成为“运行”。
线程对象创建后，其他线程(比如main线程）调用了该对象的start()方法。该状态的线程位于可运行线程池中，等待被线程调度选中，获取cpu 的使用权，此时处于就绪状态（ready）。就绪状态的线程在获得cpu 时间片后变为运行中状态（running）。
③**阻塞(BLOCKED)**：表线程阻塞于锁。
④**等待(WAITING)**：进入该状态的线程需要等待其他线程做出一些特定动作（通知或中断）。
⑤**超时等待(TIME_WAITING)**：该状态不同于WAITING，它可以在指定的时间内自行返回。

⑥**终止(TERMINATED)**：表示该线程已经执行完毕。



3.wait/sleep区别

功能都是当前线程暂停，有什么区别？

wait放开手去睡，放开手里的锁

sleep握紧手去睡，醒了手里还有锁



4.示例代码

```java
package com.atguigu.sh.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket //资源类
{
    private int number=30;
    private Lock lock = new ReentrantLock();

    public void saleTicket()
    {
        lock.lock();
        try {
            if (number>0)
            {
                System.out.println(Thread.currentThread().getName()+"\t卖出第："+(number--)+"\t还剩下："+number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
/*
    题目：三个售票员    卖出  30张票

    多线程编程的企业级套路+模板

    1.  在高内聚低耦合的前提下，线程  操作（对外暴露的调用方法）  资源类
 */


public class SaleTicket {

    public static void main(String[] args) throws Exception     //main一切程序入口
    {
        Ticket ticket = new Ticket();

        new Thread(()->{for (int i=1;i<=40;i++)ticket.saleTicket();},"A").start();
        new Thread(()->{for (int i=1;i<=40;i++)ticket.saleTicket();},"B").start();
        new Thread(()->{for (int i=1;i<=40;i++)ticket.saleTicket();},"C").start();


        //Thread(Runnable target, String name) 分配一个新的 Thread对象。

        //使用了匿名内部类
        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=40;i++){
                    ticket.saleTicket();
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=40;i++){
                    ticket.saleTicket();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=40;i++){
                    ticket.saleTicket();
                }
            }
        },"C").start();
        */

    }

}



```

