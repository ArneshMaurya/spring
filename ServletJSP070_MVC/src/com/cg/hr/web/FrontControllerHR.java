package com.cg.hr.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.hr.core.beans.Employee;
import com.cg.hr.core.exceptions.empException;
import com.cg.hr.core.services.EmployeeService;
import com.cg.hr.core.services.EmployeeServiceImpl;

@WebServlet("*.hr")
public class FrontControllerHR extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	/*@Override
	public void init() throws ServletException {
		
		super.init();
		
	}*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx=super.getServletContext();
		EmployeeService services=(EmployeeService) ctx.getAttribute("services");
		String url=request.getRequestURI();
		System.out.println(getCommand(url));
		String command=getCommand(url);
		RequestDispatcher dispatcher=null;
		String JspName=null;
		String preFix="/WEB-INF/pages/";
		String postFix=".jsp";
		
		
		try {
			switch(command) {
			case "*":
			case "HomePage":{
					JspName="HomePage";
					break;
				}
			case "Login":{
				JspName="Login";
				break;
				
			}
			case "Authenticate":{
				
				String userName=request.getParameter("userName");
				String password=request.getParameter("password");
				
//			for multiple data
//			request.getParameterValues(arg0);
				
				if(userName.equals("Manish")&&password.equals("Kumar"))
				{
					
					HttpSession session=request.getSession(true);
					//request scope
					System.out.println(session.getId());
					session.setAttribute("fullName", "Manish Kumar");
					JspName="MainMenu";
				}
				else
				{
					request.setAttribute("message", "wrong authentication plz provide correct login or password");
					JspName="Login";
				}
				
				break;
			}
			case "Logout":{
				HttpSession session=request.getSession(false);
				session.invalidate();
				JspName="Logout";
				break;
			}
			case "printList":{
				ArrayList<Employee> empList=services.fetchALLemp();
				System.out.println(empList);
				request.setAttribute("empList", empList);
				JspName="EmpList";
				break;
			}
			case "viewDetails":{
				String strEmpId=request.getParameter("id");
				int empId=Integer.parseInt(strEmpId);
				Employee emp=services.getEmpbyEid(empId);
				System.out.println(emp);
				request.setAttribute("emp", emp);
				JspName="EmpDetails";
				break;
			}
			}
		} catch (empException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispatcher=request.getRequestDispatcher(preFix+JspName+postFix);
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private String getCommand(String url)
	{
		int idxSlash=url.lastIndexOf("/");
		int idxDot=url.lastIndexOf(".");
		if(idxDot<0) {
			return "HomePage";
		}
		else {
		return url.substring(idxSlash+1, idxDot);
		
	}
	}
}
