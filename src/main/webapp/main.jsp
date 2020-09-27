<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ include file="/Todo.java"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="./css/styles.css" />
<title>main</title>
</head>

<body>
	<%
		List<Todo> list = (List) request.getAttribute("list");
	%>
	<div class="new-todo">
		<div class="add-new-todo">
			<a href="todoForm.jsp">새로운 TODO 등록</a>
		</div>
	</div>
	<div class="wrapper">
		<section class="todo">
			<div class="title">TODO</div>
			<div class="content todo-content">
				<c:forEach var="todo" items="${list }">
                	${requestScope.todo }
                </c:forEach>
		</section>
		<section class="doing">
			<div class="title">DOING</div>
			<div class="content doing-content"></div>
		</section>
		<section class="done">
			<div class="title">DONE</div>
			<div class="content done-content"></div>
		</section>
	</div>
</body>

</html>