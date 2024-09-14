package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.dao.EmployeeDao;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	public String storeEmployee(Employee emp) {
		if(employeeDao.storeEmployee(emp)>0) {
			return "Employee record inserted";
		}else {
			return "Employee record didn't insert";
		}
	}
		
	public String updateEmployee(Employee emp) {
		if(employeeDao.updateEmployee(emp)>0) {
			return "Employee record updated";
		}else {
			return "Employee record not present";
		}
	}
	
	public String deleteEmployee(int id) {
		if(employeeDao.deleteEmployee(id)>0) {
			return "Employee record deleted";
		}else {
			return "Employee record not present";
		}
	}
	
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}
	
	public List<Map<String,Object>> getEmployeeInAsMap() {
		return employeeDao.findAllAsListOfMap();
	}
}
