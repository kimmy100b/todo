package kr.or.connect.jdbcexam;

import java.io.IOException;
import java.util.List;

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
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html);charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		
		TodoDao dao = new TodoDao();
		
		List<Todo> list = dao.getTodos();
		
        request.setAttribute("list",list);
		
//		for(Todo todo : list) {
//			String name = todo.getName();
//	        request.setAttribute("name",name);
//	        String regDate = todo.getRegDate();
//	        request.setAttribute("regDate",regDate);
//	        int sequence = todo.getSequence();
//	        request.setAttribute("sequence",sequence);
//	        String title = todo.getTitle();
//	        request.setAttribute("title",title);
//	        String type = todo.getType();
//	        request.setAttribute("type",type);
//		}
        
        RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
        rd.forward(request, response);
	}

}
