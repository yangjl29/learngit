$(function(){
	var under_hheight = $(".blank_under_header").offset().top;
	$(window).scroll(function(){
		var this_scrollTop=$(this).scrollTop();
		if(this_scrollTop>under_hheight){
			$("#backtop").show();
		}
		else{
			$("#backtop").hide();
		}
	});
})

