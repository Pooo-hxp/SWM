	var code;
	function createCode() {
		 code = '';
		var codeLength = 4;
		var codeV = document.getElementById('check_idcode');
		var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
		for(var i = 0; i < codeLength; i++) {
			var index = Math.floor(Math.random() * 36);
			code += random[index];
		}
		codeV.value = code;
	}
	function validate() {
		var oValue = document.getElementById('code_input').value.toUpperCase();//转为大写，方便验证
		if(oValue == '') {
			alert("请输入验证码");
			return false;

		}else if(oValue != code) {
			check();
			return false;
		} else
			return true;
	}
	window.onload = function() {
		createCode();
	}
	function check(){
		$(".out").css("display","block");
				$('.inner').animate({
				width: $(".out").width(),
			}, 1500, function() {
				alert('验证码错误，请重新输入');
				$(".out").css("display","none"); 
				$(".inner").css("width","0px");
				$("#code_input").val(""); //清空验证码
			});
			var timerID = setInterval(function() { /*设置计时器,动态的改变span的文本显示*/
				var num = Math.ceil($(".inner").width() / $(".out").width() * 100); 
				$("span").html(num + '%');
			}, 100);
	}
