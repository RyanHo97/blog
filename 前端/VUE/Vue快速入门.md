# Vue快速入门

前言

视频名称：黑马程序员前端基础教程-4个小时带你快速入门vue

视频地址：https://www.bilibili.com/video/BV12J411m7MG

笔记作者：Ryanho97

笔记时间：2021年5月10日

## 正文

### 一、课程介绍

- 掌握HTML、CSS、Javascript、AJAX基础知识
- 选用VSCode作为开发工具
- 安排：基础-本地应用-网络应用-综合应用

### 二、Vue基础

#### Vue简介

1.JavaScript框架

2.简化Dom操作

3.响应式数据驱动

#### 第一个Vue程序

作者：尤雨溪

文档地址：https://cn.vuejs.org

尝试 Vue.js 最简单的方法是使用 [Hello World 例子](https://codesandbox.io/s/github/vuejs/vuejs.org/tree/master/src/v2/examples/vue-20-hello-world)。你可以在浏览器新标签页中打开它，跟着例子学习一些基础用法。或者你也可以[创建一个 `.html` 文件](https://github.com/vuejs/vuejs.org/blob/master/src/v2/examples/vue-20-hello-world/index.html)，然后通过如下方式引入 Vue：

```html
<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
```

或者：

```html
<!-- 生产环境版本，优化了尺寸和速度 -->
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
```


简单示例：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VUE基础</title>
    <!-- 开发环境版本，包含了有帮助的命令行警告 -->
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
    <div id="app">
        {{ message }}
    </div>
    <script>
        var app = new new Vue({
            el:"#app",
            data:{
                message:"Hello Vue！"
            }
        })
    </script>
</body>
</html>
```

步骤：

- 导入**开发版本**的Vue.js
- 创建Vue实例对象，设置**el**属性和**data**属性
- 使用简洁的**模板语法**把数据渲染到页面上



#### el:挂载点

```html
<div id="app">
    {{ message }}
</div>
```

```javascript
var app = new new Vue({
    el:"#app",
    data:{
        message:"你好 小黑！"
    }
})
```

##### Vue实例的作用范围是什么呢？

Vue会管理el选项**命中的元素**及其内部的**后代元素**

##### 是否可以使用其他的选择器？

可以使用其他的选择器，但是建议使用**ID选择器**

##### 是否可以设置其他的dom元素呢？

可以使用其他的双标签，不能使用**HTML**和**BODY**

代码示例：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>el挂载点</title>
    <!-- 开发环境版本，包含了有帮助的命令行警告 -->
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
    {{message}}
    <div id="app" class="app">
        {{ message }}
        <span>
            {{message}}
        </span>
    </div>
    <script>
        var app = new new Vue({
            el:"#app",    //id方式，推荐
            // el:".app",   class方式
            // el:"div",    div标签方式
            data:{
                message:"黑马程序员"
            }
        })
    </script>
</body>
</html>
```



#### data:数据对象

- Vue中用到的数据定义在data中
- data中可以写**复杂类型**的数据
- 渲染复杂类型数据时，遵守js的**语法**即可

代码示例：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VUE基础</title>
    <!-- 开发环境版本，包含了有帮助的命令行警告 -->
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
    <div id="app">
        {{message}}
        <h2>{{school.name}} {{school.mobile}}</h2>
        <ul>
            <li>{{campus[0]}}</li>
            <li>{{campus[3]}}</li>
        </ul>
    </div>

    <script>
        var app = new Vue({
            el:"#app",
            data:{
                message:"你好 小黑！",
                school:{
                    name:"黑马程序员",
                    mobile:"400-618-9090"
                },
                campus:["北京","上海","广州","深圳"]
            }
        })
    </script>
</body>
</html>
```



### 三、本地应用

#### 1.内容绑定，事件绑定

#### 2.显示切换，属性绑定

#### 3.列表循环，表单元素绑定




el:挂载点

data:数据对象
