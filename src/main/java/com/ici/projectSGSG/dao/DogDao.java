package com.ici.projectSGSG.dao;

import java.util.ArrayList;

import com.ici.projectSGSG.dto.DogDto;

public interface DogDao {
	public ArrayList<DogDto> getDogsData(int aid);

	public int getDogTag(String dbreeds);

	public void DogAddDao( int aId, String dBreeds, String dName, int dGender, String dAge, int iId); //강아지 추가
	public ArrayList<DogDto> doglistdao(int aId); //강아지 리스트 
	public void DogDeleteDao(int dID);
	 
}
