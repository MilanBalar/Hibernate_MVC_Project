package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.employee;


public class employeeDao{
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{

		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "");
		return con;
	}
	//Delete Method 
		public static void deleteById(int id) throws ClassNotFoundException, SQLException
		{
			Connection con=employeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		}
		//update record by the id 
		public static int updateRecordbyId(employee s) throws ClassNotFoundException, SQLException
		{
			Connection con=employeeDao.getConnection();
			int status=0;
			PreparedStatement ps=con.prepareStatement("update employee set name=?,password=?,country=?,salary=? where id=?");
			ps.setString(1, s.getEname());
			ps.setString(2, s.getEpassword());
			ps.setString(3, s.getEcountry());
			ps.setInt(4, s.getEsalary());
			ps.setInt(5, s.getId());
			status=ps.executeUpdate();
			return status;
			
			
		}
		
	public  static int saveemployee(employee s) throws ClassNotFoundException, SQLException
	{
		Connection con=employeeDao.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into Employee(name,password,country,salary) values(?,?,?,?)");
		ps.setString(1, s.getEname());
		ps.setString(2, s.getEpassword());
		ps.setString(3, s.getEcountry());
		ps.setInt(4, s.getEsalary());
		int i=ps.executeUpdate(); 
		return i; 
		
	}
	public static employee getDatabyId(int id) throws ClassNotFoundException, SQLException
	{
		Connection con=employeeDao.getConnection();
		PreparedStatement ps =con.prepareStatement("select * from employee where id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		employee s=new employee();
		while(rs.next())
		{
			
			s.setId(rs.getInt(1));
			s.setEname(rs.getString(2));
			s.setEpassword(rs.getString(3));
			s.setEcountry(rs.getString(4));
			s.setEsalary(rs.getInt(5));
			
		}
		return s;
		
	}
	public static ArrayList<employee> getAllemployeeData() throws ClassNotFoundException, SQLException
	{
		ArrayList<employee> list=new ArrayList<employee>();
		Connection con=employeeDao.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from employee");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			employee s=new employee();
			s.setId(rs.getInt(1));
			s.setEname(rs.getString(2));
			s.setEpassword(rs.getString(3));
			s.setEcountry(rs.getString(4));
			s.setEsalary(rs.getInt(5));
			
			
			list.add(s);
		}
		return list;
	}
}