# Mybatis

## 笔记相关

课程：尚硅谷MyBatis实战教程全套完整版

地址：https://www.bilibili.com/video/BV1mW411M737

笔记作者：Ryanho97

笔记时间：2021/2/6



## 正文

### 一、入门

#### 0.基础入门知识

JDBC->Dbutils(QueryRunner)->JDBCTemplate：工具

框架：整体解决方案



正常操作数据库的步骤

1.编写sql

2.预编译

3.设置参数

4.执行sql

5.封装结果



Mybatis出现原因：

JDBC：功能简单，SQL语句编写在Java代码里面，硬编码高耦合的方式。



Hibernate：全自动ORM(Object Relation Mapping)框架，皆在消除sql。HQL可以定制操作，但Hibernate与数据库交互黑箱操作。



Mybatis：希望SQL语句交给我们开发人员编写，SQL不失去灵活性。



#### 1.Mybatis简介

Mybatis是Apache的一个Java开源项目，是一个支持动态Sql语句的持久层框架。Mybatis可以将Sql语句配置在XML文件中，避免将Sql语句硬编码在Java类中。与JDBC相比：

1. Mybatis通过参数映射方式，可以将参数灵活的配置在SQL语句中的配置文件中，避免在Java类中配置参数（JDBC）
2. Mybatis通过输出映射机制，将结果集的检索自动映射成相应的Java对象，避免对结果集手工检索（JDBC）
3. Mybatis可以通过Xml配置文件对数据库连接进行管理。



面试中小知识：Mybatis=ibatis



#### 2.Mybatis和hibernate的优缺点比较

**Hibernate** ：Hibernate 是当前最流行的ORM框架，对数据库结构提供了较为完整的封装。

**Mybatis**：Mybatis同样也是非常流行的ORM框架，主要着力点在于POJO 与SQL之间的映射关系。

**mybatis：**

\1. 入门简单，即学即用，提供了数据库查询的自动对象绑定功能，而且延续了很好的SQL使用经验，对于没有那么高的对象模型要求的项目来说，相当完美。

\2. 可以进行更为细致的SQL优化，可以减少查询字段。

\3. 缺点就是框架还是比较简陋，功能尚有缺失，虽然简化了数据绑定代码，但是整个底层数据库查询实际还是要自己写的，工作量也比较大，而且不太容易适应快速数据库修改。

\4. 二级缓存机制不佳。

**hibernate：**

\1. 功能强大，数据库无关性好，O/R映射能力强，如果你对Hibernate相当精通，而且对Hibernate进行了适当的封装，那么你的项目整个持久层代码会相当简单，需要写的代码很少，开发速度很快，非常爽。

\2. 有更好的二级缓存机制，可以使用第三方缓存。

\3. 缺点就是学习门槛不低，要精通门槛更高，而且怎么设计O/R映射，在性能和对象模型之间如何权衡取得平衡，以及怎样用好Hibernate方面需要你的经验和能力都很强才行。



#### 3.Mybatis下载

·https://github.com/mybatis/mybatis-3/

releases下找到发行版

downloads分为

mybatis-3.4.1.zip （jar包、文档压缩包）

Source code(zip)（源码包）



学习建议两个都下



#### 4.HelloWorld

·1.在DB创建测试表（我提前创建好了，所以用navicat导出）

```sql
/*
Navicat MySQL Data Transfer

Source Server         : mysql80
Source Server Version : 80021
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 80021
File Encoding         : 65001

Date: 2021-02-06 22:45:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_employee`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_employee`;
CREATE TABLE `tbl_employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gender` char(1) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of tbl_employee
-- ----------------------------
INSERT INTO `tbl_employee` VALUES ('1', 'tom', '0', 'tom@atguigu');

```







·2.创建项目



创建：Employee.java

```java
package com.atguigu.mybatis.bean;

public class Employee {

    private Integer id;
    private String lastname;//这里最后在对应mapper中使用别名
    private String email;
    private String gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

```



导入jar包到lib

build path

IntelliJ IDEA如何build path？

File -> Project Structure -> Modules -> 选中要添加build path的项目 -> Dependencies -> 点击右边的小加号  -> 选择JARs or directories ->选择要添加的外部jar包。





创建xml文件

mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="${driver}"/>
        <property name="url" value="${url}"/>
        <property name="username" value="${username}"/>
        <property name="password" value="${password}"/>
      </dataSource>
    </environment>
  </environments>
  <mappers>
    <mapper resource="org/mybatis/example/BlogMapper.xml"/>
  </mappers>
</configuration>
```



注意：

intellij idea与eclipse的区别

需要将xml配置文件的文件夹设置为resource

右键文件夹-->Mark Directory-->Test Resources Root





MybatisTest示例代码：

```java
package com.atguigu.mybatis.test;


import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    /*
        1.根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象
            有数据源一些运行环境信息
        2.sql映射文件；配置了每一个sql，以及sql的封装规则等；
        3.将sql映射文件注册在全局配置文件中
        4.写代码：
            1）、根据全局配置文件得到SqlSessionFactory；
            2）、使用SqlSession工厂，获取到sqlSession对象使用他来执行增删改查
                 一个SqlSession就是代表和数据库的一次会话，用完关闭
            3）、使用sql的唯一标识来告诉Mybatis执行哪个sql。sql都是保存在sql映射文件中的。

     */

    @Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取sqlSession实例，能直接执行已经映射的sql语句
        //sql的唯一标识：
        //执行sql要用的参数：
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            Employee employee = openSession.selectOne("org.mybatis.example.BlogMapper.selectEmp", 1);
            System.out.println(employee);
        }finally {
            openSession.close();
        }
    }
}

```



#### 5.接口式编程

创建EmployeeMapper接口：

```java
package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);
}

```



在对应的mapper.xml中的namespace指定为接口的全类名

