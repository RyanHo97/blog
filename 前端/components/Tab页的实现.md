可以实现鼠标停留到tab页即可显示对应内容。

html+css+javascript



示例代码：

index.html

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>tab实现</title>
		<!--引入css-->
		<link href="index.css" rel="stylesheet"/>
		<!--引入保存刷新插件-->
		<script src="live.js"></script>
		<!--让所有的A标签的默认跳转方式都为blank（跳转新窗口打开）-->
		<base target="_blank" />
	</head>
	<body>
		
		<!--最外边的盒子-->
		<div class="tab_contents">
			<ul class="tab_nav">
				<li class="tabNav_active">
					<img src="images/html.png" alt="" />
					<h2>html</h2>
				</li>
				<li>
					<img src="images/css.png" alt="" />
					<h2>css</h2>
				</li>
				<li>
					<img src="images/js.png" alt="" />
					<h2>js</h2>
				</li>
				<li>
					<img src="images/react.png" alt="" />
					<h2>react</h2>
				</li>
				<li>
					<img src="images/vue.png" alt="" />
					<h2>vue</h2>
				</li>
			</ul>
			<!--面板区-->
			<ul class="tab_box">
				<li class="tabBox_active">
					<img src="images/html.png" alt=""/>
					<div>
						<h2>html</h2>
						<p>
							HTML称为超文本标记语言，是一种标识性的语言。它包括一系列标签．通过这些标签可以将网络上的文档格式统一，使分散的Internet资源连接为一个逻辑整体。HTML文本是由HTML命令组成的描述性文本，HTML命令可以说明文字，图形、动画、声音、表格、链接等.
						</p>
						<button>
							<a href="#">
								Look at all >
							</a>
						</button>
					</div>
				</li>
				<li>
					<img src="images/css.png" alt=""/>
					<div>
						<h2>css</h2>
						<p>
							层叠样式表(英文全称：Cascading Style Sheets)是一种用来表现HTML（标准通用标记语言的一个应用）或XML（标准通用标记语言的一个子集）等文件样式的计算机语言。
						CSS不仅可以静态地修饰网页，
						还可以配合各种脚本语言动态地对网页各元素进行格式化。
						</p>
						<button>
							<a href="#">
								Look at all >
							</a>
						</button>
					</div>
				</li>
				<li>
					<img src="images/js.png" alt=""/>
					<div>
						<h2>JAVAScript</h2>
						<p>
							avaScript（简称“JS”） 是一种具有函数优先的轻量级，解释型或即时编译型的高级编程语言。虽然它是作为开发Web页面的脚本语言而出名的，但是它也被用到了很多非浏览器环境中，JavaScript
							                    基于原型编程、多范式的动态脚本语言，并且支持面向对象、命令式和声明式（如函数式编程）风格。
						</p>
						<button>
							<a href="#">
								Look at all >
							</a>
						</button>
					</div>
				</li>
				<li>
					<img src="images/vue.png" alt=""/>
					<div>
						<h2>Vue</h2>
						<p>
							Vue (读音 /vjuː/，类似于 view) 是一套用于构建用户界面的渐进式JavaScript框架。与其它大型框架不同的是，Vue
							                    被设计为可以自底向上逐层应用。Vue的核心库只关注视图层，方便与第三方库或既有项目整合。
						</p>
						<button>
							<a href="#">
								Look at all >
							</a>
						</button>
					</div>
				</li>
				<li>
					<img src="images/react.png" alt=""/>
					<div>
						<h2>React</h2>
						<p>
							React 起源于 Facebook 的内部项目，因为该公司对市场上所有 JavaScript MVC
							                    框架，都不满意，就决定自己写一套，用来架设Instagram的网站。做出来以后，发现这套东西很好用，就在2013年5月开源了。
						</p>
						<button>
							<a href="#">
								Look at all >
							</a>
						</button>
					</div>
				</li>
				
			</ul>
			
		</div>
		
		
		<script>
			
			/*
				思路：
				循环遍历导航条
				点击导航条切换类名  进行  显示和隐藏
				
			*/
			
			let tabNavItem = document.querySelectorAll(".tab_nav>li");
			let tabBoxItem = document.querySelectorAll(".tab_box>li");
			
			let tabNavActive = document.querySelector(".tabNav_active");
			let tabBoxActive = document.querySelector(".tabBox_active");
			
			tabNavItem.forEach(function(item,index){
				item.onmouseenter = function(){
					
					tabNavActive.className = "";
					this.className = "tabNav_active";
					tabNavActive = this;
					
					
					tabBoxActive.className="";
					tabBoxItem[index].className = "tabBox_active";
					tabBoxActive = tabBoxItem[index];
					
					
				}
			})
			
			
			
			
			
		</script>
		
		
		
		
	</body>
</html>

```

index.css

```css
* {
	margin: 0;
	padding: 0;
}

html,body{
	width: 100%;
	height: 100%;
	background: #282c34;
	/*让盒子进行flex布局，并且居中显示*/
	display:flex;
	justify-content: center;
	align-items: center;
}
/*去除小圆点*/
.tab_contents ul{
	list-style: none;
}

/*定义盒子*/
.tab_contents{
	width: 700px;
	height: 200px;
	/* background-color: white; 隐藏边框*/
}

/*导航横排*/
.tab_contents .tab_nav{
	display: flex;
}

/*导航块样式*/
.tab_contents .tab_nav li{
	padding: 10px 20px;
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
	background: #e5e9ea;
	margin-right: 2px;
	color: #607291;
	cursor: pointer;
	display: flex;
	position: relative;
	overflow: hidden;
}

.tab_contents .tab_nav li img{
	width: 20px;
	height: 20px;
	margin-right: 5px;
	opacity: 0.3;/*透明度为30%*/
	transition: opacity 0.3s;
}

.tab_contents .tab_nav li h2{
	font-size: 14px;
}

.tab_contents .tab_nav li:hover img{
	opacity: 1;/*设置为不透明*/
}

.tab_contents .tabNav_active{
	background: #f9f9f9 !important;
}

.tab_contents .tabNav_active img {
    opacity: 1 !important;
}

/*面板*/

.tab_contents .tab_box{
	position: relative;
	min-height: 150px; /*这部分最小高度设置为150px*/
	background: #F9F9F9;
	padding: 2em;
	color: #607291;
}

/*面板块*/
.tab_contents .tab_box li{
	width: 100%;
	height: 100%;
	position: absolute;
	top: 0;
	left: 0;
	display: flex;
	align-items: center;
	padding: 15px;
	overflow:hidden;
	box-sizing: border-box;
	/*display 不支持动画切换*/
	
	/* display: none; */
	
	opacity: 0;
	visibility: hidden;
	transition: all 0.3s ease;
	
}

.tab_contents .tab_box .tabBox_active{
	/* display: flex; */
	opacity: 1;
	visibility: visible;
}

.tab_contents .tab_box li img{
	width: 128px;
}

.tab_contents .tab_box li div{
	width: 100%;
	position: relative;
	margin-left: 20px;
}

.tab_contents .tab_box li p{
	text-indent: 2em;
	margin-top: 40px;
	line-height: 1.5em;
	
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 3; /*超过三行隐藏*/
	-webkit-box-orient: vertical;
	
}

.tab_contents .tab_box li button{
	margin-top: 20px;
	width: 110px;
	height: 35px;
	border: #607291 solid 1px;
	background: transparent;
	float: right;
}

.tab_contents .tab_box li button a{
	display:block;
	text-decoration: none;
	color: #607291;
}
```

