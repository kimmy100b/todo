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
import kr.or.connect.todo.dto.TodoDto;

@WebServlet("/todoType")
public class TodoTypeServlet extends HttpServlet {
	TodoDao dao = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		String type = req.getParameter("type");

		if (type.equals("TODO")) {
			type = "DOING";
		} else if (type.equals("DOING")) {
			type = "DONE";
		}

		TodoDto todo = new TodoDto(id, type);
		TodoDao dao = new TodoDao();
		dao.updateTodo(todo);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
