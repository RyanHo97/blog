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

个人版本：

只取从当前开始计算的近一周的时间
```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>timecontrol</title>
    <script type="text/javascript" src="./static/js/jquery.min.js"></script>
</head>

<body>

    <div id="time">
        <input id="start_date">
        <input id="end_date">
    </div>

    <script>
        $(function () {

            getNowDate();

            getLastThreeMonthDate();

        })

        //补零代码
        function supZero(initdata){

            console.log(initdata);

            var sdata = initdata.toString();

            if(initdata<10){
                sdata = "0"+sdata;
            }
            
            console.log("sdata="+sdata);

            return sdata;
        }

        function getNowDate(){
            var myDate = new Date;
            var year = myDate.getFullYear(); //获取当前年
            var mon = myDate.getMonth() + 1; //获取当前月
            var date = myDate.getDate(); //获取当前日
            var h = myDate.getHours();//获取当前小时数(0-23)
            var m = myDate.getMinutes();//获取当前分钟数(0-59)
            var s = myDate.getSeconds();//获取当前秒
            var week = myDate.getDay();

            var smon = supZero(mon);
            var sdate = supZero(date);
            var sh = supZero(h);
            var sm = supZero(m);
            var ss = supZero(s);

            // var weeks = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
            // console.log(year, mon, date, weeks[week])
            $("#end_date").val(year + "-" + smon + "-" + sdate + " " + sh +":" + sm + ":" + ss);
        }

        function getLastWeekDate(){
            var myDate = new Date;
            var year = myDate.getFullYear(); //获取当前年
            var mon = myDate.getMonth() + 1; //获取当前月
            var date = myDate.getDate() - 7; //获取上周天数
            var h = myDate.getHours();//获取当前小时数(0-23)
            var m = myDate.getMinutes();//获取当前分钟数(0-59)
            var s = myDate.getSeconds();//获取当前秒
            var week = myDate.getDay();


                if (date <= 0) {
                    mon = mon -1;

                    if(mon == 2){
                        if(year % 4 == 0){
                            date = date + 29;
                        }else{
                            date = date + 28;
                        }
                    }else if(mon == 4){
                        date = date + 30;
                    }else if(mon == 6){
                        date = date + 30;
                    }else if(mon == 9){
                        date = date + 30;
                    }else if(mon == 11){
                        date = date + 30;
                    }else{
                        date = date + 31;
                    }
                }

                if (mon > 1) {
                    mon = mon;
                }else {
                    year = year - 1;
                    mon = 12;
                }

            if(mon < 10){
                mon = "0"+mon;
            }
            if(date < 10){
                date = "0"+date;
            }
            if(h < 10){
                h = "0"+h;
            }
            if(m < 10){
                m = "0"+m;
            }
            if(s < 10){
                s = "0"+s;
            }

            $("#start_date").val(year + "-" + mon + "-" + date + " " + h +":" + m + ":" + s);
        }

        function getLastMonthDate(){
            var myDate = new Date;
            var year = myDate.getFullYear(); //获取当前年
            var mon = myDate.getMonth(); //获取上月
            var date = myDate.getDate(); //获取上周天数
            var h = myDate.getHours();//获取当前小时数(0-23)
            var m = myDate.getMinutes();//获取当前分钟数(0-59)
            var s = myDate.getSeconds();//获取当前秒
            var week = myDate.getDay();


                if (date <= 0) {
                    mon = mon -1;

                    if(mon == 2){
                        if(year % 4 == 0){
                            date = date + 29;
                        }else{
                            date = date + 28;
                        }
                    }else if(mon == 4){
                        date = date + 30;
                    }else if(mon == 6){
                        date = date + 30;
                    }else if(mon == 9){
                        date = date + 30;
                    }else if(mon == 11){
                        date = date + 30;
                    }else{
                        date = date + 31;
                    }
                }

                if (mon > 1) {
                    mon = mon;
                }else {
                    year = year - 1;
                    mon = 12;
                }

            if(mon < 10){
                mon = "0"+mon;
            }
            if(date < 10){
                date = "0"+date;
            }
            if(h < 10){
                h = "0"+h;
            }
            if(m < 10){
                m = "0"+m;
            }
            if(s < 10){
                s = "0"+s;
            }

            $("#start_date").val(year + "-" + mon + "-" + date + " " + h +":" + m + ":" + s);
        }

        function getLastThreeMonthDate(){
            var myDate = new Date;
            var year = myDate.getFullYear(); //获取当前年
            var mon = myDate.getMonth() - 2; //获取上月
            var date = myDate.getDate(); //获取上周天数
            var h = myDate.getHours();//获取当前小时数(0-23)
            var m = myDate.getMinutes();//获取当前分钟数(0-59)
            var s = myDate.getSeconds();//获取当前秒
            var week = myDate.getDay();


                if (date <= 0) {
                    mon = mon -1;

                    if(mon == 2){
                        if(year % 4 == 0){
                            date = date + 29;
                        }else{
                            date = date + 28;
                        }
                    }else if(mon == 4){
                        date = date + 30;
                    }else if(mon == 6){
                        date = date + 30;
                    }else if(mon == 9){
                        date = date + 30;
                    }else if(mon == 11){
                        date = date + 30;
                    }else{
                        date = date + 31;
                    }
                }

                if (mon > 1) {
                    mon = mon;
                }else {
                    year = year - 1;
                    mon = 12;
                }

            if(mon < 10){
                mon = "0"+mon;
            }
            if(date < 10){
                date = "0"+date;
            }
            if(h < 10){
                h = "0"+h;
            }
            if(m < 10){
                m = "0"+m;
            }
            if(s < 10){
                s = "0"+s;
            }

            $("#start_date").val(year + "-" + mon + "-" + date + " " + h +":" + m + ":" + s);
        }

    </script>

</body>

</html>
```
