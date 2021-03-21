# 前言

关于笔记：

​	课程名称：黑马2020最新 响应式布局 与 Bootstrap框架

​	课程地址：https://www.bilibili.com/video/BV1Nt4y1q7pn

​	笔记作者：Ryanho97

​	笔记时间：2021/03/15



目录：

- rem基础
- 媒体查询
- Less基础
- rem适配方案
- 苏宁首页案例制作



# 正文

## 1.rem适配布局

方案？

1.页面布局文字能否随着屏幕大小变化而变化？

2.流式布局和flex布局主要针对于宽度布局，那高度如何设置？

3.怎么样让屏幕发生变化的时候元素的高度和宽度等比例缩放？



### rem基础

#### rem单位

rem（root em）是一个相对单位，类似于em，em是父元素字体大小。

不同的是rem的基准是相对于html元素的字体大小。

比如，根元素（html）设置font-size=12px;非根元素设置width:2rem;则换成px表示就是24px。



示例demo代码：

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style>
			html{
				font-size: 12px;
			}
			
			div{
				font-size: 12px;
				width: 15rem;
				height: 15rem;
				background-color: purple;
			}
			
			p{
				/*1.em相对于父元素 的字体大小来说的*/
				/* width: 10em;
				height: 10em; */
				/*2.rem相对于html元素，字体大小来说的*/
				width: 10rem;
				height: 10rem;
				background-color: pink;
				/* 3.rem最大的优点就是可以通过修改html里面的文字大小来改变页面中元素的大小可以整体控制 */
				
			}
		</style>
	</head>
	
	<body>
		<div>
			<p></p>
		</div>
		
		
	</body>
</html>

```



## 2.媒体查询

### 什么是媒体查询

媒体查询（Media Query）是CSS3新语法。

- 使用@media查询，可以针对不同的媒体类型定义不同的样式。
- **@media可以针对不同的屏幕尺寸设置不同的样式**
- 当你重置浏览器大小的过程中，页面也会根据浏览器的高度和宽度重新渲染页面
- 目前针对很多苹果手机、Android手机，平板等设备都用得到多媒体查询



### 语法规范

```css
@media mediatype and|not|only (media feature){
    CSS-Code;
}
```

- 用@media开头 注意@符号
- mediatype媒体类型
- 关键字 and not only
- media feature媒体特性 必须有小括号包含



### 查询类型

| 值        | 解释说明                           |
| --------- | ---------------------------------- |
| all       | 用于所有设备                       |
| print     | 用于打印机和打印预览               |
| **scree** | 用于电脑屏幕，平板电脑，智能手机等 |



### 关键字

关键字将媒体类型或多个媒体特性连接到一起作为媒体查询的条件。



- and：可以将多个媒体特性连接到一起，相当于“且”的意思。
- not：排除某个媒体类型，相当于“非”的意思，可以省略
- only：指定某个特定的媒体类型，可以省略。



### 媒体特性

每种媒体类型都具体各自不同的特性，根据不同媒体类型的媒体特性设置不同的展示风格。我们暂且了解三个。注意他们要加小括号包含

| 值        | 解释说明                           |
| --------- | ---------------------------------- |
| width     | 定义输出设备中页面可见区域的宽度   |
| min-width | 定义输出设备中页面最小可见区域宽度 |
| max-width | 定义输出设备中页面最大可见区域宽度 |



示例代码

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style>
			/* 这句话的意思就是:在我们屏幕上 并且 最大的宽度是800像素 设置我们想要的样式 */
			/* max-width 小于等于800 pink
			   max-width 小于等于500 purple*/
			@media screen and (max-width:800px){
				body{
				background-color: pink;
				}
			}
			@media screen and (max-width:500px) {
				body{
					background-color: purple;
				}
			}
			
		</style>
	</head>
	
	<body>
	
	</body>
</html>

```



### 案例：根据页面宽度改变背景颜色

实现思路

1. 按照从大到小的或者从小到大的思路
2. 注意我们有最大值max-width和最小值min-width都是包含等于的
3. 当屏幕小于540像素，背景颜色变为蓝色（x<=539）
4. 当屏幕大于等于540像素并且小于等于969像素的时候背景颜色为绿色（540=<x<=969）
5. 当屏幕大于等于970像素的时候，背景颜色为红色（x>=970）

示例代码

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1.0" />
		<meta http-equiv="X-UA-Compatible" content="ie=edge"/>
		<title></title>
		<style>
			/* 
				1.媒体查询一般按照从大到小 或者 从小到大的顺序来
				2.小于540px 页面的背景颜色变为蓝色
			*/
		   
		   @media screen and (max-width:539px) {
				body{
					background-color: blue;
				}
		   }
		   /* 3.540~970 我们的页面颜色改为 绿色 */
		   /* @media screen and (min-width:540px) and (max-width:969px){ */
			/*   body{ */
			/* 	   background-color: green; */
			/*   } */
		   /* } */
		   
		   /* 注意：可以利用css层叠性使代码更加简洁 */
		   @media screen and (min-width:540px){
		   			   body{
		   				   background-color: green;
		   			   }
		   }
		   /* 4.大于等于970 我们页面的颜色改为 红色 */
		   @media screen and (min-width:970px) {
				body{
					background-color: red;
				}
		   }
		   /* 5.screen 还有 and 必须带上不能省略 */
		   /* 6.我们的数字后面必须跟单位 */
		   
		</style>
	</head>
	<body>
		
	</body>
</html>

```



### 媒体查询+rem实现元素动态变化

示例代码

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style type="text/css">
			*{
				margin: 0;
				padding: 0;
			}
			
			/* html{
				font-size: 100px;
			} */
			
			@media screen and (min-width:320px) {
				html{
					font-size:50px;
				}
			}
			
			@media screen and (min-width:640px) {
				html{
					font-size:100px;
				}
			}
			
			.top{
				height: 1rem;
				font-size: .5rem;
				text-align: center;
				background-color: green;
				color: #fff;
				line-height: 1rem;
			}
		</style>
	</head>
	<body>
		
		<div class="top">
			购物车
		</div>
		
	</body>
</html>
```



### 引入资源（理解）

当样式比较繁多的时候，我们可以针对不同的媒体使用不同stylesheets（样式表）。

原理，就是直接在link中判断设备的尺寸，然后引用不同的css文件。



示例代码

html

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style>
			/* 当我们屏幕大于等于 640px以上的，我们让div 一行显示2个 */
			/* 当我们屏幕小于640 我们让div一行显示一个 */
			/* 一个建议：我们媒体查询最好的方法是从小到大 */
			/* 引入资源就是 针对不同的屏幕尺寸 调用不同的css文件 */
		</style>
		<link rel="stylesheet" href="./style320.css" media="screen and (min-width:320px)"/>
		<link rel="stylesheet" href="./style640.css" media="screen and (min-width:640px)"/>
	</head>
	<body>
		<div>1</div>
		<div>2</div>
	</body>
</html>
```

style320.css

```css
div{
	width: 100%;
	height: 100%;
}

div:nth-child(1){
	background-color: pink;
}

div:nth-child(2){
	background-color: purple;
}
```

style640.css

```css
div{
	float: left;
	width: 50%;
	height: 100%;
}

div:nth-child(1){
	background-color: pink;
}

div:nth-child(2){
	background-color: purple;
}
```


## 3.Less

### 维护css的弊端

CSS是一门非程序式语言，没有变量、函数、SCOPE（作用域）等概念。

- CSS需要书写大量看似没有逻辑的代码，CSS冗余度是比较高的。
- 不方便维护及拓展，不利于复用。
- CSS没有很好的计算能力
- 非前端开发工程师来讲，往往会因为缺少CSS编写经验而很难写出组织良好且易于维护的CSS代码项目。



### Less介绍

Less（Leaner Style Sheets 的缩写）是一门CSS扩展语言，也称为CSS预处理器

作为CSS的一种形式的扩展，它并没有减少CSS的功能，而是在现有的CSS语法之上，为CSS加入程序式语言的特性

它在CSS的语法基础上，引入了变量，Mixin（混入），运算以及函数等功能，大大简化了CSS的编写，并且降低了CSS的维护成本，就像它的名称所说的那样，Less可以让我们用更少的代码做更多的事情

Less中文网址：http://lesscss.cn/

常见的CSS预处理器：Sass、Less、Stylus

**一句话：**Less是一门CSS预处理语言，它扩展了CSS的动态特性。



### Less安装

1. 安装nodejs，可选择版本(8.0)，网址：http://nodejs.cn/download/     注：这里自用版本（14.16.0）
2. 检查是否安装成功，使用cmd命令（win10是window+r打开 运行输入cmd）---输入 “ node -v “ 查看版本即可
3. 基于nodejs在线安装Less，使用cmd命令 ”npm install -g less“ 即可
4. 检查是否安装成功，使用cmd命令 ”lessc -v“ 查看版本即可



### Less使用

1. 新建my.less
   - Less变量
   - Less编译
   - Less嵌套
   - Less运算



my.less代码示例

```less
// 定义一个粉色的变量
@color:#00ffff;
// 错误的变量名 @1color @color~#
// 变量名区分大小写 @color 和 @Color 是两个不同的变量
@font14:14px;
body{
	background-color: @color;
}
div{
	color: @color;
	font-size: @font14;
}
a{
	font-size: @font14;
}
```



### Less变量

变量是指没有固定的值，可以改变的。因为我们CSS中的一些颜色和数值等经常使用。

```less
	@变量名:值;
```

#### 1.变量命名规范

- 必须有@为前缀
- 不能包含特殊字符
- 不能以数字开头
- 大小写敏感



### Less编译

本质上，Less包含一套自定义的语法及一个解析器，用户根据这些语法定义自己的样式规则，这些规则最终会通过解析器，编译生成对应CSS文件。

所以，我们需要把我们的less文件，编译生成为css文件，这样我们的html页面才能使用。



vscode Less插件：Easy LESS

HBuilderX Less插件：less编译(自动编译：package.json->"onDidSaveExecution": true)



### Less嵌套

我们经常用到选择器的嵌套

```css
#header .logo{
    width:300px;
}
```

Less嵌套写法

```less
#header{
    .logo{
        width:300px
    }
}
```



如果遇见（交集|伪类|伪元素选择器）

- 内层选择器的前面没有&符号，则它被解析为父选择器的后代；
- 如果有&符号，它就被解析为父元素自身或父元素的伪类。



代码示例

html部分

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style>
			/* .header{}
			.header a{} */
		</style>
		<link rel="stylesheet" type="text/css" href="nest.css"/>
	</head>
	<body>
		<div class="header">
			<a href="#">文字</a>
		</div>
		<div class="nav">
			<div class="logo">传智播客</div>
		</div>
	</body>
</html>
```

Less部分

```less
.header{
	width: 200px;
	height: 200px;
	background-color: pink;
	// 1.less嵌套 子元素的样式直接写到父元素里面就好了
	a {
		color: red;
		// 2.如果有伪类、交集选择器、伪元素选择器 在内层选择器的前面需要加&
		&:hover{
			color: blue;
		}
	}
}
.nav{
	.logo{
		color: green;
	}
	&::before{
		content: "";
	}
}
```



### Less运算⭐

任何数字、颜色或者变量都可以参与运算。就是Less提供了加（+）、减（-）、乘（*）、除（/）算术运算。

```less
/*Less 里面写*/
@width:10px + 5;
div{
    border:@width solid red;
}
/*生成的css*/
div{
    border:15px solid red;
}
/*Less 甚至还可以这样写*/
width:(@width + 5) * 2;
```

注意:

- 乘号（*）和除号（/）的写法
- **运算符中间左右有个空格隔开1px + 5**
- 对于两个不同的单位的值之间的运算，运算结果的值取第一个值的单位
- 如果两个值之间只有一个只有单位，则运算结果就取该单位



代码示例

html部分

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" href="count.css" />
	</head>
	<body>
		<div></div>
	</body>
</html>
```

Less部分

```less
@border:5px + 5;
div{
	width: 200px - 50;
	height: 200px * 2;
	border: @border solid red;
}
img{
	width: 82/50rem;
	height: 82/50rem;
}
```



## 4.rem适配方案

思考

1. 我们是配的目标是什么？
   - 让一些不能等比自适应的元素，达到当设备尺寸发生改变的时候，等比例适配当前设备。
   - 使用媒体查询根据不同设备按比例设置html的字体大小，然后页面元素使用rem做尺寸单位，当html字体大小变化元素尺寸也会发生变化，从而达到等比例缩放的适配。
2. 怎么去达到这个目标的？
3. 在实际的开发当中使用？



rem实际开发适配方案

1. 按照设计稿与设备宽度的比例，动态计算并设置html根标签的font-size大小；（媒体查询）
2. CSS中，设计稿元素的宽、高、相对位置等取值，按照同等比例换算为rem为单位的值；



技术方案1

- less
- 媒体查询
- rem



技术方案2

- flexible.js
- rem



总结：

1. 两种方案现在都存在。
2. 方案2更简单，现阶段大家无需了解里面的js代码。



### 案例1 rem+媒体查询+less技术

一、设计稿常见尺寸宽度

| 设备              | 常见宽度                                                     |
| ----------------- | ------------------------------------------------------------ |
| iphone 4、5       | 640px                                                        |
| **iphone6、7、8** | **750px**                                                    |
| Android           | 常见320px、360px、375px、384px、400px、414px、500px、720px<br />**大部分4.7~5寸的安卓设备为720px** |



