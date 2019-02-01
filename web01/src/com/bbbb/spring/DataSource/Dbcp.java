package com.bbbb.spring.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbbb.spring.student.Student;
@Component
public class Dbcp {
	private String sqlStr = "INSERT INTO student (id,name) VALUES (?,?)";
	private String deleteSql = "DELETE FROM student WHERE id = ?";
	private String updateSql = "UPDATE student SET name = ? WHERE id = ?";
	private String querySql = "SELECT * FROM student ORDER BY age DESC LIMIT ?,?";
	@Autowired
	private DataSource dataSource;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
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
					System.out.println("关闭语句");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
					System.out.println("关闭链接");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
		}
		
	}
	public void deleteStudent(int id){
		System.out.println("删除学生");
	
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(deleteSql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("删除学生");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try{
					stmt.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
			
			}
			if (conn != null) {
				try{
					conn.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
		
	}
	public void updateStudent(int id,String name){
		System.out.println("更新学生");
		try{
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(updateSql);
			stmt.setString(1, name);
			stmt.setInt(2, id);
			stmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null){
				try{
					stmt.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
			
			}
			if (conn != null) {
				try{
					conn.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
	}
	public List<Student> queryStudent(int page){
		Connection conn2 = null;
		PreparedStatement stmt2 = null;
		ResultSet rs2 = null;
		List<Student> students = new ArrayList<Student>();
		System.out.println("查询");
		try{
			conn2 = dataSource.getConnection();
			stmt2 = conn2.prepareStatement(querySql);
			stmt2.setInt(1, (page -1) * 3);
			stmt2.setInt(2, 3);
			rs2 = stmt2.executeQuery();
		
			while(rs2.next()){
				//System.out.println(rs.getString("name"));
				System.out.println(rs2.getInt("age"));
				Student st = new Student(rs2.getInt("id"),rs2.getString("name"),rs2.getInt("age"));
				students.add(st);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
				try {
					if (rs2 != null) {
						rs2.close();
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
				
						try {
							if (stmt2 != null) {
								stmt2.close();
							}
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} finally {
							try{
								if (conn2 != null){
									conn2.close();
								}
							} catch (SQLException e){
								e.printStackTrace();
							}
						
						}
					}
			}
		return students;
	}
	

}
