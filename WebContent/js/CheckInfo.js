$(function() {
	$.ajax({
		dataType: "json",
		type: "get",
		url: "CheckInfoServlet",
		success: function(data) {
			var A = ""; 
			var a = data["Payroll"] * 1 + data["OverTime"] * 200 - data["Sleep"] * 100;//需要轉換的數字
			a=String(a);
			$("#StaffNum").html(data["StaffNum"]);
			$("#Payroll").html(data["Payroll"] * 1);
			$("#Bonus").html(data["OverTime"] * 200);
			$("#Deduction").html(data["Sleep"] * 100);
			$("#add").html(a + "RMB");
			for(i = 0; i < a.length ; i++) {
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
			switch(a.length ) {
				case 1:
					A = A + "元";
					break;
				case 2:
					A = A[0] + "拾" + A[1] + "元";
					break;
				case 3:
					A = A[0] + "佰" + A[1] + "拾" + A[2] + "元";
					break;
				case 4:
					A = A[0] + "仟" + A[1] + "佰" + A[2] + "拾"+A[3]+ "元";
					break;
			};
			document.getElementById("ADD").innerHTML = A;
		}
	})
})