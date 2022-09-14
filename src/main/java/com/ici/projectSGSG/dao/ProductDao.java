package com.ici.projectSGSG.dao;

import java.util.ArrayList;

import com.ici.projectSGSG.dto.ProductDto;

public interface ProductDao {
	   public void product_Add(String PNAME,int PPRICE,String PDESC,int IID ); //상품 추가
	   
	   public void product_Update(int PID,String PNAME,int PPRICE,String PDESC); //상품 수정
	   
	   public void product_Delete(int PID); //상품 삭제
	   
	   public ArrayList<ProductDto> product_NAME(String PNAME); //이름으로 상품 목록에 업데이트
	      
	   public ProductDto product_Explain(int PID); //상품 설명창에 업데이트

	   public ArrayList<ProductDto> product_Manage(int PID); //상품 목록 업데이트
	   
	   public int product_FindId(String PNAME);

}
