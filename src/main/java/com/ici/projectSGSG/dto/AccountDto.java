package com.ici.projectSGSG.dto;

 
public class AccountDto {
	private int aId;
	private String aLoginid;
	private String aLoginpw;
	private String aName;
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getaLoginid() {
		return aLoginid;
	}
	public void setaLoginid(String aLoginid) {
		this.aLoginid = aLoginid;
	}
	public String getaLoginpw() {
		return aLoginpw;
	}
	public void setaLoginpw(String aLoginpw) {
		this.aLoginpw = aLoginpw;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public AccountDto(int aId, String aLoginid, String aLoginpw, String aName) {
		super();
		this.aId = aId;
		this.aLoginid = aLoginid;
		this.aLoginpw = aLoginpw;
		this.aName = aName;
	}
	public AccountDto() {
		super();
	}
	
	
}
