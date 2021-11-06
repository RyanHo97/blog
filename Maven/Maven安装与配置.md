# Maven安装与配置

时间：2021年11月6日

作者：RyanHo97



## 一、安装Maven

1. [官网下载maven](https://maven.apache.org/download.cgi)

   windows版本：Binary zip archive [apache-maven-3.8.3-bin.zip](https://dlcdn.apache.org/maven/maven-3/3.8.3/binaries/apache-maven-3.8.3-bin.zip)

   Linux版本：Binary tar.gz archive [ apache-maven-3.8.3-bin.tar.gz](https://dlcdn.apache.org/maven/maven-3/3.8.3/binaries/apache-maven-3.8.3-bin.tar.gz)

2. 下载完成后解压到某个安装路径下面，记住这个路径，配置环境变量。



## 二、环境变量配置

1. 右键此电脑–>属性–>高级系统设置–>环境变量
2. 新建变量MAVEN_HOME = D:\Tools\Maven\apache-maven-3.5.4（**以个人的安装路径为准**）
3. 编辑变量Path，添加变量值%MAVEN_HOME%\bin
4. 打开win+R运行cmd，输入mvn -version，可以查看到当前的maven版本，说明配置成功。



## 三、配置本地仓库

1. 在D:\Tools\Maven\路径下面新建repository文件夹，用作maven的本地库。

2. 进入D:\Tools\Maven\apache-maven-3.5.4\conf下面找到settings.xml文件

3. 找到节点localRepository，在注释外添加

   ```xml
   <localRepository>D://Tools//Maven//respository</localRepository>
   ```

   > Maven 的本地仓库，在安装 Maven 后并不会创建，它是在第一次执行 maven 命令的时候才被创建。
   >
   > 运行 Maven 的时候，Maven 所需要的任何构件都是直接从本地仓库获取的。如果本地仓库没有，它会首先尝试从远程仓库下载构件至本地仓库，然后再使用本地仓库的构件。
   >
   > 默认情况下，不管Linux还是 Windows，每个用户在自己的用户目录下都有一个路径名为 .m2/repository/ 的仓库目录。
   >
   > Maven 本地仓库默认被创建在 %USER_HOME% 目录下。要修改默认位置，在 %M2_HOME%\conf 目录中的 Maven 的 settings.xml 文件中定义另一个路径。



## 四、配置镜像

1. 在settings.xml配置文件中找到mirrors节点

2. 添加如下配置（注意要添加在<mirrors>和</mirrors>两个标签之间，其它配置同理）

   ```xml
     <mirrors>
       <mirror>
         <id>alimaven</id>
         <mirrorOf>central</mirrorOf>
         <name>aliyun maven</name>
         <url>http://maven.aliyun.com/nexus/content/repositories/central/</url>
       </mirror>
     </mirrors>
   ```

   

## 五、配置完成

配置完成，win+R运行cmd，输入mvn help:system测试，配置成功则本地仓库中会出现一些文件。

