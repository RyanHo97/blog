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

mybatis-config.xml（仅为模板）

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



mybatis-config.xml有些变化：

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
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf8&amp;connectTimeout=1000&amp;ampsocketTimeout=3000&amp;autoReconnect=true&amp;serverTimezone=UTC"/>
                <property name="username" value="root"/>
                <property name="password" value="password"/>
            </dataSource>
        </environment>
    </environments>
    <!--  将我们写好的sql映射文件（EmployeeMapper.xml）一定要注册到全局配置文件中-->
    <mappers>
        <mapper resource="EmployeeMapper.xml"/>
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
            Employee employee = openSession.selectOne("com.atguigu.mybatis.EmployeeMapper.selectEmp", 1);
            System.out.println(employee);
        }finally {
            openSession.close();
        }
    }
}

```



EmployeeMapper.xml示例代码：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.atguigu.mybatis.EmployeeMapper">
    <!--
    namespace:名称空间
    id：唯一标识
    resultType：返回值类型
    #{id}:从传递过来的参数中取出id值
    -->
    <select id="selectEmp" resultType="com.atguigu.mybatis.bean.Employee">
        select id,last_name lastname,email,gender from tbl_employee where id = #{id}
    </select>
</mapper>
```





#### 5.接口式编程

接口可以与配置文件进行动态绑定

创建EmployeeMapper接口：

```java
package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);
}

```



在对应的mapper.xml中的namespace指定为接口的全类名

 

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.atguigu.mybatis.dao.EmployeeMapper">
    <!--
    namespace:名称空间；接口的全类名
    id：唯一标识
    resultType：返回值类型
    #{id}:从传递过来的参数中取出id值

    public Employee getEmpById(Integer id);
    -->
    <select id="getEmpById" resultType="com.atguigu.mybatis.bean.Employee">
        select id,last_name lastname,email,gender from tbl_employee where id = #{id}
    </select>
</mapper>
```



MybatisTest测试类的示例代码：

test01

```java
package com.atguigu.mybatis.test;


import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

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

    /*
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
            Employee employee = openSession.selectOne("com.atguigu.mybatis.EmployeeMapper.selectEmp", 1);
            System.out.println(employee);
        }finally {
            openSession.close();
        }
    }
    */

    @Test
    public void test01() throws IOException {
        //1.获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //2.获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            //3.获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查的方法
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

            Employee employee = mapper.getEmpById(1);

            System.out.println(mapper.getClass()); //代理对象$Proxy4
            System.out.println(employee);
        }finally {
            openSession.close();
        }
    }


}

```

接口定义好了，是不是还要再定义一个实现类呢？答案是否定的。Mybatis会使用动态代理机制来帮助我们完成额外的工作，我们需要做的就是把这个接口注册到Mybatis中。在Mybatis的总配置文件中，加入如下语句。



#### 6.小结

1、接口式编程

​	原生： Dao  ====>DaoImpl

​	mybatis: Mapper ====>xxMapper.xml

2、SqlSession代表和数据的一次会话；用完必须关闭

3、SqlSession和connection一样它都是非线程安全。每次使用都应该去获取新的对象。

​	private SqlSession sqlSession；//错误，有可能造成资源的竞争。

4、mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象。

​		(将接口和xml进行绑定)

​		EmployeeMapper emp Mapper = sqlSession.getMapper(EmployeeMapper.class);

5、两个重要的配置文件；

​		mybatis的全局配置文件：包含数据库连接池信息，事务管理器信息...系统运行环境信息

​		sql映射文件：保存了每一个sql语句的映射信息：

​								将sql抽取出来。

```xml
    <select id="getEmpById" resultType="com.atguigu.mybatis.bean.Employee">
        select id,last_name lastname,email,gender from tbl_employee where id = #{id}
    </select>
```





### 二、Mybatis-全局配置文件

#### 1.引入dtd约束

约束文件位置：

mybatis-3.4.1.jar -> org.apache.ibatis ->builder ->xml ->mybatis-3-config.dtd

mybatis-3.4.1.jar -> org.apache.ibatis ->builder ->xml ->mybatis-3-mapper.dtd



视频的环境为eclipse，在这块有细微区别，解决方法都会写，约定每次出现intellij idea即为解决方案

·Intellij idea

IDEA对于mybatis.xml文件没有自动提示功能

1.导入方式，file->setting 或者setting for new project

2.languages&frameworks->schemas and dtds

3.在右侧上面的窗口点击添加，如图，添加两个dtd文件，前面的内容是头文件的内容：

 http://mybatis.org/dtd/mybatis-3-config.dtd
 http://mybatis.org/dtd/mybatis-3-mapper.dtd

浏览器打开该链接可下载两个文件，也可通过视频中解压jar包方式，位置在上面

后面的内容是存放这两个文件的本地存储的地址

4.完成后输入<后按住alt+/就会有提示。



#### 2.引入外部配置文件

·intellij idea复制项目：

与eclipse不同，直接复制文件夹的方式会使复制导入失败。解决方案：

1、复制一个项目，并改名字

2、更改.iml文件名字，改成与项目名一致

3、将以下文件中的原有名字，替换成更改后的名字

.idea/modules.xml

.idea/workspace.xml

4、将out文件夹删除

5、然后用IDEA打开项目，打开File->project Structure，检查project名字和modules名字。



⭐引入外部配置文件

作用：可以把jdbc连接池的配置提取出来



dbconfig.properties：

注：因为使用的是MySQL8.0，所以在jdbc.url配置项后增加了时区配置，不然报错。

```file
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&serverTimezone=UTC
jdbc.username=root
jdbc.password=password
```



mybatis-config.xml：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!--
        1、mybatis可以使用properties来引入外部properties配置文件的内容
        resource:引入类路径下的资源
        url:引入网络路径或者磁盘路径下的资源

		这里使用的是类路径的方式
    -->
    <properties resource="dbconfig.properties"></properties>

    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <!--将value改成${}的配置方式-->
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
    </environments>
    
    <!--  将我们写好的sql映射文件（EmployeeMapper.xml）一定要注册到全局配置文件中-->
    <mappers>
        <mapper resource="EmployeeMapper.xml"/>
    </mappers>
</configuration>
```



运行MybatisTest.java测试成功：

class com.sun.proxy.$Proxy4
Employee{id=1, lastname='tom', email='tom@atguigu', gender='0'}



#### 3.运行时行为设置

##### settings标签

中文文档地址：https://mybatis.org/mybatis-3/zh/configuration.html

settings

| 设置名                   | 描述                                                         | 有效值        | 默认值 |
| :----------------------- | :----------------------------------------------------------- | :------------ | :----- |
| mapUnderscoreToCamelCase | 是否开启驼峰命名自动映射，即从经典数据库列名 A_COLUMN 映射到经典 Java 属性名 aColumn。 | true \| false | False  |



mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!--
        1、mybatis可以使用properties来引入外部properties配置文件的内容
        resource:引入类路径下的资源
        url:引入网络路径或者磁盘路径下的资源
    -->
    <properties resource="dbconfig.properties"></properties>


    <!--
        2、settings包含很多重要的设置项
        setting：用来设置每一个设置项
            name：设置项名
            value：设置项取值

    -->

    <settings>
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>


    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
    </environments>
    
    <!--  将我们写好的sql映射文件（EmployeeMapper.xml）一定要注册到全局配置文件中-->
    <mappers>
        <mapper resource="EmployeeMapper.xml"/>
    </mappers>
</configuration>
```



##### typeAliases标签

typeAliases别名处理器

查询结果的返回值每次都写全类名很麻烦

可以起别名



1.默认全类名是转换成小写的类名

mybatis-config.xml代码示例：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    
    <properties resource="dbconfig.properties"></properties>


    <settings>
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>

    <!-- 3、typeAliases:别名处理器：可以为我们的java类型起别名-->
    <typeAliases>
        <!-- typeAlias:为某个java类型起别名
                type：指定要起别名的类型全类名；默认别名就是类名小写；employee
                alias：指定新的别名
        -->
        <typeAlias type="com.atguigu.mybatis.bean.Employee" />
    </typeAliases>


    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
    </environments>
    
    <!--  将我们写好的sql映射文件（EmployeeMapper.xml）一定要注册到全局配置文件中-->
    <mappers>
        <mapper resource="EmployeeMapper.xml"/>
    </mappers>
</configuration>
```





对应mapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.atguigu.mybatis.dao.EmployeeMapper">
    
   <!--把返回值的全类名改成小写employee-->
    <select id="getEmpById" resultType="employee">
        select *
        from tbl_employee where id = #{id}
    </select>
</mapper>
```



2.可以增加alias=“”指定新的别名

mybatis-config.xml代码示例：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <properties resource="dbconfig.properties"></properties>

    <settings>
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>

    <!-- 3、typeAliases:别名处理器：可以为我们的java类型起别名-->
    <typeAliases>
        <!-- typeAlias:为某个java类型起别名
                type：指定要起别名的类型全类名；默认别名就是类名小写；employee
                alias：指定新的别名
        -->
        <typeAlias type="com.atguigu.mybatis.bean.Employee" alias="emp"/>
    </typeAliases>


    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
    </environments>
    
    <!--  将我们写好的sql映射文件（EmployeeMapper.xml）一定要注册到全局配置文件中-->
    <mappers>
        <mapper resource="EmployeeMapper.xml"/>
    </mappers>
</configuration>
```



对应mapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.atguigu.mybatis.dao.EmployeeMapper">
    <!--
		这里使用了新别名"emp".
    -->
    <select id="getEmpById" resultType="emp">
        select *
        from tbl_employee where id = #{id}
    </select>
</mapper>
```



3.也可以指定一个包名，MyBatis 会在包名下面搜索需要的 Java Bean，比如：

package:为某个包下的所有类批量起别名，缺点是如果子包下有同名类，则会把所有同名类都起相同别名          

​		name：指定包名（为当前包以及下面所有的后代包的每一个类都起一个默认别名（类名小写），）

```xml
<typeAliases>
  <package name="domain.blog"/>
</typeAliases>
```



mybatis-config.xml示例代码：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <properties resource="dbconfig.properties"></properties>
    <settings>
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>

    <!-- 3、typeAliases:别名处理器：可以为我们的java类型起别名
            别名不区分大小写
     -->
    <typeAliases>
        <!-- typeAlias:为某个java类型起别名
                type：指定要起别名的类型全类名；默认别名就是类名小写；employee
                alias：指定新的别名

        <typeAlias type="com.atguigu.mybatis.bean.Employee" alias="emp"/>
        -->

        <!-- package:为某个包下的所有类批量起别名
                name：指定包名（为当前包以及下面所有的后代包的每一个类都起一个默认别名（类名小写），）
        -->

        <package name="com.atguigu.mybatis.bean"></package>
    </typeAliases>


    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
    </environments>
    
    <!--  将我们写好的sql映射文件（EmployeeMapper.xml）一定要注册到全局配置文件中-->
    <mappers>
        <mapper resource="EmployeeMapper.xml"/>
    </mappers>
</configuration>
```



对应mapper.xml： 需要将返回值类型改回类名resultType="employee"



4.@Alias注解

批量起别名的情况下，使用@Alias注解为某个类型指定新的别名



bean.Employee

```java
package com.atguigu.mybatis.bean;

import org.apache.ibatis.type.Alias;

@Alias("emp")
public class Employee {

    private Integer id;
    private String lastname;
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

对应mapper.xml： 需要将返回值类型改回类名resultType="emp"


##### typeHandlers标签

类型处理器（typeHandlers）

MyBatis 在设置预处理语句（PreparedStatement）中的参数或从结果集中取出一个值时， 都会用类型处理器将获取到的值以合适的方式转换成 Java 类型。

作为一个java类型与JDBC类型的桥梁

**提示** 从 3.4.5 开始，MyBatis 默认支持 JSR-310（日期和时间 API） 。

一部分类型处理器：

| 类型处理器              | Java 类型                      | JDBC 类型                            |
| :---------------------- | :----------------------------- | :----------------------------------- |
| `BooleanTypeHandler`    | `java.lang.Boolean`, `boolean` | 数据库兼容的 `BOOLEAN`               |
| `ByteTypeHandler`       | `java.lang.Byte`, `byte`       | 数据库兼容的 `NUMERIC` 或 `BYTE`     |
| `ShortTypeHandler`      | `java.lang.Short`, `short`     | 数据库兼容的 `NUMERIC` 或 `SMALLINT` |
| `IntegerTypeHandler`    | `java.lang.Integer`, `int`     | 数据库兼容的 `NUMERIC` 或 `INTEGER`  |
| `LongTypeHandler`       | `java.lang.Long`, `long`       | 数据库兼容的 `NUMERIC` 或 `BIGINT`   |
| `FloatTypeHandler`      | `java.lang.Float`, `float`     | 数据库兼容的 `NUMERIC` 或 `FLOAT`    |
| `DoubleTypeHandler`     | `java.lang.Double`, `double`   | 数据库兼容的 `NUMERIC` 或 `DOUBLE`   |
| `BigDecimalTypeHandler` | `java.math.BigDecimal`         | 数据库兼容的 `NUMERIC` 或 `DECIMAL`  |
| `StringTypeHandler`     | `java.lang.String`             | `CHAR`, `VARCHAR`                    |





##### plugins标签

MyBatis 允许你在映射语句执行过程中的某一点进行拦截调用

默认情况下，MyBatis 允许使用插件来拦截的方法调用包括：

四大对象

- Executor：执行器 (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)
- ParameterHandler：参数处理器 (getParameterObject, setParameters)
- ResultSetHandler：结果集处理器(handleResultSets, handleOutputParameters)
- StatementHandler：执行语句处理器(prepare, parameterize, batch, update, query)





##### environments标签

环境配置

MyBatis 可以配置成适应多种环境，这种机制有助于将 SQL 映射应用于多种数据库之中， 现实情况下有多种理由需要这么做。例如，开发、测试和生产环境需要有不同的配置；或者想在具有相同 Schema 的多个生产数据库中使用相同的 SQL 映射。还有许多类似的使用场景。

代码示例：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <properties resource="dbconfig.properties"></properties>

    <settings>
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>

    <typeAliases>

        <package name="com.atguigu.mybatis.bean"></package>

    </typeAliases>


    <!--4、environments:环境们，mybatis可以配置多种环境，default指定使用某种环境。可以达到快速切换环境。
            environment：配置一个具体的环境信息；必须有两个标签；id代表当前环境的唯一标识
                transactionManager：事务管理器；
                       type:事务管理器的类型；JDBC(JdbcTransactionFactory)|MANAGED(ManagedTransactionFactory)
                            自定义事务管理器：实现TransactionFactory接口，type指定为全类名
                dataSource：数据源；
                       type：数据源类型；UNPOOLED|POOLED|JNDI
                             
                             自定义数据源：实现DataSourceFactory接口，type是全类名
    -->
    <environments default="development">
        <environment id="test">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
    </environments>
    
    <!--  将我们写好的sql映射文件（EmployeeMapper.xml）一定要注册到全局配置文件中-->
    <mappers>
        <mapper resource="EmployeeMapper.xml"/>
    </mappers>
</configuration>
```

##### databaseIdProvider标签

数据库厂商标识（databaseIdProvider）

MyBatis 可以根据不同的数据库厂商执行不同的语句，这种多厂商的支持是基于映射语句中的 `databaseId` 属性。 MyBatis 会加载带有匹配当前数据库 `databaseId` 属性和所有不带 `databaseId` 属性的语句。 如果同时找到带有 `databaseId` 和不带 `databaseId` 的相同语句，则后者会被舍弃。 为支持多厂商特性，只要像下面这样在 mybatis-config.xml 文件中加入 `databaseIdProvider` 即可：

```xml
<databaseIdProvider type="DB_VENDOR" />
```


Oracle数据库未安装，略过。

这里只展示mysql的部分示例：

mybatis-config.xml

```xml
    <!-- 5、databaseIdProvider：支持多数据库厂商的
         type="DB_VENDOR"：VendorDatabaseIdProvider
                作用就是得到数据库厂商的标识（驱动getDatabaseProductName()），mybatis就能根据数据库厂商标识来执行不同的sql
                MySQL、Oracle、SQL Server、xxxx
    -->

    <databaseIdProvider type="DB_VENDOR">
        <!-- 为不同的数据库厂商起别名-->
        <property name="MySQL" value="mysql"/>
        <property name="Oracle" value="oracle"/>
        <property name="SQL Server" value="sqlserver"/>
    </databaseIdProvider>
```

EmployeeMapper.xml

```xml
    <!-- databaseId指定不同厂商的数据库 -->
    <select id="getEmpById" resultType="emp" databaseId="mysql">
        select * from tbl_employee where id = #{id}
    </select>
```

##### mappers标签

既然 MyBatis 的行为已经由上述元素配置完了，我们现在就要来定义 SQL 映射语句了。 但首先，我们需要告诉 MyBatis 到哪里去找到这些语句。 在自动查找资源方面，Java 并没有提供一个很好的解决方案，所以最好的办法是直接告诉 MyBatis 到哪里去找映射文件。 你可以使用相对于类路径的资源引用，或完全限定资源定位符（包括 file:/// 形式的 URL），或类名和包名等。



代码示例：

```xml
    <!--  将我们写好的sql映射文件（EmployeeMapper.xml）一定要注册到全局配置文件中-->
    <!--  6、mappers：将sql映射注册到全局配置中  -->

    <mappers>
        <!--
            mapper：注册一个sql映射
                resource：引用类路径下的sql映射文件
                    mybatis/mapper/EmployeeMapper.xml
                url：引用网络路径或者磁盘路径下的sql映射文件
                    file：///var/mappers/EmployeeMapper.xml

                注册接口
                class:引用（注册）接口，
                    1、有sql映射文件，映射文件名必须和接口同名，并且放在与接口同一目录下；
                    2、没有sql映射文件，所有的sql都是利用注解写在接口上；
                    推荐：比较重要的Dao接口我们来写sql映射文件
                          不重要，简单的Dao接口为了开发快速可以使用注解；
        -->

        <!--<mapper resource="mybatis/mapper/EmployeeMapper.xml"/>-->
        <!--<mapper class="com.atguigu.mybatis.dao.EmployeeMapperAnnotation"/>-->

        <!--  批量注册：-->
        <!--  package
                    注意：同样和用注解一样，需要映射文件名必须和接口同名，并且放在与接口同一目录下，解决方法是在conf文件夹下
                          创建com.atguigu.mybatis.dao同名路径，最后在编译时类路径会合并一起。
        -->
        <package name="com.atguigu.mybatis.dao"/>

    </mappers>
```



EmployeeMapperAnnotation.java:

```java
package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapperAnnotation {
    @Select("select * from tbl_employee where id=#{id}")
    public Employee getEmpById(Integer id);
}

```



MybatisTest.java测试方法：

```java
    @Test
    public void test02() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {

                EmployeeMapperAnnotation mapper = openSession.getMapper(EmployeeMapperAnnotation.class);
                Employee empById = mapper.getEmpById(1);
                System.out.println(empById);
        }finally {
                openSession.close();
        }

    }
```

