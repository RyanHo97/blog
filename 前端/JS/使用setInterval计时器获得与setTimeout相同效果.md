      ```javascript
      		var dingShi;  //定时器的方法，每3秒执行一次，把想执行的方法放这里；
      		var sword = 0;  //标记，进入方法后变1停止；
      
      		$(document).ready(function(){
      			Rytiming();
      		})
      
      		function Rytiming(){
      			dingShi = setInterval(viewData,2000);
      		}
      
      		function viewData(name){
      
      			sword = 1;
      			if(sword == 1){
      				clearInterval(dingShi);
      			}
              
             		//你想执行到的代码
              }
      ```
