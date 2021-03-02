# guns开源二次开发

## guns分析



guns-vip

项目结构：

guns-base-support

- ​	guns-base:基础工具和依赖模块

- ​	guns-base-auth:鉴权模块

- ​	guns-dbctn:数据库模块

- ​	guns-sys:系统管理基础模块



guns-vip-main

​	cn.stylefeng.guns：

- config：spring和其他配置包
- core：通用封装核心包
- modular：业务包
- GunsApplication项目主启动类



pom.xml

```xml
<!--核心组件-->
<dependency>
    <groupId>cn.stylefeng.roses</groupId>
    <artifactId>kernel-core</artifactId>
    <version>${kernel.version}</version>
</dependency>
```

`kernel-core`模块为抽象出的核心（通用）模块，以供其他模块调用，此模块主要封装了一些通用的工具类，公共枚举，常量，配置等等，此模块的gitee地址是https://gitee.com/stylefeng-Roses/roses-kernel







**Guns开发三部曲 -> 1.建表 2.代码生成 3.添加菜单 4.适配业务代码**

开源版没有代码生成器





## 4.2分支源码分析

### 技术选型

springboot

mybatis-plus

shiro

beetl

ehcache

jwt



### 项目部署

云服务器百度：180.76.110.81:8080

mysql(MariaDB): 运行sql文件



在项目的 guns-parent 目录执行 clean package -Dmaven.test.skip=true ，即可打包。

运行：

java -jar guns-admin-1.0.0-SNAPSHOT.jar 



 iptables -I INPUT -p tcp --dport 8080 -j ACCEPT



firewall开启端口

root@instance-vlq0ju87:~# firewall-cmd --zone=public --add-port=8080/tcp --permanent
success
root@instance-vlq0ju87:~# firewall-cmd --reload
success
root@instance-vlq0ju87:~# firewall-cmd --zone=public --list-ports





### 模块分析

guns-admin 后台管理模块

guns-core 核心模块

guns-generator 代码生成器模块

guns-rest rest-api模块



map+warpper模式：

map+warpper方式即为把controller层的返回结果使用BeanKit工具类把原有bean转化为Map的形式(或者原有bean直接是map模式)

再用单独写的一个包装类再包装一次这个map，使里面的参数更加具体，更加有含义

关键类：

BaseControllerWarpper

UserWarpper



启动项目：localhost:8080

系统管理->用户管理

刷新

找到list 在浏览器开发者模式可以看到是/mgr/list

对应代码：

guns\guns-admin\src\main\java\com\stylefeng\guns\modular\system\controller\UserMgrController.java



```java
    /**
     * 查询管理员列表
     */
    @RequestMapping("/list")
    @Permission
    @ResponseBody
    public Object list(@RequestParam(required = false) String name, @RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime, @RequestParam(required = false) Integer deptid) {
        if (ShiroKit.isAdmin()) {
            List<Map<String, Object>> users = userService.selectUsers(null, name, beginTime, endTime, deptid);
            return new UserWarpper(users).warp();
        } else {
            DataScope dataScope = new DataScope(ShiroKit.getDeptDataScope());
            List<Map<String, Object>> users = userService.selectUsers(dataScope, name, beginTime, endTime, deptid);
            return new UserWarpper(users).warp();
        }
    }
```





前端系统管理子按钮对应的Controller





