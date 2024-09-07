package com.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DemoTest {

	public static void main(String[] args) {
		
		
		Resource res=new ClassPathResource("bean.xml");
		BeanFactory obj=new XmlBeanFactory(res);
		Employee e1=(Employee)obj.getBean("emp1");
		e1.display();

	}

}
