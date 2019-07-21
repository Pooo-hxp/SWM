$(function(){
	$(".top_center ul li").mouseover(function(){
		var index=$(this).index();	
		var index=index-1;
		var wid=760-index*120; //设置单个导航120px，则这里根据下标减去相应宽度，使其对应
		 var a=	document.getElementById("banner_div").style.width=wid+"px"; 
		  var b=document.getElementsByClassName("banner_item")[index]; 
		b.style.width=wid+"px"; //同上
		//$(".banner_item").eq(index).slideDown("slow").css("display","block"); 
		//--因动态效果的时候，延迟展示动画，所以操作频繁的时候会有轻微bug。
		$(".banner_item").eq(index).css("display","block");// 不使用时延迟动画，无任何问题。
	})
		$(".top_center ul li").mouseleave(function(){
		var index=$(this).index();
		var index=index-1; 
		$(".banner_item").eq(index).css("display","none").siblings().css("display","none");
	})
	$(".banner_item").mouseleave(function(){
		var index=$(this).index();
			var index=index-1;
		$(".banner_item").eq(index).css("display","none").siblings().css("display","none");
	})
	$(".body_right_middle div").click(function(){
		var index=$(this).index();
		$(".body_right_middle div").eq(index).addClass("active").siblings().removeClass("active");
		$(".middle_item").eq(index).css("display","block").siblings().css("display","none");
	})
	 $(".biaoqing").click(function(){
 	$(".photo").css("display","block");
 })
//--第一次点击清空留言框内提醒内容------------	 
	 var flag=0;
	$("#body_bottom_right_txt").click(function(){
		var dele=document.getElementById("body_bottom_right_txt");
		if(flag==0){
			dele.innerHTML="";
		}
			flag=1;
	})
  	$(".photo  img").click(function(){
	//---点击添加相应表情。
		var shu = new Array('weixiao', 'wuzuixiao', 'chiya', 'daxiao', 'deyi', 'kenai', 'kun', 'se');
		var a = $(this).index();
		var sr = "img/" + shu[a] + ".gif";
		var txt = document.getElementById("body_bottom_right_txt");
		//---盛放文本和表情的容器选用可编辑型div，避免表情图片以文本形式展示。
		txt.innerHTML += "<img src='" + sr + "'>";
		$(".photo").css("display", "none");
 	})
$(".pu").mouseover(function() {
		var txt = document.getElementById("body_bottom_right_txt").innerHTML;
	  //---把div中的图片转化为字符存放在input标签中，方便留言文本往数据库存储；
		var out="" //用于装时间字符串
		var date= new Date();
		 out+=date.getMonth()+1+"月";  
		 out+=date.getDate()+"日";
		 out+=date.getHours()+"时";
		 out+=date.getMinutes()+"分"
		 out+=date.getSeconds()+"秒";
		 $(".DateTime").val(out);
		 txt=txt.replace(/草|日|操|fuck|逼|靠|shit|智|障|死|傻|屌/gi, '**'); //敏感字过滤
		 $(".Txt").val(txt);
	});
	//------以下为获取数据库中存放的用户留言数据---------
		//----学院公告留言数据获取---------------
		$.ajax({
		datatype:"json",
		type:"get",
		url:"MsgServlet",
		success:function(data){
			var data1=JSON.parse(data);
			for (var i=data1.length-1;i>=0;i--) {
				var div=document.createElement("div");
				var p1=document.createElement("p");
				p1.appendChild(document.createTextNode(data1[i]["StaffName"]+"："))
				div.appendChild(p1);
				div.innerHTML+=data1[i]["Txt"];
				var p2=document.createElement("p");
				p2.className="Staff_p";
				p2.appendChild(document.createTextNode(data1[i]["DateTime"]));
				div.appendChild(p2);
				div.className="Staff";
				document.getElementsByClassName("middle_item")[0].appendChild(div);				
			}
		}	
	})
		//-------职工留言数据获取----
	$.ajax({
		datatype:"json",
		type:"post",
		url:"MsgServlet",
		success:function(data){
			var data1=JSON.parse(data);
			for (var  i=data1.length-1;i>=0;i--) {
				var div=document.createElement("div");
				var p1=document.createElement("p");
				p1.appendChild(document.createTextNode(data1[i]["StaffName"]+"："));
				div.appendChild(p1);
				div.innerHTML+=data1[i]["Txt"];
				var p2=document.createElement("p");
				p2.className="Staff_p";
				p2.appendChild(document.createTextNode(data1[i]["DateTime"]));
				div.appendChild(p2);
				div.className="Staff";
				document.getElementsByClassName("middle_item")[1].appendChild(div);				
			}
		}	
	});

	
})
