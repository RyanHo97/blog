JavaScript邮箱格式检查验证

#### 准备一个邮箱输入框和一个验证按钮

```html
<div>
    <input id="emailaddress" placeholder="邮箱地址" type="text">
    <button onclick="emailVerification()">
        <label>邮箱验证</label>
    </button>
    <p id="tips">
        提示信息
    </p>
</div>
```

#### 接下来是JS部分

```javascript
var reg = RegExp(/^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/);//正则匹配方法

function emailVerification() { 

      var emailAddr = $("#emailaddress").val();//取得输入邮箱

      if(emailAddr == "" || emailAddr == null){
        $("#tips").text("userEmail不为空");
        return;
      }

      if(reg.test(emailAddr) == false){
        $("#tips").text("邮箱格式错误");
        return;
      }

      console.log("验证通过");

      //可在此写后端AJAX代码
}
```

