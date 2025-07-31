package com.skt.SpringAi.Request;


public class EncryptedRequest {

	private String panNumber;
	private String mobileNumber;
	private String ivCode;
	
	
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getIvCode() {
		return ivCode;
	}
	public void setIvCode(String ivCode) {
		this.ivCode = ivCode;
	}
	
	
}
