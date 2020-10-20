package kr.or.connect.todo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.Todo;

@WebServlet("/todoAdd")
public class TodoAddServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int MAX_TITLE_LEN = 24;
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		int sequence = Integer.parseInt(request.getParameter("sequence"));

		Todo todo = new Todo(title, name, sequence);

		TodoDao dao = new TodoDao();
		dao.addTodo(todo);

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<script>alert('등록되었습니다.'); location.href='./main';</script>");
		writer.close();
	}

}
