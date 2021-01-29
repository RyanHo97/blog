#先进入当前库
USE myemployees;

#查询表中单个字段
SELECT last_name FROM employees;

#查询表中多个字段
SELECT last_name ,salary,email FROM employees;

#查询表中所有字段,如果是*会输出默认顺序
SELECT * FROM employees;

#'`'着重号
SELECT `last_name` FROM employees;

#4.查询常量值
SELECT 100;
SELECT 'john';

#5.查询表达式
SELECT 100%98;

#6.查询函数
SELECT VERSION();

#7.起别名

#优点：1.便于理解，2.如果要查询的字段有重名的情况

#方式一：使用AS

SELECT 100%98 AS 结果;
SELECT last_name AS '姓',first_name AS '名' FROM employees;

#方式二：使用空格

SELECT last_name 姓,first_name 名 FROM employees;

#案例：查询salary，显示结果为out put（别名有特殊符号需要加上双引号）
SELECT salary AS "out put" FROM employees;

8.去重

#案例：查询员工表中涉及到的所有的部门

SELECT DISTINCT department_id from employees;



#9.+号的作用
#仅仅只有一个功能：运算符
#案例：查询员工名和姓连接成一个字段，并显示为 姓名

SELECT last_name+first_name AS 姓名
FROM employees;



#使用CONCAT
SELECT CONCAT(last_name,first_name) AS 姓名
FROM employees;



练习：

#1.		下面的语句是否可以执行成功
SELECT last_name,job_id,salary AS sal
FROM employees;

#2.		下面的语句是否可以执行成功
SELECT * FROM employees;

#3.		找出下面语句中的错误
#SELECT employee_id,last_name,salary*12 “ANNUAL SALARY” 
#FROM employees;
#中文的双引号“”
SELECT employee_id,last_name,salary*12 "ANNUAL SALARY" 
FROM employees;

#4.显示表departments的结构，并查询其中的全部数据
DESC departments;
SELECT * FROM departments;

#5.显示出表employees中的全部job_id(不能重复)
SELECT DISTINCT job_id from employees;

#6.显示出表employess中的全部列，各个列之间用逗号连接，列头显示成OUT_PUT

SELECT 
				CONCAT(first_name,',',last_name,',',job_id) AS OUT_PUT
FROM
				employees;



#进阶2：条件查询

/*
语法：
		select 
					查询列表
		form
					表名
		where
					筛选条件；

分类：


```txt
	一、按条件表达式筛选
    条件运算符：> < = != <> >= <=

	二、按逻辑运算符筛选

	逻辑运算符：
					&& || !
					and or not
	三、模糊查询
					like
					between and
					in
					is null
```


#一、按条件表达式筛选

#案例1：查询工资>12000的员工信息

SELECT
*
FROM
employees
WHERE
salary>12000;

#案例2：查询部门编号不等于90号的员工名和部门编号
SELECT
				last_name,
				department_id
FROM
				employees
WHERE
				department_id!=90;