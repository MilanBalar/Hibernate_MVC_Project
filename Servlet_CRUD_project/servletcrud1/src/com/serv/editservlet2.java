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



@WebServlet("/editServlet2")
public class editservlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String ename=request.getParameter("ename");
		String epassword=request.getParameter("epassword");
		String ecountry=request.getParameter("ecountry");
		int esalary=Integer.parseInt(request.getParameter("esalary"));
		employee s=new employee();
		s.setId(id);
		s.setEname(ename);
		s.setEpassword(epassword);
		s.setEcountry(ecountry);
		s.setEsalary(esalary);
		
		try {
			int i=employeeDao.updateRecordbyId(s);
			if(i>0)
			{
				out.println("<h3>Record Updated</h3>");
				response.sendRedirect("viewemployee");
			}
			else
			{
				out.println("<h3> Record is not Updated ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	}

