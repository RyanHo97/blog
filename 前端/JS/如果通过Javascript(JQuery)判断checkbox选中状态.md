#### 如果通过Javascript(JQuery)判断checkbox选中状态

html代码部分：

```html
<input type="checkbox" id="target" checked="checked">
<!-- checked="checked"会使按钮默认为选中的状态 -->
<p id="test">目前check为选中的状态</p>
```

Javascript代码部分：

```javascript
    $(function () {
            //监控checkbox代码
            $("#target").on("change", function () {
                var change = $("#target").is(':checked');
                if (change) {
                  $("#test").text("按钮为选中的状态");
                }else{
                  $("#test").text("按钮为未选中的状态");
                }
            });
    });
```

作者：Ryanho97(https://github.com/RyanHo97/)

日期：2021年9月28日

