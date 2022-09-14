package com.ici.projectSGSG.dto;
 

public class ImageDto { 
	
	private int iId;//파일의 고유번호(시퀀스)
	private String iFilename;//랜덤으로 변경된 파일의 이름
	private String iOrifilename;//파일의 원래 이름
	private String iFileurl;//파일의 저장 경로
	private String iFileextension;//파일의 확장자
	public int getiId() {
		return iId;
	}
	public void setiId(int iId) {
		this.iId = iId;
	}
	public String getiFilename() {
		return iFilename;
	}
	public void setiFilename(String iFilename) {
		this.iFilename = iFilename;
	}
	public String getiOrifilename() {
		return iOrifilename;
	}
	public void setiOrifilename(String iOrifilename) {
		this.iOrifilename = iOrifilename;
	}
	public String getiFileurl() {
		return iFileurl;
	}
	public void setiFileurl(String iFileurl) {
		this.iFileurl = iFileurl;
	}
	public String getiFileextension() {
		return iFileextension;
	}
	public void setiFileextension(String iFileextension) {
		this.iFileextension = iFileextension;
	}
	public ImageDto(int iId, String iFilename, String iOrifilename, String iFileurl, String iFileextension) {
		super();
		this.iId = iId;
		this.iFilename = iFilename;
		this.iOrifilename = iOrifilename;
		this.iFileurl = iFileurl;
		this.iFileextension = iFileextension;
	}
	public ImageDto() {
		super();
	}
	
	
	
}
