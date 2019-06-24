$(function(){
	$(".body_on_top div").mouseover(function(){
		var index=$(this).index();
		if(index<4){
		$(".body_on_top div").eq(index).addClass("add").siblings().removeClass("add");
			
		}
	$(".body_on_top").mouseleave(function(){
		var index=1;
		$(".body_on_top div").eq(index).addClass("add").siblings().removeClass("add");
	})
	})
	
})