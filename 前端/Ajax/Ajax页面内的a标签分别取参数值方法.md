## Ajax页面内的a标签分别取参数值方法

难点在于如何遍历所有a标签然后分别在对应的位置更新后端数据

```html
	<script>

		var name = "project_id"; //匹配的参数值

		$(document).ready(function (name) {

			var hrefArr = $("#textTopLeft a");

			for( var i=0; i<hrefArr.length; i++ ){
				var patt = /(?<=\=)\S+()/g; //斜线内是正则，g代表全局
				var r = hrefArr[i].href; //遍历数组内的所有a标签
				var result = r.match(patt); //使用match方法
				if(result != null){
					var projectid = result.toString(); //match后是数组，里面只有一个元素，toString()方法变字符串
					console.log(projectid);
					//ajax
					$.ajax({
    				        type: "POST",
    				        url: "/api接口地址",
    				        dataType: "json",
    				        timeout: 0,
    				        data: {
    				            'project_id':projectid
    				    },
    				    success: function(data) {
    				        if (data.success) {
								$(".projectMoney").eq(i-1).empty();
								$(".projectPeople").eq(i-1).empty();

    				            $(".projectMoney").eq(i-1).text(data.result.sysData.money);
    				            $(".projectPeople").eq(i-1).text('爱心人次：'+data.result.sysData.cishu);
    				        }
    				    },
    				    error: function(e) {
    				        console.log(e.responseText);
    				    }
    				});


				}
			}
			
		})
		
	</script>
```

