<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
		<div class="modal fade" id="myModal"  role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button"  class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">登录</h4>
					</div>
					<form action="" method="post">
						<div class="login-wrap">
							<div class="modal-body">
								<div class="form-group">
									<label for="username" class="control-label" >用户名或Email</label>
									<input type="text" id="username" class="form-control" name="username" tabindex="1" required="required"  placeholder="用户名 或 Email"
									    autocomplete="off" autofocus="autofocus">
								</div>
								<div class="form-group">
									<label class="control-label">密码</label>
									<span class="pull-right">
										<a href="" tabindex="4">忘记密码</a>
									</span>
									<input type="password" class="form-control" name="password" tabindex="2" required="required" placeholder="请输入密码">
								</div>
							</div>
							<div class="login_alert">账号或密码错误</div>
							<div class="modal-footer">
								<button type="button" id="modal_login_btn" class="flogbtn btn btn-success" tabindex="3">登录</button>
							</div>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
		<a id="top" name="top"></a>
		<div class="container question-page-topbar">
			<div class="col-sm-8 col-md-9 col-lg-9 topbar-leftdiv">
				<div class="header-logo">
					<h1>
						<a class="hlogo" href="../questions/showQuestions.do">JLearning</a>
					</h1>
				</div>
				<form action="#" method="get" class="header-search  hidden-sm hidden-xs ">
					<button class="btn btn-link">
						<span class="glyphicon glyphicon-search"></span>
					</button>
					<input type="text" name="q" class="form-control" id="search-input" autocomplete="off" />
				</form>
			</div>
			<div class="col-sm-4 col-md-3 col-lg-3 text-right topbar-rightdiv">
				<ul>
				<c:if test="${user==null}">
					<li class="regandlog">
						<a class="reglink userlink" href="${pageContext.request.contextPath}/user/showRegister.do">
							<button type="button" class="btn btn-primary  regbtn">注册</button>
						</a>
						<a class="loginlink userlink">
							<button type="button" id="login_btn" class="btn btn-default  logbtn" data-toggle="modal" data-target="#myModal">登录</button>
						</a>
					</li>
				</c:if>
				<c:if test="${user!=null}">
					<li class="logined-drop">
						<div class="btn-group">
							<button type="button" class="start-btn btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">开始
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li>
									<a href="/ask">提问题</a>
								</li>
								<li>
									<a href="/write">写文章</a>
								</li>
								<li>
									<a href="/record">记笔记</a>
								</li>
							</ul>
						</div>
					</li>
				</c:if>
				</ul>
			</div>
		</div>
	</header>
	<div class="blank_under_header"></div>
	
	