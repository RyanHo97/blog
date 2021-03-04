# Docker

## 前言

课程名字：【狂神说Java】Docker最新超详细版教程通俗易懂

课程地址：https://www.bilibili.com/video/BV1og4y1q7M4

笔记作者：https://github.com/RyanHo97

笔记时间：2021/03/04 - 

学习心态：谦卑

​	弱小和无知不是生存的障碍，傲慢才是。		-《三体》

## 正文

### 1.Docker学习大纲

学习准备

1. Linux(必要)
2. SpringBoot



**Docker**学习

- Docker概述
- Docker安装
- Docker命令
  - 镜像命令
  - 容器命令
  - 操作命令
- Docker镜像！
- 容器数据卷
- DockerFile
- Docker网络原理
- IDEA整合Docker
- Docker Compose（集群）
- Docker Swarm（集群）
- CI\CD Jenkins
- 后期进阶转向学习K8S



### 2.Docker概述

#### Docker为什么出现？

一款产品：开发 -- 上线 两套环境！应用环境，应用配置！

开发 ---- 运维。问题：我在我的电脑上可以运行！版本更新，导致服务不可用！

环境配置时每一个机器都要部署环境（集群Redis、ES、Hadoop...）！费时费力。

发布一个项目（jar+（Redis Mysql jdk ES）），项目能不能都带上环境安装打包！

之前在服务器配置一个应用的环境Redis MySQL jdk ES Hadoop，配置超麻烦的，不能够跨平台。

Windows，最后发布到Linux！



java -- apk --发布（应用商店） --用户使用apk

java -- jar（环境） -- 打包项目带上环境（镜像） -- （Docker仓库：商店） -- 下载我们好的发布镜像 -- 直接运行即可！



Docker给以上的问题，提出了解决方案！





 ![img](https://www.runoob.com/wp-content/uploads/2016/04/docker01.png)

Docker的思想就来自于集装箱

JRE -- 多个应用（端口冲突） -- 原来都是交叉的

隔离：Docker核心思想！打包装箱！每个箱子是互相隔离的。

Docker通过隔离机制，可将服务器利用到极致。



本质：所有的技术都是因为出现了一些问题，我们需要去解决，才去学习！



#### Docker历史

2010年，几个IT方面的人才，就在美国成立了一家公司**dotCloud**

做一些pass的云计算服务！LXC有关的容器技术。

他们将自己的技术（容器化技术）命名 就是 Docker！

Docker刚刚诞生的时候，没有引起行业的注意！dotCloud，就活不下去！

**开源**

开放源代码！

2013，Docker开源！

Docker越来越多的人发现了docker的优点！火了，Docker每个月都会更新一个版本！

2014年4月9日，Docker1.0发布！

Docker为什么这么火？十分的轻巧！

在容器技术出来之前，我们都是使用虚拟机技术！

虚拟机：在window中装一个Vmware，通过这个软件我们可以虚拟出来一台或者多台电脑！

虚拟机也是属于虚拟化技术，Docker容器技术，也是一种虚拟化技术！

vm:linux centos原生镜像（一个电脑！）隔离，需要开启多个虚拟机！

docker:隔离，镜像（最核心的环境 4m + jdk +mysql）十分的小巧，运行镜像就可以了！小巧（几个m kb） 秒级启动！



聊聊Docker

Docker是基于Go语言开发的！开源项目！

官网：https://www.docker.com/

文档地址：https://docs.docker.com/ Docker的文档是超级详细的！

仓库地址：https://hub.docker.com/



#### Docker能做什么

虚拟机技术图：

![Docker图1](.\Docker\Docker图1.png)

虚拟机技术缺点：

1、资源占用十分多

2、冗余步骤多

3、启动很慢



容器化技术图：

![Docker图2](.\Docker\Docker图2.png)

容器化技术不是模拟的一个完整的操作系统



比较Docker 和 虚拟机技术的不同：

- 传统虚拟机，虚拟出一条硬件，运行一个完整的操作系统，然后在这个系统上安装和运行软件
- 容器内的应用直接运行在 宿主机的内容，容器是没有自己的内核的，也没有虚拟我们的硬件，所以就轻便了
- 每个容器间是互相隔离，每个容器内都有一个属于自己的文件系统，互不影响。

> DevOps（开发、运维）

**应用更快速的交付和部署**

传统：一堆帮助文档，安装程序

Docker：打包镜像发布测试，一键运行

**更便捷的升级和扩缩容**

使用了Docker之后，我们部署应用就和搭积木一样！

（SpringBoot 1.5	Redis5	tomcat8）升级

项目打包为一个镜像，扩展 服务器A！服务器B

**更简单的系统运维**

在容器化之后，我们的开发，测试环境都是高度一致的。

**更高效的计算资源利用**：

Docker 是 内核级别的虚拟化，可以在一个物理机上可以运行很多的容器实例！服务器的性能可以被压榨到极致。



### 3.Docker安装

#### Docker的基本组成

![img](https://img2020.cnblogs.com/blog/1865616/202004/1865616-20200420232419387-1082587992.jpg)

