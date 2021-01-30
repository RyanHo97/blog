# 数据库

一、数据库的好处

1.可以持久化数据到本地

2.结构化查询



二、数据库的常见概念⭐

1、DB：数据库，存储数据的容器

2、DBMS：数据库管理系统，有称为数据库软件或数据库产品，用于创建或管理DB

3、SQL：结构化查询语言，用于和数据库通信的语言，不是某个数据库软件特有的，而是几乎所有的主流数据库软件通用的语言



三、数据库存储数据的特点

1、数据存放到表中，然后表在放到库中

2、一个库可以有多张表，每张表具有唯一的表明用来标识自己

3、表中有一个或多个列，列又称为“字段“，相当于java中”属性“

4、表中的每一行数据，相当于java中”对象“



四、常见的数据库管理系统

mysql、oracle、db2、sqlserver



## Mysql

一、Mysql的背景

前身属于瑞典的一家公司，MySQL AB

08年被sun公司收购

09年被oracle收购



二、MySQL的优点

1、开源、免费、成本低

2、性能高、移植性也好

3、体积小、便于安装



三、MySQL的安装

属于c/s架构的软件，一般来讲安装服务端

企业版

社区版



5.5

5.6

5.7

8.0



四、MySQL服务的启动和停止

方式一：通过命令行

net start 服务名

net stop 服务名

方式二：计算机--右键--管理--服务



五、MySQL服务的登录和退出



登录：mysql 【-h 主机名 -P 端口号】 -u 用户名 -p明码



退出：exit或ctrl+C





## DQL语言

### 一、语法

select 查询列表

from 表名；

### 二、特点

1、查询列表可以是字段、常量、表达式、函数，也可以是多个

2、查询结果是一个虚拟表



### 三、示例

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



#### 条件查询

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



 #二、按逻辑表达式筛选

#案例1；查询工资z在10000到20000之间的员工名，工资以及奖金
SELECT
				last_name,
				salary,
				commission_pct
FROM
				employees
WHERE
				salary>=10000 AND salary<=20000;

#案例2：查询部门编号不是在90到110之间，或者工资高于15000的员工信息
SELECT
				*
FROM
				employees
WHERE
				NOT(department_id>=90 AND department_id<110) OR salary>15000;



#### 模糊查询

#三、模糊查询

#1.like

#案例1：查询员工名中包含字符a的员工信息

%任意多个字符，包含零个字符

_任意单个字符

SELECT
				*
FROM
				employees
WHERE
				last_name LIKE '%a%';

#案例2：查询员工名中第三个字符为e，第五个字符为a的员工名和工资

SELECT
				last_name,
				salary
FROM
				employees
WHERE
				last_name LIKE '__n_l%';

#案例3：查询员工名中第二个字符为_的员工名

SELECT
				last_name
FROM
				employees
WHERE
				last_name LIKE '_$_%' ESCAPE	'$';
#/_也是可以转义

#2.between and
#·使用between and 可以提高语句的简洁度
#·包含临界值
#·两个临界值不要调换顺序


#案例1：查询员工编号在100到120之间的员工信息

SELECT
				*
FROM
				employees
WHERE
				employee_id >=100 AND employee_id<=120;
#---------------------
SELECT
				*
FROM
				employees
WHERE
				employee_id BETWEEN 100 AND 120;



#3.in
#含义：判断某字段的值是否属于in列表中的某一项
#特点： 1、使用in提高语句简洁度 2、in列表的值类型必须一致或者兼容
#案例：查询员工的工种编号是 IT_PORG、AD_VP、AD_PRES中的一个员工名和工种编号

SELECT
				last_name,
				job_id
FROM
				employees
WHERE
				job_id='IT_PROT' OR job_id='AD_VP' OR job_id='AD_PRES';
#---------------------------
SELECT
				last_name,
				job_id
FROM
				employees
WHERE
				job_id IN('IT_PROT','AD_VP','AD_PRES');

#4.is null
#= 或 <>不能用于判断null值
#is null 或 is not null 可以判断null值

#案例1：查询没有奖金的员
SELECT
				last_name,
				commission_pct
FROM
				employees
WHERE
				commission_pct IS NULL;

#案例2：查询有奖金的员
SELECT
				last_name,
				commission_pct
FROM
				employees
WHERE
				commission_pct IS NOT NULL;

#------------以下为错误的

SELECT
				last_name,
				commission_pct
FROM
				employees
WHERE
				salary IS 12000;



#is null pk <=>

#IS NULL:仅仅可以判断null值，可读性较高，建议使用
#<=>		:既可以判断null值，又可以判断普通的数值，可读性较低


#2.查询员工号为176员工的姓名和部门号和年薪

SELECT
				employee_id,
				last_name,
				department_id,
				salary*12*(1+IFNULL(commission_pct,0)) AS 年薪
FROM
				employees
WHERE
				employee_id = 176;



测试题详解

#一、查询没有奖金，且工资小于18000的salary，last_name
SELECT
				salary,last_name
FROM
				employees
WHERE
				commission_pct is NULL
AND
				salary<18000;

#二、查询employees表中，job_id不为‘IT’或者 工资为12000的员工信息

SELECT
				*
FROM
				employees
WHERE
				job_id <>'IT'
OR
				salary=12000;

#三、查看部门departments表的结构

DESC	departments;

#四、查询部门departments表中涉及到了哪些位置编号

SELECT
			DISTINCT location_id
FROM
			departments;

#五、经典面试题
#试问：select * from employees;和
#select * from employees where commission_pct like '%%' and last_name like '%%';
#结果是否一样？并说明原因

#答：不一样！如果判断的字段有null值



#### 排序查询

#进阶3：排序查询
/*
引入：

SELECT * FROM employees;

语法：
			SELECT 查询列表
			FROM 表
			【where 筛选条件】
			ORDER BY 排序列表;
特点：
			1、asc代表的是升序，desc代表的是降序
			如果不写，默认是升序
			2、order by子句中可以支持单个字段、多个字段、表达式、函数、别名
			3、order by子句一般是放在查询语句的最后面，limit字句除外

*/

#案例1：查询员工信息，要求工资从高到低排序
SELECT * FROM employees ORDER BY salary DESC;
SELECT * FROM employees ORDER BY salary ASC;

#案例2： 查询部门编号>=90的员工信息，按入职时间的先后进行排序
SELECT *
FROM employees
WHERE department_id>=90
ORDER BY hiredate ASC;

#案例3：按年薪的高低显示员工的信息和 年薪【按表达式排序】

SELECT *,salary*12*(1+IFNULL(commission_pct,0)) 年薪
FROM employees
ORDER BY salary*12*(1+IFNULL(commission_pct,0)) DESC;

#案例3：按年薪的高低显示员工的信息和 年薪【按别名排序】
SELECT *,salary*12*(1+IFNULL(commission_pct,0)) 年薪
FROM employees
ORDER BY 年薪 DESC;

#案例5：按姓名的长度显示员工的姓名和工资【按函数排序】
SELECT	LENGTH(last_name) 字节长度,last_name,salary
FROM	employees
ORDER BY LENGTH(last_name) DESC;

#案例6：查询员工信息，要求先按工资排序，再按员工编号排序【按多个字段排序】

SELECT	*
FROM employees
ORDER BY salary ASC,employee_id DESC;



测试题详解



#1.查询员工的姓名和部门号和年薪，按年薪降序 按姓名升序
SELECT last_name,department_id,salary*12*(1+IFNULL(commission_pct,0)) 年薪
FROM	employees
ORDER BY 年薪 DESC,last_name ASC;

#2.选择工资不在8000到17000的员工的姓名和工资，按工资降序
SELECT last_name,salary
FROM employees

WHERE	salary NOT BETWEEN 8000 AND 17000
ORDER BY salary DESC;

#3.查询邮箱中包含e的员工信息，并先按邮箱的字节数降序，再按部门号升序

SELECT *
FROM employees
WHERE email LIKE '%e%'
ORDER BY LENGTH(email) DESC,department_id ASC;



#### 常见函数

#进阶4：常见函数
/*

概念：类似于java的方法，将一组逻辑语句封装在方法体中，对外暴露方法名
好处：1、隐藏了实现细节 2、提高代码的重用性
调用：select 函数名(实参列表)【from表】
特点：
			1、叫什么（函数名）
			2、干什么（函数功能）
分类：
			1、单行函数
			如 concat、length、ifnull
			2、分组函数
			功能：做统计使用，又称为统计函数、聚合函数、组函数



##### 字符函数

#一、字符函数

#1.length 获取参数值的字节个数
SELECT LENGTH('john');
SELECT LENGTH('张三丰hahaha');

#SHOW VARIABLES LIKE '%char%'

#2.concat 拼接字符串

SELECT CONCAT(last_name,'_',first_name) 姓名 FROM employees;

#3.upper、lower
SELECT UPPER('john');
SELECT LOWER('joHn');
#示例：将姓变大写，名变小写，然后拼接
SELECT CONCAT(UPPER(last_name),LOWER(first_name)) 姓名 FROM	employees;

#4.substr、substring
#注意：索引从1开始

#截取从指定索引处后面所有字符
SELECT SUBSTR('李莫愁爱上了陆展元' ,7) out_put;

#截取从指定索引处指定字符长度的字符
SELECT SUBSTR('李莫愁爱上了陆展元' ,1,3) out_put;

#案例：姓名中首字符大写，其他字符消息然后用_拼接，显示出来
SELECT CONCAT(UPPER(SUBSTR(last_name, 1,1)),'_',LOWER(SUBSTR(last_name,2))) out_put
FROM employees;

#5.instr 返回字串第一次出现的索引，如果找不到返回0

SELECT INSTR('杨不悔爱上了殷六侠','殷六侠') AS out_put;

#6.trim

SELECT LENGTH(TRIM('  张翠山  ')) AS out_put;

SELECT TRIM('aa' FROM 'aaaaaaaaaa张aaaa翠山aaaaaaaa') out_put;

#7.lpad 用指定的字符实现左填充指定长度

SELECT LPAD('殷素素',10,'*') AS out_put;
#小于字符本身长度截断
SELECT LPAD('殷素素',2,'*') AS out_put;

#8.rpad 用指定的字符实现右填充指定长度

SELECT RPAD('殷素素',12,'*') AS out_put;

#9.replace 替换
SELECT REPLACE('周芷若周芷若周芷若周芷若张无忌爱上了周芷若','周芷若','赵敏') AS out_put;



##### 数学函数

#二、数学函数

#round 四舍五入
SELECT ROUND(-1.55);
SELECT ROUND(1.567,2);

#ceil 向上取整，返回>=该参数的最小整数

SELECT CEIL(-1.02);

#floor 向下取整 返回<=该参数的最大整数

#truncate 截断
SELECT TRUNCATE(1.69999,1);

#mod取余

#MOD(a,b): a-a/b*b

SELECT MOD(10,-3);
SELECT 10%3;



##### 日期函数

#三、日期函数

#now 返回当前系统日期+时间
SELECT NOW();

#curdate 返回当前系统日期，不包含时间
SELECT CURDATE();

#curtime 返回当前时间，不包含日期
SELECT CURTIME();

#可以获取指定的部分，年、月、日、小时、分钟、秒
SELECT YEAR(NOW()) 年;
SELECT YEAR('1998-1-1') 年;

SELECT YEAR(hiredate) 年 FROM employees;

SELECT MONTH(NOW()) 月;
SELECT MONTHNAME(NOW()) 月;

#str_to_date 将日期格式的字符转换成指定格式的日期

SELECT STR_TO_DATE('1998-3-2','%Y-%c-%d') AS out_put;

#查询入职日期为1992-4-3的员工信息
SELECT * FROM employees WHERE hiredate = '1992-4-3';

SELECT * FROM employees WHERE hiredate = STR_TO_DATE('4-3 1992','%c-%d %Y');

#date_format 将日期转换成字符

SELECT DATE_FORMAT(NOW(),'%y年%m月%d日') AS out_put;

#查询有奖金的员工名和入职日期(xx月/xx日 xx年)
SELECT last_name,DATE_FORMAT(hiredate,'%m月/%d日 %y年') 入职日期
FROM employees
WHERE commission_pct IS NOT NULL;



##### 其他函数

#四、其他函数

SELECT VERSION();
SELECT DATABASE();
SELECT USER();



##### 流程控制函数

#五、流程控制函数
#1.if函数： if else 的效果

SELECT IF(10<5,'大','小');

SELECT last_name,commission_pct,IF(commission_pct IS NULL,'没奖金，呵呵','有奖金，嘻嘻') 备注
FROM employees;



