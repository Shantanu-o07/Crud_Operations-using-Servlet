package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	PrintWriter out=response.getWriter();
	
	String proid=request.getParameter("ProID");
	
	int id=Integer.parseInt(proid);
	
	String proname=request.getParameter("ProName");
	
	String proprice=request.getParameter("PPrice");
	int procost=Integer.parseInt(proprice);
	
//	System.out.println(proid+" "+proname+" "+proprice);
	
	GetSet st=new GetSet();
	st.setId(id);
	st.setName(proname);
	st.setPrice(procost);
	
	
	int r= ProductOperations.Update(st);
	
	if(r>0){
		
		response.sendRedirect("show");
	}
	else{
		out.println("Sorry! unable to update record");
	}
	
	out.close();
}
}
