$(function(){
	$(".body_on_top div").mouseover(function(){
		var index=$(this).index();
		if(index<4){
		$(".body_on_top div").eq(index).addClass("add").siblings().removeClass("add");
			
		}
	$(".body_on_top").mouseleave(function(){
		var index=1;
		$(".body_on_top div").eq(index).addClass("add").siblings().removeClass("add");
	})
	});
//--第一次点击清空留言框内提醒内容------------
	var flag=0;
	$("#txt").click(function(){
		var dele=document.getElementById("txt");
		if(flag==0){
			dele.innerHTML="";
		}
			flag=1;
	})
	//----展示表情包------------
	$(".biaoqing").click(function(){
 	$(".photo").css("display","block");
	})
$(".photo  img").click(function(){
	//---点击添加相应表情。
		var shu = new Array('weixiao', 'wuzuixiao', 'chiya', 'daxiao', 'deyi', 'kenai', 'kun', 'se','bishi','zilian','cahan');
		var a = $(this).index();
		var sr = "img/" + shu[a] + ".gif";
		var txt = document.getElementById("txt");
		//---盛放文本和表情的容器选用可编辑型div，避免表情图片以文本形式展示。
		txt.innerHTML += "<img src='" + sr + "'>";
 	});
 	$(".pu").mouseover(function() {
		var txt = document.getElementById("txt").innerHTML;
	  //---把div中的图片转化为字符存放在input标签中，方便留言文本往数据库存储；
		var out="" //用于装时间字符串
		var date= new Date();
		 out+=date.getMonth()+1+"月";  
		 out+=date.getDate()+"日";
		 out+=date.getHours()+"时";
		 out+=date.getMinutes()+"分"
		 out+=date.getSeconds()+"秒";
		 $(".DateTime").val(out);
		 txt= txt.replace(/草|日|操|fuck|逼|靠|shit|智|障|死|傻|屌/gi, '**');//不当言辞过滤
		 $(".Txt").val(txt);
		$(".photo").css("display", "none");
	});
	$(".pu").click(function(){
		var dele=document.getElementById("txt");
			dele.innerHTML="";
	})
//---------------------以下为获取数据库中存放的不同用户留言信息--------------------
		//----学院公告留言数据获取---------------
		$.ajax({
		datatype:"json",
		type:"get",
		url:"MsgServlet",
		success:function(data){
			var data1=JSON.parse(data);
			for (var i=data1.length-1;i>=0;i--) { //倒序，使得越近的通知，越靠前排列
				$("#list2 ul").append(`
                                <li class="list_text">
					<a><p><span class="Date">${data1[i]["DateTime"]}</span></p>
					   <div class="text"><a>${data1[i]["Txt"]}</a></div>
					   <p><span class="StaffName">一一${data1[i]["StaffName"]}</span></p>
					</a>
				</li>`);														
			}
		}	
	})
//-------职工留言数据获取-------
	$.ajax({
		datatype:"json",
		type:"post",
		url:"MsgServlet",
		success:function(data){
			var data1=JSON.parse(data);
			for (var  i=data1.length-1;i>=0;i--) {
				$("#list2 ul").append(`
                                <li class="list_text">
					<a><p><span class="Date">${data1[i]["DateTime"]}</span></p>
					   <div class="text"><a>${data1[i]["Txt"]}</a></div>
					   <p><span class="StaffName">一一${data1[i]["StaffName"]}</span></p>
					</a>
				</li>`);			
			}
		}	
	});
	
})
