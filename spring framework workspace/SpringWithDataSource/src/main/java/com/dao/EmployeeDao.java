package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired    	  //autowire search database connection using bytype in xml file.
	DataSource ds;    //before spring framework we were doing configuration for data source in
					  //application server like web logic,jboss etc. and using jndi lookupwe were searching
					  //database connection
	
	public int storeEmployee(Employee emp) {
		try {
			Connection con=ds.getConnection();
			PreparedStatement pstmt=con.prepareStatement("insert into employee values(?,?,?)");
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setFloat(3, emp.getSalary());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public int updateEmployee(Employee emp) {
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update employee set salary = ? where id = ?");
			pstmt.setFloat(1, emp.getSalary());
			pstmt.setInt(2, emp.getId());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public int deleteEmployee(int id) {
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from employee where id  = ?");
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public List<Employee> findAll() {
		List<Employee> listofemp = new ArrayList<Employee>();
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from employee");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getFloat(3));
				listofemp.add(emp);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return listofemp;
	}
}
