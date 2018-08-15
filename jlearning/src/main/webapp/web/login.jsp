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
					<form action="${pageContext.request.contextPath}/user/login.do" method="post">
						<div class="login-wrap">
							<div class="modal-body">
								<div class="form-group">
									<label for="username" class="control-label">用户名</label>
									<input type="text" class="form-control" name="username" tabindex="1" required="required" oninput="setCustomValid('')" placeholder="请输入用户名"
										autocomplete="off">
										<span class="msg-error " id="unamespan">用户名长度为6~9位</span>
								</div>
								<div class="form-group">
									<label class="control-label">密码</label>
									<span class="msg-default hidden" id="passwordspan">密码长度为6~9位</span>
									
									<input type="password" class="form-control" name="password" tabindex="2" required="required" placeholder="请输入密码">
								</div>
							</div>
							
							
								<p class="pull-right">
									<a href="#" tabindex="4">忘记密码</a>
								</p>

							<div class="modal-footer">
								<button type="submit" class="flogbtn btn btn-success" tabindex="3">登录</button>
							     <span><a href="../user/showRegister.do">没有账号？立即注册</a></span>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	

</body>

</html>