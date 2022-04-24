最近看到一个问题就是让绝对定位的div居中，在尝试了top：50%；left：50%；后发现，居中是有问题的并不是想象中的样子

需要再加两句margin-top：-盒子高度的一般px  margin-left:-盒子宽度的一般px；

就这样让一个绝对定位的盒子居中就实现了，但是有一个缺点就是，必须要知道盒子的高宽；

我们可使用css3里面的transform实现，设置left为50%，transform：translateX（-50%）即可实现不得到宽实现居中；

本文作者：xiaopo
本文链接：https://www.cnblogs.com/xiaopo/p/14288987.html
