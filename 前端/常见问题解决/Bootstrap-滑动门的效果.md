Bootstrap tabs选项卡 鼠标经过效果



代码示例

```html
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bootstrap tabs选项卡 鼠标经过效果</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script>
        $(function () {
            $("#tabs1 a").mousemove(function (e) {
                $(this).tab('show');
            });
            $("#tabs2 a").mousemove(function (e) {
                $(this).tab('show');
            });
            $("#tabs3 a").mousemove(function (e) {
                $(this).tab('show');
            });
        });
    </script>
</head>
<body>
<div class="container">
  <div class="row" style="margin-top:100px;">
    <ul class="nav-tabs nav" id="tabs1">
      <li class="active"><a href="#tabs-1">关于我们 </a></li>
      <li><a href="#tabs-2">资讯中心</a></li>
      <li><a href="#tabs-3">联系我们 </a></li>
    </ul>
    <div class="tab-content">
      <div class="tab-pane active" id="tabs-1">
        <p>none此元素不会被显示。</p>
      </div>
      <div class="tab-pane" id="tabs-2">
        <ul>
          <li>none此元素不会被显示。</li>
          <li>block此元素将显示为块级元素，此元素前后会带有换行符。</li>
          <li>inline默认。此元素会被显示为内联元素，元素前后没有换行符。</li>
        </ul>
      </div>
      <div class="tab-pane" id="tabs-3">
          <p>inline-block行内块元素。（CSS2.1 新增的值）</p>
      </div>
    </div>
  </div>
</div>
</body>
</html>
```

