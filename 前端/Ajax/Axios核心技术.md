# Axios核心技术

前言

课程名称：尚硅谷_axios核心技术

课程地址：https://www.bilibili.com/video/BV1NJ41197u6

笔记作者：RyanHo97

笔记时间：2021年6月6日

## 正文

### 第1章：HTTP相关

#### 1.1 MDN文档

https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Overview

#### 1.2 HTTP请求交互基本过程

​             ------------请求行、请求头、请求体----------->

客户端                                                                                   服务器

​             <---------------状态行、响应头、实体内容-------

1. 前后应用从浏览器端向服务器发送HTTP请求（请求报文）
2. 后台服务器接收到请求后，调度服务器应用处理请求，向浏览器端返回HTTP响应（响应报文）
3. 浏览器端接收到响应，解析显示响应体/调用监视回调
#### 1.3 HTTP请求报文

1. 请求行：
   - method url
   - GET /product_detail?id=2
   - POST /login
2. 多个请求头
   - Host:www.baidu.com
   - Cookie:BAIDUID=AD3B0FA706E;BIDUPSID=AD3B0FA706;
   - Content-Type:application/x-www-form-urlencoded 或者 application/json
3. 请求体
   - username=tom&pwd=123
   - {"username":"tom","pwd":123}

#### 1.4 HTTP响应报文

1. 响应状态行：status statusText

2. 多个响应头

   Content-Type：text/html;charset=utf-8

   Set-Cookie:BD_CK_SAM=1;path=/

3. 响应体

   html 文本/json 文本/js/css/图片...

#### 1.5 post请求体参数格式

1. Content-Type:application/x-www-form-urlencoded;charset=utf-8

   用于键值对参数，参数的键值用=连接，参数之间用&连接

   例如：name=%E5%B0%8F%E6%98%8E&age=12

2. Content-Type:application/json;charset=utf-8

   用于json字符串参数

   例如:{"name":"%E5%B0%8F%E6%98%8E","age":12}

3. Content-Type:multipart/form-data

#### 1.6 常见的响应状态码

| 状态码 | 对应英文              | 对应释义                           |
| ------ | --------------------- | ---------------------------------- |
| 200    | OK                    | 请求成功。一般用于GET与POST请求    |
| 201    | Created               | 已创建。成功请求并创建了新的资源   |
| 401    | Unauthorized          | 未授权/请求要求用户的身份认证      |
| 404    | Not Found             | 服务器无法根据客户端的请求找到资源 |
| 500    | Internal Server Error | 服务器内部错误，无法完成请求       |

#### 1.7 不同类型的请求及其作用

1. GET：从服务器端读取数据
2. POST：向服务器端添加新数据
3. PUT：更新服务器端已经数据
4. DELETE：删除服务器端数据

#### 1.8 API的分类

1. REST API： restful

   （1）发送请求进行CRUD那个操作由请求方式来决定

   （2）同一个请求路径可以进行多个操作

   （3）请求方式会用到GET/POST/PUT/DELETE

2. 非REST API： restless

   （1）请求方式不决定请求的CRUD操作

   （2）一个请求路径只对应一个操作

   （3）一般只有GET/POST

#### 1.9 使用json-server搭建REST API

地址：https://github.com/typicode/json-server

安装（全局）：npm install -g json-server

创建db.json：

```json
{
  "posts": [
    { "id": 1, "title": "json-server", "author": "typicode" }
  ],
  "comments": [
    { "id": 1, "body": "some comment", "postId": 1 }
  ],
  "profile": { "name": "typicode" }
}
```

基于文件产生接口：

```bash
json-server --watch db.json
```

启动后会生成接口：

```bash
  Resources
  http://localhost:3000/posts
  http://localhost:3000/comments
  http://localhost:3000/profile

  Home
  http://localhost:3000
```
#### 1.10 使用axios访问测试

```javascript
 <script src="https://cdn.bootcdn.net/ajax/libs/axios/0.21.1/axios.min.js"></script>
```

代码示例：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
</head>
<body>
  <div>
    <button onclick="testGet()">GET请求</button>
    <button onclick="testPost()">POST请求</button>
    <button onclick="testPut()">PUT请求</button>
    <button onclick="testDelete()">DELETE请求</button>
  </div>

  <script src="https://cdn.bootcdn.net/ajax/libs/axios/0.21.1/axios.min.js"></script>
  <script>
    function testGet(){
      axios.get('http://localhost:3000/posts')
        .then(response =>{
          console.log('/posts',response.data)
        })
    }

    function testPost(){
      axios.post('http://localhost:3000/posts',{"title":"json-server3","author":"typicode3"})
        .then(response =>{
          console.log('/posts post',response.data)
        })
    }

    function testPut(){
      axios.put('http://localhost:3000/posts/3',{"title":"json-server...","author":"typicode..."})
        .then(response =>{
          console.log('/posts post',response.data)
        })
    }

    function testDelete(){
      axios.delete('http://localhost:3000/posts/3')
        .then(response =>{
          console.log('/posts post',response.data)
        })
    }
  </script>
  <script>
  
  </script>
</body>
</html>
```
### 第2章：XHR的理解和使用

#### 2.1 MDN文档

https://developer.mozilla.org/zh-CN/docs/Web/API/XMLHttpRequest

#### 2.2 理解

1. 使用XMLHttpRequest(XHR)对象可以与服务器交互，也就是发送ajax请求
2. 前端可以获取到数据，而无需让整个的页面刷新。
3. 这使得Web页面可以只更新页面的局部，而不影响用户的操作。

#### 2.3 区别一般http请求与ajax请求

1. ajax请求是一种特别的http请求

2. 对服务器端来说，没有任何区别，区别在浏览器端

3. 浏览器端发请求：只有XHR或fetch发出的才是ajax请求，其他所有的都是非ajax请求

4. 浏览器端接收到响应

   （1）一般请求：浏览器一般会直接显示响应体数据，也就是我们常说的刷新/跳转页面

   （2）ajax请求：浏览器不会对界面进行任何更新操作，只是调用监视的回调函数并传入响应相关数据
   
#### 2.4 API

1. XMLHttpRequest()：创建XHR对象的构造函数
2. status：响应状态码值，比如200，404
3. statusText：响应状态文本
4. readyState：标识请求状态的只读属性
5. onreadystatechange：绑定readyState改变的监听
