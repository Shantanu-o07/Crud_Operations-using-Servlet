package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertServlet extends HttpServlet{

	public void doPost(HttpServletRequest res,HttpServletResponse rep) throws IOException
	{
		PrintWriter pw=rep.getWriter();
		
		String ProductId=res.getParameter("ProId");
		int ProId=Integer.parseInt(ProductId);
		
		String ProductName=res.getParameter("ProName");
		
		String ProductPrice=res.getParameter("ProPrice");
		int ProPrice=Integer.parseInt(ProductPrice);
		
		
		GetSet gt=new GetSet();
		gt.setId(ProId);
		gt.setName(ProductName);
		gt.setPrice(ProPrice);
		
		
		int status=ProductOperations.insert(gt);
		
		if(status>0) 
		{
			pw.print("Record inserted");
		}
		else 
		{
			pw.print("Record not inserted");
		}
		
	}
}
