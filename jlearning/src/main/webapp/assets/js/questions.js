$(document).ready(function () {
	
	$(".regbtn").click(function(){
		$(this).hide(500);
	});
	
	$(".hlogo").click(function(){
		if($(".regandlog").css("display")!="none"){
			$(".regandlog").css("display","none");
		}
		else{
			$(".regandlog").css("display","block");
		}
		
	});
	
	$(".glyphicon-menu-up").click(function(){
		$(".login-banner").slideUp(500);
	});
	
	
	
});

$(function(){
	
	$.ajax({
		url:"../questions/getNewestQuestions.do",
		data:"",
		type:"get",
		dataType:"json",
		success:function(obj){
			if(obj.state==1){
				$("#date-list").append("<section class='stream-list__item'><div class='qa-rank'><div class='answers-num-tag'><div class='a-num'>0</div><div class='a-state'>回答</div></div><div class='views-num-tag hidden-xs'><div class='v-num'>0</div><div>浏览</div></div></div><div class='summary'><h5><a>python 和 js 变量作用域问题的不理解</a></h5><ul><li>用户名<span>发布时间</span></li></ul></div></section>"); 
			}
		}
	});
	

});

