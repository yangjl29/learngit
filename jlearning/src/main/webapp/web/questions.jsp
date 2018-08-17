<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh">
<!--bootstrap 3.3.7-->

<head>
<meta charset="utf-8" />
<title>新鲜事 - JLearning 金手指</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="../assets/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../assets/css/frame.css" />
<script src="../assets/js/frame.js" type="text/javascript"
	charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href="../assets/css/questions.css" />
<script type="text/javascript" src="../assets/js/questions.js"></script>

</head>

<body>
	<%@ include file="header.jsp"%>
	<article>
		<c:if test="${user==null}">
			<div class="login-banner hidden-sm hidden-xs ">
				<div class="container">
					<div class="jumbotron">
						<h1 class="title">在JLearning金手指，畅所欲言</h1>
						<p class="banner-slogan">加入我们，你可以认识更多的好友</p>
						<p>
							<a class="btn  btn-lg banner-btn" href="../user/showRegister.do"
								role="button">免费注册</a>
						</p>
						<i class="glyphicon glyphicon-menu-up"></i>
					</div>
				</div>
			</div>
		</c:if>
		<div class="container question-page-artical">
			<div class="col-xs-12 col-md-9 main-content">
				<div>

					<!-- Nav tabs -->
					<ul class="nav nav-tabs content-toptab" role="tablist">
						<li role="presentation" class="active"><a href="#date-list"
							aria-controls="home" role="tab" onclick="getNewest()">新鲜事</a></li>
						<li role="presentation"><a href="../questions/hottest.do"
							aria-controls="profile" role="tab">热门</a></li>
						<li role="presentation"><a href="../questions/unanswered.do"
							aria-controls="messages" role="tab">等待回答</a></li>
					</ul>
					<!-- Tab panes -->
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane  active" id="date-list">
							<c:forEach items="${newList}" var="n">
								<section class="stream-list__item">
									<div class="qa-rank">
										<div class="unanswered_tag">
											<c:if test="${n.replyCount==null}">
												0
											</c:if>
											<c:if test="${n.replyCount!=null}">
												${n.replyCount }
											</c:if>
											<div class="a-state">回答</div>
										</div>
										<div class="views-num-tag hidden-xs">
											0
											<div>浏览</div>
										</div>
									</div>
									<div class="summary">
										<h5>
											<a href="../questions/showQdetail.do?qid=${n.id}">${n.title}</a>
										</h5>
										<ul>
											<li>
												<div class="ss">${n.username}</div> <span> <fmt:formatDate
														value="${n.createdTime}" type="both"></fmt:formatDate>
											</span>
											</li>
										</ul>
									</div>
								</section>
							</c:forEach>
						</div>

					</div>
				</div>
				<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><c:if test="${curentPage-1==0}">
						<a  aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
						</c:if> <c:if test="${curentPage-1!=0}">
							<a href="../questions/showQuestions.do?page=${curentPage-1}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a>
						</c:if></li>
					<li><a>${curentPage}</a></li>
					<li><c:if test="${curentPage+1>pageSize}">
						<a href="#" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
						</c:if> <c:if test="${curentPage+1<=pageSize}">
							<a href="../questions/showQuestions.do?page=${curentPage+1}"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a>
						</c:if></li>
				</ul>
			</nav>
			</div>
			<div class="hidden-md hidden-sm hidden-xs col-xs-12 col-md-3 side-content"> </div>
			<div></div>

		</div>
	</article>

	<%@ include file="footer.jsp"%>
	<a href="#" id="backtop" class="btn-meau" title="返回顶部"
		style="display: flex;"> <svg xmlns="http://www.w3.org/2000/svg"
			width="19" height="12">
			<path
				d="M9.314 0l9.313 9.314-2.12 2.121-7.193-7.192-7.193 7.192L0 9.314z"
				fill="#FFF" fill-rule="evenodd"></path>
		</svg>
	</a>
</body>
</html>
