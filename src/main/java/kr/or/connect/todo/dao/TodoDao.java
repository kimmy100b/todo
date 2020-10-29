package kr.or.connect.todo.dao;

import kr.or.connect.todo.dto.TodoDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {

	final private static String dbUrl = "jdbc:mysql://localhost:3306/edwith?useSSL=false";
	final private static String dbUser = "root";
	final private static String dbPasswd = "mysql";

	public TodoDao() {
		try {
//			Class.forName("org.mysql.Driver");
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int addTodo(TodoDto todo) {
		int insertCount = 0;
		String sql = "INSERT INTO todo(title, name, sequence) VALUES(?,?,?)";

		try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());

			insertCount = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return insertCount;
	}

	public List<TodoDto> getTodos() {
		List<TodoDto> list = new ArrayList<>();
		String sql = "select id, title, name, sequence, type, regdate from todo order by regdate";

		try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				Long id = rs.getLong("id");
				String title = rs.getString("title");
				String name = rs.getString("name");
				int sequence = rs.getInt("sequence");
				String type = rs.getString("type");
				String regDate = rs.getString("regDate");
				TodoDto todo = new TodoDto(id, name, regDate, sequence, title, type);
				list.add(todo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public int updateTodo(TodoDto todo) {
		int updateCount = 0;
		String sql = "UPDATE todo SET type = ? where id = ?";

		try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, todo.getType());
			ps.setLong(2, todo.getId());
			updateCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return updateCount;
	}

}
