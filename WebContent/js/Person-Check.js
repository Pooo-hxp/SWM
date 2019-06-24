$(function() {
	$.ajax({
		dataType: "json",
		type: "post",
		url: "PersonCheckServlet",
		success: function(data) {
			for(var i = 0;i < data.length; i++) {
				console.log(data);
				var tr = document.createElement("tr");
				var kk=new Array(5);
                kk[0]=data[i]["StaffNum"];
                kk[1]=data[i]["Sleep"]+"天";
                kk[2]=data[i]["OverTime"]+"天";
                kk[3]=data[i]["Payroll"]+"元";
                kk[4]=data[i]["Money"]+"元";
				for(var j = 0; j < 5; j++) {
							var td = document.createElement("td");
							var txt = document.createTextNode(kk[j]);
							td.appendChild(txt);
							tr.appendChild(td); 
				}
				var ele = document.getElementById("tbody");
				ele.appendChild(tr);
			}
		}
	})
})