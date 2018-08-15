

//注册横条收起
$(document).ready(function () {
	
	$(".glyphicon-menu-up").click(function(){
		$(".login-banner").slideUp(500);
	});
});

//搜索框点击变化
$(function(){
	$("#search-input").focus(function(){
		$(".header-search").css("width","500px");
	});
	$("#search-input").blur(function(){
		$(".header-search").css("width","196px");
	});
});
