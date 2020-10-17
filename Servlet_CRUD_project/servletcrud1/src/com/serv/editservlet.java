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


@WebServlet("/editServlet")
public class editservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		employee s=null;
		try {
			s=employeeDao.getDatabyId(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<h2> Update Form </h2>");
		out.println("<form action='editServlet2' method='post'>");
		out.println("<table border=1>");
		out.println("<tr><td>employee Id</td><td><input type='text' name='id' value='"+s.getId()+"'/></td></tr>");
		out.println("<tr><td>Name</td><td><input type='text' name='ename' value='"+s.getEname()+"'/></td></tr>");
		out.println("<tr><td>password</td><td><input type='password' name='epassword' value='"+s.getEpassword()+"'/></td></tr>");
		out.println("<tr><td>country</td><td><input type='text' name='ecountry' value='"+s.getEcountry()+"'/></td></tr>");
		out.println("<tr><td>salary</td><td><input type='text' name='esalary' value='"+s.getEsalary()+"'/></td></tr>");
		out.println("<tr><td><input type='Submit' name='Update' value='Update'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		
	}

	

}

