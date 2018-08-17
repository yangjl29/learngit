

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

//退出按钮按下与松开变化
$(function(){
	$(".exit").mousedown(function(){
		$(".exit>a>button").css("box-shadow","inset rgba(49, 45, 45, 0.88) 0px 0px 5px 1px");
		$(".exit>a>button").css("font-size","13px");
	});
	$(".exit").mouseup(function(){
		$(".exit>a>button").css("box-shadow","0px 0px 9px 2px #000000e0");
		$(".exit>a>button").css("font-size","14px");
	});
})
$(function(){
	
	$(".user-name>small").click(function(){
		alert("未发现个人主页");
		/*$.ajax({
		url:"../user/personalInfo.do",
		data:"uid=${user.id}",
		type:"post",
		dataType:"json",
		success:function(obj){
			location.href = "../user/showPersonalpage.do";
		}
	});*/
	});
})