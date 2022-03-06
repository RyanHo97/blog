# elementUI学习笔记



日期：2022年3月6日

## 正文

### 一、入门和安装

1. ElementUI：一套为传统桌面准备的基于Vue.js的前端组件库；

2. 我们在学习它是基于Vue-cli脚手架下，所以需要一些基础，如下；

3. 学习完毕Vue.js（核心篇+工具篇）；

4. 如果学习过微实战篇更佳；

5. 安装环境，需要安装Node.js环境、Vue.js脚手架等工具即可；

6. 首先，安装Vue.js脚手架，命令如下：

   ```bash
   vue create cli
   ```

7. 切换到安装好的cli目录下，安装ElementUI，命令如下：

   ```bash
   npm i element-ui -S
   ```

8. 在脚手架main.js引入ElementUI，具体如下：

   ```javascript
   import ElementUI from 'element-ui'
   import 'element-ui/lib/theme-chalk/index.css'
   
   Vue.use(ElementUI)
   ```

9. 配置好UI之后，我们查看一下手册，找一个比较简单容易的UI测试一下；

   ```html
   <el-row>
         <el-button type="success">按钮</el-button>
   </el-row>
   ```

   