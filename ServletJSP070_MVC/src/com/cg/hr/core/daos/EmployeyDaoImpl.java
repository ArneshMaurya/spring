package com.cg.hr.core.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.cg.hr.core.beans.Employee;
import com.cg.hr.core.exceptions.empException;
import com.cg.hr.core.util.JDBCUtil;
import com.cg.hr.core.util.JPAUtil;

public class EmployeyDaoImpl implements EmployeeDao {

   private Connection connect;
    public EmployeyDaoImpl() throws empException {
	JDBCUtil util=new JDBCUtil();
	connect=util.getConnect();
		
	}
	
	/*@Override
	public Employee addEmp(Employee emp) {
		entityTran.begin();
		em.persist(emp);
		entityTran.commit();
		return emp;
	}*/

	@Override
	public ArrayList<Employee> fetchALLemp() throws empException {
		//JPQL
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Employee> empList=new ArrayList<>();
		try {
		stmt=connect.createStatement();
		rs=stmt.executeQuery("SELECT empno,ename,sal FROM emp");
		
		while(rs.next()) {
			int empNo=rs.getInt("empno");
			String empNm=rs.getString("ename");
			float empSal=rs.getFloat("sal");
			Employee emp=new Employee(empNo,empNm,empSal);
			empList.add(emp);
		}
		
		return empList;
		}
		catch(Exception e) {
			throw new empException("Something went wrong");
		}finally {
			try {
				if(rs !=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			} catch (SQLException e) {
				throw new empException("something wrong in fething",e);
			}
		}
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		if(connect!=null) {
			connect.close();
		}
		super.finalize();
	}

	/*@Override
	public Employee deleteEmp(int empId) {
	Employee e1=em.find(Employee.class,empId);
	entityTran.begin();
	em.remove(e1);
	entityTran.commit();
		return e1;
	}*/

	@Override
	public Employee getEmpbyEid(int empId) throws empException {
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Employee emp=null;
		try {
		stmt=connect.prepareStatement("SELECT empno,ename,sal FROM emp WHERE empno=?");
		stmt.setInt(1, empId);
		
		
		rs=stmt.executeQuery();
		
		while(rs.next()) {
			int empNo=rs.getInt("empno");
			String empNm=rs.getString("ename");
			float empSal=rs.getFloat("sal");
			emp=new Employee(empNo,empNm,empSal);
			
		}
		
		return emp;
		}
		catch(Exception e) {
			throw new empException("Something went wrong", e);
		}finally {
			try {
				if(rs !=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			} catch (SQLException e) {
				throw new empException("something wrong in fething",e);
			}
		}
		
	}
	/*public Employee updateEmp(int empId, String newName, float newSal) {
		Employee ee=em.find(Employee.class,empId);
		ee.setEmpName(newName);
		ee.setEmpSal(newSal);
		entityTran.begin();
		em.merge(ee);
		entityTran.commit();
		
		return ee;
	}*/


	}