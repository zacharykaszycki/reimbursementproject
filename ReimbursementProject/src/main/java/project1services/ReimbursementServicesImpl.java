package project1services;

import java.util.List;

import project1dao.ReimbursementDaoImpl;
import project1models.Reimbursement;
import project1models.User;

public class ReimbursementServicesImpl implements ReimbursementServices {
	ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
	

	public void addNewReimbursement(Reimbursement newReim, int id) {
		rdi.addNewReimbursement(newReim, id);
		
	}

//	@Override
//	public void addNewReimbursement(Reimbursement newReim) {
//		rdi.addNewReimbursement(newReim);
//		
//	}
	
//	@Override
//	public List<Reimbursement> getUsersReimbursements(User us) {
//		// TODO Auto-generated method stub
//		return rdi.getUsersReimbursements(us);
//	}
	
	@Override
	public List<Reimbursement> getUsersReimbursements(User us) {
		// TODO Auto-generated method stub
		List<Reimbursement> temp = rdi.getUsersReimbursements(us);
		return temp;
	}
	

//	@Override
//	public List<Reimbursement> getAllReimbursements() {
//		// TODO Auto-generated method stub
//		return rdi.getAllReimbursements();
//	}
	
	@Override
	public List<Reimbursement> getAllReimbursements() {
		// TODO Auto-generated method stub
		List<Reimbursement> temp = rdi.getAllReimbursements();
		return temp;
	}

	@Override
	public List<Reimbursement> getUncheckedReimbursements() {
		// TODO Auto-generated method stub
		return rdi.getUncheckedReimbursements();
	}

	public void changeApproval(Integer id, String status, Integer approver) {
		rdi.changeApproval(id, status, approver);
	}

	@Override
	public void resolveReimb(Integer userId, Integer newStatus) {
		// TODO Auto-generated method stub
		
	}

}
