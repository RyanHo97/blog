# SiteServer STL 语言

## 介绍

TIP

页面右上方 **分类** 或者 **索引** 下拉菜单可以快速定位到标签参考详情页。

STL语言，或者STL标签，全称为 SiteServer Template Language（SiteServer 模版语言），是 SiteServer CMS 系统使用的模版标签语言。

你可以把STL语言理解为带有特定意义的占位符，这些占位符通过标签（元素及实体）来标记出需要调取并显示的网站数据及功能；在生成静态页面的过程中，SiteServer CMS 系统通过STL解析引擎解析这些占位符，从站点中获取对应的数据，最终将占位符替换为带有数据或功能的HTML标签并在服务器中生成对应的静态页面文件。

SiteServer CMS 系统的核心由内容管理与内容解析两部分组成，STL语言就是内容管理与内容解析的桥梁，将后台管理的各种动态数据最终解析为用户能访问的静态页面。

除了将后台的动态数据解析为前台的静态页面，STL语言还能够实现诸如功能互动、动态显示、数据统计、数据库解析等一系列功能；除了 SiteServer CMS 系统自带的STL标签，各类插件也拥有自己的STL标签，用以实现不同的功能。

### [#](https://sscms.com/docs/v6/stl/guide/#stl语言规则)STL语言规则

和 HTML 语言一样，STL语言也是一种标准通用标记语言，采用与 HTML 语言一致的语法和规则。

STL语言并不复杂，但功能强大，其主要规则如下：

- **标签不区分大小写**

STL标签是不区分大小写的，和 HTML 标签一样，`<stl:a>` 和 `<STL:A>` 是相同的。

- **属性值区分大小写**

STL标签的属性值是区分大小写的，例如 `<stl:a channelIndex="News">` 和 `<stl:a channelIndex="NEWS">` 是不同的。

- **结束标记可以省略**

与 HTML 一样，在没有子标签的情况下，STL 可以省略结束标记。例如 `<stl:value></stl:value>` 与 `<stl:value />` 是一致的。

- **标签可以嵌套标签**

与 HTML 一样，STL 的标签可以相互嵌套，将一个或多个STL标签放到其他STL标签内部。例如 `<stl:a><stl:content type="title"></stl:content></stl:a>` 。

### [#](https://sscms.com/docs/v6/stl/guide/#元素及实体)元素及实体

STL标签由元素及实体组成，元素以尖括号 **`<>`** 作为标记，实体以大括号 **`{}`** 作为标记。

例如显示内容标题可以采用STL 元素： `<stl:content type="title"></stl:content>` 也可以采用STL 实体： `{stl:content type="title"}` 或者内容实体的简写： `{content.title}`。

STL元素和STL实体的最大区别在于元素能够嵌套子标签而实体无法嵌套子标签，例如链接标签 `<stl:a channelIndex="新闻">News</stl:a>` （将解析为HTML A标签）无法通过实体 `{stl:a channelIndex="新闻"}` （将解析为对应的链接地址字符串）表示。

在模板中你可以使用元素也可以使用实体，通常情况下在独立使用时采用STL元素，在嵌入标签属性时采用STL实体，例如独立使用时采用：`<stl:content type="summary"></stl:content>`，嵌入属性时采用：`<stl:a title="{stl:content type=summary}">`。

STL标签的属性值使用英文双引号标识，例如：`<stl:content type="title"></stl:content>`，STL实体的属性可以使用英文双引号、英文单引号或者无标识，例如：`{stl:content type="title"}`，`{stl:content type='title'}`或者`{stl:content type=title}`均为正确的写法。

### [#](https://sscms.com/docs/v6/stl/guide/#地址通配符)地址通配符

在STL标签中，地址使用通配符（“~”）和（“@”）来进行存储和读取，您可以使用通配符（“~”）来表示应用程序的根目录，使用通配符（“@”）来表示当前站点的域名地址，而不需要将地址硬编码为文件的绝对地址。

例如，您可以使用 `<stl:a href="~/index.html">主站</stl:a>` 生成指向到主站点index.html文件的链接，使用 `<stl:a href="@/index.html">本站</stl:a>` 生成指向到当前站点index.html文件的链接。

### [#](https://sscms.com/docs/v6/stl/guide/#插件)插件

《STL语言参考手册》仅列出了 SiteServer CMS 系统自带标签，不包含具体插件的标签使用说明。

插件相关标签的使用方法请参考对应的插件文档。







## 术语

你可能会在文档中碰到一些陌生的概念，本节列出了文档中常见的术语，方便查阅。

### [#](https://sscms.com/docs/v6/stl/guide/glossary.html#站点-site)站点(Site)

即网站，SiteServer CMS 是网站群系统，会为每个站点分配独立的文件目录、栏目架构以及内容数据。

主站点指站点目录在 SiteServer CMS 根目录的站点，只能创建一个；子站点指拥有单独文件夹作为站点目录的站点，可以创建任意多个，同时子站点还可以创建下级站点，下级站点的站点文件夹存储于上级站点文件夹内。

### [#](https://sscms.com/docs/v6/stl/guide/glossary.html#栏目-channel)栏目(Channel)

栏目也叫频道或者菜单，用于将站点的内容进行归类存放。栏目与文件夹类似，可以不断创建下级栏目，形成一个树状结构。

站点首页也是栏目，只不过此栏目没有父节点，是站点内所有栏目的根节点。

### [#](https://sscms.com/docs/v6/stl/guide/glossary.html#内容-content)内容(Content)

内容代表SiteServer CMS 需要进行增删改查的数据，可以是文章、新闻、博客、视频，甚至站点的友情链接、广告等一切可结构化的数据均可以成为内容。

一篇内容只能属于具体的一个栏目，STL标签通常通过栏目来定位进而获取内容。

### [#](https://sscms.com/docs/v6/stl/guide/glossary.html#模板-template)模板(Template)

模板是一个包含了显示样式的HTML文件，通常在模板文件中会包含HTML标签、CSS标签、JS标签以及STL标签，系统在生成静态页面时需要获取模板文件的内容，解析并替换模板文件中的STL标签。

根据系统生成页面的类型，模板分为首页模板、栏目模板、内容模板以及单页模板。

### [#](https://sscms.com/docs/v6/stl/guide/glossary.html#静态页面-static)静态页面(Static)

静态页面也称为HTML页面，是相对动态页面而言的。静态网页不是指网页中的元素都是静止不动的，而是指网页文件中没有程序代码，只有HTML（超文本标记语言）标记，一般后缀为.htm、.html、.shtml或.json、.xml等。

静态页面一经生成，内容就不会再变化，不管何人何时访问，显示的内容都是一样的。

如果要修改静态页面的内容，就必须通过 SiteServer CMS 重新生成此页面。

### [#](https://sscms.com/docs/v6/stl/guide/glossary.html#动态页面-dynamic)动态页面(Dynamic)

动态网页是指在网页文件中除了HTML标记以外，还包括一些实现特定功能的程序代码，这些程序代码使得浏览器与服务器之间可以进行交互，即服务器端可以根据客户端的不同请求动态产生网页内容。

动态网页的后缀名通常根据所用的程序设计语言的不同而不同，一般为.asp、.aspx、cgi、.php、.perl、.jsp等。

动态页面每次访问都需要连接数据库获取内容，同时容易被黑客攻击，所以 SiteServer CMS 不支持动态页面，如果希望实现动态页面的功能，可以通过 `<stl:dynamic>` 动态标签实现动态数据载入。







## STL 元素

STL 元素包裹在开始和结束尖括号 **<>** 中，属性用空格隔开，可以包含其他标签作为子标签，例如：

```html
<stl:a channelIndex="首页">链接</stl:a>
```

STL 元素之间可以相互嵌套；例如：

```html
<stl:a channelIndex="首页">
  <stl:content type="title"></stl:content>
</stl:a>
```

STL 元素最终将解析为 HTML 标签或者纯文字。

### [#](https://sscms.com/docs/v6/stl/guide/elements.html#栏目标签)栏目标签

内容标签包含获取内容列表以及内容属性相关的标签。

| STL 元素                                                     | 说明                                               |
| ------------------------------------------------------------ | -------------------------------------------------- |
| [stl:channel 获取栏目值](https://sscms.com/docs/v6/stl/channel/) | 通过 stl:channel 标签在模板中显示指定栏目的属性值  |
| [stl:channels 栏目列表](https://sscms.com/docs/v6/stl/channels/) | 通过 stl:channels 标签在模板中显示栏目列表         |
| [stl:pageChannels 翻页栏目列表](https://sscms.com/docs/v6/stl/pageChannels/) | 通过 stl:pageChannels 标签在模板中显示翻页栏目列表 |

### [#](https://sscms.com/docs/v6/stl/guide/elements.html#内容标签)内容标签

内容标签包含获取内容列表以及内容属性相关的标签。

| STL 元素                                                     | 说明                                               |
| ------------------------------------------------------------ | -------------------------------------------------- |
| [stl:content 获取内容值](https://sscms.com/docs/v6/stl/content/) | 通过 stl:content 标签在模板中显示指定内容的属性值  |
| [stl:contents 内容列表](https://sscms.com/docs/v6/stl/contents/) | 通过 stl:contents 标签在模板中显示内容列表         |
| [stl:pageContents 翻页内容列表](https://sscms.com/docs/v6/stl/pageContents/) | 通过 stl:pageContents 标签在模板中显示翻页内容列表 |

### [#](https://sscms.com/docs/v6/stl/guide/elements.html#导航标签)导航标签

导航标签包含所有与页面导航相关的标签，包括链接、当前位置、导航、以及下拉菜单等。

| STL 元素                                                     | 说明                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [stl:a 获取链接](https://sscms.com/docs/v6/stl/a/)           | 通过 stl:a 标签在模板中创建链接，系统将根据所处上下文计算链接地址 |
| [stl:location 当前位置](https://sscms.com/docs/v6/stl/location/) | 通过 stl:location 标签在模板中插入页面的当前位置             |
| [stl:navigation 显示导航](https://sscms.com/docs/v6/stl/navigation/) | 通过 stl:navigation 标签在模板中显示链接导航                 |
| [stl:tree 树状导航](https://sscms.com/docs/v6/stl/tree/)     | 通过 stl:tree 标签在模板中显示树状导航                       |

### [#](https://sscms.com/docs/v6/stl/guide/elements.html#图片及多媒体标签)图片及多媒体标签

图片标签包含所有涉及到显示图片以及组织图片显示样式的相关标签。

| STL 元素                                                     | 说明                                                    |
| ------------------------------------------------------------ | ------------------------------------------------------- |
| [stl:image 显示图片](https://sscms.com/docs/v6/stl/image/)   | 通过 stl:image 标签在模板中显示栏目或内容的图片         |
| [stl:file 文件下载链接](https://sscms.com/docs/v6/stl/file/) | 通过 stl:file 标签在模板中显示文件下载链接              |
| [stl:video 播放视频](https://sscms.com/docs/v6/stl/video/)   | 通过 stl:video 标签在模板中显示视频播放器               |
| [stl:audio 播放音频](https://sscms.com/docs/v6/stl/audio/)   | 通过 stl:audio 标签在模板中显示并播放音频文件           |
| [stl:flash 显示 Flash](https://sscms.com/docs/v6/stl/flash/) | 通过 stl:flash 标签在模板中获取并显示栏目或内容的 Flash |
| [stl:player 播放视频](https://sscms.com/docs/v6/stl/player/) | 通过 stl:player 标签在模板中播放视频                    |
| [stl:focusViewer 滚动焦点图](https://sscms.com/docs/v6/stl/focusViewer/) | 通过 stl:focusViewer 标签在模板中显示滚动焦点图         |

### [#](https://sscms.com/docs/v6/stl/guide/elements.html#判断标签)判断标签

判断标签用于根据条件判断显示内容，包含通用的 if 标签以及用于列表的 itemTemplate 标签。

| STL 元素                                                     | 说明                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [stl:if 条件判断](https://sscms.com/docs/v6/stl/if/)         | 通过 stl:if 标签在模板中根据条件判断显示内容                 |
| [stl:itemTemplate 列表项](https://sscms.com/docs/v6/stl/itemTemplate/) | 通过 stl:itemTemplate 标签在模板中控制列表中每一项的显示内容及样式 |
| [stl:loading 载入模板](https://sscms.com/docs/v6/stl/loading/) | 通过 stl:loading 标签在模板中创建载入中显示的内容            |
| [stl:yes 成功模板](https://sscms.com/docs/v6/stl/yes/)       | 通过 stl:yes 标签在模板中显示成功模板                        |
| [stl:no 失败模板](https://sscms.com/docs/v6/stl/no/)         | 通过 stl:no 标签在模板中显示失败模板                         |

### [#](https://sscms.com/docs/v6/stl/guide/elements.html#翻页标签)翻页标签

翻页标签包含所有涉及翻页时所需要用到的标签，包括翻页元素、栏目翻页列表、内容翻页列表等。

| STL 元素                                                     | 说明                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [stl:pageItems 翻页项容器](https://sscms.com/docs/v6/stl/pageItems/) | 通过 stl:pageItems 标签在模板中插入翻页项的容器，当不需要翻页时容器内的内容不显示 |
| [stl:pageItem 翻页项](https://sscms.com/docs/v6/stl/pageItem/) | 通过 stl:pageItem 标签在模板中显示翻页项（上一页、下一页、当前页、页跳转、页导航等） |

### [#](https://sscms.com/docs/v6/stl/guide/elements.html#数据库标签)数据库标签

数据库标签用于获取指定数据库信息，包括显示列表以及获取值所需要的标签。

| STL 元素                                                     | 说明                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [stl:sqlContents 数据库列表](https://sscms.com/docs/v6/stl/sqlContents/) | 通过 stl:sqlContents 标签在模板中显示数据库列表              |
| [stl:sqlContent 数据库值](https://sscms.com/docs/v6/stl/sqlContent/) | 通过 stl:sqlContent 标签在模板中显示数据库值                 |
| [stl:queryString SQL 查询语句](https://sscms.com/docs/v6/stl/queryString/) | 通过 stl:queryString 标签在模板中定义 SQL 查询语句           |
| [stl:pageSqlContents 翻页数据库列表](https://sscms.com/docs/v6/stl/pageSqlContents/) | 通过 stl:pageSqlContents 标签在模板中显示能够翻页的数据库列表 |

### [#](https://sscms.com/docs/v6/stl/guide/elements.html#站点标签)站点标签

站点标签包含获取网站列表以及网站属性相关的标签。

| STL 元素                                                   | 说明                                    |
| ---------------------------------------------------------- | --------------------------------------- |
| [stl:value 获取值](https://sscms.com/docs/v6/stl/value/)   | 通过 stl:value 标签在模板中获取值       |
| [stl:sites 站点列表](https://sscms.com/docs/v6/stl/sites/) | 通过 stl:sites 标签在模板中显示站点列表 |
| [stl:site 获取站点值](https://sscms.com/docs/v6/stl/site/) | 通过 stl:site 标签在模板中显示站点值    |

### [#](https://sscms.com/docs/v6/stl/guide/elements.html#其他标签)其他标签

其他常用的 STL 标签。

| STL 元素                                                     | 说明                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [stl:action 执行动作](https://sscms.com/docs/v6/stl/action/) | 通过 stl:action 标签在模板中创建链接，点击链接后将执行相应的动作 |
| [stl:container 容器](https://sscms.com/docs/v6/stl/container/) | 通过 stl:container 标签在模板中定义容器，切换上下文          |
| [stl:count 显示数值](https://sscms.com/docs/v6/stl/count/)   | 通过 stl:count 标签在模板中显示统计数字                      |
| [stl:dynamic 动态显示](https://sscms.com/docs/v6/stl/dynamic/) | 通过 stl:dynamic 标签在模板中实现动态显示功能                |
| [stl:each 列表项循环](https://sscms.com/docs/v6/stl/each/)   | 通过 stl:each 标签在模板中遍历指定的列表项                   |
| [stl:include 包含文件](https://sscms.com/docs/v6/stl/include/) | 通过 stl:include 标签在模板中包含另一个文件，作为模板的一部分 |
| [stl:marquee 无间隔滚动](https://sscms.com/docs/v6/stl/marquee/) | 通过 stl:marquee 标签在模板中创建一个能够无间隔滚动的内容块  |
| [stl:printer 打印](https://sscms.com/docs/v6/stl/printer/)   | 通过 stl:printer 标签在模板中实现打印功能                    |
| [stl:rss Rss 订阅](https://sscms.com/docs/v6/stl/rss/)       | 通过 stl:rss 标签在模板中生成 Rss 阅读器能够浏览的 Rss 订阅  |
| [stl:search 搜索](https://sscms.com/docs/v6/stl/search/)     | 通过 stl:search 标签在模板中显示搜索结果                     |
| [stl:select 下拉列表](https://sscms.com/docs/v6/stl/select/) | 通过 stl:select 标签在模板中显示栏目或内容下拉列表           |
| [stl:tabs 页签切换](https://sscms.com/docs/v6/stl/tabs/)     | 通过 stl:tabs 标签在模板中显示页签切换                       |
| [stl:tags 标签](https://sscms.com/docs/v6/stl/tags/)         | 通过 stl:tags 标签在模板中显示内容标签                       |
| [stl:zoom 文字缩放](https://sscms.com/docs/v6/stl/zoom/)     | 通过 stl:zoom 标签在模板中实现文字缩放功能                   |









## STL实体

STL实体包裹在开始和结束大括号 **{}** 中，属性用空格隔开，无法包含其他标签作为子标签；例如：

```js
{stl:a channelIndex="首页"}
```

STL实体通常解析为 JSON 对象或者纯文字。

一般来说，大部分功能都可以通过STL元素来实现，但是有些情况下STL元素不适合：

- 需要在属性中设置数据
- 需要在 JavaScript 代码中设置数据

由于STL元素最终将解析为 HTML 标签，将 HTML 标签放到 HTML 属性中或者 JavaScript 代码中都将引起混乱，所以一般这两种情况下需要使用STL实体。

STL实体的属性可以使用英文双引号、英文单引号或者无标识，例如以下三种写法均为正确写法：

```js
{stl:content type="title"}
{stl:content type='title'}
{stl:content type=title}
```

### [#](https://sscms.com/docs/v6/stl/guide/entities.html#stl实体简写)STL实体简写

为了方便，STL实体可以使用简写方式，简写方式不需要包含前缀 stl:，且无法设置属性。

#### [#](https://sscms.com/docs/v6/stl/guide/entities.html#stl-xyz){stl.xyz}

{stl:value type='xyz'} 的简写。

{stl.} 代表 {stl:value} 元素的简写，`{stl:value type=siteUrl}` 等价于`{stl.siteUrl}`。

#### [#](https://sscms.com/docs/v6/stl/guide/entities.html#channel-xyz){channel.xyz}

{stl:channel type='xyz'} 的简写。

{channel.} 代表 {stl:channel} 元素的简写，`{stl:channel type=title}` 等价于`{channel.title}`。

#### [#](https://sscms.com/docs/v6/stl/guide/entities.html#content-xyz){content.xyz}

{stl:content type='xyz'} 的简写。

{content.} 代表 {stl:content} 元素的简写，`{stl:content type=title}` 等价于`{content.title}`。

#### [#](https://sscms.com/docs/v6/stl/guide/entities.html#sql-xyz){sql.xyz}

{stl:sqlContent type='xyz'} 的简写。

{sql.} 代表 {stl:sqlContent} 元素的简写，`{stl:sqlContent type=xyz}` 等价于`{sql.xyz}`。

### [#](https://sscms.com/docs/v6/stl/guide/entities.html#在属性中使用实体)在属性中使用实体

通常在 HTML 属性或者STL属性中获取数据通常使用实体标签，例如：

```html
<img alt="{stl:content type='summary'}"></img>
```

或者

```html
<stl:a title="{stl:content type='title'}"></stl:a>
```

### [#](https://sscms.com/docs/v6/stl/guide/entities.html#在-javascript-代码中使用实体)在 JavaScript 代码中使用实体

JS 代码处理的对象主要是不带格式的纯数据，所以使用STL实体返回纯文本或者JSON对象非常关键，例如：

```javascript
<script type="text/javascript">
var arr = {stl:contents};
<script>
```

解析后的代码为：

```javascript
<script type="text/javascript">
var arr = [
  {
    id: 10935,
    channelId: 1746,
    siteId: 1739,
    addUserName: "admin",
    lastEditUserName: "admin",
    writingUserName: "",
    lastEditDate: "2018-06-13 12:27:00",
    taxis: 6,
    groupNameCollection: "",
    tags: "",
    sourceId: 0,
    referenceId: 0,
    isChecked: "True",
    checkedLevel: 1,
    hits: 28,
    hitsByDay: 1,
    hitsByWeek: 28,
    hitsByMonth: 28,
    lastHitsDate: "2018-06-14 00:00:00",
    settingsXml:
      "titleformatstring=False_False_False_&translatecontenttype=Copy",
    title: "第九届国际发明展览会集团荣获 “发明创业&#8226;项目奖”",
    isTop: "False",
    isRecommend: "False",
    isHot: "False",
    isColor: "False",
    linkUrl: "",
    addDate: "2015-09-30 13:52:00",
    subTitle: "",
    imageUrl: "",
    videoUrl: "",
    fileUrl: "",
    content:
      "<div>近日，第九届国际发明展览会在昆山国际会展中心圆满落幕。作为我国发明创新领域对外开放的重要窗口、创新思想交流和发明成果产业化的重要平台，国际发明展览会自1988年创办以来，在国内外发明界、产业界产生了广泛影响。在上千个参展的创新发明项目中，集团荣获三项“发明创业•项目奖”。</div><div>电梯研发部<br/>一种用于高速电梯钢丝绳补偿及涨紧装置<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 本发明研究轿厢、对重各使用一部分缓冲器时的布置情况，并确保电梯运行过程中补偿绳不对轿厢及对重产生偏载力。高速电梯钢丝绳补偿及涨紧装置的研发对整个曳引式电梯市场补偿绳系统设计具有重大意义。按照国家质检要求，2m/s以上的曳引式电梯均应安装此产品，故钢丝绳补偿及涨紧装置具有较大的市场，能够产生一定的生产效益和社会效益。</div><div>扶梯研发部<br/>一种具有安全隔离控制柜的自动扶梯<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 本发明目的在于解决自动扶梯的客户电源布置不合理的问题，提供一种采用客户电源与控制柜一体式布置，内部隔离技术的安全隔离型主控制柜的自动扶梯。本项目在2009年初设计完成，同年首次使用在“辽宁省沈阳市鞍山西柳中国商贸城”项目上，完成了本系统的初次试验并取得成功。同年申请发明专利。现在依然成功的应用在我司所有项目共计2055台自动扶梯上，并取得“零”触电事故的安全效果。该发明有效地提高了企业在行业内的竞争优势，也符合国家对安全扶梯的倡导，具有积极推广的意义。</div><div>车库研发部<br/>多台共柱安装的双层倾斜式停车装置（停车宝）<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 本项目的研究主要降低了对建筑空间层高和柱网间距的要求，实现了在较低的空间内双层停车，实现了多车位连续、多台共柱安装，大大提升了停车空间利用率。俯仰式简易升降布置灵活，规模大到上百车位，小到几个车位，外观漂亮、结构简单。<br/>实用性：<br/>1、此产品能广泛应用在层高仅为2800mm的空间，比原3600mm的层高要求降低了800mm，应用范围更广；<br/>2、此产品多台共柱，减少了并排安装时立柱之间预留空间的需求，相同空间可增加更多停车位，提高停车空间利用率。</div><p><br/></p>",
    summary: "",
    author: "",
    source: "",
    titleformatstring: "False_False_False_",
    translatecontenttype: "Copy",
    navigationUrl: "/test19/contents/1746/10935.html"
  },
  ...
];
<script>
```

### [#](https://sscms.com/docs/v6/stl/guide/entities.html#stl标签转换为stl实体)STL标签转换为STL实体

大部分STL元素均有对应的STL实体，将元素的尖括号替换为大括号，去掉闭合标签即为对应实体，实体中属性采用双引号、单引号或者不带引号均可。如内容值元素：

```html
<stl:content type="Title" wordNum="20"></stl:content>
```

对应实体为

```html
{stl:content type='Title' wordNum='20'}
```







## 包含文件

包含文件用于创建可在多个页面重复使用的页眉、页脚或元素。

[](https://sscms.com/docs/v6/stl/include/) 标签会获取指定文件中存在的所有文本/代码/标记，并复制到使用 include 语句的文件中。

包含文件很有用，如果你需要在网站的多张页面上引用相同的 STL、HTML 或文本的话。

包含文件省去了大量的工作，这意味着你可以为所有页面创建标准页头、页脚或者菜单文件。然后，在页头需要更新时，你只需更新这个页头包含文件即可。

需要注意的是，一旦包含文件中的内容更改了，需要生成所有页面才能将变化体现到网站中。

### [#](https://sscms.com/docs/v6/stl/guide/include.html#示例)示例

假设我们有一个名为 "footer.html" 的标准的页脚文件，存放在站点根目录下的 include 文件夹中，就像这样：

```html
<p>Copyright © 2006-2018 {stl.siteName}</p>
```

如需在模板中引用这个页脚文件，请使用 include 语句：

```html
<html>
<body>

<h1>欢迎访问我们的首页！</h1>
<p>一段文本。</p>
<p>一段文本。</p>

<stl:include file="/include/footer.html"></stl:include>

</body>
</html>
```







## 解析上下文

系统生成页面时将根据上下文来解析 STL 标签，例如，内容模板中使用标签 `<stl:content type="title"></stl:content>` 获取内容的标题，系统在解析这段代码的时候会使用当前内容作为上下文，从而解析出正确的数据。

通常，根据默认的上下文能获取到正确的结果，但有些情况下，需要通过属性重新定义上下文。例如，我们希望在内容中获取栏目名称，可以使用标签 `<stl:channel type="title"></stl:channel>` 获得数据，但如果我们希望显示的不是内容所属的栏目名称，而是特定的栏目名称时，通过默认的上下文就无法实现了，这时我们需要通过属性 channelIndex 来指定栏目：`<stl:channel channelIndex="栏目索引" type="title"></stl:channel>`。

我们可以通过属性来指定上下文，也可以通过容器标签来指定上下文，我们甚至能通过站点标签在切换网站；同时我们还可以通过条件判断标签来获取当前所处的上下文，下面分别进行说明。

### [#](https://sscms.com/docs/v6/stl/guide/context.html#通过属性切换上下文)通过属性切换上下文

#### [#](https://sscms.com/docs/v6/stl/guide/context.html#channelindex-栏目索引)channelIndex 栏目索引

栏目索引是一个站点中栏目的标识，具有唯一性。

如果设置了 channelIndex 属性，系统将寻找对应索引的栏目并将上下文切换到此栏目。

```html
<!-- 链接到首页 -->
<stl:a channelIndex="首页"></stl:a>
```

#### [#](https://sscms.com/docs/v6/stl/guide/context.html#channelname-栏目名称)channelName 栏目名称

栏目名称可以重复，所以应该尽量避免使用栏目名称来切换上下文，但是如果 channelName 与 channelIndex 属性配合使用，系统将首先定位到 channelIndex 索引所在的栏目，之后再寻找此栏目下栏目名称为 channelName 的栏目。

```html
<!-- 链接到当前栏目下的名称为“栏目名称”的栏目 -->
<stl:a channelName="栏目名称"></stl:a>
<!-- 链接到“栏目索引”下的名称为“栏目名称”的栏目 -->
<stl:a channelIndex="栏目索引" channelName="栏目名称"></stl:a>
```

#### [#](https://sscms.com/docs/v6/stl/guide/context.html#parent-父栏目)parent 父栏目

将上下文切换到当前栏目的上一级栏目。

- `"true"` 表示切换到当前栏目的上一级栏目，等价于 upLevel="1"。
- `"false"` 表示不切换到当前栏目的上一级栏目。

如果同时设置了 parent 以及 channelIndex 属性，系统将首先定位到 channelIndex 栏目索引所在的栏目，之后再切换到对应栏目的上级栏目。

```html
<!-- 链接到当前栏目的上一级栏目 -->
<stl:a parent="true"></stl:a>
```

#### [#](https://sscms.com/docs/v6/stl/guide/context.html#uplevel-上-n-级栏目)upLevel 上 N 级栏目

切换到上级栏目，1 为上一级栏目，2 为上两级栏目，以此类推。

如果同时设置了 upLevel 以及 channelIndex 属性，系统将首先定位到 channelIndex 栏目索引所在的栏目，之后再切换到对应栏目的上 N 级栏目。

```html
<!-- 链接到当前栏目的上两级栏目 -->
<stl:a upLevel="2"></stl:a>
```

#### [#](https://sscms.com/docs/v6/stl/guide/context.html#toplevel-第-n-级栏目)topLevel 第 N 级栏目

切换到从首页向下第 N 个级别的栏目，0 代表切换到首页，1 代表一级栏目，2 代表二级栏目，以此类推。

```html
<!-- 链接到一级栏目 -->
<stl:a topLevel="1"></stl:a>
```

### [#](https://sscms.com/docs/v6/stl/guide/context.html#context-列表上下文)context 列表上下文

通常如果标签被嵌套在列表元素中时，系统会设置上下文为当前的列表类型，同时对标签进行解析时也将根据列表类型进行判断，如将 `<stl:a></stl:a>` 放到内容列表以及栏目列表中时，stl:a 标签的链接会分别显示内容的连接以及栏目的连接。

如果希望`<stl:a></stl:a>`标签无论在内容列表还是栏目列表都只显示栏目链接，可以设置 context 属性为 Channel:`<stl:a context="channel"></stl:a>`

- `"default"` 默认，即当前所处上下文。
- `"content"` 内容上下文。
- `"channel"` 栏目上下文。
- `"sqlContent"` Sql 内容上下文。
- `"site"` 站点上下文。

```html
<!-- 分别显示栏目与内容链接 -->
<stl:channels>
  <stl:contents>
    栏目：<stl:a context="channel"></stl:a>
    内容：<stl:a></stl:a>
  </stl:contents>
</stl:channels>
```

### [#](https://sscms.com/docs/v6/stl/guide/context.html#通过-stl-container-元素切换上下文)通过 <stl:container> 元素切换上下文

如果希望一段代码无论放到什么位置，都解析为同样的结果，可以使用 <stl:container>将这段代码嵌套进来并设置属性指定的上下文。请参考：[ 容器元素](https://sscms.com/docs/v6/stl/container/)

```html
<stl:container channelIndex="栏目索引">
  栏目：<stl:channel type="title"></stl:channel>
  此栏目下的内容：
  <stl:contents>
    <stl:a></stl:a>
  </stl:contents>
</stl:container>
```

### [#](https://sscms.com/docs/v6/stl/guide/context.html#通过-stl-site-元素切换网站)通过 <stl:site> 元素切换网站

如果在本站点的模板中显示其他站点的数据，可以通过<stl:site> 元素切换站点，此元素中嵌套的标签都将解析为指定站点的数据。请参考：[ 站点元素](https://sscms.com/docs/v6/stl/site/)

```html
<stl:site siteDir="MySite">
  ...
</stl:site>
```

### [#](https://sscms.com/docs/v6/stl/guide/context.html#通过-stl-if-判断上下文)通过 <stl:if> 判断上下文

如果希望对上下文进行判断，从而使用不同的标签，可以通过<stl:if> 元素判断上下文，根据判断结果嵌套不同的标签。请参考：[ 判断元素](https://sscms.com/docs/v6/stl/if/)

[#](https://sscms.com/docs/v6/stl/guide/context.html#判断当前栏目名称是否为-栏目名称)判断当前栏目名称是否为"栏目名称"

```html
<stl:if type="ChannelName" op="Equals" value="栏目名称">
  <stl:yes> <p>true</p> </stl:yes>
  <stl:no> <p>false</p> </stl:no>
</stl:if>
```

#### [#](https://sscms.com/docs/v6/stl/guide/context.html#根据模板类型显示不同内容)根据模板类型显示不同内容

下面的例子判断当前模板是不是内容模板。

```html
<stl:if type="TemplateType" op="Equals" value="ContentTemplate">
  <stl:yes>
      这是内容页面
  </stl:yes>
  <stl:no>
      这不是内容页面
  </stl:no>
</stl:if>
```

#### [#](https://sscms.com/docs/v6/stl/guide/context.html#根据模板名称显示不同内容)根据模板名称显示不同内容

下面的例子根据当前模板的模板名称显示不同的内容。

```html
<stl:if type="TemplateName" op="Equals" value="系统首页模板">
  <stl:yes>
      <li><A href="/" class="current">首 页</A></li>
  </stl:yes>
  <stl:no>
      <li>我不是首页</li>
  </stl:no>
</stl:if>
```









## 动态显示

默认系统是通过生成全静态页面来显示内容的，这样的好处有很多，比如加载速度快、安全性高、服务器负载小、便于 SEO 优化等等。

但是有些情况下，我们希望能够实时显示数据，而不是每次需要生成页面后才能显示最新的数据，这种情况下我们就需要采用动态显示方式显示内容了。

我们可以通过属性来切换动态显示，也可以通过动态标签来切换动态显示，下面分别进行说明。

### [#](https://sscms.com/docs/v6/stl/guide/dynamic.html#通过属性-isdynamic-切换动态显示)通过属性 isDynamic 切换动态显示

大部分标签都拥有 isDynamic 属性，用于设置是否将此标签动态显示。

```html
<stl:contents isDynamic="true">
  <stl:a></stl:a>
</stl:contents>
```

### [#](https://sscms.com/docs/v6/stl/guide/dynamic.html#通过-stl-dynamic-元素切换动态显示)通过 <stl:dynamic> 元素切换动态显示

如果需要动态显示的标签比较多，可以使用 <stl:dynamic>将这些代码嵌套进来实现动态显示。请参考：[ 容器元素](https://sscms.com/docs/v6/stl/dynamic/)。

```html
<stl:dynamic>
  <stl:channel type="title"></stl:channel>
  <stl:contents>
    <stl:a></stl:a>
  </stl:contents>
</stl:dynamic>
```

### [#](https://sscms.com/docs/v6/stl/guide/dynamic.html#js-脚本事件)Js 脚本事件

Js 脚本事件只能通过定义 <stl:dynamic> 元素的属性来支持。

<stl:dynamic> 标签是由 Ajax 来实现的，页面通过 Js 发起动态请求，服务器返回请求结果并显示在页面中。

动态内容由于通过 Ajax 加载，会有一定的延迟，我们可以通过定义 Ajax 事件来进行精确控制。

请参考：[Js 脚本事件](https://sscms.com/docs/v6/stl/dynamic/#js脚本事件)。





## 列表循环

在页面中循环显示列表数据是频繁使用的功能，如获取某个栏目下的内容列表，或者在导航栏显示栏目列表等等。

主要的列表循环标签有以下几种：

| 列表标签                                                     | 说明           |
| ------------------------------------------------------------ | -------------- |
| [stl:contents](https://sscms.com/docs/v6/stl/contents/)      | 内容列表       |
| [stl:pageContents](https://sscms.com/docs/v6/stl/pageContents/) | 翻页内容列表   |
| [stl:channels](https://sscms.com/docs/v6/stl/channels/)      | 栏目列表       |
| [stl:pageChannels](https://sscms.com/docs/v6/stl/pageChannels/) | 翻页栏目列表   |
| [stl:sites](https://sscms.com/docs/v6/stl/sites/)            | 站点列表       |
| [stl:each](https://sscms.com/docs/v6/stl/each/)              | 字段遍历列表   |
| [stl:sqlContents](https://sscms.com/docs/v6/stl/sqlContents/) | 数据库列表     |
| [stl:pageSqlContents](https://sscms.com/docs/v6/stl/pageSqlContents/) | 翻页数据库列表 |

### [#](https://sscms.com/docs/v6/stl/guide/list.html#元素与实体)元素与实体

列表标签使用元素的写法时，标签内必须嵌套 HTML 或者 STL 标签，列表标签会逐项解析嵌套的标签并循环显示，如果列表标签内没有嵌套内容，系统将忽略此标签。例如`<stl:contents></stl:contents>`是无效的。

列表标签使用实体的写法时，标签将解析为JSON数组，数组内的项为列表项的JSON对象，例如：

```javascript
var arr = {stl:contents};
```

解析后的代码为：

```javascript
var arr = [{"id":10935,"channelId":1746,"siteId":1739,"addUserName":"admin","lastEditUserName":"admin","writingUserName":"","lastEditDate":"2018-06-13 12:27:00","taxis":6,"groupNameCollection":"","tags":"","sourceId":0,"referenceId":0,"isChecked":"True","checkedLevel":1,"hits":28,"hitsByDay":1,"hitsByWeek":28,"hitsByMonth":28,"lastHitsDate":"2018-06-14 00:00:00","settingsXml":"titleformatstring=False_False_False_&translatecontenttype=Copy","title":"第九届国际发明展览会爱登堡电梯集团荣获 “发明创业&#8226;项目奖”","isTop":"False","isRecommend":"False","isHot":"False","isColor":"False","linkUrl":"","addDate":"2015-09-30 13:52:00","subTitle":"","imageUrl":"","videoUrl":"","fileUrl":"","content":"<div>近日，第九届国际发明展览会在昆山国际会展中心圆满落幕。作为我国发明创新领域对外开放的重要窗口、创新思想交流和发明成果产业化的重要平台，国际发明展览会自1988年创办以来，在国内外发明界、产业界产生了广泛影响。在上千个参展的创新发明项目中，爱登堡电梯集团荣获三项“发明创业•项目奖”。</div><div>电梯研发部<br/>一种用于高速电梯钢丝绳补偿及涨紧装置<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 本发明研究轿厢、对重各使用一部分缓冲器时的布置情况，并确保电梯运行过程中补偿绳不对轿厢及对重产生偏载力。高速电梯钢丝绳补偿及涨紧装置的研发对整个曳引式电梯市场补偿绳系统设计具有重大意义。按照国家质检要求，2m/s以上的曳引式电梯均应安装此产品，故钢丝绳补偿及涨紧装置具有较大的市场，能够产生一定的生产效益和社会效益。</div><div>扶梯研发部<br/>一种具有安全隔离控制柜的自动扶梯<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 本发明目的在于解决自动扶梯的客户电源布置不合理的问题，提供一种采用客户电源与控制柜一体式布置，内部隔离技术的安全隔离型主控制柜的自动扶梯。本项目在2009年初设计完成，同年首次使用在“辽宁省沈阳市鞍山西柳中国商贸城”项目上，完成了本系统的初次试验并取得成功。同年申请发明专利。现在依然成功的应用在我司所有项目共计2055台自动扶梯上，并取得“零”触电事故的安全效果。该发明有效地提高了企业在行业内的竞争优势，也符合国家对安全扶梯的倡导，具有积极推广的意义。</div><div>车库研发部<br/>多台共柱安装的双层倾斜式停车装置（停车宝）<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 本项目的研究主要降低了对建筑空间层高和柱网间距的要求，实现了在较低的空间内双层停车，实现了多车位连续、多台共柱安装，大大提升了停车空间利用率。俯仰式简易升降布置灵活，规模大到上百车位，小到几个车位，外观漂亮、结构简单。<br/>实用性：<br/>1、此产品能广泛应用在层高仅为2800mm的空间，比原3600mm的层高要求降低了800mm，应用范围更广；<br/>2、此产品多台共柱，减少了并排安装时立柱之间预留空间的需求，相同空间可增加更多停车位，提高停车空间利用率。</div><p><br/></p>","summary":"","author":"","source":"","titleformatstring":"False_False_False_","translatecontenttype":"Copy","navigationUrl":"/test19/contents/1746/10935.html"}];
```

列表标签可以通过设置属性来控制所有列表项的显示方式，同时列表标签还可以通过<stl:itemTemplate> 子元素控制具体某一项的显示方式，下面依次加以说明。

### [#](https://sscms.com/docs/v6/stl/guide/list.html#通过属性控制列表)通过属性控制列表

#### [#](https://sscms.com/docs/v6/stl/guide/list.html#totalnum-一共显示多少项)totalNum 一共显示多少项

设置列表一共显示多少条信息，默认值为 0，代表显示所有信息。

```html
<stl:contents totalNum="7">
  <stl:a></stl:a><br />
</stl:contents>
```

#### [#](https://sscms.com/docs/v6/stl/guide/list.html#startnum-从第几项开始显示)startNum 从第几项开始显示

设置列表从第几条信息开始显示，默认值为 1，代表从第一条信息开始显示。

```html
<stl:contents startNum="3" totalNum="7">
  <stl:a></stl:a><br />
</stl:contents>
```

#### [#](https://sscms.com/docs/v6/stl/guide/list.html#pagenum-每页显示多少项)pageNum 每页显示多少项

设置翻页列表每一页显示的列表项数目，默认值为 25。

此属性仅针对翻页列表标签起作用： [stl:pageContents](https://sscms.com/docs/v6/stl/pageContents/)、[stl:pageChannels](https://sscms.com/docs/v6/stl/pageChannels/) 及 [stl:pageSqlContents](https://sscms.com/docs/v6/stl/pageSqlContents/) 。

```html
<stl:pageContents pageNum="20">
    <stl:a target="_blank"></stl:a><br />
</stl:pageContents>
```

#### [#](https://sscms.com/docs/v6/stl/guide/list.html#maxpage-最多显示多少页)maxPage 最多显示多少页

设置翻页列表最多显示多少页，默认值为 0，代表不控制显示页数。

此属性在列表翻页特别多的时候可以用来控制总页数，比如只列出前30页的内容，从而提高生成页面速度。

此属性仅针对翻页列表标签起作用： [stl:pageContents](https://sscms.com/docs/v6/stl/pageContents/)、[stl:pageChannels](https://sscms.com/docs/v6/stl/pageChannels/) 及 [stl:pageSqlContents](https://sscms.com/docs/v6/stl/pageSqlContents/) 。

```html
<stl:pageContents pageNum="20" maxPage="100">
    <stl:a target="_blank"></stl:a><br />
</stl:pageContents>
```

#### [#](https://sscms.com/docs/v6/stl/guide/list.html#layout-列表布局)layout 列表布局

列表布局属性用于控制列表循环中每一项的显示方式，默认值为 `none`，即直接循环，不控制列表项显示。

- `"none"` 列表不使用布局，仅循环列表项，不控制列表项显示。此值是默认的，如果没有指定属性的话。
- `"table"` 列表使用表格布局，系统将把列表标签解析为 HTML <table> 元素，table 标签的所有属性（class、style、cellPadding、cellSpacing等）均可用在列表标签中。

```html
<stl:contents layout="table" columns="3" width="90%" border="0" cellpadding="2">
    <stl:a><stl:content type="Title"></stl:content></stl:a>
</stl:contents>
```

#### [#](https://sscms.com/docs/v6/stl/guide/list.html#columns-列数)columns 列数

columns 属性决定要显示的列的数量。比如，如果要在列表中显示四列的项，那么可以把这个属性设为4。

```html
<stl:contents layout="table" columns="3" width="90%" border="0" cellpadding="2">
    <stl:a><stl:content type="Title"></stl:content></stl:a>
</stl:contents>
```

WARNING

columns 属性只有当列表布局为表格 `layout="table"` 时才起作用。

#### [#](https://sscms.com/docs/v6/stl/guide/list.html#direction-方向)direction 方向

direction属性用于确定列表是按水平方向还是或垂直方向来重复。

- `"vertical"` 垂直
- `"horizontal"` 水平

如果将此属性设置为vertical，列表中的项显示在从上到下加载的列中，然后从左到右，直到呈现所有项。例如，如果将columns属性设置为3，列表中的项显示在三列中，如下表所示。

| 1    | 4    | 7    |
| ---- | ---- | ---- |
| 2    | 5    | 8    |
| 3    | 6    | 9    |

如果将此属性设置为horizontal，列表中的项以从左到右加载的行显示，然后从上到下，直到呈现所有项。例如，如果将columns属性设置为3，列表的项将以每行三项的形式显示，如下表所示。

| 1    | 2    | 3    |
| ---- | ---- | ---- |
| 4    | 5    | 6    |
| 7    | 8    | 9    |

TIP

即使 direction 值为 vertical，还是显示为 4 个列。columns 永远是指重复的列的数量，而不是行的数量。

WARNING

direction 属性只有当列表布局为表格 `layout="table"` 且设置了列数 `columns` 时才起作用。

#### [#](https://sscms.com/docs/v6/stl/guide/list.html#height-整体高度)height - 整体高度

设置列表的整体高度。

WARNING

height 属性只有当列表布局为表格 `layout="table"` 时才起作用。

#### [#](https://sscms.com/docs/v6/stl/guide/list.html#width-整体宽度)width - 整体宽度

设置列表的整体宽度。

WARNING

width 属性只有当列表布局为表格 `layout="table"` 时才起作用。

#### [#](https://sscms.com/docs/v6/stl/guide/list.html#align-整体对齐)align - 整体对齐

设置列表的整体对齐方式。

- `"center"` 居中对齐。
- `"left"` 居左对齐。
- `"right"` 居右对齐。
- `"justify"` 向页面的左右边缘对齐。
- `"notSet"` 不设置。此值是默认的，如果没有指定属性的话。

WARNING

align 属性只有当列表布局为表格 `layout="table"` 时才起作用。

#### [#](https://sscms.com/docs/v6/stl/guide/list.html#itemheight-项高度)itemHeight - 项高度

列表中每一项的高度。

WARNING

itemHeight 属性只有当列表布局为表格 `layout="table"` 时才起作用。

#### [#](https://sscms.com/docs/v6/stl/guide/list.html#itemwidth-项宽度)itemWidth 项宽度

列表中每一项的宽度。

WARNING

itemWidth 属性只有当列表布局为表格 `layout="table"` 时才起作用。

#### [#](https://sscms.com/docs/v6/stl/guide/list.html#itemalign-项水平对齐)itemAlign 项水平对齐

列表中每一项的水平对齐方式。

- `"center"` 居中对齐。
- `"left"` 居左对齐。
- `"right"` 居右对齐。
- `"justify"` 向页面的左右边缘对齐。
- `"notSet"` 不设置。此值是默认的，如果没有指定属性的话。

WARNING

itemAlign 属性只有当列表布局为表格 `layout="table"` 时才起作用。

#### [#](https://sscms.com/docs/v6/stl/guide/list.html#itemverticalalign-项垂直对齐)itemVerticalAlign 项垂直对齐

列表中每一项的垂直对齐方式。

- `"top"` 顶端对齐。
- `"middle"` 居中对齐。
- `"bottom"` 底端对齐。
- `"notSet"` 不设置。此值是默认的，如果没有指定属性的话。

WARNING

itemVerticalAlign 属性只有当列表布局为表格 `layout="table"` 时才起作用。

#### [#](https://sscms.com/docs/v6/stl/guide/list.html#itemclass-项css类)itemClass 项Css类

列表中每一项的 Css 类

WARNING

itemClass 属性只有当列表布局为表格 `layout="table"` 时才起作用。

### [#](https://sscms.com/docs/v6/stl/guide/list.html#通过-itemtemplate-控制列表)通过 <itemTemplate> 控制列表

在列表标签中设置属性可以控制列表中每一项的显示方式，但如果我们需要控制列表中具体某一项的显示方式，就要用到<itemTemplate> 列表项子元素标签了。请参考：[ 列表项元素](https://sscms.com/docs/v6/stl/itemTemplate/)。

下面的例子显示的内容列表采用不同的颜色交替显示。

```html
<stl:contents>
    <stl:itemTemplate type="Item">
        <stl:a><stl:content type="Title"></stl:content></stl:a><br />
    </stl:itemTemplate>
    <stl:itemTemplate type="AlternatingItem">
        <stl:a style="color:red"><stl:content type="Title"></stl:content></stl:a> <br />
    </stl:itemTemplate>
</stl:contents>
```







## 内容解析

### [#](https://sscms.com/docs/v6/stl/guide/content.html#解析文字)解析文字

当模板中需要使用<stl:content>、<stl:channel>、<stl:value>等标签解析文字时，我们可以通过属性来控制文字解析的格式。

#### [#](https://sscms.com/docs/v6/stl/guide/content.html#wordnum-文字字数)wordNum 文字字数

设置解析文字的字数，超出部分将用 ellipsis 属性设置的值替代。

TIP

wordNum 区分中英文，中文汉字算作一个字符，两个英文字母才算作一个字符。

由于在 Web 页面中，两个英文字母的宽度等于一个汉字，所以我们通常使用 wordNum 属性来设置文本的解析数量。

```html
<stl:content wordNum="50"></stl:content>
```

#### [#](https://sscms.com/docs/v6/stl/guide/content.html#startindex-文字开始位置)startIndex 文字开始位置

设置文字开始解析的位置，默认值为 0，代表从头解析。

TIP

startIndex 不区分中英文，汉字、英文字母、空格及符号均认为是一个字符。

```html
<stl:content startIndex="10"></stl:content>
```

#### [#](https://sscms.com/docs/v6/stl/guide/content.html#length-文字字数)length 文字字数

设置解析文字的字数，超出部分将用 ellipsis 属性设置的值替代。

TIP

length 不区分中英文，汉字、英文字母、空格及符号均认为是一个字符。

```html
<stl:content length="100"></stl:content>
```

#### [#](https://sscms.com/docs/v6/stl/guide/content.html#ellipsis-省略符号)ellipsis 省略符号

设置了 wordNum 属性或者 length 属性时，当文字超出了指定的字数后，超出部分将用 ellipsis 属性设置的值来替代。

ellipsis 的默认值为 `...`，你也可以设置空值（ellipsis=""）来让超出部分不使用符号替换。

```html
<stl:content wordNum="100" ellipsis=" -- end --"></stl:content>
```

#### [#](https://sscms.com/docs/v6/stl/guide/content.html#replace-替换前文字)replace 替换前文字

如果需要将文字中的一部分替换为另一部分，可以使用 replace 属性和 to 属性。

replace 代表需要替换的文字，支持纯文本、列表和正则表达式三种写法。

##### [#](https://sscms.com/docs/v6/stl/guide/content.html#使用纯文本替换)使用纯文本替换

纯文本替换直接输入替换前文字和替换后文字即可：

```html
<stl:content replace="他" to="她"></stl:content>
```

##### [#](https://sscms.com/docs/v6/stl/guide/content.html#使用列表替换)使用列表替换

列表替换适合多个文本替换的情况，将需要替换的文字用英文逗号（,）隔开：

```html
<stl:content replace="他,她" to="he,she"></stl:content>
```

如果多个文本都替换为一个文本，to 属性可以不使用逗号隔开：

```html
<stl:content replace="他,她" to="who"></stl:content>
```

##### [#](https://sscms.com/docs/v6/stl/guide/content.html#使用正则表达式替换)使用正则表达式替换

正则表达式替换需要将 replace 前后添加“/”符号，“/”符号之间的文字为替换需要使用的正则表达式：

```html
<stl:content replace="/(Mr\\.? |Mrs\\.? |Miss |Ms\\.? )/" to=""></stl:content>
```

#### [#](https://sscms.com/docs/v6/stl/guide/content.html#to-替换后文字)to 替换后文字

to 代表替换后的文字。

#### [#](https://sscms.com/docs/v6/stl/guide/content.html#iscleartags-是否清除-html-标签)isClearTags 是否清除 HTML 标签

设置是否清除 HTML 标签，仅解析纯文本。

在后台内容编辑器中录入的数据通常会带有大量的 HTML 标签，如果我们只希望解析文字本身，需要使用 isClearTags 属性。

- `"true"` 清除 HTML 标签。
- `"false"` 不清除 HTML 标签。此值是默认的，如果没有指定属性的话。

```html
<stl:content type="content" isClearTags="true"></stl:content>
```

#### [#](https://sscms.com/docs/v6/stl/guide/content.html#isreturntobr-是否转换换行符)isReturnToBr 是否转换换行符

设置是否将回车换行符号替换为 HTML <br>换行标签。

由于 HTML 中的换行在页面中解析为空格，所以如果需要解析后台 TextArea 文本框录入的换行时，需要使用 isReturnToBr 属性。

- `"true"` 替换回车符。
- `"false"` 不替换回车符。此值是默认的，如果没有指定属性的话。

```html
<stl:content type="summary" isReturnToBr="true"></stl:content>
```

#### [#](https://sscms.com/docs/v6/stl/guide/content.html#islower-是否转换为小写)isLower 是否转换为小写

设置是否将文本中的所有英文字母转换为小写字母。

- `"true"` 转换为小写。
- `"false"` 不转换为小写。此值是默认的，如果没有指定属性的话。

```html
<stl:content type="title" isLower="true"></stl:content>
```

#### [#](https://sscms.com/docs/v6/stl/guide/content.html#isupper-是否转换为大写)isUpper 是否转换为大写

设置是否将文本中的所有英文字母转换为大写字母。

- `"true"` 转换为大写。
- `"false"` 不转换为大写。此值是默认的，如果没有指定属性的话。

```html
<stl:content type="title" isUpper="true"></stl:content>
```

#### [#](https://sscms.com/docs/v6/stl/guide/content.html#lefttext-文字前缀)leftText 文字前缀

解析在文字之前的文字，系统会判断文字是否为空，如果文字为空，文字前缀也将不解析。

```html
<stl:content leftText="标题：" type="title"></stl:content>
```

#### [#](https://sscms.com/docs/v6/stl/guide/content.html#righttext-文字后缀)rightText 文字后缀

解析在文字之后的文字，系统会判断文字是否为空，如果文字为空，文字后缀也将不解析。

```html
<stl:content leftText="【" rightText="】" type="title"></stl:content>
```

### [#](https://sscms.com/docs/v6/stl/guide/content.html#解析日期)解析日期

当需要解析日期型的字段值时，通常通过 formatString 属性来设置日期格式，具体格式如下：

| 格式模式 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| d        | 月中的某一天。一位数的日期没有前导零。                       |
| dd       | 月中的某一天。一位数的日期有一个前导零。                     |
| ddd      | 周中某天的缩写名称，在 AbbreviatedDayNames 中定义。          |
| dddd     | 周中某天的完整名称，在 DayNames 中定义。                     |
| M        | 月份数字。一位数的月份没有前导零。                           |
| MM       | 月份数字。一位数的月份有一个前导零。                         |
| MMM      | 月份的缩写名称，在 AbbreviatedMonthNames 中定义。            |
| MMMM     | 月份的完整名称，在 MonthNames 中定义。                       |
| y        | 不包含纪元的年份。如果不包含纪元的年份小于 10，则解析不具有前导零的年份。 |
| yy       | 不包含纪元的年份。如果不包含纪元的年份小于 10，则解析具有前导零的年份。 |
| yyyy     | 包括纪元的四位数的年份。                                     |
| gg       | 时期或纪元。如果要设置格式的日期不具有关联的时期或纪元字符串，则忽略该模式。 |
| h        | 12小时制的小时。一位数的小时数没有前导零。                   |
| hh       | 12小时制的小时。一位数的小时数有前导零。                     |
| H        | 24小时制的小时。一位数的小时数没有前导零。                   |
| HH       | 24小时制的小时。一位数的小时数有前导零。                     |
| m        | 分钟，一位数的分钟数没有前导零。                             |
| mm       | 分钟，一位数的分钟数有一个前导零。                           |
| s        | 秒，一位数的秒数没有前导零。                                 |
| ss       | 秒，一位数的秒数有一个前导零。                               |
| f        | 秒的小数精度为一位。其余数字被截断。                         |
| ff       | 秒的小数精度为两位。其余数字被截断。                         |
| fff      | 秒的小数精度为三位。其余数字被截断。                         |
| ffff     | 秒的小数精度为四位。其余数字被截断。                         |
| fffff    | 秒的小数精度为五位。其余数字被截断。                         |
| ffffff   | 秒的小数精度为六位。其余数字被截断。                         |
| fffffff  | 秒的小数精度为七位。其余数字被截断。                         |
| t        | 在AMDesignator或PMDesignator中定义的AM/PM指示项的第一个字符（如果存在）。 |
| tt       | 在AMDesignator或PMDesignator中定义的AM/PM指示项（如果存在）。 |
| z        | 时区偏移量（“+”或“-”后面仅跟小时）。一位数的小时数没有前导零。例如，太平洋标准时间是“-8”。 |
| zz       | 时区偏移量（“+”或“-”后面仅跟小时）。一位数的小时数有前导零。例如，太平洋标准时间是“-08”。 |
| zzz      | 完整时区偏移量（“+”或“-”后面跟有小时和分钟）。一位数的小时数和分钟数有前导零。例如，太平洋标准时间是“-08:00”。 |
| :        | 在TimeSeparator中定义的默认时间分隔符。                      |
| /        | 在DateSeparator中定义的默认日期分隔符。                      |
| %c       | 其中c是格式模式（如果单独使用）。如果格式模式与原义字符或其他格式模式合并，则可以省略“%”字符。 |
| c        | 其中c是任意字符。照原义解析字符。若要解析反斜杠字符，请使用“\”。 |

#### [#](https://sscms.com/docs/v6/stl/guide/content.html#示例)示例

下面的例子在页面中解析内容的添加时间，并按照"yyyy-MM-dd"格式解析。

```html
<stl:content type="AddDate" formatString="yyyy-MM-dd"></stl:content>
```

解析后的 HTML 代码：

```html
2013-06-03
```