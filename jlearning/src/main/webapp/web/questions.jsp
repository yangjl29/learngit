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
		<c:if test="${user==null}">
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
		</c:if>
		<div class="container question-page-artical">
			<div class="col-xs-12 col-md-9 main-content">
				<div>

					<!-- Nav tabs -->
					<ul class="nav nav-tabs content-toptab" role="tablist">
						<li role="presentation" class="active">
							<a href="#date-list" aria-controls="home" role="tab"  onclick="getNewest()">最新的问题</a>
						</li>
						<li role="presentation">
							<a href="../questions/showHottest.do" aria-controls="profile" role="tab"  >热门问题</a>
						</li>
						<li role="presentation">
							<a href="../questions/showUnAnswered.do" aria-controls="messages" role="tab"  >等待回答</a>
						</li>
					</ul>
					<!-- Tab panes -->
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane  active" id="date-list">
						按照日期查询前10条记录
							<c:forEach items="${newList}" var="n" >
								<section class="stream-list__item">
									<div class="qa-rank">
										<div class="unanswered_tag">0
											"<div class="a-state">回答</div>
										</div>
										<div class="views-num-tag hidden-xs">0
											<div>浏览</div>
										</div>
									</div>
									<div class="summary">
										<h5>
											<a href="#">${n.title}</a>
										</h5>
										<ul>
											<li>
											<c:forEach items="userList" var="u">
												<c:if test="${u.id==n.uid }">
													${u.username}
												</c:if>
											</c:forEach>
											<span>${n.createdTime}</span></li>
										</ul>
									</div>
								</section>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-md-3 side-content">
				
			</div>
			<div>
			</div>
		</div>
	</article>
	
	<%@ include file="footer.jsp" %>
</body>
</html>
