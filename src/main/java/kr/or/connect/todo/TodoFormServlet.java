package kr.or.connect.todo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.Todo;

@WebServlet("/TodoFormServlet")
public class TodoFormServlet extends HttpServlet {

       
    public TodoFormServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		int sequence = Integer.parseInt(request.getParameter("sequence"));
		
		Todo todo = new Todo(title,name, sequence);
		
		TodoDao dao = new TodoDao();
		int insertCount = dao.addTodo(todo);
		
		System.out.println(insertCount);
		
		response.sendRedirect("./main.jsp");
	}

}
