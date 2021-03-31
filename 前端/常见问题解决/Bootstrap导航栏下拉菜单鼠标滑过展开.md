# Bootstrap导航栏下拉菜单鼠标滑过展开

boostrap的导航栏不提供鼠标滑过展开，通过给类为dropdown的li标签添加和移除open类实现

代码示例：

```javascript
$(function () {
    $(".dropdown").mouseover(function () {
        $(this).addClass("open");
    });

    $(".dropdown").mouseleave(function(){
        $(this).removeClass("open");
    })

})
```

