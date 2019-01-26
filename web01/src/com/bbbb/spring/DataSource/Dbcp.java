package com.bbbb.spring.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbbb.spring.student.Student;
@Component
public class Dbcp {
	private String sqlStr = "INSERT INTO student (id,name) VALUES (?,?)";
	@Autowired
	private DataSource dataSource;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	public void addStudent(Student student) {
		System.out.println("插入学生");
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(sqlStr);
			stmt.setInt(1, student.getId());
			stmt.setString(2, student.getName());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
		}
		
	}

}
