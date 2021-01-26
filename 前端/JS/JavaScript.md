# JavaScript

## 1.初识

一个完整的JavaScript实现应该由以下三个部分构成：

ECMAScript、DOM、BOM



镶嵌html

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<!--JS代码编写需要到script标签中-->
		<script>
			/*
			alert("这是我的第一行JS代码");

```html
		document.write()像body输出内容
		
		document.write("看我出不出来~~~");
		*/
	   
	   console.log("1");
		
	</script>
</head>
<body>
</body>
</html>
```


外部引用：

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<script type="text/javascript" src="JavaScript/script.js">
		</script>
		<script>
			alert("内部js");
		</script>
	</head>
	<body>
		<p>外部引用代码</p>
	</body>
</html>

按照从上到下顺序加载。

注意：一旦外部引用JS文件，那script标签的内部写的代码失效。

​			如果想用可以再写一个<script>标签



## 2.基本语法

/*

​	多行注释

*/



//单行注释



**1.JS中严格区分大小写**

**2.JS中每一条语句以分号（；）结尾**

如果不写分号，浏览器会自动添加，但是也会消耗一些资源，而且有些时候，浏览器会加错

**3.JS会忽略多个换行和空格**



## 3.字面量和变量

字面量，都是一些不可改变的值

比如：1 2 3 4 5

字面量都是可以直接使用，但是我们一般都不会直接使用字面量。

变量，变量可以用来保存字面量，而且变量的值可以任意改变的

比如：x=1



声明变量JS

var a;

console.log(a);





## 4.标识符

在JS中所有的可以由我们自主命名的都可以称为是标识符

例如：变量名、函数名、属性名都属于标识符

规则：

1.可以含有字母、数字、_、$

2.不能以数字开头

3.不能是ES中的关键字或保留字

4.一般采用驼峰命名法

首字母小写，每个单词的开头字母大写，其余字母小写。

JS底层保存时实际采用的Unicode编码

UTF-8实际上也可以用，但是千万不要这么用



## 5.字符串

在JS中六种数据类型：

基本数据类型

1. String 字符串
2. Number 数值
3. Boolean 布尔值
4. Null 空值
5. Undefined 未定义

引用数据类型

Object 对象







