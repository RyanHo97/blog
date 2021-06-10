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
