package project1services;

import java.util.List;

import project1models.Reimbursement;
import project1models.User;

public interface ReimbursementServices {

	public List<Reimbursement> getUsersReimbursements(User us);
	
	public List<Reimbursement> getAllReimbursements();
	
	public List<Reimbursement> getUncheckedReimbursements();
	
	public void resolveReimb(Integer userId, Integer newStatus);

}
