<stl:itemTemplate> 列表项
<stl:itemTemplate
    type="列表项类型"
    selected="列表当前选定项类型"
    selectedValue="当前选定项的值">
</stl:itemTemplate>
#说明
通过 stl:itemTemplate 标签在模板中控制列表中每一项的显示内容及样式

type属性为Item、AlternatingItem、Separator三种类型的列表项在列表中最多只能有一个，SelectedItem类型的列表项可以有零个或多个。

SelectedItem类型的列表项所显示的内容由 selected 属性控制，默认当前内容为选中项。

<stl:itemTemplate> 标签对应的实体为{stl:itemTemplate}。

#父标签
<stl:itemTemplate> 标签用于显示列表项，必须嵌套在列表标签中使用，列表标签清单如下：

父标签	说明
stl:channels	栏目列表
stl:contents	内容列表
stl:each	列表项循环
stl:pageChannels	翻页栏目列表
stl:pageContents	翻页内容列表
stl:pageSqlContents	翻页数据库列表
stl:sqlContents	数据库列表
stl:sites	站点列表
#属性
属性	说明
type	列表项类型
selected	列表当前选定项类型
selectedValue	当前选定项的值
#type - 列表项类型
列表项的类型

"alternatingItem" 为列表的交替项提供模板
"footer" 为列表提供底部模板
"header" 为列表提供头部模板
"item" 为列表的项提供模板
"selectedItem" 为列表当前选定项提供模板
"separator" 为列表各项之间的分隔符提供模板
#selected - 列表当前选定项类型
决定 SelectedItem 的选定内容项类型

"channelName" 指定栏目名称的项
"current" 当前项为选中项
"file" 带附件项为选中项
"image" 带图片项为选中项
"isColor" 醒目项为选中项
"isHot" 热点项为选中项
"isRecommend" 推荐项为选中项
"isTop" 置顶项为选中项
"top" 当前栏目从首页向下的栏目为选中项
"up" 当前栏目的上级栏目为选中项
"video" 带视频项为选中项
"n" n 为数字，代表列表的第 n 项为显示选择项，如：1
"n,m,p..." 字母为数字，代表列表的第 n,m,p 等项为选择项，如：2,4,6
"n-m" n 及 m 为数字，代表列表的第 n 项到第 m 项为选择项，如：2-8
#selectedValue - 当前选定项的值
如果 selected 为 ChannelName,selectedValue 应该为栏目名称

#示例
#显示指定的内容列表
下面的例子显示栏目"新闻"下的内容列表，对设置为醒目的内容采用红色显示。

<stl:contents channelIndex="新闻" totalNum="5">
    <stl:itemTemplate type="Item">
        <stl:a target="_blank"></stl:a><br />
    </stl:itemTemplate>
    <stl:itemTemplate type="SelectedItem" selected="IsColor">
        <stl:a style="color:red" target="_blank"></stl:a><br />
    </stl:itemTemplate>
</stl:contents>
解析后的 HTML 代码：

<a href="/news/4.html" target="_blank">我是带图片的内容</a><br>
<a href="/news/3.html" target="_blank">我也是带图片的内容</a><br>
<a href="/news/2.html" style="color:red" target="_blank">我也是带图片的内容</a><br>
<a href="/news/1.html" target="_blank">我是带图片的内容</a><br>
#定制列表中交替项的显示内容
下面的例子显示栏目索引为"新闻"的所有内容的列表，列表的交替项与列表项的显示颜色有所不同。

<stl:contents channelIndex="新闻" totalNum="10">
    <stl:itemTemplate type="Item">
        <stl:a><stl:content type="Title"></stl:content></stl:a><br />
    </stl:itemTemplate>
    <stl:itemTemplate type="AlternatingItem">
        <stl:a style="color:red"><stl:content type="Title"></stl:content></stl:a> <br />
    </stl:itemTemplate>
</stl:contents>
解析后的 HTML 代码：

<a href="/news/4.html">我是带图片的内容</a><br>
<a href="/news/3.html" style="color:red">我也是带图片的内容</a> <br>
<a href="/news/2.html">我也是带图片的内容</a><br>
<a href="/news/1.html" style="color:red">我是带图片的内容</a> <br>
#显示指定的栏目列表
下面的例子显示所有栏目组别为"STL 标签"的栏目列表，各栏目项间用" | "分隔。

<stl:channels groupChannel="STL" isTotal="true">
  <stl:itemTemplate type="Item">
    <stl:a><stl:channel type="title"></stl:channel></stl:a>
  </stl:itemTemplate>
  <stl:itemTemplate type="Separator">
    |
  </stl:itemTemplate>
</stl:channels>
解析后的 HTML 代码：

<a href="/channels/4.html">STL标签</a>
    |
<a href="/channels/79.html">STL实体</a>
#显示指定的内容列表
下面的例子显示栏目"新闻"下的内容列表，对第 2 条至第 4 条内容用红色显示。

<stl:contents channelIndex="新闻" totalNum="5">
  <stl:itemTemplate type="Item">
      <stl:a target="_blank"></stl:a><br />
  </stl:itemTemplate>
  <stl:itemTemplate type="SelectedItem" selected="2-4">
      <stl:a style="color:red" target="_blank"></stl:a><br />
  </stl:itemTemplate>
</stl:contents>
解析后的 HTML 代码：

<a href="/news/4.html" target="_blank">我是带图片的内容</a><br>
<a href="/news/3.html" style="color:red" target="_blank">我也是带图片的内容</a><br>
<a href="/news/2.html" style="color:red" target="_blank">我也是带图片的内容</a><br>
<a href="/news/1.html" style="color:red" target="_blank">我是带图片的内容</a><br>
