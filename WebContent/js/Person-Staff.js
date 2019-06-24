$(function() {
	$.ajax({
		dataType: "json",
		type: "post",
		url: "PersonStaffServlet",
		success: function(data) {
			for(var i = 0;i < data.length; i++) {			
				var tr = document.createElement("tr");	
				console.log(data);
                var kk=new Array(7);
                kk[0]=data[i]["StaffNum"];
                kk[1]=data[i]["StaffName"];
                kk[2]=data[i]["StaffSex"];
                kk[3]=data[i]["StaffJob"];
                kk[4]=data[i]["IDNum"];
                kk[5]=data[i]["DeptNum"];
                kk[6]=data[i]["DeptName"];
                
				for(var j = 0; j <=6; j++) {
							var td = document.createElement("td");
							var txt = document.createTextNode(kk[j]);
							td.appendChild(txt); //把文本内容塞进td内
							tr.appendChild(td); //把td塞进tr中
				}
				var ele = document.getElementById("tbody");
				ele.appendChild(tr);
			}
		}
	})
})