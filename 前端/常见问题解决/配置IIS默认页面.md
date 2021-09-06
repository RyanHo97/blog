# IIS设置默认访问页  
1.点击打开IIS服务管理器，点击你的网站，点击默认文档  
2.点击右侧添加，输入index.asp，然后点确定（这样设置就表示默认页面就是index.asp）  
3.想设置哪个为首页，就点右侧的上移下移就可以，第一个位置就是默认页，第一个没有就依次往后  
  
问题解决：  
带路径的页面可以用重定向解决，也可以在默认页面添加以下代码  
```html  
<html>
<body>
<script type="text/javascript">
   window.location="address/index.htm"
</script>
</body>
</html>
```
