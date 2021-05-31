# Webpack入门到达精通

前言

课程名称：尚硅谷最新版Webpack5实战教程(从入门到精通)

课程地址：https://www.bilibili.com/video/BV1e7411j7T5

笔记作者：RyanHo97

笔记时间：2021年5月27日

## 正文

### 第1章 Webpack简介

#### 1.1 Webpack是什么

Webpack是一种前端资源构建工具，一个静态模块打包器(module bundler)。

在Webpack看来，前端的所有资源文件(js/json/css/img/less/...)都会作为模块处理。

它将根据模块的依赖关系进行静态分析，打包成对应的静态资源(bundle)。

#### 1.2 Webpack五个核心概念

##### 1.2.1 Entry

​	入口(Entry)指示 Webpack 以哪个文件为入口起点开始打包，分析构建内部依赖图。

##### 1.2.2 Output

​	输出(Output)指示 Webpack 打包后的资源bundles 输出到哪里去，以及如何命名。

##### 1.2.3 Loader

​	Loader让 Webpack 能够去处理那些非JavaScript文件(webpack 自身只理解JavaScript)。

##### 1.2.4 Plugins

​	插件(Plugins)可以用于执行范围更广的任务。插件的范围包括，从打包优化和压缩，一直到重新定义环境中的变量等。

##### 1.2.5Mode

​	模式(Mode)指示 Webpack 使用相应模式的配置。

|    选项     |                             描述                             |            特点            |
| :---------: | :----------------------------------------------------------: | :------------------------: |
| development | 会将process.env.NODE_ENV的值设为development。<br />启用NamedChunksPlugin和NamedModulesPlugin | 能让代码本地调试的运行环境 |
| production  | 会将process.env.NODE_ENV的值设为production。<br />启用FlagDependencyUsagePlugin，FlagIncludedChunksPlugin，ModuleConcatenationPlugin，NoEmitOnErrorsPlugin，OccurrenceOrderPlugin，SideEffectsFlagPlugin和UglifyJsPlugin。 | 能让代码优化上线运行的环境 |

