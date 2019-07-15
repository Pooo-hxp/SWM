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
				document.getElementById("please").appendChild(`
                                     <p style="color: green; text-align: center;">
                                         正在审核中,勿多次次提交！！！
                                            </p>
                                  `);
			}else if(data["State"]=="审核完成"){
				$(".please form").css("display","none");			
				document.getElementById("please").appendChild(`
                                      <p style="color: green; text-align: center;">
                                          您的审核已通过！
                                            </p>

                               `);
			} 
		}
	});
});
