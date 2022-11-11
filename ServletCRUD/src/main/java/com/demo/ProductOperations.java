package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductOperations {
	
	public static int insert(GetSet g) 
	{
		int status=0;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shantanu","prouser","prouser@123");		
			String s="insert into productdata values (?,?,?)";
			PreparedStatement ps=conn.prepareStatement(s);
		
			ps.setInt(1, g.getId());
			ps.setString(2, g.getName());
			ps.setInt(3, g.getPrice());
			status=ps.executeUpdate();
			System.out.println(status+ "Record Inserted");
			
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	
	public static List<GetSet> select() 
	{
		List<GetSet> li=new ArrayList<GetSet>();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shantanu","prouser","prouser@123");	
			String s="select * from productdata";
			PreparedStatement ps=conn.prepareStatement(s);
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next()) 
			{
				GetSet g=new GetSet();
				g.setId(rs.getInt(1));
				g.setName(rs.getString(2));
				g.setPrice(rs.getInt(3));
				li.add(g);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return li;
	}
	
	
	
	public static GetSet getProductById(int id) 
	{
		
		//System.out.println(id);
		GetSet gs=new GetSet();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shantanu","prouser","prouser@123");
				
			String s="select * from productdata where productid=?";
			
			PreparedStatement ps=con.prepareStatement(s);
			ps.setInt(1,id);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				gs.setId(rs.getInt(1));
				gs.setName(rs.getString(2));
				gs.setPrice(rs.getInt(3));
			}
		}
		catch(Exception e) {}
		
		//System.out.println(gs.getId()+" "+gs.getName());
		return gs;
	}
	
	
	
	public static int Update (GetSet s) 
	{
		int status=0;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shantanu","prouser","prouser@123");	
			String s1="update productdata set productname=?,productprice=? where productid=?";
			PreparedStatement ps=conn.prepareStatement(s1);
			ps.setString(1, s.getName());
			ps.setInt(2,s.getPrice());
			ps.setInt(3, s.getId());
			status=ps.executeUpdate();
			
			conn.close();
		}
		catch(Exception e) 
		{}
		
		return status;
		
		
	}
	
	
	
	
	
	public static int Delete(int id) 
	{
		int status=0;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shantanu","prouser","prouser@123");	
			String s1="delete from productdata where productid=?";
			PreparedStatement ps=conn.prepareStatement(s1);
			ps.setInt(1, id);
			status=ps.executeUpdate();
			
			conn.close();
		}
		catch(Exception e) 
		{}
		
		return status;
		
		
	}
}
