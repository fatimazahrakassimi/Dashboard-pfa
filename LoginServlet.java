package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.loginService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

	 String userId = request.getParameter("userId");	
	 String password = request.getParameter("password");
	 loginService loginService = new loginService();
	 boolean result = loginService.authenticateUser(userId, password);
	 User user = loginService.getUserByUserId(userId);
	 if(result == true){
		 request.getSession().setAttribute("user", user);		
		 response.sendRedirect("ProjectServlet");
	 }
	 else{
		 response.sendRedirect("error.jsp");
	 }
}
}
