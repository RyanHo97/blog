# Jsoup爬虫入门实战

前言

视频名称：【狂神说Java】Jsoup爬虫入门实战

视频地址：https://www.bilibili.com/video/BV1La4y1x7Wm

笔记作者：Ryanho97.github.io

笔记时间：2021/03/09



## 正文

爬取数据：（获取请求返回的页面信息，筛选出我们想要的数据就可以了！）

pom.xml

```xml
 	<!-- Jsoup解析网页 -->
	<dependency>
      <groupId>org.jsoup</groupId>
      <artifactId>jsoup</artifactId>
      <version>1.9.2</version>
    </dependency>
```



创建Jsoupdemo项目

- 示例代码:

```java
package com.ryan.pachong.jsoupdemo.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HtmlParseUtil {
    public static void main(String[] args) throws IOException {
        // 获得请求 http://search.jd.com/Search?keyword=java
        // 前提，需要联网，ajax 不能获取到！

        String url = "http://search.jd.com/Search?keyword=java";
        // 解析网页(Jsoup返回Document就是浏览器Document对象)
        Document document = Jsoup.parse(new URL(url), 30000);
        // 所有你在js中使用的方法，这里都能用!
        Element element = document.getElementById("J_goodsList");

        System.out.println(element.html());

        // 获取所有的li元素
        Elements elements = element.getElementsByTag("li");
        // 获取元素中的内容,这里el 就是每一个li标签了!
        for (Element el : elements) {
            //关于这种图片特别多的网站，所有的图片都是延迟加载的!
            String img = el.getElementsByTag("img").eq(0).attr("src");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String title = el.getElementsByClass("p-name").eq(0).text();

            System.out.println("================================================");
            System.out.println(img);
            System.out.println(price);
            System.out.println(title);



        }

    }
}

```

问题：

```txt
Connected to the target VM, address: '127.0.0.1:57859', transport: 'socket'
Disconnected from the target VM, address: '127.0.0.1:57859', transport: 'socket'
Exception in thread "main" java.lang.NullPointerException
	at com.ryan.pachong.jsoupdemo.utils.HtmlParseUtil.main(HtmlParseUtil.java:23)

Process finished with exit code 1
```

问题解决

因为京东做了防爬虫，所以换了一个国美来爬，测试成功。

- 示例代码：

```java
package com.ryan.pachong.jsoupdemo.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class pcTest {
    public static void main(String[] args) throws IOException {
        String url = "https://search.gome.com.cn/search?question=java";
        //product-box
        Document document = Jsoup.parse(new URL(url), 30000);

        Element element = document.getElementById("product-box");

        System.out.println(element.html());



    }
}

```

- 控制台的部分结果：

```txt
<li class="product-item" skuid="pop8010867451" pid="A0006369748"> 
 <ul class="arbitrage clearfix"></ul> 
 <div class="item-tab-warp"> 
  <p class="item-pic"><a class="emcodeItem item-link" target="_blank" track="产品列表图片" href="//item.gome.com.cn/A0006369748-pop8010867451.html?search_id=sdw233vyv434" title="Huawei/华为T2281 移动3G直板按键手机QQ上网 JAVA(黑色 官方标配)"><img gome-src="//gfs17.gomein.net.cn/T1TCVbBmbT1RCvBVdK_210.jpg" alt="Huawei/华为T2281 移动3G直板按键手机QQ上网 JAVA(黑色 官方标配)" src="//app.gomein.net.cn/images/grey.gif"></a></p> 
  <div class="item-price-info"> 
   <div class="item-price"> 
    <span class="price"></span> 
   </div> 
  </div> 
  <p class="item-name"><a class="emcodeItem item-link" href="//item.gome.com.cn/A0006369748-pop8010867451.html?search_id=sdw233vyv434" title="Huawei/华为T2281 移动3G直板按键手机QQ上网 JAVA(黑色 官方标配)" target="_blank">Huawei/华为T2281 移动3G直板按键手机QQ上网 <label style="color:red;">JAVA</label>(黑色 官方标配)</a></p> 
  <p class="item-comment-dispatching"> <a href="//item.gome.com.cn/A0006369748-pop8010867451.html#j-comment-section" target="_blank" class="comment">1</a> </p> 
  <p class="item-shop"> <a class="nname" target="_blank" href="//mall.gome.com.cn/80015337/">仕伟手机专营店</a> </p> 
  <p class="item-option clearfix"> <span class="add-contrast display-page-compare-checkbox"><i class="icon"></i></span> <span class="add-collection"><i class="icon"></i></span> <span class="add-cart addTo-cart"><i class="icon"></i></span> <span title="在线客服" class="gomekf online-server" customer-entry="product" shopid="80015337" skuid="pop8010867451" productid="A0006369748" categoryid="cat31665542_cat10000012_cat10000070" brandid="15L9"><i class="icon"></i></span> </p> 
 </div> </li> 
<li class="product-item" skuid="pop8010855900" pid="A0006368397"> 
 <ul class="arbitrage clearfix"></ul> 
 <div class="item-tab-warp"> 
  <p class="item-pic"><a class="emcodeItem item-link" target="_blank" track="产品列表图片" href="//item.gome.com.cn/A0006368397-pop8010855900.html?search_id=sdw233vyv434" title="ZTE/中兴 U219 移动3G 学生备用手机 电子书 JAVA(浅灰色 官方标配)"><img gome-src="//gfs17.gomein.net.cn/T13Xd_BgWT1RCvBVdK_210.jpg" alt="ZTE/中兴 U219 移动3G 学生备用手机 电子书 JAVA(浅灰色 官方标配)" src="//app.gomein.net.cn/images/grey.gif"></a></p> 
  <div class="item-price-info"> 
   <div class="item-price"> 
    <span class="price"></span> 
   </div> 
  </div> 
  <p class="item-name"><a class="emcodeItem item-link" href="//item.gome.com.cn/A0006368397-pop8010855900.html?search_id=sdw233vyv434" title="ZTE/中兴 U219 移动3G 学生备用手机 电子书 JAVA(浅灰色 官方标配)" target="_blank">ZTE/中兴 U219 移动3G 学生备用手机 电子书 <label style="color:red;">JAVA</label>(浅灰色 官方标配)</a></p> 
  <p class="item-comment-dispatching"> <a href="//item.gome.com.cn/A0006368397-pop8010855900.html#j-comment-section" target="_blank" class="comment">0</a> </p> 
  <p class="item-shop"> <a class="nname" target="_blank" href="//mall.gome.com.cn/80015337/">仕伟手机专营店</a> </p> 
  <p class="item-option clearfix"> <span class="add-contrast display-page-compare-checkbox"><i class="icon"></i></span> <span class="add-collection"><i class="icon"></i></span> <span class="add-cart addTo-cart"><i class="icon"></i></span> <span title="在线客服" class="gomekf online-server" customer-entry="product" shopid="80015337" skuid="pop8010855900" productid="A0006368397" categoryid="cat31665542_cat10000012_cat10000070" brandid="147z"><i class="icon"></i></span> </p> 
 </div> </li> 
<li class="product-item" skuid="pop8010865942" pid="A0006369574"> 
 <ul class="arbitrage clearfix"></ul> 
 <div class="item-tab-warp"> 
  <p class="item-pic"><a class="emcodeItem item-link" target="_blank" track="产品列表图片" href="//item.gome.com.cn/A0006369574-pop8010865942.html?search_id=sdw233vyv434" title="Huawei/华为 T552 移动G3 老人 学生 备用直板手机 JAVA(金色 官方标配)"><img gome-src="//gfs17.gomein.net.cn/T1gIEQB7xT1RCvBVdK_210.jpg" alt="Huawei/华为 T552 移动G3 老人 学生 备用直板手机 JAVA(金色 官方标配)" src="//app.gomein.net.cn/images/grey.gif"></a></p> 
  <div class="item-price-info"> 
   <div class="item-price"> 
    <span class="price"></span> 
   </div> 
  </div> 
  <p class="item-name"><a class="emcodeItem item-link" href="//item.gome.com.cn/A0006369574-pop8010865942.html?search_id=sdw233vyv434" title="Huawei/华为 T552 移动G3 老人 学生 备用直板手机 JAVA(金色 官方标配)" target="_blank">Huawei/华为 T552 移动G3 老人 学生 备用直板手机 <label style="color:red;">JAVA</label>(金色 官方标配)</a></p> 
  <p class="item-comment-dispatching"> <a href="//item.gome.com.cn/A0006369574-pop8010865942.html#j-comment-section" target="_blank" class="comment">0</a> </p> 
  <p class="item-shop"> <a class="nname" target="_blank" href="//mall.gome.com.cn/80015337/">仕伟手机专营店</a> </p> 
  <p class="item-option clearfix"> <span class="add-contrast display-page-compare-checkbox"><i class="icon"></i></span> <span class="add-collection"><i class="icon"></i></span> <span class="add-cart addTo-cart"><i class="icon"></i></span> <span title="在线客服" class="gomekf online-server" customer-entry="product" shopid="80015337" skuid="pop8010865942" productid="A0006369574" categoryid="cat31665542_cat10000012_cat10000070" brandid="15L9"><i class="icon"></i></span> </p> 
 </div> </li> 
<li class="product-item" skuid="pop8010969003" pid="A0006381129"> 
 <ul class="arbitrage clearfix"></ul> 
 <div class="item-tab-warp"> 
  <p class="item-pic"><a class="emcodeItem item-link" target="_blank" track="产品列表图片" href="//item.gome.com.cn/A0006381129-pop8010969003.html?search_id=sdw233vyv434" title="ZTE/中兴 U235B 移动3G手机直板按键手机JAVA系统 电子书(黑色蓝边)"><img gome-src="//gfs17.gomein.net.cn/T1MLdbBTCT1RCvBVdK_210.jpg" alt="ZTE/中兴 U235B 移动3G手机直板按键手机JAVA系统 电子书(黑色蓝边)" src="//app.gomein.net.cn/images/grey.gif"></a></p> 
  <div class="item-price-info"> 
   <div class="item-price"> 
    <span class="price"></span> 
   </div> 
   
   
...

 <p class="item-shop"> <a class="nname" target="_blank" href="//mall.gome.com.cn/80015337/">仕伟手机专营店</a> </p> 
  <p class="item-option clearfix"> <span class="add-contrast display-page-compare-checkbox"><i class="icon"></i></span> <span class="add-collection"><i class="icon"></i></span> <span class="add-cart addTo-cart"><i class="icon"></i></span> <span title="在线客服" class="gomekf online-server" customer-entry="product" shopid="80015337" skuid="pop8010969002" productid="A0006381129" categoryid="cat31665542_cat10000012_cat10000070" brandid="147z"><i class="icon"></i></span> </p> 
 </div> </li>
```



后期爬视频的解决方案博客

https://blog.csdn.net/weixin_40986713/article/details/107769979

