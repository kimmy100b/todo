package kr.or.connect.jdbcexam.dao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.jdbcexam.dto.Todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDao extends HttpServlet {

	private static String dburl = "jdbc:mysql://localhost:3306/edwith";
	private static String dbUser = "root";
	private static String dbpasswd = "mysql";

	public TodoDao() {
		try {
			Class.forName("org.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

		}
	}

	public int addTodo(Todo todo) {
		int insertCount = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "INSERT INTO todo(title, name, sequence) VALUES(?,?,?)";

		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());
	
			insertCount = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return insertCount;
	}

	public List<Todo> getTodos() {
		List<Todo> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "select id, title, name, sequence, type, regdate from todo order by regdate asc";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					Long id = rs.getLong("id");
					String title = rs.getString("title");
					String name = rs.getString("name");
					int sequence = rs.getInt("sequence");
					String type = rs.getString("type");
					String regDate = rs.getString("regDate");
					Todo todo = new Todo(id, name, regDate, sequence, title, type);
					list.add(todo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return list;

	}

	public int updateTodo(Todo todo) {
		int updateCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection ( dburl, dbUser, dbpasswd );
			
			String sql = "UPDATE todo SET type = ? where id = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, todo.getType());
			ps.setLong(2, todo.getId());
			
			updateCount = ps.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {}
			} // if
			
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {}
			} // if
		} // finally
		
		return updateCount;
	}

}
