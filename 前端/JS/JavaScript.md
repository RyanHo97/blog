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



## 5.数据类型

在JS中六种数据类型：

基本数据类型

1. String 字符串
2. Number 数值
3. Boolean 布尔值
4. Null 空值
5. Undefined 未定义

引用数据类型

Object 对象



- String字符串
  - 在JS中字符串需要使用引号引起来
  - 使用双引号或单引号都可以，但是不要混用
  - 引号不能嵌套，双引号不能放双引号，单引号不能放单引号
  - 在字符串中我们可以使用\作为转义字符，当表示一些特殊符号时可以使用\进行转义



//输出字面量 字符串str

alert("str");

//输出变量str

alert(str);



- Number数值

  - 在JS中所有的数值都是Number类型，

  - 包括整数和浮点数（小数）

  - 可以使用一个运算符typeof

    来检查一个变量的类型

    语法：typeof 变量

    检查字符串时，会返回string

    检查数值时，会返回number

  - JS中可以表示的数字的最大值

    Number.MAX_VALUE

    ​	1.7976931348623157e+308

    Number.MIN_VALUE

    ​	5e-324

    如果使用Number表示的数字超过了最大值，则会返回一个

    Infinity 表示正无穷

    -Infinity 表示负无穷

    使用typeof检查Infinity也会返回Number

    NAN 是一个特殊的数字，表示 Not A Number

  - 在JS中整数的运算基本可以保证精确

  - 如果使用JS进行浮点运算，可能得到一个不精确的结果

    所以千万不要使用JS进行对精确对要求比较高的运算





- Boolean布尔值
  - 布尔值只有两个
    - true -表示真
    - false -表示假



- Null空值
  - Null类型的值只有一个，就是null
  - null这个值专门用来表示一个为空的对象
  - 使用typeof检查一个null值时，会返回object



- Undefined未定义
  - 当声明一个变量，但是并不给变量赋值时，它的值就是undefined
  - 使用typeof检查一个undefined时也会返回undefined









