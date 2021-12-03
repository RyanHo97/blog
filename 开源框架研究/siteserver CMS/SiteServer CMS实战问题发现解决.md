## SiteServer CMS实战问题发现解决

日期：2021年8月9日

- 问题：在Tab页切换的场景，STL无法在非active的tab页中正常解析

  解决方案：

  使用<stl:dynamic>  动态显示标签解决成功

  文档链接：https://sscms.com/docs/v6/stl/dynamic/#%E8%AF%B4%E6%98%8E

  通过 stl:dynamic 标签在模板中实现动态显示功能

  <stl:dynamic> 使用 AJAX 技术使页面中部分区域能够及时反应出变化内容，而不必生成页面后才能显示。

  <stl:dynamic> 标签用于需要即时反应出变化的页面区域，可以将任何代码放置在 <stl:dynamic> 中，页面将显示出最新的内容。

  大部分 STL 标签拥有 isDynamic 属性，如：`<stl:contents isDynamic="true"></stl:contents>`。设置此属性的结果与以下代码一致：`<stl:dynamic><stl:contents></stl:contents><stl:dynamic>`

  <stl:dynamic> 中可以包含任何 STL 标签或 HTML 标签。
  
日期：2021年8月9日

- 问题：模板stl:contents范围错误

  解决方案

  <stl:contents channelIndex="news" scope="范围">

  scope - 范围
  内容范围。此属性只可属于以下可能的取值的一种。

  "self" 只显示本栏目下的所有内容
  "children" 只显示下一极子栏目下的所有内容
  "selfAndChildren" 显示本级栏目及下一极子栏目下的所有内容
  "descendant" 显示所有级别的子栏目下的所有内容
  "all" 显示全部内容
  
  
日期：2021年12月3日

- 问题：视频<stl:player>无法正常解析
  问题原因
  
  模板调用内容使用的是{content.content}方式
  
  解决方案
  
  使用<stl:content type="content"></stl:content>即可解决。
