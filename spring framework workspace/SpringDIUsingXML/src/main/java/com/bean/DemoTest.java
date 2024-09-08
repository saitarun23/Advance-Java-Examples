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
		Employee e2=(Employee)obj.getBean("emp2");
		Employee e3=(Employee)obj.getBean("emp3");
		e1.display();
		e2.display();
		e3.display();
		
		Connection c1=(Connection) obj.getBean("con1");
		Connection c2=obj.getBean("con2", Connection.class);
		Connection c3=obj.getBean("con1", Connection.class);
		
		System.out.println("c1 is "+c1+" and hashcode is:"+c1.hashCode());
		System.out.println("c2 is "+c2+" and hashcode is:"+c2.hashCode());
		System.out.println("c3 is "+c3+" and hashcode is:"+c3.hashCode());

	}

}
