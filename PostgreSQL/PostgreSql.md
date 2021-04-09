# PostgreSql

## 1.什么是PostgreSql

#### 百度百科

> PostgreSQL是一种特性非常齐全的自由软件的对象-关系型数据库管理系统（[ORDBMS](https://baike.baidu.com/item/ORDBMS/870762)），是以[加州大学](https://baike.baidu.com/item/加州大学/3298010)计算机系开发的POSTGRES，4.2版本为基础的对象关系型数据库管理系统。POSTGRES的许多领先概念只是在比较迟的时候才出现在商业网站数据库中。PostgreSQL支持大部分的[SQL](https://baike.baidu.com/item/SQL/86007)标准并且提供了很多其他现代特性，如复杂查询、[外键](https://baike.baidu.com/item/外键/1232333)、[触发器](https://baike.baidu.com/item/触发器/16782)、[视图](https://baike.baidu.com/item/视图/1302820)、事务完整性、多版本并发控制等。同样，PostgreSQL也可以用许多方法扩展，例如通过增加新的数据类型、函数、操作符、[聚集函数](https://baike.baidu.com/item/聚集函数/6704258)、索引方法、过程语言等。另外，因为许可证的灵活，任何人都可以以任何目的免费使用、修改和分发PostgreSQL。



#### 知识点

- 面向关系的数据库
  - Oracle
  - Mysql
  - SQLServer
  - PostgreSql
- Nosql
  - MongDB
  - Redis



#### 数据库排名

https://db-engines.com/en/ranking

#### 官方网站

https://www.postgresql.org/

#### 技术准备

SQL语言基础

#### 使用环境

视频推荐：

- Ubuntu Server 16 LTS
- PostgreSql 9.5.x

个人环境：

- Ubuntu 20.04 LTS
- PostgreSql 12.6

#### 安装

```linux
$ sudo apt-get install postgresql
$ psql --version
```

## 2.初来乍到数据库

#### 知识点

- psql的基础
- 数据库简单操作
- 写个SQL

#### 实战演习

```bash
sudo su postgres 切换用户
psql --version  查看版本
psql -l			查看所有的数据库
createdb ryanhoblog		创建数据库
psql -l
psql ryanhoblog			进入数据库
help					帮助
\h						帮助操作表的命令
\?						帮助操作库的命令
\l						查看所有的数据库
\q						退出
psql ryanhoblog
select now();			查看当前时间
select version();		查看当前版本
\q
dropdb ryanhoblog		删除数据库
psql -l
```



## 3.操作数据表

#### 知识点

- create table
- drop table
- psql使用

#### 实战演习

```bash
sudo su postgres
createdb ryanblog
psql -l
psql ryanblog

>create table posts (title varchar(255),content text);  建表 posts 文章标题 文本类型
>\dt	当前表一览
>\d posts	具体表的信息
>alter table posts rename to ryanposts;	重命名表
>\dt
>drop table ryanposts;	删除表
>\dt
>\q

nano db.sql	复用sql语句

psql ryanblog
>\i db.sql
>\dt

```
