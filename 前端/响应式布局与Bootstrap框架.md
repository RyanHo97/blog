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

