package com.cg.hr.core.tests;

import java.util.ArrayList;

import com.cg.hr.core.beans.Employee;
import com.cg.hr.core.exceptions.empException;
import com.cg.hr.core.services.EmployeeService;
import com.cg.hr.core.services.EmployeeServiceImpl;

public class TestEmpList {

	public static void main(String[] args) {
		try {
		EmployeeService services=new EmployeeServiceImpl();
		ArrayList<Employee> empList;
		
			empList = services.fetchALLemp();
			for(Employee emp:empList) {
				System.out.println(emp);
				
			}
		} catch (empException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	
		}
}
