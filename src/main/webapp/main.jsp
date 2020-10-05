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
<title>main</title>
</head>
<body>
	<div class="new-todo">
		<div class="add-new-todo">
			<a href="todoForm.jsp">새로운 TODO 등록</a>
		</div>
	</div>
	<div class="wrapper">
		<article class="todo">
			<div class="title">TODO</div>
			<c:forEach items="${ list }" var="todo">
				<c:if test="${todo.type eq 'TODO' }">
					<section class="content todo-content">
						<div class="content-title">${ todo.title }</div>
						<!-- <td>등록날짜 :   <fmt:parseDate var="parseRegDate" value="${ todo.regDate }" pattern="yyyy-MM-dd HH:mm:ss.S" /> -->
						<div class="content-detail">
							등록날짜 :
							<fmt:parseDate var="parseRegDate" value="${ todo.regDate }"
								pattern="yyyy-MM-dd HH:MM:SS" />
							<fmt:formatDate var="formatRegDate" value="${parseRegDate}"
								pattern="yyyy.MM.dd" />
							${ formatRegDate }, ${ todo.name }, 우선순위 ${ todo.sequence }
							<i class="fas fa-arrow-right"></i>
						</div>
					</section>
				</c:if>
			</c:forEach>
		</article>
		<article class="doing">
			<div class="title">DOING</div>
			<c:forEach items="${ list }" var="todo">
				<c:if test="${todo.type eq 'DOING' }">
					<section class="content doing-content">
						<div class="content-title">${ todo.title }</div>
						<!-- <td>등록날짜 :   <fmt:parseDate var="parseRegDate" value="${ todo.regDate }" pattern="yyyy-MM-dd HH:mm:ss.S" /> -->
						<div class="content-detail">
							등록날짜 :
							<fmt:parseDate var="parseRegDate" value="${ todo.regDate }"
								pattern="yyyy-MM-dd HH:MM:SS" />
							<fmt:formatDate var="formatRegDate" value="${parseRegDate}"
								pattern="yyyy.MM.dd" />
							${ formatRegDate }, ${ todo.name }, 우선순위 ${ todo.sequence }
						</div>
					</section>
				</c:if>
			</c:forEach>
		</article>
		<article class="done">
			<div class="title">DONE</div>
			<c:forEach items="${ list }" var="todo">
				<c:if test="${todo.type eq 'DONE' }">
					<section class="content done-content">
						<div class="content-title">${ todo.title }</div>
						<!-- <td>등록날짜 :   <fmt:parseDate var="parseRegDate" value="${ todo.regDate }" pattern="yyyy-MM-dd HH:mm:ss.S" /> -->
						<div class="content-detail">
							등록날짜 :
							<fmt:parseDate var="parseRegDate" value="${ todo.regDate }"
								pattern="yyyy-MM-dd HH:MM:SS" />
							<fmt:formatDate var="formatRegDate" value="${parseRegDate}"
								pattern="yyyy.MM.dd" />
							${ formatRegDate }, ${ todo.name }, 우선순위 ${ todo.sequence }
						</div>
					</section>
				</c:if>
			</c:forEach>
		</article>
	</div>
</body>

</html>