package com.cg.hr.core.services;

import java.util.ArrayList;

import com.cg.hr.core.daos.EmployeeDao;
import com.cg.hr.core.daos.EmployeyDaoImpl;
import com.cg.hr.core.exceptions.empException;
import com.cg.hr.core.beans.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	
   EmployeeDao empDao=null;
   public EmployeeServiceImpl() throws empException {
	   empDao=new EmployeyDaoImpl();
   }

/*public Employee addEmp(Employee emp) {
	// TODO Auto-generated method stub
	return empDao.addEmp(emp);
}*/

public ArrayList<Employee> fetchALLemp() throws empException {
	// TODO Auto-generated method stub
	return empDao.fetchALLemp();
}

/*public Employee deleteEmp(int empId) {
	// TODO Auto-generated method stub
	return empDao.deleteEmp(empId);
}
*/
public Employee getEmpbyEid(int empId) throws empException {
	// TODO Auto-generated method stub
	return empDao.getEmpbyEid(empId);
}

/*public Employee updateEmp(int empId, String newName, float newSal) {
	// TODO Auto-generated method stub
	return empDao.updateEmp(empId, newName, newSal);
			
}*/
}

