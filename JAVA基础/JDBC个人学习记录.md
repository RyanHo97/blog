# JDBC个人学习记录

感谢尚硅谷的宋老师的课程：

https://www.bilibili.com/video/BV1eJ411c7rf



获取数据库连接三要素

- Driver接口实现类
- URL
- 用户名和密码



JDBC连接方式

方式1：

```java
package jdbctest;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {

    //方式1：
    @Test
    public void testConnection1() throws SQLException{
        //要素1：Driver接口实现类
        Driver driver = new com.mysql.cj.jdbc.Driver();
        //URL
        //jdbc:mysql:协议
        //localhost:ip地址
        //:3306默认mysql的端口号
        //test:test数据库
        String url = "jdbc:mysql://localhost:3306/test";
        //将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","password");

        Connection conn = driver.connect(url, info);

        System.out.println(conn);


    }

}
```

成功连接控制台的输出：

```bash
com.mysql.cj.jdbc.ConnectionImpl@f8c1ddd

Process finished with exit code 0
```



方式2：

```java
    //方式2：对方式1的迭代(优点：在如下的程序中不出现第三方的api，使得程序具有更好的可移植性)
    @Test
    public void testConnection2() throws Exception {
        //1.获取Driver实现类对象：使用反射
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        //2.提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test";

        //3.提供连接需要的用户名和密码
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","password");

        //4.获取连接
        Connection conn = driver.connect(url,info);
        System.out.println(conn);

    }
```



方式3：

```java
    //方式3：使用DriverManager替换Driver
    @Test
    public void testConnection3() throws Exception{
        //1.获取Driver实现类对象：使用反射
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        //2.提供另外三个连接的基本信息：
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "password";

        //注册驱动
        DriverManager.registerDriver(driver);

        //获取连接
        Connection conn = DriverManager.getConnection(url,user,password);
        System.out.println(conn);

    }
```



方式4：

```java
    //方式4：可以只是加载驱动，不用显示的驱动注册了
    @Test
    public void testConnection4() throws Exception{
        //1.提供另外三个连接的基本信息：
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "password";

        //2.加载Driver
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        //相较于方式3可以省略如下的操作：
//        Driver driver = (Driver) clazz.newInstance();
//        //注册驱动
//        DriverManager.registerDriver(driver);

        //3.获取连接
        Connection conn = DriverManager.getConnection(url,user,password);
        System.out.println(conn);

    }
```



