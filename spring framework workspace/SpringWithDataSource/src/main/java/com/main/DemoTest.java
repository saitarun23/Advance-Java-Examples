package com.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;
import com.service.EmployeeService;

public class DemoTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");// load xml file
		EmployeeService es = (EmployeeService) ac.getBean("employeeService");// camel naming rule
		
		String con;
		int id;
		String name;
		float salary;
		int choice;
		String result;
		do {
			System.out.println("1: Add Employee 2: Update Employee 3: Delete Employee 4 :Retrieve Employee");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the id");
				id = sc.nextInt();
				System.out.println("Enter the name");
				name = sc.next();
				System.out.println("Enter the salary");
				salary = sc.nextFloat();
				Employee emp1 = (Employee) ac.getBean("employee");
				emp1.setId(id);
				emp1.setName(name);
				emp1.setSalary(salary);
				result = es.storeEmployee(emp1);
				System.out.println(result);
				break;

			case 2:
				System.out.println("Enter the id");
				id = sc.nextInt();
				System.out.println("Enter the salary");
				salary = sc.nextFloat();
				Employee emp2 = (Employee) ac.getBean("employee");
				emp2.setId(id);
				emp2.setSalary(salary);
				result = es.updateEmployee(emp2);
				System.out.println(result);
				break;
				
			case 3:
				System.out.println("Enter the id");
				id = sc.nextInt();
				result = es.deleteEmployee(id);
				System.out.println(result);
				break;
				
			case 4:
				List<Employee> listOfEmp = es.findAll();
				for (Employee emp : listOfEmp) {
					System.out.println(emp);
				}
				break;
				
			default:
				System.out.println("wrong choice");
				break;
				
			}
			System.out.println("do you want to continue?");
			con = sc.next();
		} while (con.equalsIgnoreCase("y"));
		System.out.println("Thank you!");
	}

}
