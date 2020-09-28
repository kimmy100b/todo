package kr.or.connect.jdbcexam;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.jdbcexam.dao.TodoDao;
import kr.or.connect.jdbcexam.dto.Todo;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public MainServlet() {
        super();
		TodoDao dao = new TodoDao();
		
		List<Todo> list = dao.getTodos();
		
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html);charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
		TodoDao dao = new TodoDao();
		
		List<Todo> list = dao.getTodos();
        
        request.setAttribute("list",list);
		        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main.jsp");
        requestDispatcher.forward(request, response);
	}

}
