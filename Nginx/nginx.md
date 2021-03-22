# Nginx

前言

- 课程名称：尚硅谷Nginx教程由浅入深（一套打通丨初学者也可掌握）

- 课程地址：https://www.bilibili.com/video/BV1zJ411w7SV

- 笔记作者：Ryanho97

- 笔记时间：2021/03/19

目录

1、nginx基本概念

- nginx是什么，做什么事情
- 反向代理
- 负载均衡
- 动静分离



2、nginx安装、常用命令和配置文件

- 在linux系统中安装nginx
- nginx常用命令
- nginx配置文件



3、nginx配置实例1-反向代理



4、nginx配置实例2-负载均衡



5、nginx配置实例3-动静分离



6、nginx配置高可用集群



7、nginx原理



## 正文

### 1、nginx简介

百度百科

> *Nginx* (engine x) 是一个高性能的[HTTP](https://baike.baidu.com/item/HTTP)和[反向代理](https://baike.baidu.com/item/反向代理/7793488)web服务器，同时也提供了IMAP/POP3/SMTP[服务](https://baike.baidu.com/item/服务/100571)。Nginx是由伊戈尔·赛索耶夫为[俄罗斯](https://baike.baidu.com/item/俄罗斯/125568)访问量第二的Rambler.ru站点（俄文：Рамблер）开发的，第一个公开版本0.1.0发布于2004年10月4日。
>
> 特点：占有内存少，[并发](https://baike.baidu.com/item/并发/11024806)能力强，事实上nginx的并发能力在同类型的网页服务器中表现较好
>
> 中国大陆使用nginx网站用户有：百度、[京东](https://baike.baidu.com/item/京东/210931)、[新浪](https://baike.baidu.com/item/新浪/125692)、[网易](https://baike.baidu.com/item/网易/185754)、[腾讯](https://baike.baidu.com/item/腾讯/112204)、[淘宝](https://baike.baidu.com/item/淘宝/145661)等。



1. 什么是nginx

   Nginx是一个高性能的HTTP和反向代理服务器，特点是占有内存少，并发能力强，事实上nginx的并发能力确实在同类型的网页服务器中表现较好

   Nginx专为性能优化而开发，性能是其最重要的考量，实现上非常注重效率，能经受高负载的考验，有报告表明能支持高达50000个并发连接数。

2. 反向代理

   - 正向代理：如果把局域网外的Internet想象成一个巨大的资源库，则局域网中的客户端要访问Internet，则需要通过代理服务器来访问，这种代理服务就称为正向代理。

     浏览器配置代理服务器，通过代理服务器进行互联网访问

   - 反向代理：其实客户端对代理是无感知的，因为客户端不需要任何配置就可以访问，我们只需要将请求发送到反向代理服务器，由反向代理服务器去选择目标服务器获取数据后，再返回客户端，此时反向代理服务器和目标服务器对外就是一个服务器，暴露的是代理服务器的地址，隐藏了真实服务器IP地址。

1. 负载均衡
2. 动静分离
3. 高可用

