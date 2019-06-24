$(function() {
	var index = 0;
	$(".Background-color").click(function() {
		switch(index) {
			case 0:
				$(".nack").css("background", "linear-gradient(to left,#DDDDDD,#AAAAAA)");
				$(".body").css("background", "lavender");
				index = 1;
				break;

			case 1:
				$(".nack").css("background", "linear-gradient(to left,#FFCCCC,powderblue)");
				$(".body").css("background", "#DDDDDD");
				index = 2;
				break;
			case 2:
				$(".nack").css("background", "linear-gradient(to left,#AAAAAA,lavender)");
				$(".body").css("background", "silver");
				index = 3;

				break;
			case 3:
				$(".nack").css("background", "linear-gradient(to left,#FFFFFF,#DDDDDD)");
				$(".body").css("background", "#DDDDDD");
				index = 4;

				break;
			case 4:
				$(".nack").css("background", "rgba(255, 255, 255, 0.6)");
				$(".body").css("background", "#f7f5f4");
				index = 0;

				break;

		}
	})
})