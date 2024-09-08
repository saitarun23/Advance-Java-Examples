package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;
import com.service.EmployeeService;

public class DemoTest {
	
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");// load xml file
		EmployeeService es=(EmployeeService)ac.getBean("employeeService");// camel naming rule 
		Employee emp=(Employee)ac.getBean("employee");
		emp.setId(5);
		emp.setName("Dhoni");
		emp.setSalary(45000);
		String result = es.storeEmployee(emp);
		System.out.println(result);
	}

}
