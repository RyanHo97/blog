```javascript
//获取上周起始时间结束时间、下周起始时间结束时间开始时间和本周起始时间结束时间;（西方）
function getTime(n) {
  var now = new Date();
  var year = now.getFullYear();
  //因为月份是从0开始的,所以获取这个月的月份数要加1才行
  var month = now.getMonth() + 1;
  var date = now.getDate();
  var day = now.getDay();
  console.log(date);
  //判断是否为周日,如果不是的话,就让今天的day-1(例如星期二就是2-1)
  if (day !== 0) {
    n = n + (day - 1);
  } else {
    n = n + day;
  }
  if (day) {
    //这个判断是为了解决跨年的问题
    if (month > 1) {
      month = month;
    }
    //这个判断是为了解决跨年的问题,月份是从0开始的
    else {
      year = year - 1;
      month = 12;
    }
  }
  now.setDate(now.getDate() - n);
  year = now.getFullYear();
  month = now.getMonth() + 1;
  date = now.getDate();
  // console.log(n);
  var s = year + "-" + (month < 10 ? ('0' + month) : month) + "-" + (date < 10 ? ('0' + date) : date);
  return s;
}

/***参数都是以周一为基准的***/
//上周的开始时间
// console.log(getTime(7));
//上周的结束时间
// console.log(getTime(1));
//本周的开始时间
// console.log(getTime(0));
//本周的结束时间
// console.log(getTime(-6));
//下周的开始时间
// console.log(getTime(-7));
//下周结束时间
// console.log(getTime(-13));
```

 下面的标准的礼拜一（起始时间）到礼拜天（结束时间）



```javascript
<script type="text/javascript">
    function getTime(n) {
        var now = new Date();
        var year = now.getFullYear();
        var month = now.getMonth() + 1;
        var day = now.getDay(); //返回星期几的某一天;
        n = day == 0 ? n + 6 : n + (day - 1)
        now.setDate(now.getDate() - n);
        date = now.getDate();
        var s = year + "-" + (month < 10 ? ('0' + month) : month) + "-" + (date < 10 ? ('0' + date) : date);
        return s;
    }
    //上周的开始时间
    console.log(getTime(7));
    //上周的结束时间
    console.log(getTime(1));
    //本周的开始时间
    console.log(getTime(0));
    //本周的结束时间
    console.log(getTime(-6));
    //下周的开始时间
    console.log(getTime(-7));
    //下周结束时间
    console.log(getTime(-13));
</script>
```

转载：https://www.cnblogs.com/lhl66/p/9669270.html
