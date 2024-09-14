
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.Employee;

@Repository						// singleton 
public class EmployeeDao {
	
	//@Autowired	// autowire search database connection using byType in xml file. 
	//DataSource ds;// before spring framework we were doing configuration for data source in 
			// application server like web logic, jboss etc. and using jndi lookup we were searching 
				// database connection. 
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int storeEmployee(Employee emp) {
		try {
	return 
	jdbcTemplate.update("insert into employee(id,name,salary) values(?,?,?)", emp.getId(),emp.getName(),emp.getSalary());
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
//	public int storeEmployee(Employee emp) {
//		try {
//			Connection con = ds.getConnection();
//			PreparedStatement pstmt = con.prepareStatement("insert into employee(id,name,salary) values(?,?,?)");
//			pstmt.setInt(1, emp.getId());
//			pstmt.setString(2, emp.getName());
//			pstmt.setFloat(3, emp.getSalary());
//			return pstmt.executeUpdate();
//		} catch (Exception e) {
//			System.err.println(e);
//			return 0;
//		}
//	}
	
//	public int updateEmployee(Employee emp) {
//		try {
//			Connection con = ds.getConnection();
//			PreparedStatement pstmt = con.prepareStatement("update employee set salary = ? where id = ?");
//			pstmt.setFloat(1, emp.getSalary());
//			pstmt.setInt(2, emp.getId());
//			return pstmt.executeUpdate();
//		} catch (Exception e) {
//			System.err.println(e);
//			return 0;
//		}
//	}
	
	public int updateEmployee(Employee emp) {
		try {
return jdbcTemplate.update("update employee set salary = ? where id = ?", emp.getSalary(),emp.getId());
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
//	public int deleteEmployee(int id) {
//		try {
//			Connection con = ds.getConnection();
//			PreparedStatement pstmt = con.prepareStatement("delete from employee where id  = ?");
//			pstmt.setInt(1, id);
//			return pstmt.executeUpdate();
//		} catch (Exception e) {
//			System.err.println(e);
//			return 0;
//		}
//	}
	
	public int deleteEmployee(int id) {
		try {
			return jdbcTemplate.update("delete from employee where id =?", id);
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
//	public List<Employee> findAll() {
//		List<Employee> listofemp = new ArrayList<Employee>();
//		try {
//			Connection con = ds.getConnection();
//			PreparedStatement pstmt = con.prepareStatement("select * from employee");
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()) {
//				Employee emp = new Employee();
//				emp.setId(rs.getInt(1));
//				emp.setName(rs.getString(2));
//				emp.setSalary(rs.getFloat(3));
//				listofemp.add(emp);
//			}
//		} catch (Exception e) {
//			System.err.println(e);
//		}
//		return listofemp;
//	}
	
	// query method : 1st parameter query and 2nd parameter RowMapper interface reference 
		// Rowmap
		public List<Employee> findAll() {
			try {
	return jdbcTemplate.query("select * from employee", new MyRowMapper());	
			} catch (Exception e) {
				System.err.println(e);
				return null;
			}
		
		}
	
	public List<Map<String, Object>> findAllAsListOfMap() {	// each record retrieve as a map object. 
		try {
		return jdbcTemplate.queryForList("select * from employee");
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
}

class MyRowMapper implements RowMapper<Employee>{
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setId(rs.getInt(1));
		emp.setName(rs.getString(2));
		emp.setSalary(rs.getFloat(3));
		return emp;
	}
}