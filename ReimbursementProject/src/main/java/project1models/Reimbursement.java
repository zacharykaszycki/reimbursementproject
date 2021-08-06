package project1models;

import java.util.Arrays;

public class Reimbursement {
	private Integer reimbId;
	private Double	reimbAmount;
	private String reimbSubmitted;
	private String reimbResolved;
	private String reimbDescription;
	private byte[] reimbReceipt;
	
//	private Integer reimbAuthor;
//	private Integer reimbResolver;
	private String reimbAuthor;
	private String reimbResolver;
	private String reimbStatusID;
	private String reimbTypeId;
	
	
	
//	public Reimbursement(Integer reimbId, Double reimbAmount, String reimbSubmitted, String reimbResolved,
//			String reimbDescription, byte[] reimbReceipt, Integer reimbAuthor, Integer reimbResolver,
//			String reimbStatusID, String reimbTypeId) {
//		super();
//		this.reimbId = reimbId;
//		this.reimbAmount = reimbAmount;
//		this.reimbSubmitted = reimbSubmitted;
//		this.reimbResolved = reimbResolved;
//		this.reimbDescription = reimbDescription;
//		this.reimbReceipt = reimbReceipt;
//		this.reimbAuthor = reimbAuthor;
//		this.reimbResolver = reimbResolver;
//		this.reimbStatusID = reimbStatusID;
//		this.reimbTypeId = reimbTypeId;
//	}
	
	public Reimbursement(Integer reimbId, Double reimbAmount, String reimbSubmitted, String reimbResolved,
			String reimbDescription, byte[] reimbReceipt, String reimbAuthor, String reimbResolver,
			String reimbStatusID, String reimbTypeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbReceipt = reimbReceipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusID = reimbStatusID;
		this.reimbTypeId = reimbTypeId;
	}
	


	
	public Reimbursement(Double reimbAmount, String reimbDescription, String reimbTypeId) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbTypeId = reimbTypeId;
	}



	public Reimbursement() {
		super();
	}



	public void shrinkDates()
	{
		if (this.reimbSubmitted != null)
			this.reimbSubmitted = this.reimbSubmitted.substring(0, 19);
		if (this.reimbResolved != null)
			this.reimbResolved = this.reimbResolved.substring(0, 19);
	}



	public void setReimbId(Integer reimbId) {
		this.reimbId = reimbId;
	}



	public void setReimbSubmitted(String reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}



	public void setReimbResolved(String reimbResolved) {
		this.reimbResolved = reimbResolved;
	}



	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}



	public void setReimbReceipt(byte[] reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}


//	public void setReimbAuthor(Integer reimbAuthor) {
//		this.reimbAuthor = reimbAuthor;
//	}
//
//	public void setReimbResolver(Integer reimbResolver) {
//		this.reimbResolver = reimbResolver;
//	}
	
	public void setReimbAuthor(String reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public void setReimbResolver(String reimbResolver) {
		this.reimbResolver = reimbResolver;
	}



	public void setReimbStatusID(String reimbStatusID) {
		this.reimbStatusID = reimbStatusID;
	}



	public void setReimbTypeId(String reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}



	public Integer getReimbId() {
		return reimbId;
	}
	public Double getReimbAmount() {
		return reimbAmount;
	}
	public String getReimbSubmitted() {
		return reimbSubmitted;
	}
	public String getReimbResolved() {
		return reimbResolved;
	}
	public String getReimbDescription() {
		return reimbDescription;
	}
	public byte[] getReimbReceipt() {
		return reimbReceipt;
	}
//	public Integer getReimbAuthor() {
//		return reimbAuthor;
//	}
//	public Integer getReimbResolver() {
//		return reimbResolver;
//	}
	public String getReimbAuthor() {
		return reimbAuthor;
	}
	public String getReimbResolver() {
		return reimbResolver;
	}
	public String getReimbStatusID() {
		return reimbStatusID;
	}
	public String getReimbTypeId() {
		return reimbTypeId;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbReceipt=" + Arrays.toString(reimbReceipt) + ", reimbAuthor=" + reimbAuthor
				+ ", reimbResolver=" + reimbResolver + ", reimbStatusID=" + reimbStatusID + ", reimbTypeId="
				+ reimbTypeId + "]";
	}
	
	

}
