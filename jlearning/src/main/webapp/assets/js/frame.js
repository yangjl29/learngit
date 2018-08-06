$(document).ready(function () {
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
	
	
	
	
});

$(document).ready(function () {
	
	$(".glyphicon-menu-up").click(function(){
		$(".login-banner").slideUp(500);
	});
});