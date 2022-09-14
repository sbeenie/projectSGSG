package com.ici.projectSGSG.dao;

import java.util.ArrayList;

import com.ici.projectSGSG.dto.AccountDto;
import com.ici.projectSGSG.dto.AccountPlainDto;

public interface AccountDao {
	public void accountInsert(String A_LOGINID, String A_LOGINPW, String A_NAME); // 회원가입
	public void accountUpdate(int A_ID,String A_LOGINPW , String A_NAME);  //정보수정
	public void accountDelete(String a_ID, String A_LOGINPW); //회원탈퇴
	
	public AccountDto accountQuery(int A_ID); // A_ID로 정보 가져오기
	public AccountPlainDto accountgetInfo(String A_LOGINID);//LOGINID로 찾아서 A_ID 반환
	
	public int accountCheckId(String A_LOGINID);//LOGINID로 찾아서 있으면 1반환
	public int accountCheckPw(String A_LOGINID, String A_LOGINPW); // LOGINPW로 찾아서 있으면 1반환
	
	public ArrayList<AccountDto> accountList(); 
}
