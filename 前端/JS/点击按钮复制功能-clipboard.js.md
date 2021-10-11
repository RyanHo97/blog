# 点击按钮复制功能-clipboard.js

日期：2021年10月11日

借鉴：https://blog.csdn.net/qq_24147051/article/details/106908326



#### （1）介绍

clipboard.js是一款轻量级的实现复制文本到剪贴板功能的JavaScript插件。通过该插件可以将输入框，文本域，DIV元素中的文本等文本内容复制到剪贴板中

clipboard.js支持主流的浏览器：chrome 42+; Firefox 41+; IE 9+; opera 29+; Safari 10+;

#### （2）clipboard复印内容的方式有

- 从target复印目标内容
- 通过function 要复印的内容
- 通过属性返回复印的内容

#### （3）clipboard使用实例

- 从target复印目标内容：

  ```html
  <!DOCTYPE html>
  <html lang="en">
    <head>
      <meta charset="UTF-8" />
      <title>target-div</title>
      <meta name="viewport" content="width=device-width, initial-scale=1" />
    </head>
    <body>
      <!-- 1. Define some markup -->
      <div>hello</div>
      <button
        class="btn"
        data-clipboard-action="copy"
        data-clipboard-target="div"
      >
        Copy
      </button>
  
      <!-- 2. Include library -->
      <script src="../dist/clipboard.min.js"></script>
  
      <!-- 3. Instantiate clipboard -->
      <script>
        var clipboard = new ClipboardJS('.btn');
  
        clipboard.on('success', function (e) {
          console.log(e);
        });
  
        clipboard.on('error', function (e) {
          console.log(e);
        });
      </script>
    </body>
  </html>
  
  ```

- 通过function 要复印的内容：

  ```html
  <!DOCTYPE html>
  <html lang="en">
    <head>
      <meta charset="UTF-8" />
      <title>function-text</title>
      <meta name="viewport" content="width=device-width, initial-scale=1" />
    </head>
    <body>
      <!-- 1. Define some markup -->
      <button class="btn">Copy</button>
  
      <!-- 2. Include library -->
      <script src="../dist/clipboard.min.js"></script>
  
      <!-- 3. Instantiate clipboard -->
      <script>
        var clipboard = new ClipboardJS('.btn', {
          text: function () {
            return 'to be or not to be';
          },
        });
  
        clipboard.on('success', function (e) {
          console.log(e);
        });
  
        clipboard.on('error', function (e) {
          console.log(e);
        });
      </script>
    </body>
  </html>
  ```

- 通过属性返回复印的内容:

  ```html
  <!DOCTYPE html>
  <html lang="en">
    <head>
      <meta charset="UTF-8" />
      <title>constructor-node</title>
      <meta name="viewport" content="width=device-width, initial-scale=1" />
    </head>
    <body>
      <!-- 1. Define some markup -->
      <div id="btn" data-clipboard-text="1">
        <span>Copy</span>
      </div>
  
      <!-- 2. Include library -->
      <script src="../dist/clipboard.min.js"></script>
  
      <!-- 3. Instantiate clipboard by passing a HTML element -->
      <script>
        var btn = document.getElementById('btn');
        var clipboard = new ClipboardJS(btn);
  
        clipboard.on('success', function (e) {
          console.log(e);
        });
  
        clipboard.on('error', function (e) {
          console.log(e);
        });
      </script>
    </body>
  </html>
  ```

  