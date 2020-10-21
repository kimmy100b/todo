package kr.or.connect.todo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.TodoDto;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TodoDao dao = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		TodoDao dao = new TodoDao();
		List<TodoDto> todoList = dao.getTodos();
		req.setAttribute("todoList", todoList);
		
		String[] todoTypes= {"TODO", "DOING", "DONE"};
		req.setAttribute("todoTypes", todoTypes);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("main.jsp");
		try {
			requestDispatcher.forward(req, resp);
		} catch (ServletException e) {
			System.out.println(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
