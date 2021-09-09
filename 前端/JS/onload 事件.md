# onload 事件

## 实例

在页面加载后立即执行 JavaScript：

```html
<!DOCTYPE html>
<html>
<body onload="myFunction()">

<h1>Hello World!</h1>

<script>
function myFunction() {
  alert("Page is loaded");
}
</script>

</body>
</html>
```



## 定义和用法

onload 事件在对象被加载后发生。

onload 最常用于 <body> 元素中，用于在网页完全加载所有内容（包括图像、脚本文件、CSS 文件等）后执行脚本。

onload 事件可用于检查访问者的浏览器类型和浏览器版本，并根据这些信息加载网页的正确版本。

onload 事件也可用于处理 cookie (请参阅下面的更多实例).



## 技术细节

| 冒泡：             | 不支持                                                       |
| ------------------ | ------------------------------------------------------------ |
| 可取消：           | 不支持                                                       |
| 事件类型：         | 如果从用户界面生成，[UiEvent](https://www.w3school.com.cn/jsref/obj_uievent.asp)。否则 [Event](https://www.w3school.com.cn/jsref/obj_event.asp)。 |
| 支持的 HTML 标签： | <body>, <frame>, <iframe>, <img>, <input type="image">, <link>, <script>, <style> |
| DOM 版本：         | Level 2 Events                                               |

