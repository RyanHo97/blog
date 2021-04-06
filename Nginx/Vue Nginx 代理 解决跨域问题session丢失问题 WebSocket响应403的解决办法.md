# Vue Nginx 代理 解决跨域问题session丢失问题 WebSocket响应403的解决办法

博客地址：https://blog.csdn.net/jingogfhvk001/article/details/96305228



前期准备：

nginx官网下载地址太慢：http://nginx.org/en/download.html

百度网盘（windows 1.19.7）：

链接：https://pan.baidu.com/s/1ELTPU4T-io-6zl5pdgiC4Q 
提取码：vvrn 



start nginx 启动nginx
nginx -s reload  ：修改配置后重新加载生效
nginx -s reopen  ：重新打开日志文件
nginx -t -c /path/to/nginx.conf 测试nginx配置文件是否正确

关闭nginx：
nginx -s stop  :快速停止nginx
         quit  ：完整有序的停止nginx



1.修改 Nginx 服务器 config/nginx.conf 文件



```nginx
#设置访问的web应用列表

upstream apiserver{

server api.douban.com;

}

upstream adminserver{

server 10.84.77.52:8080;

}

 

server {
listen 80;

server_name localhost;

# root /usr/local/nginx/html/; #可以指定项目自定义路径

#charset koi8-r;

 

#access_log logs/host.access.log main;

 

location ^~ /api/ {

#** api前面的部分将被替换成localserver的地址 **

proxy_pass https://api.douban.com/;

proxy_set_header X-Real-IP $remote_addr;

}

 

location //george/ {

#** web前面的部分将被替换成localserver的地址 **

proxy_pass http://adminserver/george/;

proxy_cookie_path /george /george;#这里的路径要注意对应关系解决session丢失

#proxy_set_header Host $http_host; #下面是解决js css引用不到问题

proxy_set_header X-Real-IP $remote_addr;

proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;

proxy_set_header Origin ""; #WebSocket响应403的解决办法

}

 

location / {

#vue history 模式需要配置 否则404错误

try_files $uri $uri/ /index.html;

}

#error_page 404 /404.html;
```





WebSocket响应403的解决办法加一条 proxy_set_header Origin "";

特别注意：

url的/问题

在nginx中配置proxy_pass时，当在后面的url加上了/，相当于是绝对根路径，则nginx不会把location中匹配的路径部分代理走;如果没有/，则会把匹配的路径部分也给代理走。

 

下面四种情况分别用http://192.168.1.4/proxy/test.html 进行访问。

第一种：

location /proxy/ {
     proxy_pass http://127.0.0.1:81/;

}

 

会被代理到http://127.0.0.1:81/test.html 这个url

 

第二咱(相对于第一种，最后少一个 /)

location /proxy/ {
     proxy_pass http://127.0.0.1:81;

}

会被代理到http://127.0.0.1:81/proxy/test.html 这个url

 

第三种：

location /proxy/ {
     proxy_pass http://127.0.0.1:81/ftlynx/;

}

会被代理到http://127.0.0.1:81/ftlynx/test.html 这个url。

 

第四种情况(相对于第三种，最后少一个 / )：

location /proxy/ {
     proxy_pass http://127.0.0.1:81/ftlynx;

}

会被代理到http://127.0.0.1:81/ftlynxtest.html 这个url