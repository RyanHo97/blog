# Node.js

前言

笔记作者：ryanho97

笔记时间：2021年12月28日



## 一.初识Node.js

### 1.简介

Node.js是一个基于ChromeV8引擎的JavaScript运行环境。

### 2.Node.js中的JavaScript运行环境

V8引擎+内置API(fs,path,http......)

注意：

- 浏览器是JavaScript的前端运行环境。
- Node.js是JavaScript的后端运行环境。
- Node.js中无法调用DOM和BOM等浏览器内置API。

### 3.使用Node.js可以做什么

- 基于Express框架，可以快速构建Web应用。
- 基于Electron框架，可以构建跨平台的桌面应用。
- 基于restify框架，可以快速构建API接口项目。
- 读写和操作数据库、创建实用的命令行工具辅助前端开发......

### 4.安装Node.js环境

4.1 LTS版本和Current版本的区别：

- LTS版本：长期稳定版，对于追求稳定性的企业及项目来说，推荐安装LTS版本的Node.js
- Current版本：新特性尝鲜版，对于热衷尝试新特性的用户来说，推荐安装Current版本的Node.js。但是，Current版本中可能存在隐藏Bug或安全性漏洞，因此不推荐在企业级项目中使用Current版本的Node.js。

4.2 查看已安装的Node.js的版本号

打开终端，在终端输入命令node -v后，按下回车键，即可查看已安装的Node.js的版本号。

