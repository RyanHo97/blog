# Spring5

课程内容

1、Spring概念

2、IOC容器

3、Aop

4、JdbcTemplate

5、事务管理

6、Spring5新特性



## 1、Spring概念

spring框架概述

1、Spring是轻量级的开源的JavaEE框架

2、Spring可以解决企业应用开发的复杂性

3、Spring有两个核心部分：IOC和Aop

（1）IOC：控制反转，把创建对象过程交给Spring进行管理

（2）Aop：面向切面，不修改源代码进行功能增强

4、Spring特点

（1）方便解耦，简化开发

（2）Aop编程支持

（3）方便程序程序测试

（4）方便和其他框架进行整合

（5）方便进行事务操作

（6）降低API开发难度



## 2、入门案例

（1）下载Spring5

（2）在Github中下载GA稳定版本

repo.spring.io/release/org/springframework/spring/

（3）打开idea工具，创建普通Java工程

（4）导入4个基本包：

​		beans context core expression

 		还有一个日志包

​	     logging

​		下载地址：http://commons.apache.org/proper/commons-logging/download_logging.cgi

（5）创建包，创建普通类，在这个类创建普通方法

（6）创建Spring配置文件，在配置文件配置创建的对象

​		·使用xml：bean1.xml

​		 <bean id="user" class="com.ryanho.spring5.User"> 

</bean>

（7）进行测试代码编写

​		·创建测试类TestSpring5

​			@Test

​			public void testAdd(){

//1.加载Spring配置文件

​				ApplicationContext context = new ClassPathXmlApplicationContext(configLocation:"bean1.xml")

//2.获取配置创建的对象

​				User user = context.getBean(s:"user",User.class);



​				System.out.println(user);

​				user.add();

​			}

## 3、IOC底层原理

IOC（概念和原理）

1、什么是IOC

​	（1）控制反转，把对象创建和对象之间的调用过程，交给Spring进行管理。

​	（2）使用IOC目的：为了耦合度降低

​	（3）做入门案例就是IOC实现

2、IOC底层原理

​	（1）xml解析、工厂模式、反射

3、IOC过程

​			·第一步 xml配置文件，配置创建的对象

​			·第二步 有service类和dao类，创建工厂类

​				核心代码：

​						String classValue = class属性值; //1xml解析

​						Class clazz = Class.forName(classValue);//2通过反射创建对象

​						return (UserDao)clazz.newInstance();



4、IOC（接口）

​	（1）IOC思想基于IOC容器完成，IOC容器底层就是对象工厂

​	（2）Spring提供IOC容器实现两种方式：

​			·BeanFactory：IOC容器基本实现，是Spring内部使用的接口，不提供开发人员进行使用

​			*加载配置文件时候不会创建对象，在获取对象（使用）才去创建对象

​			·ApplicationContext：BeanFactory接口的子接口，提供更多强大的功能，一般由开发人员进行使用

​			*加载配置文件时候就会把在配置文件对象进行创建

​	（3）ApplicationContext接口有实现类

​			![jiekou](F:\BLOG\Spring5\jiekou.PNG)



## 4、IOC操作Bean管理

### 	1、什么是Bean管理

​		（0）Bean管理指的是两个操作

​		（1）Spring创建对象

​		（2）Spring注入属性

### 	2、Bean管理操作有两种方式

​		（1）基于xml配置文件方式实现

​		（2）基于注解方式实现

### 	3、IOC操作Bean管理（基于xml方法）

​		（1）基于xml方式创建对象

​				·1  在spring配置文件中，使用bean标签，标签里面添加对应属性，就可以实现对象创建。

​				·2 在bean标签里面有很多属性，介绍常用的属性：

​					*id属性：唯一标识

​					*class属性：类全路径（包类路径）

​				·3 创建对象时候，默认也是执行无参数构造方法完成对象创建。

​		（2）基于xml方式注入属性

​				·1 DI：依赖注入，就是注入属性

​					第一种注入方式：使用set方法进行注入

​					第二种注入方式：使用有参数的构造注入



set方法注入步骤：

​	准备工作：先创建对象

​	1.set方法注入属性

​	2.使用property完成属性注入



有参数构造进行注入步骤：

​	1.创建类，定义属性，创建属性对应有参数构造方法

​	2.在spring配置文件中进行配置



p名称空间注入（了解）

（1）使用p名称空间注入，可以简化基于xml配置方式

第一步 添加p名称空间在配置文件中

第二步 进行属性注入，在bean标签里面进行操作





​		（3）IOC操作Bean管理（xml注入其他类型属性）

​	1、字面量

​			·null值

​			<property name="address">

​			<null/>

​			</property>



​			·属性值包含特殊符号

​			1.把<>进行转义 &lt;,&gt;

​			2.把带特殊符号内容写道CDATA

​			<property name="address">

​				<value>

​					<![CDATA[<<南京>>]]>

​				</value>

​			</property>

​		

​	2、注入属性-外部bean

​		（1）创建两个类service类和dao类

​		（2）在service调用dao里面的方法

​		（3）在spring配置文件中进行配置





​	3、注入属性-内部bean和级联赋值

​		（1）一对多关系：部门和员工

​				一个部门有多个员工，一个员工属于一个部门

​				部门是一，员工是多

​		（2）在实体类之间表示一对多关系，员工表示所属部门，使用对象类型属性进行表示





​	4、注入属性-级联赋值





​		（4）IOC操作Bean管理（xml注入集合属性）



## 5、AOP

### 1、AOP基本概念

​	（1）面向切面编程（方面），利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高开发效率。

​	（2）通俗描述：不通过修改源代码方式，在主干功能里面添加新功能

​	（3）使用登录的例子作为说明。