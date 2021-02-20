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

#流程控制函数
#1.if函数： if else 的效果

SELECT IF(10<5,'大','小');

SELECT last_name,commission_pct,IF(commission_pct IS NULL,'没奖金，呵呵','有奖金，嘻嘻') 备注
FROM employees;



#case函数的使用一：switch case 的效果

/*

switch(变量或表达式){
		case 常量1： 语句1;break;
		...
		default:语句n;break;
}

mysql中

case
 要判断的字段或表达式
when 常量1 then 要显示的值1或语句1;
when 常量2 then 要显示的值2或语句2;
...
else 要显示的值n或语句n；
end
*/

/*案例：查询员工的工资，要求

部门号=30， 显示的工资为1.1倍
部门号=40， 显示的工资为1.2倍
部门号=50， 显示的工资为1.3倍
其他部门，显示的工资为原工资

*/

SELECT salary 原始工资,department_id,
CASE department_id
WHEN 30 THEN salary*1.1
WHEN 40 THEN salary*1.2
WHEN 50 THEN salary*1.3
ELSE salary
END AS 新工资
FROM employees;



#case函数的使用二：类似于 多重if
/*
java中：
if(条件1){
			语句1;
}else if(条件2){
			语句2;
}
...
else{
			语句n;
}

mysql中：

case
when 条件1 then 要显示的值1或语句1
when 条件2 then 要显示的值2或语句2
...
else 要显示的值n或语句n
end
*/

#案例：查询员工的工资的情况
/*
如果工资>20000,显示A级别
如果工资>15000,显示B级别
如果工资>10000,显示C级别
否则，显示D级别

*/
SELECT salary,
CASE
WHEN salary>20000 THEN 'A'
WHEN salary>15000 THEN 'B'
WHEN salary>10000 THEN 'C'
ELSE 'D'
END AS 工资级别
FROM employees;



案例讲解

#1.	显示系统时间(注： 日期+时间)

SELECT NOW();

#2.	查询员工号，姓名，工资，以及工资提高20%后的结果（new salary）

SELECT employee_id,last_name,salary*1.2 "new salary"
FROM employees;

#3. 将员工的姓名按首字母排序，并写出姓名的长度（length）

SELECT	LENGTH(last_name) 长度,SUBSTR(last_name,1,1) 首字符,last_name
FROM employees
ORDER BY 首字符;

#4. 做一个查询，产生下面的结果
/*
<last_name> earns <salary> monthly but wants <salary*3>
Deram Salary
King earns 24000 monthly but wants 72000

*/

SELECT CONCAT(last_name,' earn ',salary,' monthly but wants ',salary*3) AS "Dream Salary"
FROM employees
WHERE salary=24000;

#5. 使用case-when,按照下面的条件：
/*
job    grade
AD_PRES  A
ST_MAN   B
IT_PROG  C
SA_REP   D
ST_CLERK E

*/

SELECT last_name,job_id AS job,
CASE job_id
WHEN 'AD_PRES' THEN 'A'
WHEN 'ST_MAN' THEN 'B'
WHEN 'IT_PROG' THEN 'C'
WHEN 'SA_REP' THEN 'D'
WHEN 'ST_CLERK' THEN 'F'
END AS Grade
FROM employees
WHERE job_id = 'AD_PRES';



#### 分组函数

##### 分组函数

#二、分组函数
/*
功能：用作统计使用，又称为聚合函数或统计函数或组函数

分类：
sum 求和、avg 平均值、max 最大值、min 最小值、count 计算个数

特点：
1、sum、avg一般用于处理数值型
   max、min、count可以处理任何类型
2、以上分组函数都忽略null值
3、和distinct搭配，实现去重
4、count函数的单独介绍
一般使用count(*)用作统计行数
5、和分组函数一同查询的字段要求是group by后的字段

*/

#1、简单 的使用
SELECT SUM(salary) FROM employees;
SELECT AVG(salary) FROM employees;
SELECT MIN(salary) FROM employees;
SELECT MAX(salary) FROM employees;
SELECT COUNT(salary) FROM employees;

SELECT SUM(salary) 和,AVG(salary) 平均,MAX(salary) 最高,MIN(salary) 最低,COUNT(salary) 个数
FROM employees;

SELECT SUM(salary) 和,ROUND(AVG(salary),2) 平均,MAX(salary) 最高,MIN(salary) 最低,COUNT(salary) 个数
FROM employees;

#2、参数支持哪些类型

SELECT SUM(last_name),AVG(last_name) FROM employees;
SELECT SUM(hiredate),AVG(last_name) FROM employees;

SELECT MAX(last_name),MIN(last_name) FROM employees;
SELECT MAX(hiredate),MIN(hiredate) FROM employees;

SELECT COUNT(last_name) FROM employees;
SELECT COUNT(commission_pct) from employees;



#3、是否忽略null

SELECT SUM(commission_pct),AVG(commission_pct),SUM(commission_pct)/35,SUM(commission_pct)/107 FROM employees;

SELECT MAX(commission_pct),MIN(commission_pct) FROM employees;

SELECT COUNT(commission_pct) FROM employees;



#4、和distinct搭配

SELECT SUM(DISTINCT salary),SUM(salary) FROM employees;

SELECT COUNT(DISTINCT salary),COUNT(salary) FROM employees;

#5、count函数的详细介绍

SELECT COUNT(salary) FROM employees;

SELECT COUNT(*) FROM employees;

SELECT COUNT(1) FROM employees;

#效率：
#MYISAM存储引擎下，COUNT(*)的效率高
#INNODB存储引擎下，COUNT(*)和COUNT(1)的效率差不多，比COUNT(字段)要高一些

#6、和分组函数一同查询的字段有限制

#虽然没有报错，但是employee_id值无意义。

SELECT AVG(salary),employee_id FROM employees;



#测试

#1.查询公司员工工资的最大值，最小值，平均值，总和

SELECT MAX(salary) mx_sal,MIN(salary) mi_sal,ROUND(AVG(salary),2) ag_sal,SUM(salary) sm_sal
FROM employees;

#2.查询员工表中的最大入职时间和最小入职时间的相差天数 （DIFFRENCE）

#MAX(hiredate) MIN(hiredate)

SELECT DATEDIFF(MAX(hiredate),MIN(hiredate)) DIFFRENCE
FROM employees;

#查看自己活了多少天了
SELECT DATEDIFF(NOW(),'1995-1-1');

#3.查询部门编号为90的员工个数
SELECT COUNT(*) 个数
FROM employees
WHERE department_id = 90;



##### 分组查询

#进阶5：分组查询
/*
分组数据：GROUP BY 子句语法
语法：
				select 分组函数,列（要求出现在group by的后面）
				from 表
				【where 筛选条件】
				group by 分组的列表
				【order by 子句】
注意：
				查询列表比较特殊，要求是分组函数和group by后出现的字段



特点：

​			1、分组查询中的筛选条件分为两类

|            | 数据源         | 位置               | 关键字 |
| ---------- | -------------- | ------------------ | ------ |
| 分组前筛选 | 原始表         | group by子句的前面 | where  |
| 分组后筛选 | 分组后的结果集 | group by子句的后面 | having |

​	①分组函数做条件肯定是放在having子句中

​	②能用分组前筛选的，就优先考虑使用分组前筛选

​			2、group by子句支持单个字段分组，多个字段分组（多个字段之间用逗号隔开没有顺序要求），表达式函数（用的较少）

​			3、也可以添加排序（排序放在整个分组查询的最后）



*/

#引入：查询每个部门的平均工资
SELECT AVG(salary) FROM employees;

#简单的分组查询
#案例1：查询每个工种的最高工资
SELECT MAX(salary),job_id
FROM employees
GROUP BY job_id;

#案例2：查询每个位置上的部门个数
SELECT COUNT(*),location_id
FROM departments
GROUP BY location_id;



#添加分组前的筛选条件
#案例1：拆线呢邮箱中包含a字符的，每个部门的平均工资

SELECT AVG(salary),department_id
FROM employees
WHERE email LIKE '%a%'
GROUP BY department_id;

#案例2：查询有奖金的每个领导手下员工的最高工资

SELECT last_name,MAX(salary),manager_id
FROM employees
WHERE commission_pct IS NOT NULL
GROUP BY manager_id;



#添加分组后的筛选条件

#案例1：查询哪个部门的员工个数>2

#①查询每个部门的员工个数
SELECT COUNT(*),department_id
FROM employees
GROUP BY department_id;

#②根据①的结果进行筛选，查询哪个部门的员工个数>2

SELECT COUNT(*),department_id
FROM employees
GROUP BY department_id
HAVING COUNT(*)>2;

#案例2：查询每个工种有奖金的员工的最高工资>12000的工种编号和最高工资

#①查询每个工种有奖金的员工的最高工资

SELECT MAX(salary),job_id
FROM employees
WHERE commission_pct IS NOT NULL
GROUP BY job_id;

#②根据①结果继续筛选，最高工资>12000

SELECT MAX(salary),job_id
FROM employees
WHERE commission_pct IS NOT NULL
GROUP BY job_id
HAVING MAX(salary)>12000;

#案例3：查询领导编号>102的每个领导手下的最低工资>5000的领导编号是哪个，以及其最低工资

#①查询每个领导手下的员工固定最低工资

SELECT MIN(salary),manager_id
FROM employees
GROUP BY manager_id

#②添加筛选条件：编号>102

SELECT MIN(salary),manager_id
FROM employees
WHERE manager_id>102
GROUP BY manager_id;

#③添加筛选条件：最低工资>5000
SELECT MIN(salary),manager_id
FROM employees
WHERE manager_id>102
GROUP BY manager_id
HAVING MIN(salary)>5000;



#按表达式或函数分组

#案例：按员工姓名的长度分组，查询每一组的员工个数，筛选员工个数>5的有哪些

#①查询每个长度的员工个数

SELECT COUNT(*),LENGTH(last_name) len_name
FROM employees
GROUP BY LENGTH(last_name);

#②添加筛选条件
SELECT COUNT(*) c,LENGTH(last_name) len_name
FROM employees
GROUP BY len_name
HAVING c>5;

#按多个字段分组

#案例：查询每个部门每个工种的员工的平均工资

SELECT AVG(salary),department_id,job_id
FROM employees
GROUP BY job_id,department_id;

#添加排序
#案例：查询每个部门每个工种的员工的平均工资，并且按平均工资的高低显示

SELECT AVG(salary),department_id,job_id
FROM employees
WHERE department_id IS NOT NULL
GROUP BY job_id,department_id
HAVING AVG(salary)>10000

ORDER BY AVG(salary) DESC;



案例讲解：

#1.查询个job_id的员工工资的最大值，最小值，平均值，总和并按job_id升序

SELECT MAX(salary),MIN(salary),AVG(salary),SUM(salary),job_id
FROM employees
GROUP BY job_id
ORDER BY job_id;

#2.查询员工最高工资和最低工资的差距（DIFFRENCE）
SELECT MAX(salary)-MIN(salary) DIFFRENCE
FROM employees;

#3.查询各个管理者手下员工的最低工资，其中最低工资不能低于6000，没有管理者的员工不计算在内
SELECT MIN(salary),manager_id
FROM employees
WHERE manager_id IS NOT NULL
GROUP BY manager_id
HAVING MIN(salary)>=6000;

#4.查询所有部门的编号，员工数量和工资平均值，并按平均工资降序
SELECT department_id,COUNT(*),AVG(salary) a
FROM employees
GROUP BY department_id
ORDER BY a DESC;

#5.选择具有各个job_id的员工人数
SELECT COUNT(*) 个数,job_id
FROM employees
GROUP BY job_id;





#### 连接查询

#进阶6：连接查询
/*
含义：又称多表查询，当查询的字段来自于多个表时，就会用到连接查询

笛卡尔乘积概念：当查询多个表时，没有添加有效的连接条件，导致多个表所有行实现完全连接

笛卡尔乘积现象：表1 有m行，表2 有n行，结果=m*n行

发生原因：没有有效的连接条件
如何避免：添加有效的连接条件

分类：
			按年代分类：
			sql92标准：仅仅支持内连接
			sql99标准【标准】：支持内连接+外连接（左外+右外）+交叉连接

```
		按功能分类：
					内连接：
							等值连接
							非等值连接
							自连接
					外连接：
							左外连接
							右外连接
							全外连接
					交叉连接
```

*/

SELECT * FROM beauty;

SELECT * FROM boys;

SELECT NAME,boyName FROM boys,beauty
WHERE beauty.boyfriend_id = boys.id;



#一、sql92标准





##### 等值连接

#1、等值连接

/*

①多表等值连接的结果为多表的交集部分
②n表连接，至少需要n-1个连接条件
③多表的顺序没有要求
④一般需要为表起别名
⑤可以搭配前面介绍的所有子句使用，比如排序、分组、筛选

*/

#案例1：查询女神名和对应的男神名
SELECT NAME,boyName
FROM boys,beauty
WHERE beauty.boyfriend_id = boys.id;



#案例2：查询员工名和对应的部门名

SELECT last_name,department_name
FROM employees,departments
WHERE	employees.department_id = departments.department_id;

#2、为表起别名
/*
提高语句的简洁度
区分多个重名的字段

注意：如果为表起了别名，则查询的字段就不能使用原来的表名去限定

*/
#查询员工名、工种号、工种名

SELECT last_name,e.job_id,job_title
FROM employees e,jobs
WHERE e.job_id = jobs.job_id;

#3、两个表的舒徐是否可以调换

#查询员工名、工种号、工种名

SELECT last_name,e.job_id,job_title
FROM jobs,employees e
WHERE e.job_id = jobs.job_id;

#4、可以加筛选？

#案例1：查询有奖金的员工名、部门名

SELECT last_name,department_name,commission_pct
FROM employees e,departments d
WHERE e.department_id=d.department_id
AND e.commission_pct IS NOT NULL;

#案例2：查询城市名中第二个字符为o的部门名和城市名

SELECT department_name,city
FROM departments d,locations l
WHERE d.location_id = l.location_id
AND city LIKE '_o%';

#5、可以加分组？

#案例1：查询每个城市的部门个数

SELECT COUNT(*) 个数,city
FROM departments d,locations l
WHERE d.location_id = l.location_id
GROUP BY city;

#案例2：查询有奖金的每个部门的部门名和部门的领导编号和该部门的最低工资
SELECT department_name,d.manager_id,MIN(salary)
FROM departments d,employees e
WHERE d.department_id=e.department_id
AND commission_pct IS NOT NULL
GROUP BY department_name,d.manager_id;

#6、可以加排序

#案例：查询每个工种的工种名和员工的个数，并且按员工个数降序

SELECT job_title,COUNT(*)
FROM employees e,jobs j
WHERE e.job_id=j.job_id
GROUP BY job_title
ORDER BY COUNT(*) DESC;

#7、可以实现三表连接？

#案例：查询员工名、部门名和所在城市

SELECT last_name,department_name,city
FROM employees e,departments d,locations l
WHERE e.department_id=d.department_id
AND d.location_id=l.location_id;

##### 非等值连接

#1、非等值连接

插入job_grades表到myemployess库

USE myemployees;
CREATE TABLE job_grades(
	grade_level VARCHAR(3),
	lowest_sal  INT,
	highest_sal INT
);

INSERT INTO job_grades
VALUES ('A', 1000, 2999);

INSERT INTO job_grades
VALUES ('B', 3000, 5999);

INSERT INTO job_grades
VALUES('C', 6000, 9999);

INSERT INTO job_grades
VALUES('D', 10000, 14999);

INSERT INTO job_grades
VALUES('E', 15000, 24999);

INSERT INTO job_grades
VALUES('F', 25000, 40000);



#案例1：查询员工的工资和工资级别SELECT salary,grade_level
FROM employees e,job_grades g
WHERE salary BETWEEN g.lowest_sal AND g.highest_sal;



##### 自连接

#1、自连接

#案例：查询 员工名和上级的名称

SELECT e.employee_id,e.last_name,m.employee_id,m.last_name
FROM employees e,employees m
WHERE e.manager_id = m.employee_id;

#一、显示员工表的最大工资，工资平均值

SELECT MAX(salary),AVG(salary)
FROM employees;

#二、查询员工表的employee_id,job_id,last_name,按department_id降序,salary升序

SELECT employee_id,job_id,last_name
FROM employees
ORDER BY department_id DESC,salary ASC;

#三、查询员工表的job_id中包含 a和e的，并且a 在e的前面

SELECT job_id
FROM employees
WHERE job_id LIKE '%a%e%';

#四、已知表student,里面有id(学号)，name，gradeId(年级编号)

已知表grade，里面有id(年级编号)，name(年级名)

已知表result,里面有id，score,studentNo(学号)

#要求查询有姓名、年级名、成绩

SELECT name,name,score
FROM student s,grade g,result r
WHERE s.id=r.studentNo
AND g.id =s.gradeId;

#五、显示当前日期，以及去前后空格，截取子字符串的函数
SELECT NOW();
SELECT trim('');
SELECT SUBSTR(str,startIndex);
SELECT SUBSTR(str,startIndex,length);



##### sql99语法

#二、sql99语法
/*
语法：
			SELECT 查询列表
			FROM 表1 别名 【连接类型】
			JOIN 表2 别名
			ON 连接条件
			【where筛选条件】
			【group by 分组】
			【having 筛选条件】
			【order by 排序列表】

内连接(★)：inner
外连接
			左外(★)：left【outer】
			右外(★)：right【outer】
			全外：full【outer】
交叉连接：cross

*/

###### 内连接

#一、内连接
/*
语法：

select 查询列表
from 表1 别名
inner join 表2 别名
on 连接条件;

分类：
等值
非等值
自连接

特点：
①添加排序、分组、筛选
②inner可以省略
③筛选条件放在where后面，连接条件放在on后面，提高分离性，便于阅读
④inner join连接和sql92语法中的等值连接效果是一样的，都是查询多表的交集。

*/

#1、等值连接
#案例1、查询员工名、部门名（调换位置）

SELECT last_name,department_name
FROM employees e
INNER JOIN departments d
ON e.department_id = d.department_id;

#案例2、查询名字中包含e的员工名和工种名（添加筛选）
SELECT last_name,job_title
FROM employees e
INNER JOIN jobs j
ON e.job_id = j.job_id
WHERE e.last_name LIKE '%e%';

#3、查询部门个数>3的城市名和部门个数，（添加分组+筛选）

#①查询每个城市的部门个数
#②在①结果上筛选满足条件的
SELECT city,COUNT(*) 部门个数
FROM departments d
INNER JOIN locations l
ON d.location_id=l.location_id
GROUP BY city
HAVING COUNT(*)>3;

#案例4、查询哪个部门的员工个数>3的部门名和员工个数，并按个数降序（添加排序）

#①查询每个部门的员工个数
SELECT COUNT(*),department_name
FROM employees e
INNER JOIN departments d
ON e.department_id=d.department_id
GROUP BY department_name;

#② 在 ①结果上筛选员工个数>3的记录，并排序
SELECT COUNT(*),department_name
FROM employees e
INNER JOIN departments d
ON e.department_id=d.department_id
GROUP BY department_name
HAVING COUNT(*)>3
ORDER BY COUNT(*) DESC;

#5.查询员工名、部门名、工种名，并按部门名降序（三表连接）

SELECT last_name,department_name,job_title
FROM employees e
INNER JOIN departments d ON e.department_id=d.department_id
INNER JOIN jobs j ON e.job_id=j.job_id
ORDER BY department_name DESC;

#二、非等值连接

#查询员工的工资级别

SELECT salary,grade_level
FROM employees e
JOIN job_grades g
ON e.salary BETWEEN g.lowest_sal AND g.highest_sal;

#查询每个工资级别的个数>2的个数，并且按工资级别降序
SELECT COUNT(*),grade_level
FROM employees e
JOIN job_grades g
ON e.salary BETWEEN g.lowest_sal AND g.highest_sal
GROUP BY grade_level
HAVING COUNT(*)>20
ORDER BY grade_level DESC;

#三、自连接

#查询员工的名字、上级的名字
SELECT e.last_name,m.last_name
FROM employees e
JOIN employees m
ON e.manager_id=m.employee_id
WHERE e.last_name LIKE '%k%';



###### 外连接

#二、外连接

/*
应用场景：用于查询一个表中有，另一个表中没有的记录

特点：
1、外连接的查询结果为主表中的所有记录
			如果从表中有和它匹配的，则显示匹配的值
			如果从表中没有和它匹配的，则显示null
			外连接查询结果=内连接结果+主表中有而从表没有的记录
2、左外连接，left join左边的是主表
   右外连接，right join右边的是主表
3、左外和右外交换两个表的顺序，可以实现同样的效果

*/

#引入：查询男朋友 不在男神表的女神名

#左外连接
SELECT  b.name
FROM beauty b
LEFT OUTER JOIN boys bo
ON b.boyfriend_id = bo.id
WHERE bo.id IS NULL;

#右外连接
SELECT  b.*,bo.*
FROM boys bo
RIGHT OUTER JOIN beauty b
ON b.boyfriend_id = bo.id
WHERE b.id IS NULL;

#案例1：查询哪个部门没有员工
#左外
SELECT d.*,e.employee_id
FROM departments d
LEFT OUTER JOIN employees e
ON d.department_id=e.department_id
WHERE e.employee_id IS NULL;

#右外
SELECT d.*,e.employee_id
FROM employees e
RIGHT OUTER JOIN departments d
ON d.department_id=e.department_id
WHERE e.employee_id IS NULL;



###### 全外连接

#全外连接
/*
并集部分

*/
USE girls;
SELECT b.*,bo.*
FROM beauty b
FULL OUTER JOIN boys bo
ON b.boyfriend_id = bo.id;

###### 交叉连接

#交叉连接

#用sql99的标准实现了笛卡尔乘积

SELECT b.*,bo.*
FROM beauty b
CROSS JOIN boys bo;



#sql92和 sql99 pk
/*
功能：sql99支持的较多
可读性：sql99实现连接条件和筛选条件的分离，可读性较高

*/



案例讲解，多表连接

#二、查询哪个城市没有部门

SELECT city
FROM departments d
RIGHT OUTER JOIN locations l
ON d.location_id=l.location_id
WHERE d.department_id IS NULL;

#三、查询部门名为SAL或IT的员工信息

SELECT e.*,d.department_name
FROM departments d
LEFT JOIN employees e
ON d.department_id=e.department_id
WHERE d.department_name IN('SAL','IT');

查看部门编号

SELECT * FROM departments
WHERE department_name IN('SAL','IT');



#### 子查询介绍

#进阶7：子查询
/*
含义：
出现在其他语句中的select语句，称为子查询或内查询
外部的查询语句，称为主查询或外查询

分类：
按子查询出现的位置：
		select后面：
						仅仅支持标量子查询
		from后面：
						支持表子查询
		where或having后面：⭐
						标量子查询（单行）📌
						列子查询	（多行）📌

​						行子查询
​		exists后面（相关子查询）
​						表子查询

按结果集的行列数不同：
		标量子查询（结果集只有一行一列）
		列子查询（结果集只有一列多行）
		行子查询（结果集有一行多列）
		表子查询（结果集一般为多行多列）

*/
#示例：
SELECT first_name
FROM employees
WHERE department_id in(
		SELECT department_id FROM departments
		WHERE location_id=1700
);





##### where或having后面

#一、where或having后面
/*
1、标量子查询（单行子查询）
2、列子查询（多行子查询）

3、行子查询

特点：
①子查询放在小括号内
②子查询一般放在条件的右侧
③标量子查询，一般搭配着单行操作符使用

> < >= <= = <>

列子查询
in、any/some、all

④子查询的执行优先于主查询执行，主查询的条件用到了子查询的结果

*/

###### 标量子查询

#1.标量子查询

#案例1：谁的工资比Abel高?

#①查询Abel的工资
SELECT salary
FROM employees
WHERE last_name = 'Abel';

#②查询员工的信息，满足 salary>①结果
SELECT *
FROM employees
WHERE salary>(
		SELECT salary
		FROM employees
		WHERE last_name = 'Abel'
);

#案例2：返回job_id与141号员工相同，salary比143号员工多的员工 姓名，job_id 和工资

#①查询141号员工的job_id
SELECT job_id
FROM employees
WHERE employee_id = 141;

#②查询143号员工的salary
SELECT salary
FROM employees
WHERE employee_id = 143;

#③查询员工的姓名，job_id和工资，要求job_id=①并且salary>②

SELECT last_name,job_id,salary
FROM employees
WHERE job_id=(
		SELECT job_id
		FROM employees
		WHERE employee_id = 141
)AND salary>(
		SELECT salary
		FROM employees
		WHERE employee_id = 143
);

#案例3：返回公司工资最少的员工的last_name,job_id,和salary

#①查询公司的 最低工资
SELECT MIN(salary)
FROM employees;

#②查询last_name,job_id和salary，要求salary=①
SELECT last_name,job_id,salary
FROM employees
WHERE salary=(
		SELECT MIN(salary)
		FROM employees
);

#案例4：查询最低工资大于50号部门最低工资的部门id和其最低工资

#①查询50号部门的最低工资
SELECT MIN(salary)
FROM employees
WHERE department_id = 50;

#②查询每个部门的最低工资

SELECT MIN(salary),department_id
FROM employees
GROUP BY department_id;

#③筛选②，满足min(salary)>①

SELECT MIN(salary),department_id
FROM employees
GROUP BY department_id
HAVING MIN(salary)>(
		SELECT MIN(salary)
		FROM employees
		WHERE department_id = 50
);

#非法使用标量子查询

#如果用单行操作符，子查询结果必须唯一且有值
SELECT MIN(salary),department_id
FROM employees
GROUP BY department_id
HAVING MIN(salary)>(
		SELECT salary
		FROM employees
		WHERE department_id = 50
);



##### 列子查询

多行比较操作符

| 操作符    | 含义                           |
| --------- | ------------------------------ |
| IN/NOT IN | 等于列表中的**任意一个**       |
| ANY\|SOME | 和子查询返回的**某一个**值比较 |
| ALL       | 和子查询返回的**所有**值比较   |

#2.列子查询（多行子查询）
#案例1：返回location_id是1400或1700的部门中的所有员工姓名

#①查询location_id是1400或1700的部门编号
SELECT DISTINCT department_id
FROM departments
WHERE location_id IN(1400,1700);

#②查询员工姓名，要求部门号是①列表中的某一个
SELECT last_name
FROM employees
WHERE department_id IN(
		SELECT DISTINCT department_id
		FROM departments
		WHERE location_id IN(1400,1700)
);

#案例2：返回其他工种中比job_id为'IT_PROG'部门任一工资低的员工的员工号、姓名、job_id、以及salary

#①查询job_id为'IT_PROG'部门任一工资

SELECT DISTINCT salary
FROM employees
WHERE job_id = 'IT_PROG';

#②查询员工号、姓名、job_id 以及salary，salary<(①)的任意一个
SELECT last_name,employee_id,job_id,salary
FROM employees
WHERE salary<ANY(
		SELECT DISTINCT salary
		FROM employees
		WHERE job_id = 'IT_PROG'
) AND job_id<>'IT_PROG';

#或
SELECT last_name,employee_id,job_id,salary
FROM employees
WHERE salary<(
		SELECT MAX(salary)
		FROM employees
		WHERE job_id = 'IT_PROG'
) AND job_id<>'IT_PROG';

#案例3：返回其他部门中比job_id为'IT_PROG'部门所有工资都低的员工 的员工号、姓名、job_id、 以及salary

SELECT last_name,employee_id,job_id,salary
FROM employees
WHERE salary<ALL(
		SELECT DISTINCT salary
		FROM employees
		WHERE job_id = 'IT_PROG'
) AND job_id<>'IT_PROG';

#或

SELECT last_name,employee_id,job_id,salary
FROM employees
WHERE salary<(
		SELECT MIN(salary)
		FROM employees
		WHERE job_id = 'IT_PROG'
) AND job_id<>'IT_PROG';



#二、select后面
/*
仅仅支持标量子查询
*/

#案例1：查询每个部门的员工个数

SELECT d.*,(

			SELECT COUNT(*)
			FROM employees e
			WHERE e.department_id=d.department_id

) 个数
FROM departments d;

#案例2：查询员工号=102的部门名

SELECT (

	SELECT department_name
	FROM departments d
	INNER JOIN employees e
	ON d.department_id=e.department_id
	WHERE e.employee_id=102

) 部门名;

##### from后面

#三、from后面
/*
将子查询结果充当一张表，要求必须起别名
*/

#案例：查询每个部门的平均工资的工资等级
#查询每个部门的平均工资
SELECT AVG(salary),department_id
FROM employees
GROUP BY department_id;

SELECT * FROM job_grades;

#②连接①的结果集和job_grades表，筛选条件平均工资 between lowest_sal and highest_sal

SELECT ag_dep.*,g.grade_level
FROM (
		SELECT AVG(salary) ag,department_id
		FROM employees
		GROUP BY department_id
) ag_dep
INNER JOIN job_grades g
ON ag_dep.ag BETWEEN g.lowest_sal AND g.highest_sal;



##### exists后面（相关子查询）

#四、exists后面（相关子查询）
/*
语法：
exists(完整的查询语句)
结果：
1或0

*/

#EXISTS是布尔值，关心有没有值

SELECT EXISTS(SELECT employee_id FROM employees);

#案例1：查询有员工的部门名

SELECT department_name
FROM departments d
WHERE EXISTS(
		SELECT *
		FROM employees e
		WHERE d.department_id=e.department_id

);

#可以用in来代替

SELECT department_name
FROM departments d
WHERE d.department_id IN(
		SELECT department_id
		FROM employees

);

#案例2：查询没有女朋友的男神信息

#in

SELECT bo.*
FROM boys bo
WHERE bo.id NOT IN(
		SELECT boyfriend_id
		FROM beauty
);

#exists

SELECT bo.*
FROM boys bo
WHERE NOT EXISTS(
		SELECT boyfriend_id
		FROM beauty b
		WHERE bo.id=b.boyfriend_id
);



##### 案例讲解

#1.  查询和Zlotkey相同部门的员工姓名和工资

#①查询Zlotkey的部门
SELECT department_id
from employees e
WHERE last_name = 'Zlotkey';

#②查询部门号=①的姓名和工资
SELECT last_name,salary
FROM employees
WHERE department_id = (
				SELECT department_id
				from employees e
				WHERE last_name = 'Zlotkey'
);

#2.查询工资比公司平均工资高的员工的员工号，姓名和工资。

#①查询平均工资
SELECT AVG(salary)
FROM employees;

#②查询工资>①的员工号，姓名和工资。
SELECT last_name,employee_id,salary
FROM employees
WHERE salary>(
SELECT AVG(salary)
FROM employees
);

#3.查询各部门中工资比本部门平均工资高的员工的员工号，姓名和工资
#①查询各部门的平均工资
SELECT AVG(salary),department_id
FROM employees
GROUP BY department_id;

#②连接①结果集和employeees表，进行筛选
SELECT employee_id,last_name,salary
FROM employees e
INNER JOIN(
		SELECT AVG(salary) ag,department_id
		FROM employees
		GROUP BY department_id
) ag_dep
ON e.department_id=ag_dep.department_id
WHERE salary>ag_dep.ag;

#4.查询和姓名中包含字母u的员工在相同部门的员工的员工号和姓名
#①查询姓名中包含字母u的员工的部门

SELECT DISTINCT department_id
FROM employees
WHERE last_name LIKE '%u%';

#②查询部门号=①中的任意一个的员工号和姓名
SELECT last_name,employee_id
FROM employees
WHERE department_id IN(
				SELECT DISTINCT department_id
				FROM employees
				WHERE last_name LIKE '%u%'
);

#5.查询在部门的location_id为1700的部门工作的员工的员工号

#①查询location_id为1700的部门

SELECT DISTINCT department_id
FROM departments
WHERE location_id = 1700;

#②查询部门号=①中的任意一个的员工号
SELECT employee_id
FROM employees
WHERE department_id = ANY(
				SELECT DISTINCT department_id
				FROM departments
				WHERE location_id = 1700
);

#6.查询管理者是King的员工姓名的工资

#①查询姓名为King的员工编号
SELECT employee_id
FROM employees
WHERE last_name = 'K_ing';

#②查询那个员工的manager_id = ①
SELECT last_name,salary
FROM employees
WHERE manager_id IN (
				SELECT employee_id
				FROM employees
				WHERE last_name = 'K_ing'
);

#7.查询工资最高的员工的姓名，要求frist_name和last_name显示为一列，列名为 姓.名

#①查询最高工资
SELECT MAX(salary)
FROM employees;

#②查询工资=①的姓.名

SELECT CONCAT(first_name,'.',last_name) "姓.名"
FROM employees
WHERE salary=(
				SELECT MAX(salary)
				FROM employees

);



#### 分页查询

#进阶8：分页查询 ⭐
/*

应用场景：当要显示的数据，一页显示不全，需要分页提交sql请求
语法：
SELECT 查询列表
FROM 表
【join type join 表2
on 连接条件
where 筛选条件
group by 分组字段
having 分组后的筛选
order by 排序的字段】
LIMIT offset,size;

offset 要显示条目的起始索引(起始索引从0开始)
size 要显示的条目个数

特点：
①limit语句放在查询语句的最后
②公式
要显示的页数 page，每页的条目数size

select 查询列表
from 表
limit (page-1)*size,size;

size=10
page
1 0
2 10
3 20

*/
#案例1：查询前五条员工信息

SELECT * FROM employees
LIMIT 0,5;

#如果起始索引是0，可以省略掉
SELECT * FROM employees
LIMIT 5;

#案例2：查询第11条--第25条
SELECT * FROM employees
LIMIT 10,15;

#案例3：有奖金的员工信息，并且工资较高的前10名显示出来
SELECT * FROM employees
WHERE commission_pct IS NOT NULL
ORDER BY salary DESC
LIMIT 10;

测试题讲解

已知表 stuinfo

id 学号

name 姓名

email 邮箱	john@126.com

gradeId 年纪编号

sex 性别	男 女

age 年龄



已知表 grade

id 年级编号

gradeName 年级名称



一、查询 所有学员的邮箱的用户名 (注：邮箱中@前面的字符)

select substr(email,1,instr(email,'@')-1) 用户名

from stuinfo;



二、查询男生和女生的个数

select count(*) 个数,sex

from stuinfo

group by sex;



三、查询年龄>18岁的所有学生的姓名和年级名称

select name,gradeName

from stuinfo

inner join grade g on s.gradeId = g.id

where age>18;



四、查询哪个年级的学生最小年龄>20岁

1.每个年级的最小年龄

select min(age),gradeId

from stuinfo

group by gradeid

2.在1的结果上筛选

select min(age),gradeId

from stuinfo

group by gradeId

having min(age)>20;



五、试说出查询语句中涉及到的所有关键字，以及执行先后顺序(⚪数字代表执行顺序)

select 查询列表						   ⑦

from 表										①

连接类型 join 表2					    ②

on 连接条件								③

where 筛选条件						  ④

group by 分组列表					 ⑤

having 分组后的筛选				 ⑥

order by 排序列表					  ⑧

limit 偏移，条目数; 				   ⑨





#### 联合查询

#进阶9：联合查询

/*

union 联合 合并：将多条查询语句的结果合并成一个结果



语法：

查询语句1

union

查询语句2

union

...



应用场景

要查询的结果来自于多个表，且多个表没有直接的连接关系，但查询的信息一致时。



特点：⭐

1、要求多条查询语句的查询列数为一致！

2、要求多条查询语句的查询的每一列的类型、顺序最好一致

3、使用union关键字默认去重，如果使用union all 可以包含重复项



*/



#引入的案例：查询部门编号>90或邮箱包含a的员工信息

select * from employees where email like '%a%' or department_id>90;



select * from employees where email like '%a%'

union

select * from employees where department_id>90;





#案例：查询中国用户中男性的信息以及外国用户中男性的用户信息

SELECT id,cname,csex FROM t_ca WHERE csex='男'
UNION
SELECT t_id,tName,tGender FROM t_ua WHERE tGender='male';





## DML语言

#DML语言
/*
数据操作语言
插入：insert
修改：update
删除：delete

*/



### 插入语句



#一、插入语句
/*
语法：
insert into 表名(列名,...) values(值1,...);

*/

SELECT * FROM beauty;
#1.插入的值的类型要与列的类型一致或兼容
INSERT INTO beauty(id,NAME,sex,borndate,phone,photo,boyfriend_id)
VALUES(13，'唐艺昕','女','1990-4-23','18988888888',NULL,2);

#2.不可以为null的列必须插入值。可以为null的列如何插入值？
#方式一
INSERT INTO beauty(id,NAME,sex,borndate,phone,photo,boyfriend_id)
VALUES(13,'唐艺昕','女','1990-4-23','18988888888',NULL,2);

#方式二
INSERT INTO beauty(id,NAME,sex,phone)
VALUES(14,'金星','女','18988888888');

INSERT INTO beauty(id,NAME,sex,phone)
VALUES(15,'娜扎','女','13888888888');

#3.列的顺序是否可以调换
INSERT INTO beauty(NAME,sex,id,phone)
VALUES('蒋欣','女',16,'110');

#4.列数和值的个数必须一致

#错误示例
INSERT INTO beauty(NAME,sex,id,phone,boyfriend_id)
VALUES('关晓彤','女',17,'110');

#5.可以省略列名，默认所有列，而且列的顺序和表中列的顺序一致

INSERT INTO beauty
VALUES(18,'张飞','男',NULL,'119',NULL,NULL);
