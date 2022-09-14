package com.ici.projectSGSG.dto;


public class AccountPlainDto {
	private int aId;
	private String aName; 
	private int aAuth;
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public int getaAuth() {
		return aAuth;
	}
	public void setaAuth(int aAuth) {
		this.aAuth = aAuth;
	}
	public AccountPlainDto(int aId, String aName, int aAuth) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.aAuth = aAuth;
	}
	public AccountPlainDto() {
		super();
	}
	
	
}
