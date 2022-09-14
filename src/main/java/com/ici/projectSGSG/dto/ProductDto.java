package com.ici.projectSGSG.dto;

public class ProductDto {
	int pId;
	String pName;
	int pPrice;
	String pDesc;
	int pStock;
	int iId;
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public String getpDesc() {
		return pDesc;
	}
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}
	public int getpStock() {
		return pStock;
	}
	public void setpStock(int pStock) {
		this.pStock = pStock;
	}
	public int getiId() {
		return iId;
	}
	public void setiId(int iId) {
		this.iId = iId;
	}
	public ProductDto(int pId, String pName, int pPrice, String pDesc, int pStock, int iId) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pDesc = pDesc;
		this.pStock = pStock;
		this.iId = iId;
	}
	
	public ProductDto() {
		super();
	} 
	
}
