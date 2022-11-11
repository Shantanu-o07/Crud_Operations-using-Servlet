package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditFrom extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse rep) throws IOException 
	{
		PrintWriter pw=rep.getWriter();
		String pid=req.getParameter("id");
		int id=Integer.parseInt(pid);
		//System.out.println(id);
		GetSet gt=ProductOperations.getProductById(id);
		
		//System.out.println(gt.getPrice());
		pw.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\r\n"
				+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\"></script>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "<h1>Product Form</h1>\r\n"
				+ "	<div class=\"container\">\r\n"
				+ "		<form action=\"add1\" method=\"post\">\r\n"
				+ "		 \r\n"
				+ "		  <div class=\"mb-3\">\r\n"
//				+ "		    <label for=\"exampleInputEmail1\" class=\"form-label\">Product Id</label>\r\n"
				+ "		    <input value='"+gt.getId()+"'type=\"hidden\" class=\"form-control\" name=\"ProId\" aria-describedby=\"emailHelp\">\r\n"
				+ "		  </div>\r\n"
				+ "		 \r\n"
				+ "		  <div class=\"mb-3\">\r\n"
				+ "		    <label for=\"exampleInputPassword1\" class=\"form-label\">Product Name</label>\r\n"
				+ "		    <input value='"+gt.getName()+"' type=\"text\" class=\"form-control\" name=\"ProName\">\r\n"
				+ "		  </div>\r\n"
				+ "		 \r\n"
				+ "		   <div class=\"mb-3\">\r\n"
				+ "		    <label for=\"exampleInputPassword1\" class=\"form-label\">Product Price</label>\r\n"
				+ "		    <input value='"+gt.getPrice()+"' type=\"text\" class=\"form-control\" name=\"ProPrice\">\r\n"
				+ "		  </div>\r\n"
				+ "		  \r\n"
				+ "		  <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\r\n"
				+ "		</form>\r\n"
				+ "		<br>\r\n"
				+ "		 <button type=\"button\" class=\"btn btn-warning\"><a href=\"show\">Product List</a></button>\r\n"
				+ "	</div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}
}
