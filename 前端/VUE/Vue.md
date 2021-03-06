# Vue.js

前言：

​	课程名字：2019年最全最新Vue、Vuejs教程，从入门到精通

​	课程地址：https://www.bilibili.com/video/BV15741177Eh

​	笔记作者：Ryanho97.github.io

​	笔记时间：2021/03/06



思维导图工具：xmind

Vuejs知识量化

1. 邂逅Vuejs
2. Vue基础语法
3. 组件化开发
4. Vue CLI详解
5. vue-router前端路由
6. Vuex详解
7. 网络封装-axios
8. 项目实战
9. 项目部署
10. vuejs原理相关





## 一、邂逅Vuejs

为什么学习Vuejs？

- 可能你的公司正要将原有的项目使用Vue进行重构
- 也可能是你的公司新项目决定使用Vue的技术栈
- 当然，如果你现在正在换工作，你会发现招聘前端的需求中，10个有8个都对Vue有或多或少的要求
- 当然，作为学习者我们知道Vuejs目前非常火，可以说是前端必备的一个技能



简单认识一下Vuejs

- Vue(读音/vju:/，类似于view)，不要读错

- Vue是一个渐进式的框架，什么是渐进式的呢？
  - 渐进式意味着你可以将Vue作为你应用中的一部分嵌入其中，带来更丰富的交互体验。
  - 或者如果你希望将更多的业务逻辑使用Vue实现，那么Vue的核心库以及其生态系统。
  - 比如Core+Vue-router+Vuex，也可以满足你各种各样的需求。
- Vue有很多特点和Web开发中常见的高级功能
  - 解耦视图和数据
  - 可复用的组件
  - 前端路由技术
  - 状态管理
  - 虚拟DOM
- 这些技术需要在学习和开发中慢慢体会。
- 学习Vuejs的前提
  - 从零学习Vue开发，并不需要你具备类似于Angular、React，甚至是jQuery的经验。
  - 但是你需要具备一定的HTML、CSS、JavaScript基础。



## 二、Vuejs安装方式

- 安装Vue的方式有很多：

- 方式一：直接CDN引入

  - 你可以选择引入开发环境版本还是生产环境版本

  ```xml
  <!-- 开发环境版本，包含了有帮助的命令行警告 -->
  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  ```

  或者：

  ```xml
  <!-- 生产环境版本，优化了尺寸和速度 -->
  <script src="https://cdn.jsdelivr.net/npm/vue"></script>
  ```

- 方式二：下载和引入

  开发环境 https://vuejs.org/js/vue.js

  生产环境 https://vuejs.org/js/vue.min.js

- 方式三：NPM安装

  - 后续通过webpack和CLI的使用，我们使用该方式。



先下载Vue.js

开发工具

- vscode->插件
- webstorm



## 三、Vue初体验

### Hello Vuejs

准备工作：

启动Webstorm，创建项目，创建js文件夹，把vue.js放进去。

> new Vue的时候出现了一些小插曲，入门踩坑：
>
> **unresolved type vue**
>
> 解决方式：https://blog.csdn.net/weixin_43872261/article/details/105411339
>
> 如果上述方式过期，请详见个人博客下：[RyanHo97](https://github.com/RyanHo97)/**blog**/[前端](https://github.com/RyanHo97/blog/tree/main/前端)/[VUE](https://github.com/RyanHo97/blog/tree/main/前端/VUE)/

示例01-HelloVuejs.html：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<div id="app">
        <h1>{{message}}</h1>
        <h2>{{name}}</h2>
</div>


<script src="../js/vue.js"></script>
<script>
    //let(变量)/const(常量)
    //编程范式：声明式编程
    const app = new Vue({
        el:'#app',//用于挂在要管理的元素
        data:{//定义数据
            message:'HelloWorld',
            name:'coderwhy'
        }
    })

    //元素js的做法(编程范式：命令式编程）
    //1.定义div元素，设置id属性

    //2.定义一个变量叫message

    //3.将message变量放在前面的div元素中显示

    //4.修改message的数据：今天天气不错！

    //5.将修改后的数据再次替换到div元素
</script>

</body>
</html>
```

启动浏览器开发者模式

在Console中输入app.message ='你好'

结果会变成：

```
"你好"
```

对应的massage在浏览器的显示也会变化成‘你好’



小结：

- 创建Vue对象的时候，传入了一些options:{}
  - {}中包含了el属性：该属性决定了这个Vue对象挂载到哪一个元素上，很明显，我们这里是挂载到了id为app的元素上
  - {}中包含了data属性：该属性中通常会存储一些数据
    - 这些数据可以是我们直接定义出来的，比如向上面这样。
    - 也可能是来自网络，从服务器加载的
- 浏览器执行代码的流程：
  - 执行到10~13行代码显示出对应的HTML
  - 执行第16行代码创建Vue实例，并且对原HTML进行解析和修改
- 并且，目前代码是可以做到响应式的。



### Vue列表的展示

示例代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>


<div id="app">
    <ui>
        <li v-for="item in movies">{{item}}</li>
    </ui>
</div>

<script src="../js/vue.js"></script>
<script>
    const app = new Vue({
        el:'#app',
        data:{
            message:'你好啊',
            movies:['星际穿越','大话西游','少年派','盗梦空间']
        }
    })
</script>

</body>
</html>
```

启动浏览器开发者模式

在Console中输入

app.movies.push('海王')

console返回：

```
5
```

网页中更新了：

星际穿越

大话西游

少年派

盗梦空间

海王



小结：

- 展示了更加复杂的数据：数据列表
  - 比如我们现在从服务器请求过来一个列表
  - 希望展示到HTML中。
- HTML代码中，使用v-for指令
- 不需要再JavaScript代码中完成DOM的拼接相关操作
- 响应式的





### 计数器

实现一个小的计数器

- 点击+计数器+1
- 点击-计数器-1

新指令和属性：

- 新的属性：methods，该属性用于在Vue对象中定义方法。
- 新的指令：@click，该指令用于监听某个元素的点击事件，并且需要指定当发生点击时，执行的方法(方法通常是methods中定义的方法)

示例代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<div id="app">
    <h2>当前计数：{{counter}}</h2>
    <!--
    <button v-on:click='counter++'>+</button>
    <button v-on:click='counter&#45;&#45;'>-</button>
    -->
    <button v-on:click="add">+</button>
    <button v-on:click="sub">-</button>
</div>

<script src="../js/vue.js"></script>
<script>
    const app=new Vue({
        el:'#app',
        data:{
            counter:0
        },
        methods:{
            add:function () {
                console.log("add被执行");
                this.counter++;
            },
            sub:function () {
                console.log("sub被执行")
                this.counter--;
            }
        }
    })

    //1.拿button元素

    //2.添加监听事件
</script>

</body>
</html>
```

小结：

