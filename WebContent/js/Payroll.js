$(function(){
	$(".item").mouseover(function(){
		var index=$(this).index();
		$(".left_top_bottom_add").css("display","block");	
		$(".list").eq(index).fadeIn(50).siblings().fadeOut(50);
	})
	$(".item").mouseleave(function(){
		$(".left_top_bottom_add").css("display","none");
	})
})
