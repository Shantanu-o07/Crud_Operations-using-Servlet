package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter pw=res.getWriter();
		String Proid=req.getParameter("id");
		int proid=Integer.parseInt(Proid);
		
		int st=ProductOperations.Delete(proid);
		
		if(st>0) 
		{
			res.sendRedirect("show");
//			System.out.println("record Deleted");
		}
		else 
		{
			pw.println("Something went worong");
		}
	}
}
