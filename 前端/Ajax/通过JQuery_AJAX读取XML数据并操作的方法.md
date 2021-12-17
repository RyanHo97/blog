# 通过JQuery_AJAX读取XML数据并操作的方法

**使用此方式加载数据的**

**优势**：读取生成好的静态XML数据文件可以有效的减轻对API接口以及数据库的访问压力，而且提速非常明显。

**劣势**：需要实时更新XML数据文件，会比直接读取数据库的时效性差。



**准备工作**

1.XML文件：data.xml

```xml
<?xml version="1.0" encoding="utf-8" ?>

<channel>
  <item>
    <title>标题1</title>
    <link>http://www.w3school.com.cn/rss</link>
    <description>New RSS tutorial on W3School</description>
  </item>
  <item>
    <title>标题2</title>
    <link>http://www.w3school.com.cn/xml</link>
    <description>New XML tutorial on W3School</description>
  </item>
</channel>
```



2.AJAX代码

```xml
$.ajax({
            type: "GET",
            url: "data.xml",//路径+文件
            dataType: "XML",
            timeout: 0,
            success: function (data) {      
            
            	var jqobj = $(data);//先把data变成可操作的对象
            	
            	jqobj.find("channel").find("item").each(function(index,ele){//遍历方法
            		var newsTitle = $(this).children("title");//获取标题
                    var titleText = newsTitle.text();
                    
                    //创建html代码var
                    
                    //append方法添加以上代码
            	}
            
            },
            error: function (e) {
                console.log(e.responseText);
            }
});
```

