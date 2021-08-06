package project1servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

import project1controllers.HomeController;
import project1controllers.LoginController;
import project1controllers.ManagerController;
import project1controllers.ReimbursementController;
import project1controllers.UserController;


public class Dispatcher {

	public static void myVirtualRouter(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException, ServletException {
		
		System.out.println("\n\n\t\tIn MyDispatcher (myVirtualRouter())");
		System.out.println("Current URL: "+req.getRequestURL());
		System.out.println("Current URI: "+req.getRequestURI());
		
		
		switch(req.getRequestURI()) {
		case "/Project1/forwarding/login":
			System.out.println("case 1");
			LoginController.login(req, res);
			break;
		case "/Project1/forwarding/home":
			System.out.println("case 2");
			HomeController.home(req, res);
			break;
		case "/Project1/forwarding/manager":
			System.out.println("case manager");
			ManagerController.home(req, res);
			break;
		case "/Project1/forwarding/logout":
			System.out.println("logging out");
			LoginController.logout(req, res);
			break;
		case "/Project1/json/addReimb":
			System.out.println("case adding Reimbursement");
			ReimbursementController.addReimb(req, res);
			break;
		case "/Project1/json/approval":
			System.out.println("case changing approval");
			ReimbursementController.changeApproval(req, res);
			break;
		case "/Project1/json/getName":
			System.out.println("case getName");
			UserController.getName(req, res);
			break;
		case "/Project1/json/allReimb":
			System.out.println("case AllReimb");
			ReimbursementController.allReimb(req, res);
			break;
		case "/Project1/json/usersReimb":
			System.out.println("case 3");
			ReimbursementController.userReimb(req, res);
			break;
		case "/Project1/json/getCurrentUserObject":
			//for project 1 you'll need an endpoint that will simply fetch the user's information from their session
			/*
			 * NOW....after you login the servlet will respond with the html page that you need....
			 * THEN....that html page will IMMEDIATELY FIRE ANOTHER AJAX REQUEST to retrieve that user's session
			 * data so that you can dom manipulation it into the html home page so you can say
			 * "hello [username]". The page is now modularized.
			 */
			break;
		default:
			System.out.println("Dude, you gave me a bad URI.");
			req.getRequestDispatcher("/resources/html/badlogin.html").forward(req, res);
			return;
			
		}
	}
}
