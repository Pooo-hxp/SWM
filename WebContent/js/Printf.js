//----打印功能--------------
function preview(oper) {
		if(oper < 1) {
			bdhtml = window.document.body.innerHTML; //获取当前页的html代码          
			sprnstr = "<!--startprint-->"; //设置打印开始区域         
			eprnstr = "<!--endprint-->"; //设置打印结束区域          
			prnhtml = bdhtml.substring(bdhtml.indexOf(sprnstr)); //从开始代码向后取html 
			prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr)); //从结束代码向前取html    
			window.document.body.innerHTML = prnhtml;//使得当前打印区域格式化为打印区域
			window.print();
			window.document.body.innerHTML = bdhtml;
				} 
		else {
			window.print();
				}
};
//------------获取当前时间并转化-----------
window.onload=function(){		
	    var out="" //用于装时间字符串
		var date= new Date();
		 out+=date.getFullYear()+"年";
		 out+=date.getMonth()+1+"月";  //这里要加1 用get函数获取月份为0-11月所以我加一
		 out+=date.getDate()+"日";
		 out+=date.getHours()+"时";
		 out+=date.getMinutes()+"分"
		 out+=date.getSeconds()+"秒";
		document.getElementById("Getdate").innerHTML=out;
};
    //---------Ajax请求接收数据 这个需要提取职工表信息 ------
    $(function(){
	$.ajax({
		dataType:"json",
		type:"post",
		url:"StaffInfoServlet",
		success:function(data){
		$("#StaffName").html(data["StaffName"]);
		$("#IDNum").html(data["IDNum"]);
		}
	});
	  //---------Ajax请求接收数据 这个需要提取考勤表信息 ------
$.ajax({
		dataType:"json",
		type:"get",
		url:"PrintServlet",
		success:function(data){
			console.log(data)
		$("#Sleep").html(data["Sleep"]*1+"天");
		$("#SleepMoney").html(data["Sleep"]*100+"元");
		$("#OverTime").html(data["OverTime"]+"天");
		$("#OverTimeMoney").html(data["OverTime"]*200+"元");
		$("#Payroll").html(data["Payroll"]+"元");
		$("#Money").html(data["Money"]+"元");
        var  a=data["OverTime"]*200;
        a=String(a);
        var A="";
			for(i = 0; i <= a.length - 1; i++) {
				if(a[i] == "1") { //工资数字转中文大写函數
					A += "壹";
				} else if(a[i] == "2") {
					A += "贰";
				} else if(a[i] == "3") {
					A += "叁";
				} else if(a[i] == "4") {
					A += "肆";
				} else if(a[i] == "5") {
					A += "伍";
				} else if(a[i] == "6") {
					A += "陆";
				} else if(a[i] == "7") {
					A += "柒";
				} else if(a[i] == "8") {
					A += "捌";
				} else if(a[i] == "9") {
					A += "玖";
				} else if(a[i] == "0") {
					A += "零";
				}
			}
			switch(a.length) {
				case 3:
						A=A[0] + "佰元整";
						break;
				case 4:
					A = A[0] + "仟" + A[1] + "佰元整";
					break;
			};
			document.getElementById("OTM").innerHTML = A;
			var  b=data["Sleep"]*100;
			b=String(b);
			var B="";
			for(i = 0; i < b.length; i++) {
				if(b[i] == "1") { //工资数字转中文大写函數
					B += "壹";
				} else if(b[i] == "2") {
					B += "贰";
				} else if(b[i] == "3") {
					B += "叁";
				} else if(b[i] == "4") {
					B += "肆";
				} else if(b[i] == "5") {
					B += "伍";
				} else if(b[i] == "6") {
					B += "陆";
				} else if(b[i] == "7") {
					B += "柒";
				} else if(b[i] == "8") {
					B += "捌";
				} else if(b[i] == "9") {
					B += "玖";
				} else if(b[i] == "0") {
					B += "零";
				}
			}
			switch(b.length) {
				case 3:
					B=B[0] + "佰元整";
					break;
				case 4:
					B = B[0] + "仟" + B[1] + "佰元整" ;
					break;
			};
			document.getElementById("SM").innerHTML = B;	
		}
	})
})  

