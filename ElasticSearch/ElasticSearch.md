# ElasticSearch

前言

课程名称：【尚硅谷】ElasticSearch入门到精通2021最新教程（基于ELK技术栈elasticsearch 7.8.x版本）

课程地址：https://www.bilibili.com/video/BV1hh411D7sb

笔记作者：Ryanho

笔记时间：2021年4月23日



## 正文

### 一、概述

Elasticsearch：

The Elastic Stack, 包括 Elasticsearch、 Kibana、 Beats 和 Logstash（也称为 ELK Stack）。能够安全可靠地获取任何来源、任何格式的数据，然后实时地对数据进行搜索、分析和可视化。

Elaticsearch，简称为 ES， ES 是一个**开源的高扩展的分布式全文搜索引擎**， 是整个 ElasticStack 技术栈的核心。

它可以近乎实时的存储、检索数据；本身扩展性很好，可以扩展到上百台服务器，处理 PB 级别的数据。



### 二、入门

安装：

https://www.elastic.co/cn/downloads/



bin->elasticsearch.bat可以启动ES服务

访问：http://localhost:9200/

```json
{
  "name" : "LAPTOP-66MR4CLC",
  "cluster_name" : "elasticsearch",
  "cluster_uuid" : "d0oZc1rtRrW0dBWPbTqV7g",
  "version" : {
    "number" : "7.8.0",
    "build_flavor" : "default",
    "build_type" : "zip",
    "build_hash" : "757314695644ea9a1dc2fecd26d1a43856725e65",
    "build_date" : "2020-06-14T19:35:50.234439Z",
    "build_snapshot" : false,
    "lucene_version" : "8.5.1",
    "minimum_wire_compatibility_version" : "6.8.0",
    "minimum_index_compatibility_version" : "6.0.0-beta1"
  },
  "tagline" : "You Know, for Search"
}
```

如果有以上的画面表示启动成功。



9300端口为Elasticsearch集群间组件的通信端口，9200端口为浏览器访问的http协议RESTful端口。

问题解决：

- Elasticsearch是使用java开发的，且7.8版本的ES需要JDK版本1.8以上，默认安装包带有jdk环境，如果系统配置JAVA_HOME，那么使用系统默认的JDK，如果没有配置使用自带的JDK，一般建议使用系统配置的JDK。
- 双击启动窗口闪退，通过路径访问追踪错误，如果是“空间不足”，请修改config/jvm.options配置文件



