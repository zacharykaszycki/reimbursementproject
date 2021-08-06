package project1controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project1models.User;
import project1services.UserServicesImpl;

public class LoginController {
	
	public static void login(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		UserServicesImpl usi = new UserServicesImpl();
		String myPath = null;
		
		
		
		/*
		 * rout guarding:
		 * 
		 * you may do stuff like:
		 * "check if the user has an admin token in their session"
		 * OR
		 * "check if they are using the correct http method"
		 * OR
		 * something to that effect.
		 */
		if(!req.getMethod().equals("POST")){
			myPath = "/index.html";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}
		
		
		
		//extracting the form data
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		//check to see if the user has the correct username & password
		//you'll actually go to th database to get the user's username and password
		if(!(usi.UserLoginCheck(username, password))) {
			myPath = "/forwarding/incorrectcredentials";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}else {
			/*
			 * you probably will have a user object that you put into the session
			 * that contains their username & password and some other information....THIS is just an example
			 */
			req.getSession().setAttribute("loggedInUserID", usi.getUserId(username));
			
			req.getSession().setAttribute("loggedInUser", usi.getUser(usi.getUserId(username)));
			User us = (User) req.getSession().getAttribute("loggedInUser");
			if (us.getUserRoleId().equals("Employee"))
			{
				myPath = "/forwarding/home";
				req.getRequestDispatcher(myPath).forward(req, res);
				return;
			} else {
				myPath = "/forwarding/manager";
				req.getRequestDispatcher(myPath).forward(req, res);
				return;
			}
		}
		
		
	}
	
	public static void logout(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("loggedInUserID", 100);
		String myPath = "/index.html";
		
		req.getRequestDispatcher(myPath).forward(req, res);
	}
	
	

}
