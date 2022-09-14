package com.ici.projectSGSG.dao;

import java.util.ArrayList;

import com.ici.projectSGSG.dto.ProductDto;

public interface ProductEtcDao {
	public ArrayList<ProductDto> searchname(String Pname);
	public ArrayList<ProductDto> getRandProduct();
	public ArrayList<ProductDto> getCustomizedProduct(int tid_size, int tid_sex, int tid_age);
	public void addTag(int pid , int tid);
	public ArrayList<ProductDto> getWishList(int A_ID);
	public Integer readWish(int A_ID,int P_ID);
	public void updateWish(int A_ID,int P_ID,int count);
	public void deleteWish(int A_ID,int P_ID);
	public void deleteAllWish(int A_ID);
	public void createWish(int A_ID,int P_ID,int count);
}
