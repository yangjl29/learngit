<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>Jlearning</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Trendy Tab Login Form template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'><!--web font-->
<script src="js/jquery.min.js"></script>
<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
<!-- //js -->
</head>
<body>
	<!-- main -->
	<div class="main">
		<h1>欢迎登陆/注册</h1>
		<div class="login-form">
			<div class="sap_tabs w3ls-tabs">
				<div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
					<ul class="resp-tabs-list">
						<!--登录-->
						<li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span>登录</span></li> 
						<li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><label>/</label><span>注册</span></li>
					</ul>	
					<div class="clear"> </div>
					<div class="resp-tabs-container">
						<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
							<div class="login-agileits-top"> 
								<form action="#" method="post">
									<p>用户名</p>
									<input type="text" name="User Name" required="" placeholder="Username"/>
									<p>密码</p>
									<input type="password" name="Password" required="" placeholder="Password"/>	 
									<input type="checkbox" id="brand" value="">
									<label for="brand"><span></span> 记住密码&nbsp;?</label> 
									<input type="submit" value="确定">
								</form>  
							</div>
							<div class="login-agileits-bottom"> 
								<p><a href="#">忘记密码&nbsp;?</a></p>
							</div> 
						</div> 
						

						
						<!--注册-->
						<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
							<div class="login-agileits-top sign-up"> 
								<form action="#" method="post">
									<p>用户名 </p>
									<input type="text" name="User Name"  required=""placeholder="Username"/>
									
									<p>密码</p>
									<input type="password" name="Password"  required=""placeholder="Password"/>	
									<input type="checkbox" id="brand1" value="">
									<p>邮箱号 </p>
									<input type="text" name=Email"  required=""placeholder="Email"/>
									<label for="brand1"><span></span>接受条款的使用</label> 
									<input type="submit" value="确定">
								</form>  
							</div>
						</div>
					</div>							
				</div>	 
			</div> 
			
			
			<!-- ResponsiveTabs js -->
			<script type="text/javascript">
				$(document).ready(function () {
					$('#horizontalTab').easyResponsiveTabs({
						type: 'default',           
						width: 'auto', 
						fit: true 
					});
				});
			</script>
	
		</div>	
	</div>	

	<div class="copyright">
		<p> @ 2018 xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		<a href="#" target="_blank">jlearning</a></p>
	</div>
	 
</body>
</html>










