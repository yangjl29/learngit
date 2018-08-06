<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<!--bootstrap 3.3.7-->

<head>
	<meta charset="utf-8" />
	<title>最新的问题 - JLearning 金手指</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script type="text/javascript" src="../assets/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="../assets/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../assets/css/frame.css" />
	<script src="../assets/js/frame.js" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="../assets/css/questions.css" />
	<script type="text/javascript" src="../assets/js/questions.js"></script>
	
</head>

<body>
	<%@ include file="header.jsp" %>
	<article>
		<div class="login-banner hidden-sm hidden-xs ">
			<div class="container">
				<div class="jumbotron">
					<h1 class="title">在JLearning金手指，问题不再困扰</h1>
					<p class="banner-slogan">加入我们，你可以认识更多的好友，共同探讨问题</p>
					<p>
						<a class="btn  btn-lg banner-btn" href="../user/showRegister.do" role="button">免费注册</a>
					</p>
					<i class="glyphicon glyphicon-menu-up" ></i>
				</div>
			</div>
		</div>
		<div class="container question-page-artical">
			<div class="col-xs-12 col-md-9 main-content">
				<div>

					<!-- Nav tabs -->
					<ul class="nav nav-tabs content-toptab" role="tablist">
						<li role="presentation">
							<a href="../questions/showQuestions.do/#date-list" aria-controls="home" role="tab" data-toggle="tab">最新的问题</a>
						</li>
						<li role="presentation"  class="active">
							<a href="../questions/showQuestions.do/#comment-list" aria-controls="profile" role="tab" data-toggle="tab">热门问题</a>
						</li>
						<li role="presentation">
							<a href="../questions/showQuestions.do/#no-answer-list" aria-controls="messages" role="tab" data-toggle="tab">等待回答</a>
						</li>
					</ul>
					<!-- Tab panes -->
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane fade in active" id="date-list">
						按照日期查询前10条记录
						
						</div>
						<div role="tabpanel" class="tab-pane fade" id="comment-list">
						按照评论数查询前10条记录
						
						</div>
						<div role="tabpanel" class="tab-pane fade" id="no-answer-list">
						按照时间查询没有人回答的问题
						
						</div>
					</div>
				</div>
			</div>
			<div>
			</div>
		</div>
	</article>
	
	<%@ include file="footer.jsp" %>
</body>

</html>
