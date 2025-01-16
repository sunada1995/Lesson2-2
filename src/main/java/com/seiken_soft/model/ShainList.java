package com.seiken_soft.model;

public class ShainList {

	  private String shainId;
	  private String shainName;
	  private String email;
	  private String process;
	 	
	
	public ShainList(String shainId, String shainName, String email,String process) {
		super();
		this.shainId = shainId;
		this.shainName = shainName;
		this.email = email;
		this.process = process;
	}
	
	public String getShainId() {
		return shainId;
	}
	public void setShainId(String shainId) {
		this.shainId = shainId;
	}
	public String getShainName() {
		return shainName;
	}
	public void setShainName(String shainName) {
		this.shainName = shainName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	
	
}
