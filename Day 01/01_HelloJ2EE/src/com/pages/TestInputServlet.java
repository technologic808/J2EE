package com.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestInputServlet
 */
@WebServlet("/test_input")
public class TestInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw =response.getWriter();
		pw.append("Served at: ").append(request.getContextPath());
		pw.append("<br><h4> User Name: " + request.getParameter("f1") + "</h4>" );
//		String[] colors = request.getParameterValues("clr");
		pw.append("<br><h4> Favorite Colors: </h4>" );
		for(String s: request.getParameterValues("clr"))
			pw.append("<h4>" + s + "</h4>" );
		pw.append("<br><h4> Browser: " + request.getParameter("browser") + "</h4>" );
		pw.append("<br><h4> Selected Option: " + request.getParameter("myselect") + "</h4>" );
		
	}

}
