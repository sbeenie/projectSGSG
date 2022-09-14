package com.ici.projectSGSG.dto;

public class DogListDto { 
	private int dId; 
	private String dBreeds;
	private String dName;
	private int dGender;
	private String dAge;
	private String iUrl;
	public DogListDto(int dId, String dBreeds, String dName, int dGender, String dAge, String iUrl) {
		super();
		this.dId = dId;
		this.dBreeds = dBreeds;
		this.dName = dName;
		this.dGender = dGender;
		this.dAge = dAge;
		this.iUrl = iUrl;
	}
	public DogListDto() {
		super();
	}
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public String getdBreeds() {
		return dBreeds;
	}
	public void setdBreeds(String dBreeds) {
		this.dBreeds = dBreeds;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public int getdGender() {
		return dGender;
	}
	public void setdGender(int dGender) {
		this.dGender = dGender;
	}
	public String getdAge() {
		return dAge;
	}
	public void setdAge(String dAge) {
		this.dAge = dAge;
	}
	public String getiUrl() {
		return iUrl;
	}
	public void setiUrl(String iUrl) {
		this.iUrl = iUrl;
	}
	
	
}
