package kr.or.connect.todo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.Todo;


/**
 * @author mx02-1
 *
 */
@WebServlet("/Main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public MainServlet() {
        super();		
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html);charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
		TodoDao dao = new TodoDao();
		
		List<Todo> list = dao.getTodos();
        request.setAttribute("list",list);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("./main.jsp");
        try {
        	requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            System.out.println(e);
        }
	}

}
