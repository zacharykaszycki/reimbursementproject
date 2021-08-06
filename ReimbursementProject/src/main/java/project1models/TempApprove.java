package project1models;

public class TempApprove {
	private Integer reimbId;
	private String	approval;
	
	
	
	
	public TempApprove(Integer reimbId, String approval) {
		super();
		this.reimbId = reimbId;
		this.approval = approval;
	}
	
	public TempApprove() {
		super();
	}


	public Integer getReimbId() {
		return reimbId;
	}
	public void setReimbId(Integer reimbId) {
		this.reimbId = reimbId;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}

}
