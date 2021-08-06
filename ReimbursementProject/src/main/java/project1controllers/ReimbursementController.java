package project1controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import project1models.Reimbursement;
import project1models.TempApprove;
import project1models.TempReimb;
import project1models.User;
import project1services.ReimbursementServicesImpl;
import project1services.UserServicesImpl;

//import example.model.SuperVillain;
//import example.service.SuperVillainService;
//import example.service.SuperVillainServiceImpl;


public class ReimbursementController {

	public static void allReimb(HttpServletRequest req, HttpServletResponse res)
			throws IOException, JsonProcessingException {
		System.out.println("In Reimb Controller");
		

		ReimbursementServicesImpl rsi = new ReimbursementServicesImpl();
		List<Reimbursement> allReimbursement = rsi.getAllReimbursements();
		

		
		PrintWriter printer = res.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(allReimbursement));
	}
		
	public static void userReimb(HttpServletRequest req, HttpServletResponse res)
			throws IOException, JsonProcessingException {
		System.out.println("In Reimb Controller");
		/*
		 * THIS IS WHERE YOU'D GO TO THE DATABASE TO GET THE OBJECTS TO SEND TO THE CLIENT
		 */

		ReimbursementServicesImpl rsi = new ReimbursementServicesImpl();
		List<Reimbursement> allReimbursement = rsi.getUsersReimbursements((User) req.getSession().getAttribute("loggedInUser"));
		
		/*
		 * in your project 1 you MAY already have the user's information in their session...no
		 * need to go to the database in that case
		 * You can just extract the reimbursments doing a
		 * HttpSession session = req.getSession();
		 * session.getAttribute(".....
		 */
		
		PrintWriter printer = res.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(allReimbursement));
	}

	public static void addReimb(HttpServletRequest req, HttpServletResponse res)
			throws IOException, JsonProcessingException {
		System.out.println("In Reimb Controller");
		ReimbursementServicesImpl rsi = new ReimbursementServicesImpl();
		/*
		 * THIS IS WHERE YOU'D GO TO THE DATABASE TO GET THE OBJECTS TO SEND TO THE CLIENT
		 */
//		Double amount = Double.parseDouble(req.getParameter("amount"));
//		String description = req.getParameter("description");
//		String type = req.getParameter("type");
		ObjectMapper mapper = new ObjectMapper();
		//TempReimb tempReimb = mapper.readValue(req.getInputStream(), TempReimb.class);
		Reimbursement tempReimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
		res.setStatus(HttpServletResponse.SC_CREATED);
		HttpSession session = req.getSession();
		Integer id = (Integer) session.getAttribute("loggedInUserID");
		System.out.println("Current adding Reimb id: " + id);
		//rsi.addNewReimbursement(new Reimbursement(tempReimb.getReimbAmount(), tempReimb.getReimbDescription(), id, tempReimb.getReimbTypeId()));
		
		if(id != 100)
			rsi.addNewReimbursement(tempReimb, id);
	}
	
//	public static void addReimb(HttpServletRequest req, HttpServletResponse res)
//			throws IOException, JsonProcessingException {
//		System.out.println("In Reimb Controller");
//		ReimbursementServicesImpl rsi = new ReimbursementServicesImpl();
//		/*
//		 * THIS IS WHERE YOU'D GO TO THE DATABASE TO GET THE OBJECTS TO SEND TO THE CLIENT
//		 */
////		Double amount = Double.parseDouble(req.getParameter("amount"));
////		String description = req.getParameter("description");
////		String type = req.getParameter("type");
//		ObjectMapper mapper = new ObjectMapper();
//		//TempReimb tempReimb = mapper.readValue(req.getInputStream(), TempReimb.class);
//		Reimbursement tempReimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
//		res.setStatus(HttpServletResponse.SC_CREATED);
//		HttpSession session = req.getSession();
//		Integer id = (Integer) session.getAttribute("loggedInUserID");
//		System.out.println("Current adding Reimb id: " + id);
//		tempReimb.setReimbAuthor(id);
//		//rsi.addNewReimbursement(new Reimbursement(tempReimb.getReimbAmount(), tempReimb.getReimbDescription(), id, tempReimb.getReimbTypeId()));
//		rsi.addNewReimbursement(tempReimb);
//	}

	
	public static void changeApproval(HttpServletRequest req, HttpServletResponse res)
			throws IOException, JsonProcessingException {
		System.out.println("In Reimb Controller");
		ReimbursementServicesImpl rsi = new ReimbursementServicesImpl();
		/*
		 * THIS IS WHERE YOU'D GO TO THE DATABASE TO GET THE OBJECTS TO SEND TO THE CLIENT
		 */
		ObjectMapper mapper = new ObjectMapper();
		TempApprove ta = mapper.readValue(req.getInputStream(), TempApprove.class);
		System.out.println(ta);
		HttpSession session = req.getSession();
		res.setStatus(HttpServletResponse.SC_CREATED);
		System.out.println("TestCheck");
		Integer approver = (Integer) session.getAttribute("loggedInUserID");
		if(approver != 100)
			rsi.changeApproval(ta.getReimbId(), ta.getApproval(), approver);
		
	}
}
