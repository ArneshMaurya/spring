package com.cg.hr.core.services;


	import java.util.ArrayList;

	import com.cg.hr.core.beans.Employee;
import com.cg.hr.core.exceptions.empException;
	public interface EmployeeService {
	
	//public Employee addEmp(Employee emp); 
	public ArrayList<Employee> fetchALLemp()throws empException;
	//public Employee deleteEmp(int empId);
	public Employee getEmpbyEid(int empId)throws empException;
	//public Employee updateEmp(int empId,String newName,float newSal);
} 
