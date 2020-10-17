package com.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.employeeDao;
import com.bean.employee;



@WebServlet("/viewemployee")
public class viewemployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
			List<employee> s=employeeDao.getAllemployeeData();
			out.print("<table border=1>");
				out.println("<tr><th>Id</th><th>Name</th><th>password</th><th>country</th><th>salary</th><th>Edit</th><th>Delete</th></tr>");
				for (employee employee : s) {
					out.println("<tr><td>"+employee.getId()+"</td><td>"+employee.getEname()+"</td><td>"+employee.getEpassword()+"</td><td>"+employee.getEcountry()+"</td><td>"+employee.getEsalary()+"</td><td><a href='editServlet?id="+employee.getId()+"'>Edit</a></td><td><a href='deleteemployee?id="+employee.getId()+"'>Delete</a></td></tr>");
				}
			out.print("</table>");
			out.println("<a href='index.html'>Add New Data</a>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
