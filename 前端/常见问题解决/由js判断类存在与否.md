由js判断类存在与否



代码示例

```html
<html>
<head>
<script type="text/javascript" src="/jquery/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
  $("button").click(function(){
    alert($("li:first").hasClass("active"));
  });
});
</script>
</head>

<body>
<ul>
<li class="tabs1 active">testjs</li>
</ul>
<button>检查第一个段落列表是否拥有类 "active"</button>
</body>
</html>

```

