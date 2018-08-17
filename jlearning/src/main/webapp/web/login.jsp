<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script type="text/javascript" src="../assets/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="../assets/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../assets/css/login.css"/>
	<title>欢迎来到Jlearning</title>
</head>

<body>
	<div class="login-page">
		<div>
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">欢迎登录</h4>
					</div>
					<form >
						<div class="login-wrap">
							<div class="modal-body">
								<div class="form-group">
									<label for="username" class="control-label">用户名</label>
									<input type="text" class="form-control" id="username" name="username"
									       tabindex="1" required="required"  placeholder="请输入用户名"
										   autocomplete="off">
										<span class="msg-default hidden" id="unamespan">用户名长度为6~9位</span>
								</div>
								<div class="form-group">
									<label class="control-label">密码</label>
									<input type="password" class="form-control" id="password" 
									       name="password" tabindex="2"placeholder="请输入密码">
									<span class="msg-default hidden" id="passwordspan">密码长度为6~9位</span>
									
								</div>
							</div>
							
							
								<p class="pull-right">
									<a href="forget.jsp" tabindex="4">忘记密码</a>
								</p>

							<div class="modal-footer">
								<button type="button" id="bt-login" class="flogbtn btn btn-success" tabindex="3">登录</button>
							     <span><a href="../user/showRegister.do">没有账号？立即注册</a></span>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	      
	  <script type="text/javascript">
	  
	  	$(document).ready(function(){
	  		
	  		function checkUserName(){
				if($("#username").val()==""){
	  				$("#unamespan").attr("class","msg-error");
		  			/* $("#unamespan").css("color","red"); */
		  			$("#unamespan").text("用户名不能为空");
		  			return false;
	  			}else if($("#username").val().length<6||$("#username").val().length>9){
	  				$("#unamespan").attr("class","msg-error");
		  			/* $("#unamespan").css("color","red"); */
		  			$("#unamespan").text("用户名长度为6~9位");
		  			return false;
	  			}else{
	  				$("#unamespan").attr("class","msg-success");
		  			/* $("#unamespan").css("color","blue"); */
		  			$("#unamespan").text("OK");
		  			return true;
	  			}
	  			
	  		}
	  		
	  		
	  		
	  		function checkPassword(){
	  			
	  			if($("#password").val()==""){
	  				$("#passwordspan").attr("class","msg-error");
		  			/* $("#passwordspan").css("color","red"); */
		  			$("#passwordspan").text("密码不能为空");
		  			return false;
	  			}else if($("#password").val().length<6||$("#password").val().length>9){
	  				$("#passwordspan").attr("class","msg-error");
		  			/* $("#passwordspan").css("color","red"); */
		  			$("#passwordspan").text("密码长度为6~9位");
		  			return false;
	  			}else{     
	  				$("#passwordspan").attr("class","msg-success");
		  			/* $("#passwordspan").css("color","blue"); */
		  			$("#passwordspan").text("OK");
		  			return true;
	  			}
	  			
	  		}
	  		

	  		
	  		
  		$("#username").on("blur",function(){
  			checkUserName();
  			
  		});
  		$("#username").on("focus",function(){
  			
  			$("#unamespan").attr("class","msg-default");
  			/* $("#passwordspan").css("color","red"); */
  			$("#unamespan").text("用户名长度为6~9位");
  			
  			
  		});
  		
  		$("#password").on("blur",function(){
  			checkPassword();
  		});
  		$("#password").on("focus",function(){
  			$("#passwordspan").attr("class","msg-default");
  			/* $("#passwordspan").css("color","red"); */
  			$("#passwordspan").text("密码长度为6~9位");
  		});
	       
	       
	       
  		
  		
  		
  		
	       
	       $('bt-login').click(function(){
	    	   
	    	  if(checkUserName()&&checkPassword()){
	    		  $.ajax({
		    		   url:"../user/login.do",
		    		   data:"username="+$("#username").val()+"$password="+$("#password").val(),
		    		   type:"post",
		    		   dataType:"json",
		    		   success:function(obj){
		    			   debugger;
		    			  if(obj.state==1){
		    				  location.href='../main/showIndex.do';
		    			  } else{
		    				  $("#unamespan").html(obj.message);
		    				  $("#unamespan").css("color","red");
		    			  }
		    		   }
		    	   });
	    	  }else{
	    		  
	    		  
	    	  }
	    	   
	    	   
	       });
	  		
	  		
	  	});

	   </script>
	   
	   
	   <script>
	      $("#bt-login").click(function(){
	    	 // alert(1);
	    	 $.ajax({
	    		 url:"../user/login.do",
	    		 data:"username="+$("#username").val()+"&password="+$("#password").val(),
	    		 type:"post",
	    		 dataType:"json",
	    		 success:function(obj){
	    			 if(obj.state==0){
	    				 $("#unamespan").html(obj.message);
	    				 $("#unamespan").css("color","red");
	    			 }else{
	    				 location.href='../questions/showQuestions.do';
	    			 }
	    		 }
	    	 });
	      });
	   </script>
	   
</body>

</html>