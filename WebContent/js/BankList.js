$(function() {
	$.ajax({
		dataType: "json",
		type: "get",
		url: "BankListServlet",
		success: function(data) {
			console.log(data)
			for(var i = 0; i < data.length; i++) {
				var tr = document.createElement("tr");
				var tbody=document.createElement("tbody");
				var j= new Array(5);
				j[0] = data[i]["StaffName"];
				j[1] = data[i]["IDNum"];
				j[2] = data[i]["BankName"];
				j[3] = data[i]["Unit"];
				j[4] = data[i]["Money"]+"元";
				for(var k = 0; k < 5; k++) {
					var td = document.createElement("td");
					var p = document.createElement("p");
					p.appendChild(document.createTextNode(j[k]));
					td.appendChild(p);
					tr.appendChild(td);
				}
				$(".table tbody").append(tr);
			}
		}
	})
	var wrap = document.getElementById("wrap");
	var main = document.getElementById("main");
	var hei = document.body.clientHeight; //此处是页面可视高度
	wrap.style.height = hei + "px";
	var obj = document.getElementsByTagName("div");
	for(var i = 0; i < obj.length; i++) {
		if(obj[i].className == 'page') {
			obj[i].style.height = hei + "px"; //遍历所有页面内的div,若div类名是page；
		}                                       //则规范其高度为固定页面可视高度；
	}                                          //此举为方便划分页面；
	//加时间控制，防止滚轮过度灵敏，一次翻好几屏
	var startTime = 0, //翻屏起始时间  
		endTime = 0,
		now = 0;
	//浏览器兼容      
	if((navigator.userAgent.toLowerCase().indexOf("firefox") != -1)) {
		 //addEventListener添加事件和触发后执行的函数；
		document.addEventListener("DOMMouseScroll", scrollFun, false);
	} else if(document.addEventListener) {
		document.addEventListener("mousewheel", scrollFun, false);
	} else if(document.attachEvent) {
		document.attachEvent("onmousewheel", scrollFun);
	} else {
		document.onmousewheel = scrollFun;
	}

	//滚动事件处理函数
	function scrollFun(event) {
		startTime = new Date().getTime();
		var delta = event.detail || (-event.wheelDelta);
		//mousewheel事件中的 “event.wheelDelta” 属性值：返回的如果是正值说明滚轮是向上滚动
		//DOMMouseScroll事件中的 “event.detail” 属性值：返回的如果是负值说明滚轮是向上滚动
		if((endTime - startTime) < -1000) {
			if(delta > 0 && parseInt(main.offsetTop) > -(hei * 2)) {
				//向下滚动
				now = now - hei;
				toPage(now);
			}
			if(delta < 0 && parseInt(main.offsetTop) < 0) {
				//向上滚动
				now = now + hei;
				toPage(now);
			}
			endTime = new Date().getTime();
		} else {
			event.preventDefault();
		}
	}

	function toPage(now) {
		$("#main").animate({
			top: (now + 'px')
		}, 1000); //jquery实现动画效果
		if (now=='-2014') {
			$(".act").css("display","block");
			for(var i=0;i<3;i++){
				$(".act ul").eq(i).slideDown(2000).css("display","block");
				$(".img img").eq(i).slideDown(2000).css("display","block");
			}
		} else{
			$(".act ul").css("display","none");
			$(".img img").css("display","none");
		} 
	}
})