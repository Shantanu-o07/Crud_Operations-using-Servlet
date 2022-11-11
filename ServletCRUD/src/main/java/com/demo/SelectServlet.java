package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// show page
public class SelectServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest res,HttpServletResponse rep) throws IOException
	{
		PrintWriter pr=rep.getWriter();
		
		pr.print("<h1>Product List :</h1>");
		
		List<GetSet> proList=ProductOperations.select();
		pr.print("<table border=1>"
				+"<tr>"
				+"<th>Product Id</th>"
				+"<th>Product Name</th>"
				+"<th>Product Price</th>"
				+"<th>Update Product</th>"
				+"<th>Delete Product</th>"
				+"</tr>");
		for(GetSet gs:proList) {
		pr.print("<tr>"
				+"<td>"+gs.getId()+"</td>"
				+"<td>"+gs.getName()+"</td>"
				+"<td>"+gs.getPrice()+"</td>"
				+"<td><a href='updateForm?id="+gs.getId()+"'>Edit</a></td>"
				+"<td><a href='deleteData?id="+gs.getId()+"'>Delete</a></td>"
				+"</tr>");
		}
		pr.print("</table>");
	}
}
