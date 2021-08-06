package project1models;

public class TempReimb {
	private Double reimbAmount;
	private String reimbDescription;
	private String reimbTypeId;
	
	public TempReimb() {
		super();
	}
	
	public TempReimb(Double reimbAmount, String reimbDescription, String reimbTypeId) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbTypeId = reimbTypeId;
	}
	public Double getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(Double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public String getReimbDescription() {
		return reimbDescription;
	}
	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}
	public String getReimbTypeId() {
		return reimbTypeId;
	}
	public void setReimbTypeId(String reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}
	
	

}
