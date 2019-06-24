$(function(){
	$.ajax({
		dataType:"json",
		type:"get",
		url:'changeServlet',
		success:function(data){
		$("#StaffNum").val(data["StaffNum"]);
		$("#DeptName").val(data["DeptName"]);
		}
	});	
	$.ajax({
		dataType:"json",
		type:"post",
		url:'ChangeJudge',
		success:function(data){
			if (data["State"]=="待审核"){		
				$(".please form").css("display","none");
				var p1=document.createElement("p");
				var ptxt=document.createTextNode("正在审核中,勿再次提交！！！");		
				p1.style.textAlign="center";
				p1.style.color="green";
				p1.appendChild(ptxt);			
				document.getElementById("please").appendChild(p1);
			}else if(data["State"]=="审核完成"){
				$(".please form").css("display","none");
				var p1=document.createElement("p");
				var ptxt=document.createTextNode("您的审核已通过！");		
				p1.style.textAlign="center";
				p1.style.color="green";
				p1.appendChild(ptxt);			
				document.getElementById("please").appendChild(p1);
			} 
		}
	});
});
