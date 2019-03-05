package com.cg.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Employee implements InitializingBean,DisposableBean{
 private String fName;
 private String lName;
 private int age;
 private Department dept;
public String getfName() {
	return fName;
}
public void setfName(String fName) {
	this.fName = fName;
}
public String getlName() {
	return lName;
}
public void setlName(String lName) {
	this.lName = lName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Department getDept() {
	return dept;
}
public void setDept(Department dept) {
	this.dept = dept;
}
public Employee(String fName, String lName, int age, Department dept) {
	super();
	this.fName = fName;
	this.lName = lName;
	this.age = age;
	this.dept = dept;
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}

public void m1()
{
	System.out.println("do some initialization work here....");
}
public void m2() {
	System.out.println("clean up of bean...");
}

@Override
public String toString() {
	return "Employee [fName=" + fName + ", lName=" + lName + ", age=" + age + ", dept=" + dept + "]";
}
@Override
public void afterPropertiesSet() throws Exception {
	// TODO Auto-generated method stub
	System.out.println("allocate resource here....");
	
}
@Override
public void destroy() throws Exception {
	// TODO Auto-generated method stub
	System.out.println("destroying...");
}
 
}
