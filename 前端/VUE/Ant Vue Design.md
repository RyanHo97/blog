# Ant Vue Design

这里是 Ant Design 的 Vue 实现，开发和服务于企业级后台产品。

![img](https://gw.alipayobjects.com/zos/rmsportal/KDpgvguMpGfqaHPjicRK.svg) + ![img](https://qn.antdv.com/vue.png)

## 特性 [#](https://www.antdv.com/docs/vue/introduce-cn/#特性)

- 提炼自企业级中后台产品的交互语言和视觉风格。
- 开箱即用的高质量 Vue 组件。
- 共享[Ant Design of React](http://ant-design.gitee.io/docs/spec/introduce-cn)设计工具体系。

## 支持环境 [#](https://www.antdv.com/docs/vue/introduce-cn/#支持环境)

- 现代浏览器和 IE9 及以上（需要 [polyfills](https://www.antdv.com/docs/vue/getting-started-cn/#兼容性)）。
- 支持服务端渲染。
- [Electron](https://electronjs.org/)

| [![IE / Edge](https://raw.githubusercontent.com/alrra/browser-logos/master/src/edge/edge_48x48.png)](http://godban.github.io/browsers-support-badges/)IE / Edge | [![Firefox](https://raw.githubusercontent.com/alrra/browser-logos/master/src/firefox/firefox_48x48.png)](http://godban.github.io/browsers-support-badges/)Firefox | [![Chrome](https://raw.githubusercontent.com/alrra/browser-logos/master/src/chrome/chrome_48x48.png)](http://godban.github.io/browsers-support-badges/)Chrome | [![Safari](https://raw.githubusercontent.com/alrra/browser-logos/master/src/safari/safari_48x48.png)](http://godban.github.io/browsers-support-badges/)Safari | [![Opera](https://raw.githubusercontent.com/alrra/browser-logos/master/src/opera/opera_48x48.png)](http://godban.github.io/browsers-support-badges/)Opera | [![Electron](https://raw.githubusercontent.com/alrra/browser-logos/master/src/electron/electron_48x48.png)](http://godban.github.io/browsers-support-badges/)Electron |
| :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- |
| IE9, IE10, IE11, Edge                                        | last 2 versions                                              | last 2 versions                                              | last 2 versions                                              | last 2 versions                                              | last 2 versions                                              |

## 版本 [#](https://www.antdv.com/docs/vue/introduce-cn/#版本)

- 稳定版：[![npm package](https://img.shields.io/npm/v/ant-design-vue.svg?style=flat-square)](https://www.npmjs.org/package/ant-design-vue)

你可以订阅：https://github.com/vueComponent/ant-design-vue/releases.atom 来获得稳定版发布的通知。

## 安装 [#](https://www.antdv.com/docs/vue/introduce-cn/#安装)

### 使用 npm 或 yarn 安装 [#](https://www.antdv.com/docs/vue/introduce-cn/#使用-npm-或-yarn-安装)

**我们推荐使用 npm 或 yarn 的方式进行开发**，不仅可在开发环境轻松调试，也可放心地在生产环境打包部署使用，享受整个生态圈和工具链带来的诸多好处。

```bash
$ npm install ant-design-vue --save
$ yarn add ant-design-vue
```

如果你的网络环境不佳，推荐使用 [cnpm](https://github.com/cnpm/cnpm)。

> **组件库使用了 vue 的新特性`slot-scope`(2.5.0 新增), `provide / inject`(2.2.0 新增)**

### 浏览器引入 [#](https://www.antdv.com/docs/vue/introduce-cn/#浏览器引入)

在浏览器中使用 `script` 和 `link` 标签直接引入文件，并使用全局变量 `antd`。

我们在 npm 发布包内的 `ant-design-vue/dist` 目录下提供了 `antd.js` `antd.css` 以及 `antd.min.js` `antd.min.css`。你也可以通过 [![jsdelivr](https://data.jsdelivr.com/v1/package/npm/ant-design-vue/badge)](https://www.jsdelivr.com/package/npm/ant-design-vue) 或 [UNPKG](https://unpkg.com/ant-design-vue/dist/) 进行下载。

> **强烈不推荐使用已构建文件**，这样无法按需加载，而且难以获得底层依赖模块的 bug 快速修复支持。

> 注意：引入 antd.js 前你需要自行引入 [moment](http://momentjs.com/)。

## 示例 [#](https://www.antdv.com/docs/vue/introduce-cn/#示例)

```jsx
import Vue from 'vue';
import { DatePicker } from 'ant-design-vue';
Vue.use(DatePicker);
```

引入样式：

```jsx
import 'ant-design-vue/dist/antd.css'; // or 'ant-design-vue/dist/antd.less'
```

### 按需加载 [#](https://www.antdv.com/docs/vue/introduce-cn/#按需加载)

下面两种方式都可以只加载用到的组件。

- 使用 [babel-plugin-import](https://github.com/ant-design/babel-plugin-import)（推荐）。

  ```js
  // .babelrc or babel-loader option
  {
    "plugins": [
      ["import", { "libraryName": "ant-design-vue", "libraryDirectory": "es", "style": "css" }] // `style: true` 会加载 less 文件
    ]
  }
  ```

  > 注意：webpack 1 无需设置 `libraryDirectory`。

  然后只需从 ant-design-vue 引入模块即可，无需单独引入样式。等同于下面手动引入的方式。

  ```jsx
  // babel-plugin-import 会帮助你加载 JS 和 CSS
  import { DatePicker } from 'ant-design-vue';
  ```

- 手动引入

  ```jsx
  import DatePicker from 'ant-design-vue/lib/date-picker'; // 加载 JS
  import 'ant-design-vue/lib/date-picker/style/css'; // 加载 CSS
  // import 'ant-design-vue/lib/date-picker/style';         // 加载 LESS
  ```

## 链接 [#](https://www.antdv.com/docs/vue/introduce-cn/#链接)

- [首页](https://www.antdv.com/)
- [Ant Design Of React](https://ant.design/)
- [组件库](https://www.antdv.com/docs/vue/introduce-cn)
- [更新日志](https://www.antdv.com/docs/vue/changelog-cn)
- [CodeSandbox 模板](https://codesandbox.io/s/2wpk21kzvr) for bug reports
- [定制主题](https://www.antdv.com/docs/vue/customize-theme-cn)
- [常见问题](https://www.antdv.com/docs/vue/faq-cn)
- [支持我们](https://www.antdv.com/docs/vue/sponsor-cn)
- [Awesome Ant Design](https://github.com/vueComponent/ant-design-vue-awesome)

## 如何贡献 [#](https://www.antdv.com/docs/vue/introduce-cn/#如何贡献)

如果你希望参与贡献，欢迎 [Pull Request](https://github.com/vueComponent/ant-design-vue/pulls)，或给我们 [报告 Bug](https://vuecomponent.github.io/issue-helper/)([国内镜像](http://ant-design-vue.gitee.io/issue-helper/))。

> 强烈推荐阅读 [《提问的智慧》](https://github.com/ryanhanwu/How-To-Ask-Questions-The-Smart-Way)、[《如何向开源社区提问题》](https://github.com/seajs/seajs/issues/545) 和 [《如何有效地报告 Bug》](http://www.chiark.greenend.org.uk/~sgtatham/bugs-cn.html)、[《如何向开源项目提交无法解答的问题》](https://zhuanlan.zhihu.com/p/25795393)，更好的问题更容易获得帮助。

## 关于 ant-design-vue [#](https://www.antdv.com/docs/vue/introduce-cn/#关于-ant-design-vue)

众所周知，Ant Design 作为一门设计语言面世，经历过多年的迭代和积累，它对 UI 的设计思想已经成为一套事实标准，受到众多前端开发者及企业的追捧和喜爱，也是 React 开发者手中的神兵利器。希望 ant-design-vue 能够让 Vue 开发者也享受到 Ant Design 的优秀设计。

ant-design-vue 是 Ant Design 的 Vue 实现，组件的风格与 Ant Design 保持同步，组件的 html 结构和 css 样式也保持一致，真正做到了样式 0 修改，组件 API 也尽量保持了一致。

Ant Design Vue 致力于提供给程序员**愉悦**的开发体验。

## 特别感谢 [#](https://www.antdv.com/docs/vue/introduce-cn/#特别感谢)

[Ant Design Team](https://github.com/ant-design/ant-design/blob/master/AUTHORS.txt)







# 快速上手

Ant Design Vue 致力于提供给程序员**愉悦**的开发体验。

> 在开始之前，推荐先学习 [Vue](https://cn.vuejs.org/) 和 [ES2015](http://babeljs.io/docs/learn-es2015/)，并正确安装和配置了 [Node.js](https://nodejs.org/) v8.9 或以上。官方指南假设你已了解关于 HTML、CSS 和 JavaScript 的中级知识，并且已经完全掌握了 Vue 的正确开发方式。如果你刚开始学习前端或者 Vue，将 UI 框架作为你的第一步可能不是最好的主意。

## 使用 vue-cli@3 [#](https://www.antdv.com/docs/vue/getting-started-cn/#使用-vue-cli@3)

我们为新版的 vue-cli 准备了相应的 [Ant Design Vue](https://github.com/vueComponent/vue-cli-plugin-ant-design) 插件，你可以用它们快速地搭建一个基于 Ant Design Vue 的项目。

## 在线演示 [#](https://www.antdv.com/docs/vue/getting-started-cn/#在线演示)

最简单的使用方式参照以下 CodeSandbox 演示，也推荐 Fork 本例来进行 `Bug Report`。

- [![Vue Antd Template](https://codesandbox.io/static/img/play-codesandbox.svg)](https://codesandbox.io/s/2wpk21kzvr)

## 引入 ant-design-vue [#](https://www.antdv.com/docs/vue/getting-started-cn/#引入-ant-design-vue)

### 1. 安装脚手架工具 [#](https://www.antdv.com/docs/vue/getting-started-cn/#1.-安装脚手架工具)

[vue-cli](https://github.com/vuejs/vue-cli)

```bash
$ npm install -g @vue/cli
# OR
$ yarn global add @vue/cli
```

### 2. 创建一个项目 [#](https://www.antdv.com/docs/vue/getting-started-cn/#2.-创建一个项目)

使用命令行进行初始化。

```bash
$ vue create antd-demo
```

并配置项目。

若安装缓慢报错，可尝试用 `cnpm` 或别的镜像源自行安装：`rm -rf node_modules && cnpm install`。

### 3. 使用组件 [#](https://www.antdv.com/docs/vue/getting-started-cn/#3.-使用组件)

```bash
$ npm i --save ant-design-vue
```

**完整引入**

```jsx
import Vue from 'vue';
import Antd from 'ant-design-vue';
import App from './App';
import 'ant-design-vue/dist/antd.css';
Vue.config.productionTip = false;

Vue.use(Antd);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  components: { App },
  template: '<App/>',
});
```

以上代码便完成了 Antd 的引入。需要注意的是，样式文件需要单独引入。

**局部导入组件**

```jsx
import Vue from 'vue';
import { Button, message } from 'ant-design-vue';
import App from './App';

Vue.config.productionTip = false;

/* v1.1.2 */
Vue.component(Button.name, Button);
Vue.component(Button.Group.name, Button.Group);

/* v1.1.3+ 自动注册Button下组件，如Button.Group */
Vue.use(Button);

Vue.prototype.$message = message;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  components: { App },
  template: '<App/>',
});
```

> 你可以在左侧菜单选用更多组件。

### 4. 组件列表 [#](https://www.antdv.com/docs/vue/getting-started-cn/#4.-组件列表)

[完整组件列表](https://github.com/vueComponent/ant-design-vue/blob/master/components/index.js)

## 兼容性 [#](https://www.antdv.com/docs/vue/getting-started-cn/#兼容性)

Ant Design Vue 支持所有的现代浏览器和 IE9+。

对于 IE 系列浏览器，需要提供 [es5-shim](https://github.com/es-shims/es5-shim) 和 [es6-shim](https://github.com/paulmillr/es6-shim) 等 Polyfills 的支持。

如果你使用了 babel，强烈推荐使用 [babel-polyfill](https://babeljs.io/docs/usage/polyfill/) 和 [babel-plugin-transform-runtime](https://babeljs.io/docs/plugins/transform-runtime/) 来替代以上两个 shim。

> 避免同时使用 babel 和 shim 两种兼容方法，以规避 [#6512](https://github.com/ant-design/ant-design/issues/6512) 中所遇问题

## 按需加载 [#](https://www.antdv.com/docs/vue/getting-started-cn/#按需加载)

如果你在开发环境的控制台看到下面的提示，那么你可能使用了 `import { Button } from 'ant-design-vue';` 的写法引入了 antd 下所有的模块，这会影响应用的网络性能。

> ![img](https://zos.alipayobjects.com/rmsportal/GHIRszVcmjccgZRakJDQ.png)

可以通过以下的写法来按需加载组件。

```jsx
import Button from 'ant-design-vue/lib/button';
import 'ant-design-vue/lib/button/style'; // 或者 ant-design-vue/lib/button/style/css 加载 css 文件
```

如果你使用了 babel，那么可以使用 [babel-plugin-import](https://github.com/ant-design/babel-plugin-import) 来进行按需加载，加入这个插件后。你可以仍然这么写：

```jsx
import { Button } from 'ant-design-vue';
```

插件会帮你转换成 `ant-design-vue/lib/xxx` 的写法。另外此插件配合 [style](https://github.com/ant-design/babel-plugin-import#usage) 属性可以做到模块样式的按需自动加载。

> 注意，babel-plugin-import 的 `style` 属性除了引入对应组件的样式，也会引入一些必要的全局样式。如果你不需要它们，建议不要使用此属性。你可以 `import 'ant-design-vue/dist/antd.css` 手动引入，并覆盖全局样式。

## 配置主题和字体 [#](https://www.antdv.com/docs/vue/getting-started-cn/#配置主题和字体)

- [改变主题](https://www.antdv.com/docs/vue/customize-theme-cn)
- [使用本地字体](https://github.com/ant-design/antd-init/tree/master/examples/local-iconfont)

## 小贴士 [#](https://www.antdv.com/docs/vue/getting-started-cn/#小贴士)

- 你可以享用 `npm` 生态圈里的所有模块。
- 虽然 Vue 官方推荐模板编写组件，不过对于复杂组件，[jsx](https://github.com/vuejs/babel-plugin-transform-vue-jsx)未必不是一个更好的选择。