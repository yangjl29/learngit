$(function(){
	
})


function getNewest(){
	$.ajax({
		url:"../questions/newest.do",
		data:"",
		type:"get",
		dataType:"json",
		success:function(obj){
			if(obj.state==1){
				for(i=0; i<obj.data.length; i++){
					
					/* $("#date-list").append("<section class='stream-list__item'><div class='qa-rank'><div class='unanswered_tag'>0<div class='a-state'>回答</div></div><div class='views-num-tag hidden-xs'>0<div>浏览</div></div></div><div class='summary'><h5 style='font-size:16px;'><a href='#'>python 和 js 变量作用域问题的不理解</a></h5><ul style='position:absolute;right:0;bottom:0'><li>用户名<span>发布时间</span></li></ul></div></section>"); */
					
					var str = "<section class='stream-list__item'>" +
								"<div class='qa-rank'>" +
									"<div class='unanswered_tag'>0" +
										"<div class='a-state'>回答</div>" +
									"</div>"+
									"<div class='views-num-tag hidden-xs'>0" +
										"<div>浏览</div>" +
									"</div>" +
								"</div>"+
								"<div class='summary'>" +
									"<h5>" +
										"<a href='#'>"+obj.data[i].title+"</a>" +
									"</h5>" +
									"<ul>" +
										"<li>用户名<span>"+obj.data[i].createdTime+"</span></li>" +
									"</ul>" +
								"</div>" +
							"</section>";
					
					$("#date-list").append(str);
				}
			}
		}
	});
}
