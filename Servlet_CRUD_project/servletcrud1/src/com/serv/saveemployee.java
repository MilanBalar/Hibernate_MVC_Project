package com.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.employeeDao;
import com.bean.employee;

@WebServlet("/saveservlet")
public class saveemployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 String ename =request.getParameter("ename");  
		 String epassword =request.getParameter("epassword"); 
		 String ecountry =request.getParameter("ecountry");  
		 Integer esalary =Integer.parseInt(request.getParameter("esalary")); 
		 employee s = new employee();
		 s.setEname(ename);
		 s.setEpassword(epassword);
		 s.setEcountry(ecountry);
		 s.setEsalary(esalary);
		int i=0;
		try {
		  i = employeeDao.saveemployee(s);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if (i>0)
		 {
			 out.println("record inserted");
			 response.sendRedirect("viewemployee");
		 }
		 else
		 {
			 out.println("record not inserted");
		 }	
		
	}

}
