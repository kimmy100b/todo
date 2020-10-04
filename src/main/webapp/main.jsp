<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="./css/styles.css" />
<title>main</title>
</head>
<body>
	<div class="new-todo">
		<div class="add-new-todo">
			<a href="todoForm.jsp">새로운 TODO 등록</a>
		</div>
	</div>
	<div class="wrapper">
		<section class="todo">
			<div class="title">TODO</div>
			<c:forEach items="${ list }" var="todo">
				<c:if test="${todo.type eq 'TODO' }">
				
					<div class="content todo-content">
						<table>
							<tr>${ todo.title }</tr>
							<tr>
								<td>등록날짜 :   <fmt:parseDate var="parseRegDate" value="${ todo.regDate }" pattern="yyyy-MM-dd HH:mm:ss.S" />
								<fmt:formatDate var="formatRegDate" value="${parseRegDate}"  pattern="yyyy.MM.dd"/>
								${ formatRegDate }, ${ todo.name }, 우선순위 ${ todo.sequence }
								</td>
							</tr>
						</table>
					</div>
				</c:if>
			</c:forEach>
		</section>
		<section class="doing">
			<div class="title">DOING</div>
			<c:forEach items="${ list }" var="todo">
				<c:if test="${todo.type eq 'DOING' }">
					<div class="content doing-content">
						<table>
							<tr>${ todo.title }</tr>
							<tr>
								<td>등록날짜 :   <fmt:parseDate var="parseRegDate" value="${ todo.regDate }" pattern="yyyy-MM-dd HH:MM:SS" />
								<fmt:formatDate var="formatRegDate" value="${parseRegDate}"  pattern="yyyy.MM.dd"/>
								${ formatRegDate }, ${ todo.name }, 우선순위 ${ todo.sequence }
								</td>
							</tr>
						</table>
					</div>
				</c:if>
			</c:forEach>
		</section>
		<section class="done">
			<div class="title">DONE</div>
			<c:forEach items="${ list }" var="todo">
				<c:if test="${todo.type eq 'DONE' }">
					<div class="content done-content">
						<table>
							<tr>${ todo.title }</tr>
							<tr>
								<td>등록날짜 :   <fmt:parseDate var="parseRegDate" value="${ todo.regDate }" pattern="yyyy-MM-dd HH:MM:SS" />
								<fmt:formatDate var="formatRegDate" value="${parseRegDate}"  pattern="yyyy.MM.dd"/>
								${ formatRegDate }, ${ todo.name }, 우선순위 ${ todo.sequence }
								</td>
							</tr>
						</table>
					</div>
				</c:if>
			</c:forEach>
		</section>
	</div>
</body>

</html>