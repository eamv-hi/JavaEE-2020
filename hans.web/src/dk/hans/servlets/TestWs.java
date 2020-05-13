package dk.hans.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dk.hans.ejb.ParameterBeanLocal;

/**
 * Servlet implementation class TestWs
 */
@WebServlet("/TestWs")
public class TestWs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private ParameterBeanLocal ejb;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Parameter: " + ejb.testWs1("key1"));
		response.getWriter().append("ParameterList: " + ejb.testWs2("key"));
	}


}
