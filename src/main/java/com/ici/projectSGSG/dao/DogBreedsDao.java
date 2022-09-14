package com.ici.projectSGSG.dao;

import java.util.ArrayList;

import com.ici.projectSGSG.dto.DogBreedsDto;

public interface DogBreedsDao {

	public ArrayList<DogBreedsDto> dblistDao(); //품종 
	public DogBreedsDto dbreedsDao(String dogBreeds, int typeId); //품종 뽑아오기
}
