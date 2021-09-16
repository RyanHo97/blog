# QRCode.js：使用 JavaScript 生成二维码

## 什么是 QRCode.js？

QRCode.js 是一个用于生成二维码的 JavaScript 库。主要是通过获取 DOM 的标签,再通过 HTML5 Canvas 绘制而成,不依赖任何库。

**Github** 地址：https://github.com/davidshimjs/qrcodejs

------

## 基本用法

```html
<div id="qrcode"></div>
<script type="text/javascript">
new QRCode(document.getElementById("qrcode"), "http://www.runoob.com");  // 设置要生成二维码的链接
</script>
```

或者使用一些可选参数设置：

```javascript
var qrcode = new QRCode("test", {
    text: "http://www.runoob.com",
    width: 128,
    height: 128,
    colorDark : "#000000",
    colorLight : "#ffffff",
    correctLevel : QRCode.CorrectLevel.H
});
```

同样我们可以使用以下方法：

```javascript
qrcode.clear(); // 清除代码
qrcode.makeCode("http://www.w3cschool.cc"); // 生成另外一个二维码
```

------

## 浏览器支持

支持该库的浏览器有：IE6~10, Chrome, Firefox, Safari, Opera, Mobile Safari, Android, Windows Mobile, 等。

------

## 实例代码

### HTML 代码

```html
<input id="text" type="text" value="http://www.runoob.com" /><br />
<div id="qrcode"></div>
```

### CSS 代码

```css
#qrcode {
width:160px;
  height:160px;
  margin-top:15px;
}  
```

### JavaScript 代码

```javascript
var qrcode = new QRCode("qrcode");

function makeCode () {      
    var elText = document.getElementById("text");
    
    if (!elText.value) {
        alert("Input a text");
        elText.focus();
        return;
    }
    
    qrcode.makeCode(elText.value);
}

makeCode();

$("#text").
on("blur", function () {
    makeCode();
}).
on("keydown", function (e) {
    if (e.keyCode == 13) {
        makeCode();
    }
});
```



文章转载：https://www.runoob.com/w3cnote/javascript-qrcodejs-library.html