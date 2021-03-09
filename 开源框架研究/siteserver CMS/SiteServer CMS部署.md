SiteServer CMS v6.15.51



### 在安装SiteServer CMS之前，需要确保已经完成了以下工作：

- 已经安装好了IIS6.0或以上版本；√
- 已经安装好了.net framework 4.5.2或以上版本；√
- 已经安装好了MySql、Sql Server、PostgreSQL或Oracle四种数据库的任何版本；√



安装启动IIS6.0

**方法/步骤**

1、打开 控制面板 点击程序下方的卸载程序；

2、进去程序和功能界面之后，点击打开或关闭Windows功能；

3、进去打开或关闭Windows功能之后，可以看到Internet信息服务默认是没有勾选的；

4、将Internet信息服务里面所属的FTP服务器，Web管理工具，**万维网服务全部勾选上**，点击确定就开启了IIS功能；

5、点击确定之后，开启Wndows功能需要等待一下，等待更改功能完成之后，就成功开启了IIS功能；

6、在桌面点击Windows图标，在所有程序里面去搜索IIS，点击打开Internet信息服务（IIS）管理器就可以打开了。



安装SiteServer CMS系统可以按以下四步进行：

- 1、下载SiteServer CMS系统安装包；
- 2、新建空数据库；
- 3、新建IIS站点；
- 4、运行SiteServer CMS安装程序；

下面就按照这四步展开来详细讲解。





IIS部署“不能在此路径中使用此配置节。如果在父级别上锁定了该节，便会出现这种情况”问题解决：

CMD窗口分别输入：

```cmd
%windir%\system32\inetsrv\appcmd unlock config -section:system.webServer/handlers

%windir%\system32\inetsrv\appcmd unlock config -section:system.webServer/modules
```



基本设置中应用程序池选择：.NET v4.5



### 运行SiteServer CMS安装程序

打开浏览器（强烈建议Chrome或Firefox），因为刚才在第3步新建IIS站点时端口填写的是99，所以浏览器地址栏输入： http://localhost:99/siteserver/ 回车之后进入SiteServer CMS安装界面。



接下来就是可视化操作。

具体安装详见：

https://sscms.com/docs/v6/getting-started/#/how-to-install-siteserver-cms





### 如何登录CMS？

#### 1、安装完成时直接登录

SiteServer CMS 在产品安装完成后，会出现进入后台的链接。

点击即可进入登录CMS后台界面。

然后输入正确的帐号密码即可。

#### 2、直接输入登录地址登录

平时通过系统后台维护内容时，只需要在浏览器里输入以下地址：

http://www.abc.com/siteserver/login.aspx

或者输入IP：

http://127.0.0.1/siteserver/login.aspx

即可进入上图登录页面，然后输入帐号密码即可。

> 注意：域名www.abc.com或IP地址127.0.0.1需要替换成网站实际的域名或IP。





### 如何创建站点？

SiteServer CMS 创建站点的方式有三种，在这以“使用在线站点模板创建站点”方式来讲解如何创建一个站点的具体步骤。

详见文档：

### https://sscms.com/docs/v6/getting-started/#/how-to-create-website



### 浏览已创建的网站首页

hszh：子站点名，可以自定义的部分

http://localhost:99/hszh/index.html