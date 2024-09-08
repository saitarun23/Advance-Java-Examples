package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
