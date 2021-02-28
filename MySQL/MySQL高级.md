# 索引和事务

table index view procedure user role



## 1.索引

对于任何的数据库管理系统，索引都是进行优化的最主要因素。对于少量的数据，即使没有合适的索引对数据库性能的影响并不是很大，但是随着数据量的增加，数据库性能会急剧下降。所以索引目的在于提高减速数据的效率



### 1.1什么是索引 index

汉语字典 检字法(拼音，部首)

一本书400页 目录附录

-----

数据库表10万，13亿条数据，如何查找？

使用索引，查询内容先查询索引，根据索引可以定位到要查询的内容，可以提高查询速度。



index page    |  data page

### 1.2索引的作用

提高了查询的速度

### 1.3常见问题

- 索引占空间吗？

  占用空间，但是空间小；能够带来速度的明显提升

- 索引是不是越多越好？

  不是

  索引也占空间，多个索引就好占用更多的空间；给经常需要用到的内容建立索引，否则会查询建立了索引，占用了空间，但是很少使用。

  索引会提高查询的速度，但是会降低添加，更新，删除的速度(不仅操作数据库表，也要操作索引)

- 一般给哪些列建立索引

  Emp(empno,ename,job,mgr,hiredate,sal,comm,deptno,email)

  数据库会自动给逐渐empno和唯一键email、外键deptno建立索引，要经常给出现在where子句中或者order by子句中的列建立索引

  sal deptno ename

- 索引类型

  1.单列索引和多列索引	sal|sal hiredate

  2.唯一索引和非唯一索引	empno|sal deptno

  3.存储结构：B-Tree、R-Tree和Hash。其中B-Tree是最流行的存储结构，一般也是默认的存储结构。

- 示例：索引的使用

  - 查询所有数据（没有必要使用索引）

  select *  from emp

  - 查询指定编号的索引（使用了索引，自动的给主键创建索引）

  select * from emp where empno = 7839

  - 现在的数据库表有哪些索引

  show index from emp --自动的给主键、外键、唯一键创建索引

  - 查询指定名称的员工信息（逐个查询，效率低下）

  select * from emp where ename = 'SCOTT';

  - 给ename列创建索引

  create index index_emp_ename on emp(ename);

  - 查询指定名称的员工信息（自动使用索引，提高了查询速度）

  select * from emp where ename = 'SCOTT';

  - 删除索引

  drop index index_emp_ename on emp;

  - 创建索引：给ename列创建索引 降序排列

  alter table emp add index index_emp_ename  emp(ename desc);

  - 排序（没有使用索引，因为没有针对sal、hiredate建立索引）

  select * from emp order by sal desc,hiredate;

  - 创建索引

  create index index_emp_sal_hiredate_desc on emp(sal,hiredate desc);

  - 索引删除，先删除再新建

## 2.事务

事务是用来维护数据库完整性的，它能够保证一系列的MySQL操作要么全部执行，要么全不执行。举一个列子来进行说明，例如转账操作：A账户要转账给B账户，那么A账户上减少的钱数和B账户上增加的钱数必须一致，也就是说A账户的转出操作和B账户的转入操作，要么全部执行，要么全不执行；如果其中一个操作出现异常而没有执行的话，就会导致账户A和账户B的转入转出金额不一致的情况，为而事实上这种情况是不允许发生的，所以为了防止这种情况的发生，需要使用事务处理。



### 2.1事物的概念

事务（Transaction）指的是一个操作序列，该操作序列中的多个操作要么都做，要么都不做，是一个不可分割的工作单位，是数据库环境中的逻辑工作单位，有DBMS中的事务管理子系统负责事务的处理。

目前常用的存储引擎有InnoDB(MySQL5.5以后默认的存储引擎)和MyISAM(MySQL5.5之前默认的存储引擎)，其中InnoDB支持事务处理机制，而MyISAM不支持。



### 2.2事务的特性

ACID

四个特性：

原子性（Atomicity）、

一致性（Consistency）、

隔离性（Isolation）、

持久性（Durability）。



1、原子性

事务中的所有操作可以看作一个原子，事务是应用中不可再分的最小逻辑执行体。

使用事务对数据进行修改的操作序列，要么全部执行，要么全不执行。

2、一致性

一致性是指事务执行的结果必须使数据库从一个一致性的状态，变到另一个一致性状态。当数据库中只包含事务成功提交的结果时，数据库处于一致性状态。一致性使通过原子性来保证的。

3、隔离性

隔离性是指各个事务的执行互不干扰，任意一个事务的内部操作对其他并发的事务，都是隔离的。也就是说：并发执行的事务之间既不能看到对方的中间状态，也不能相互影响。

4、持久性

持久性指事务一旦提交，对数据所做的任何改变，都要记录到永久存储器中，通常是保存进物理数据库，即使数据库出现故障，提交的数据也应该能够恢复。



### 2.3使用事务代码

创建account账户表

```mysql
CREATE TABLE account(
	id int PRIMARY KEY auto_increment,
	username VARCHAR(30) NOT NULL,
	balance DOUBLE
);
```


#为account账户表同时插入两条数据
INSERT INTO account(username,balance)
VALUES('张三',2000),('李四',2000);
#查看account账户表中的数据
SELECT * FROM account;

#默认的每个DML语言一个单独的事务，事务会自动开启，成功自动提交commit，失败自动回滚roll

UPDATE account set balance = balance - 500 WHERE id=1;
UPDATE account set balance = balance1 + 500 WHERE id=2;

#事务不能自动的提交和回滚
START TRANSACTION; #不会自动提交和回滚
UPDATE account set balance = balance - 500 WHERE id=1;
UPDATE account set balance = balance + 500 WHERE id=2;



#手动的回滚
ROLLBACK;

#手动的提交
COMMIT;



### 2.4事务并发问题

#### 脏读（Dirty read）

当一个事务正在访问数据并且对数据进行了修改，而这种修改还没有提交到数据库中，这时另外一个事务也访问了这个数据，然后使用这个数据。因为这个数据是还没有提交的数据，另外一个事务读的这个数据是“脏数据”，依据“脏数据”所作的操作可能是不正确的。

| 时间点 | 事务A         | 事务B         |
| ------ | ------------- | ------------- |
| 1      | 开启事务A     |               |
| 2      |               | 开启事务B     |
| 3      | 查询余额为100 |               |
| 4      |               | 余额增加至150 |
| 5      | 查询余额为150 |               |
| 6      |               | 事务回滚      |

#### 不可重复读（Unrepeatableread）

指在一个事务内多次读同一数据，在这个事务还没有结束时，另一个事务也访问该数据。那么，在第一个事务中的两次读数据之间，由于第二个事务的修改导致第一个事务两次读取的数据可能不太一样。这就发生了在一个事务内两次读到的数据是不一样的情况，因此称为不可重复读。

| 时间点 | 事务A         | 事务B         |
| ------ | ------------- | ------------- |
| 1      | 开启事务A     |               |
| 2      |               | 开启事务B     |
| 3      | 查询余额为100 |               |
| 4      |               | 余额增加至150 |
| 5      | 查询余额为100 |               |
| 6      |               | 提交事务      |
| 7      | 查询余额为150 |               |

#### 幻读（Phantom read）

幻读与不可重复读类似。它发生在一个事务（T1）读取了几行数据，接着另一个事务（T2）插入了一些数据时。在随后的查询中，第一个事务（T1）就会发现多了一些原本不存在的记录，就好像发生了幻觉一样，所以称为幻读。

| 时间点 | 事务A                     | 事务B            |
| ------ | ------------------------- | ---------------- |
| 1      | 开启事务A                 |                  |
| 2      |                           | 开启事务B        |
| 3      | 查询id<3的所有记录，共3条 |                  |
| 4      |                           | 插入一条记录id=2 |
| 5      |                           | 提交事务         |
| 6      | 查询id<3的所有记录，共4条 |                  |

不可重复读和幻读区别：

不可重复读的重点是修改，幻读的重点在于新增或删除。

**解决不可重复读的问题只需锁住满足条件的行，解决幻读需要锁表**



### 2.5事务的隔离级别

事务的隔离级别用于决定如何控制并发用户读写数据的操作。数据库是允许多用户并发访问的，如果多个用户同时开启事务并对同一数据进行读写操作的话，有可能会出现脏读、不可重复读和幻读的问题，所以MySQL中提供了四种隔离级别来解决上述问题。

| 隔离级别         | 脏读 | 不可重复读 | 幻读 |
| ---------------- | ---- | ---------- | ---- |
| READ UNCOMMITTED | √    | √          | √    |
| READ COMMITTED   | ×    | √          | √    |
| REPEATABLE READ  | ×    | ×          | √    |
| SERIALIZABLE     | ×    | ×          | ×    |

事务的隔离级别从低到高依次为：READ UNCOMMITTED、READ COMMITTED、REPEATABLE READ、SERIALIZABLE，隔离级别越低，越能支持高并发的数据库操作。

备注：未提交的数据、提交的数据、可重复读的数据、序列化的数据。



默认隔离级别：REPEATABLE READ



查询当前隔离级别：select @@transaction_isolation;



设置隔离级别：

SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;
SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;



# 视图和存储过程

## 3.视图view

### 3.1视图的概念

视图是一个从单张或多张基础数据表或其他视图中构建出来的虚拟表。同基础表一样，视图中也包含了一系列带有名称的列和行数据，但是数据库中只是存放视图的定义，也就是动态检索数据的查询语句，而并不存放视图中的数据，这些数据依旧存放于构建试图的基础表中，只有当用户使用视图时才会去数据库请求相应的数据，即视图中的数据是在引用视图时动态生成的。因此视图中的数据依赖于构建视图的基础表，如果基本表中的数据发生了变化，视图中相应的数据也会跟着改变。



### 3.2视图的好处

