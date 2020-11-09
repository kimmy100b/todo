<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.or.connect.todo.dao.TodoDao"%>
<%@ page import="java.io.PrintWriter"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="todo" class="kr.or.connect.todo.dto.TodoDto"
	scope="page" />
<jsp:setProperty name="todo" property="title" />
<jsp:setProperty name="todo" property="name" />
<jsp:setProperty name="todo" property="sequence" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%
		if (todo.getTitle() == null || todo.getTitle() == "") {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('할 일이 입력되지 않았습니다.')");
		script.println("history.back()");
		script.println("</script>");
	} else if (todo.getTitle().length() >= 24) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('할 일은 최대 24자까지 입력할 수 있습니다.')");
		script.println("history.back()");
		script.println("</script>");
	} else if (todo.getName() == null || todo.getName() == "") {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이름이 입력되지 않았습니다.')");
		script.println("history.back()");
		script.println("</script>");
	} else {
		TodoDao todoDao = new TodoDao();
		int result = todoDao.addTodo(todo);

		if (result == -1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('할일 등록에 실패했습니다.')");
			script.println("history.back()");
			script.println("</script>");
		} else {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = './main'");
			script.println("</script>");
		}
	}
	%>
</body>
</html>
