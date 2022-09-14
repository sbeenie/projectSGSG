package com.ici.projectSGSG.dto;




public class ProductListDto { 
	int pId;
	String pName;
	int pPrice;
	String pDesc;
	String imageurl;
	int count=0;
	
	
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
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ProductListDto(int pId, String pName, int pPrice, String pDesc, String imageurl) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pDesc = pDesc;
		this.imageurl = imageurl;
	}
	public ProductListDto() {
		super();
	}
	
	
	
}

