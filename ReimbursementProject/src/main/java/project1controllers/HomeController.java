package project1controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController {

	public static void home(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		String myPath = "/resources/html/home.html";
		
		req.getRequestDispatcher(myPath).forward(req, res);
	}
}
