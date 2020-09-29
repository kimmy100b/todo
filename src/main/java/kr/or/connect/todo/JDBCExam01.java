package kr.or.connect.todo;

import java.util.List;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.Todo;

public class JDBCExam01 {

	public static void main(String[] args) {
		/*insert test*/
//		String title = "JSP 공부하기";
//		String name = "신윤정";
//		int sequence = 2;
//		String type = "TODO";
//		
//		Todo todo = new Todo(title,name, sequence, type);
//		
//		TodoDao dao = new TodoDao();
//		int insertCount = dao.addTodo(todo);
//		
//		System.out.println(insertCount);

		
		/*select test*/
		
		TodoDao dao = new TodoDao();
		
		List<Todo> list = dao.getTodos();
		
		for(Todo todo : list) {
			String name = todo.getName();
	        System.out.println(name);
		}
		
		/*update test*/
		
//		Long id = (long) 3;
//		String type="DOING";
//		
//		Todo todo = new Todo(id, type);
//		
//		TodoDao dao = new TodoDao();
//		int updateCount = dao.updateTodo(todo);
//		
//		System.out.println(updateCount);		
	}

}
