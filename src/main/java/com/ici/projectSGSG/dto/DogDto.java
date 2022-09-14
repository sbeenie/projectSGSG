package com.ici.projectSGSG.dto;
 
 


public class DogDto {
	private int dId;
	private int aId;
	private String dBreeds;
	private String dName;
	private int dGender;
	private String dAge;
	private int iId;
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
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
	public int getiId() {
		return iId;
	}
	public void setiId(int iId) {
		this.iId = iId;
	}
	public DogDto(int dId, int aId, String dBreeds, String dName, int dGender, String dAge, int iId) {
		super();
		this.dId = dId;
		this.aId = aId;
		this.dBreeds = dBreeds;
		this.dName = dName;
		this.dGender = dGender;
		this.dAge = dAge;
		this.iId = iId;
	}
	public DogDto() {
		super();
	}
	
	
	
}
