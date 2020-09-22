package kr.or.connect.jdbcexam;

import java.util.List;

import kr.or.connect.jdbcexam.dao.TodoDao;
import kr.or.connect.jdbcexam.dto.Todo;

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
		
//		TodoDao dao = new TodoDao();
//		
//		List<Todo> list = dao.getTodos();
//		
//		for(Todo todo : list) {
//			System.out.println(todo);
//		}
		
		/*update test*/
		
		Long id = (long) 3;
		String title="알고리즘 공부하기";
		
//		Todo todo = new Todo(id,)
		
	}

}
