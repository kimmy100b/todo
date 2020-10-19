<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="./css/styles.css" />
<script src="https://kit.fontawesome.com/2a001071af.js"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<title>main</title>
</head>
<body>
	<header>
		<h1 id="mainTitle">나의해야할 할일들</h1>
	</header>

	<div class="new-todo">
		<div class="add-new-todo">
			<a href="todoForm.jsp">새로운 TODO 등록</a>
		</div>
	</div>

	<div class="wrapper">
		<c:forEach var="type" items="${todoTypes}">
			<section id="${type}">
				<div class="title">${type}</div>
				<c:forEach var="list" items="${todoList}">
					<c:if test="${list.type eq type}">
						<div class="content">
							<h1 class="content-title">${list.title}</h1>
							<div class="content-detail">등록날짜 :
							<fmt:parseDate var="parseRegDate" value="${ list.regDate }"
								pattern="yyyy-MM-dd HH:mm:ss.S" />
							<fmt:formatDate var="formatRegDate" value="${parseRegDate}"
								pattern="yyyy.MM.dd" />
							${ formatRegDate },
								${list.name}, 우선순위 ${list.sequence}</div>
							<c:if test="${list.type ne 'DONE'}">
								<button class="btn-next"
									onclick="changeButtonClick(${list.id},this)">
									<i class="fas fa-arrow-right"></i>
								</button>
							</c:if>
						</div>
					</c:if>
				</c:forEach>
			</section>
		</c:forEach>
	</div>
	<script src="js/changeType.js"></script>
</body>

</html>
