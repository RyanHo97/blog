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

##### v-text

设置标签的文本值(textContent)

```html
<div id="app">
    <h2 v-text="message"></h2>
</div>
```

```html
<script>
    var app = new new Vue({
        el:"#app",
        data:{
            message:"黑马程序员"
        }
    })
</script>
```

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
        <h2 v-text="message+'!'">深圳</h2>
        <h2 v-text="info+'!'">深圳</h2>
        <h2>{{message+"!"}}深圳</h2>
    </div>
    <script>
        var app = new new Vue({
            el:"#app",
            data:{
                message:"黑马程序员！！！",
                info:"前端与移动教研部"
            }
        })
    </script>
</body>
</html>
```

- v-text指令的作用是：设置标签的内容(textContent)
- 默认写法会替换全部内容，使用差值表达式{{}}可以替换指定内容
- 内部支持写表达式

##### v-html

设置标签的innerHTML

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
        <p v-html="content"></p>
        <p v-text="content"></p>
    </div>

    <script>
        // 创建Vue实例
        var app = new Vue({
            el:"#app",
            data:{
                // content:"黑马程序员"
                content:"<a href='http://www.itheima.com'>黑马程序员</a>" 
            }
        })
    </script>
</body>
</html>
```

- v-html指令作用是：设置元素的innerHTML
- 内容中有html结构会被解析为标签
- v-text指令无论什么内容是什么，只会解析为文本
- 解析文本使用v-text，需要解析html结构使用v-html

##### v-on

为元素绑定事件

```html
<div id="app">
    <input type="button" value="事件绑定" v-on:click="doIt">
    <input type="button" value="事件绑定" v-on:monseenter="doIt">
    <input type="button" value="事件绑定" @dblclick="doIt">
</div>
```

```javascript
var app = new Vue({
            el:"#app",
            methods: {
                doIt:function(){
                    //逻辑
                }
            }
})
```

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
        <input type="button" value="v-on指令" v-on:click="doIt">
        <input type="button" value="v-on简写" @click="doIt">
        <input type="button" value="v-on指令" @dblclick="doIt">
        <h2 @click="changeFood">{{food}}</h2>
    </div>

    <script>
        // 创建Vue实例
        var app = new Vue({
            el:"#app",
            data:{
                food:"西兰花炒蛋"
            },
            methods: {
                doIt:function(){
                    alert("做It");
                },
                changeFood:function(){
                    // console.log(this.food);
                    this.food+="好好吃！"
                }
            },
        })
    </script>
</body>
</html>
```

- v-on指令的作用是：为元素绑定事件
- 时间名不需要写on
- 指令可以简写为@
- 绑定的方法定义在methods属性中

##### 案例：计数器

1.data中定义数据：比如：num

2.methods中添加两个方法：比如add(递增)，sub(递减)

3.使用v-text将num设置给span标签

4.使用v-on将add，sub分别绑定+,-按钮

5.累加的逻辑：小于10累加，否则提示

6.递减的逻辑：大于0递减，否则提示



代码示例：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>计数器</title>
    <!-- 开发环境版本，包含了有帮助的命令行警告 -->
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
    <div id="app">
        <!-- 计数器功能区域 -->
        <div class="input-num">
            <button @click="add">
                +
            </button>
            <span>{{num}}</span>
            <button @click="sub">
                -
            </button>
        </div>
        <img src="http://www.itheima.com/images/logo.png" alt="">
    </div>

    <script>
        // 创建Vue实例
        var app = new Vue({
            el:"#app",
            data: {
                num:1
            },
            methods: {
                add:function(){
                    console.log('add');
                    if(this.num<10){
                        this.num++;
                    }else{
                        alert('别点了，最大啦！');
                    }
                },
                sub:function(){
                    console.log('sub');
                    if(this.num>0){
                        this.num--;
                    }else{
                        alert('别点了，最小啦！');
                    }
                },
            },
        })
    </script>
</body>
</html>
```

- 创建Vue示例时：el(挂载点)，data(数据),methods(方法)
- v-on指令的作用是绑定事件，简写为@
- 方法中通过this，关键字获取data中的数据
- v-text指令的作用是：设置元素的文本值，简写为{{}}
- v-html指令的作用是：设置元素的innerHTML


#### 2.显示切换，属性绑定

##### v-show

根据表达值的真假，切换元素的显示和隐藏

```html
<div id="app">
    <img src="地址" v-show="true">
    <img src="地址" v-show="isShow">
    <img src="地址" v-show="age>=18">
</div>
```

```javascript
var app = new Vue({
    el:"#app",
    data:{
        isShow:false,
        age:16
    }
})
```

代码示例：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>v-show指令</title>
    <!-- 开发环境版本，包含了有帮助的命令行警告 -->
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
    <div id="app">
        <input type="button" value="切换显示状态" @click="changeIsShow">
        <input type="button" value="累加年龄" @click="addAge">
        <img v-show="isShow" src="./img/logodao.jpg" alt="">
        <img v-show="age>=18" src="./img/logodao.jpg" alt="">
    </div>

    <script>
        // 创建Vue实例
        var app = new Vue({
            el:"#app",
            data:{
                isShow:false,
                age:17
            },
            methods: {
                changeIsShow:function(){
                    this.isShow = !this.isShow;
                },
                addAge:function(){
                    this.age++;
                }
            },
        })
    </script>
</body>
</html>
```

- v-show指令的作用是：根据真假切换元素的显示状态
- 原理是修改元素的display，实现显示隐藏
- 指令后面的内容，最终都会解析为布尔值
- 值为true元素显示，值为false元素隐藏
- 数据改变之后，对应元素的显示状态会同步更新

##### v-if

根据表达值的真假，切换元素的显示和隐藏（操纵dom元素）

```html
<div id="app">
    <p v-if="true">我是一个p标签</p>
    <p v-if="isShow">我是一个p标签</p>
    <p v-if="表达式">我是一个p标签</p>
</div>
```

```javascript
var app = new Vue({
    el:"#app",
    data:{
        isShow:false
    }
})
```

代码示例

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>v-if指令</title>
    <!-- 开发环境版本，包含了有帮助的命令行警告 -->
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
    <div id="app">
        <input type="button" value="切换显示" @click="toggleIsShow">
        <p v-if="isShow">黑马程序员</p>
        <p v-show="isShow">黑马程序员</p>
        <p v-if="temperature>=35">很热</p>
    </div>

    <script>
        // 创建Vue实例
        var app = new Vue({
            el:"#app",
            data:{
                isShow:false,
                temperature:40
            },
            methods: {
                toggleIsShow:function(){
                    this.isShow = !this.isShow;
                }
            },
        })
    </script>
</body>
</html>
```

- v-if指令的作用是：根据表达式的真假切换元素的显示状态
- 本质是通过操纵dom元素来切换显示状态
- 表达式的值为true，元素存在于dom树中，为false，从dom树中移除
- 频繁的切换v-show，反之使用v-if，前者的切换消耗小

##### v-bind

设置元素的属性（比如：src，title，class）

语法：v-bind：属性名=表达式

```html
<div>
    <img :src="imgSrc">
    <img :title="imgTitle+'!!!!'">
    <img :src="isActive?'active':">
    <img :src="{active:isActive}">
</div>
```

```javascript
var app = new Vue({
    el:"#app",
    data:{
        imgSrc:"图片地址"，
        imgTitle:"黑马程序员",
        isActive:false
    }
})
```

代码示例：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>v-bind指令</title>
    <!-- 开发环境版本，包含了有帮助的命令行警告 -->
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <style>
        .active{
            border: 1px solid red;
        }
    </style>
</head>
<body>
    <div id="app">
        <img v-bind:src="imgSrc" alt="">
        <br>
        <img :src="imgSrc" alt="" :title="imgTitle+'!!!!'"
        :class="isActive?'active':''" @click="toggleActive">
        <br>
        <img :src="imgSrc" alt="" :title="imgTitle+'!!!!'"
        :class="{active:isActive}" @click="toggleActive">
    </div>

    <script>
        // 创建Vue实例
        var app = new Vue({
            el:"#app",
            data:{
                imgSrc:"./img/logodao.jpg",
                imgTitle:"黑马程序员",
                isActive:false
            },
            methods: {
                toggleActive:function(){
                    this.isActive = !this.isActive;
                }
            },
        })
    </script>
</body>
</html>
```

- v-bind指令的作用是：为元素绑定属性
- 完整写法是v-bind:属性名
- 简写的话可以直接忽略v-bind，只保留:属性名
- 需要动态的增删class建议使用对象的方式

##### 案例：图片的切换

```html
<div id="#app">
    <img src="地址">
    <a href="#">上一张</a>
    <a href="#">下一张</a>
</div>
```

这里v-show性能更好

```javascript
var app = new Vue({
    el:"#app",
    data:{
        imgArr:[],
        index:0
    },
    methods:{
        prev:function(){},
        next:function(){}
    }
})
```
代码示例：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>图片切换</title>
    <!-- 开发环境版本，包含了有帮助的命令行警告 -->
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
    <div id="mask">
        <div class="center">
            
            <h2 class="title">
                <img src="./img/logodao.jpg" alt="">
                孙悟空七龙珠
            </h2>

            <!-- 图片 -->
            <img :src="imgArr[index]" alt="">
            
            <!-- 左箭头 -->
            <a href="javascript:void(0)" v-show="index!=0" @click="prev" class="left">
                <img src="./img/arrow-left-bold.png" alt="">
            </a>
            <!-- 右箭头-->
            <a href="javascript:void(0)" v-show="index<imgArr.length-1" @click="next" class="right">
                <img src="./img/arrow-right-bold.png" alt="">
            </a>
        </div>
    </div>

    
    <script>
        var app = new new Vue({
            el:"#mask",
            data:{
                imgArr:[
                    "./img/logodao.jpg",
                    "./img/logodao.jpg",
                    "./img/logodao.jpg",
                    "./img/logodao.jpg",
                    "./img/logodao.jpg",
                    "./img/logodao.jpg",
                    "./img/logodao.jpg",
                    "./img/logodao.jpg",
                    "./img/logodao.jpg",
                    "./img/logodao.jpg",
                ],
                index:0
            },
            methods:{
                prev:function(){
                    this.index--;
                },
                next:function(){
                    this.index++;
                }
            }
        })
    </script>
</body>
</html>
```

- 列表数据使用**数组**保存
- **v-bind**指令可以设置元素属性，**比如src**
- **v-show**和**v-if**都可以切换元素的显示状态，频繁切换用**v-show**



#### 3.列表循环，表单元素绑定

##### v-for



##### v-on



##### v-mode
