package com.ici.projectSGSG.dto;
 

public class DogBreedsDto {
	private String dBreeds;//강아지 품종
	private int tId;//강아지 크기별 정리 (1,2,3)
	public String getdBreeds() {
		return dBreeds;
	}
	public void setdBreeds(String dBreeds) {
		this.dBreeds = dBreeds;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public DogBreedsDto(String dBreeds, int tId) {
		super();
		this.dBreeds = dBreeds;
		this.tId = tId;
	}
	public DogBreedsDto() {
		super();
	}
	
	
}
