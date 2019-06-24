$(function() {
	$.ajax({
		dataType: "json",
		type: "post",
		url: "PersonUpdataServlet",
		success: function(data) {
			if (data.length==0) {
			var ple=document.getElementsByClassName("please");
			var div1=document.createElement("div");
			var divtxt=document.createTextNode("暂无申请");
			div1.style.textAlign="center";
			div1.appendChild(divtxt);
			ple.appendChild(div1);
			} else{
			for(var i = 0;i < data.length; i++) {
				var tr = document.createElement("tr");
				var kk=new Array(5);
                kk[0]=data[i]["StaffNum"];
                kk[1]=data[i]["ChangeName"];
                kk[2]=data[i]["DeptName"];
                kk[3]=data[i]["ChangeFont"];
                kk[4]=data[i]["State"];
                var form=document.createElement("form");
                var table=document.createElement("table");
                table.className="table table-bordered table-hover tableadd";  
                form.action="ChangePassServlet";
                form.method="post";
				for(var j = 0;j<5; j++) {
					var shu=["StaffNum","ChangeName","DeptName","ChangeFont","State"]
							var td = document.createElement("td");
							td.className="text-primary add";
							var a = document.createElement("input");
							a.style.border="none";
							a.style.textAlign="center";
							a.readOnly=true;
							a.name=shu[j];
							a.value=kk[j];
							td.appendChild(a);
							tr.appendChild(td); 
				}
				var please = document.getElementById("please");
				var td2 = document.createElement("td");
				var inpu= document.createElement("input")
				td2.className="text-primary add";
				inpu.type="submit";
				inpu.value="通过";
				td2.appendChild(inpu);
				tr.appendChild(td2); 
				table.appendChild(tr);
				form.appendChild(table);
				please.appendChild(form);
			}
			}
		}
	})
})