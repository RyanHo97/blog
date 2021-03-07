# JeecgBoot2.1版

前言

目前工作中需要研究这个开源项目，故找到一些资料，做些学习笔记供大家来学习。先是课程笔记，后面会有分析的结构图，部署实战过程。

B站课程：JeecgBoot2.1实战—快速入门教程

课程地址：https://www.bilibili.com/video/BV1Ut411N7yh

笔记作者：http://RyanHo97.github.io

## 课程笔记：

### P1-开发环境准备

项目是前后端分离设计

技术文档：http://jeecg-boot.mydoc.io/

大多数内容都能在文档找到，配置的重复部分这里就不再赘述，只说一下对比，还有实际步骤。

- 前端开发工具：web storm 个人环境：webstorm2019.1.3

- 后端开发工具：Eclipse 个人环境：IDEA2017.2.2

- Nodejs镜像：v10 以上 个人环境：v12.16.1

  npm：v6.13.4

#### 实际部署过程

前端

- WebStorm入门配置

  导入jeecg前端：ant-design-vue-jeecg

  配置Nodejs镜像

  ```cmd
  npm config set registry https://registry.npm.taobao.org --global
  npm config set disturl https://npm.taobao.org/dist --global
  
  yarn config set registry https://registry.npm.taobao.org --global
  yarn config set disturl https://npm.taobao.org/dist --global
  ```

  

  安装yarn：

  ```cmd
  npm i yarn -g
  ```

  这里是全局安装的方式

  前端开发工具webstorm在控制台使用yarn install



```
yarn run serve
```



> 问题：大概意思是node版本和包版本不匹配，需要更新，但是执行node rebuild node-sass后会报上面错误，这个时候执行：

```
npm rebuild node-sass
```



前端启动成功



后端

IDEA导入项目jeecg-boot

创建DB:jeecg-boot，导入jeecg-boot-mysql5.7-20191018.sql

启动Redis的服务器

设置application.yml

启动JeecgApplication



后端启动成功

