<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>欢迎登陆</title>
<script type="text/javascript" src="../assets/js/jquery-3.3.1.min.js"></script>
<link href="../css/login.css" rel="stylesheet" />
<style type="text/css">
	body {
		background-image: url("../assets/image/bg.jpg");
	}
</style>
<script type="text/javascript">
	$("#login_btn").click(function(){
		$.ajax({
			url:"../user/login.do",
			data:"username="+$("#username").val()+"&password="+$("#password").val(),
			type:"post",
			dataType:"json",
			success:function(obj){
				if(obj.state==0){
					
				}
				else{
					location="../quesiton/showQuestons.do";
				}
			}
		});
	});
</script>
</head>
<body>
	<div class="login-from">
		<div class="top-login">
			<span> <img alt="" src="images/group.png">
			</span>
		</div>
		<h1>登录</h1>
		<div class="login">
			<form>
				<div class="login-ic">
					<input type="text" name="username" id="username" />
					<div class="clear"></div>
				</div>
				<div class="login-ic">
					<i class="icon"></i>
					<input type="password" name="password" id="password"/>
					<div class="clear"></div>
				</div>
				<div class="log-bon">
					<input type="button" value="确定" id="login_btn">
				</div>
			</form>
			<p class="copy">@ 2018 xxxxxxxxxxxxx</p>
		</div>
	</div>
</body>
</html>