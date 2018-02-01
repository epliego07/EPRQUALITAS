package com.qualitas.calc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lanzador
 */
@WebServlet("/Lanzador") 
public class Lanzador extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//leo los parametros de html, los parametros de web es string
		String text1 = request.getParameter("text1");
		String text2 = request.getParameter("text2");
		//genero la respuesta 
		response.getWriter().append("la suma es  " + (Integer.parseInt(text1) + Integer.parseInt(text2)));
	}

	

}
