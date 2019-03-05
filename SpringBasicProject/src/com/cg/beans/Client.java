package com.cg.beans;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {
	
	public static void main(String[] args)
	{
		Resource res=new ClassPathResource("beans.xml");//setting path for resources
		XmlBeanFactory factory=new XmlBeanFactory(res);//creating bundle or factory for the resources
		Employee emp=(Employee) factory.getBean("emp");//getting the required bean from the bundle or factory
	/*	emp.setfName("Manish");
		emp.setlNAme("Kumar");
		emp.setAge(22);*/
		System.out.println(emp);
		Employee emp1=(Employee) factory.getBean("emp1");
		System.out.println(emp1);
		
	}
	
}
