package com.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DemoTest {

	public static void main(String[] args) {
		
//		Employee emp = new Employee();
//		emp.display();

	Resource res = new ClassPathResource("beans.xml");		// load xml file
	BeanFactory obj = new XmlBeanFactory(res);				// get the Bean reference.
	
//	Employee e1 = (Employee)obj.getBean("emp1");
//	Employee e2 = obj.getBean("emp1", Employee.class);
//	e1.display();
//	e2.display();
	
	//Address add1 = (Address)obj.getBean("address");
	//System.out.println(add1);
	
	Employee emp1 = (Employee)obj.getBean("employee");
	System.out.println(emp1);
	}
		

	}

