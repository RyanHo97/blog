前台代码  
```html
<div class="fl search-box"> 
     <button type="button" name="btnSubmit" id="btnSubmit" class="btnSubmit">搜索</button>
     <input id="sousuo" name="sousuo" type="search" placeholder="输入搜索内容" value="">
</div>
```

搜索按钮实现  
```javascript
$(function () {
   $("body").on("click", "#btnSubmit", function () {
    var sousuo = $("#sousuo").val();
    if (sousuo == "") { alert("请输入信息"); return false; }
    location.href = "{$:CSSiteUrl}search.html?keywords=" + escape(sousuo);
   });
  });
```

键盘回车实现搜索  
```javascript
$('#sousuo').bind('keypress', function (event) { 
   if (event.keyCode == "13") { 
    $("#btnSubmit").click();
   }
  })
```

回车键event.keyCode == “13”是说键盘的的第13个键码
