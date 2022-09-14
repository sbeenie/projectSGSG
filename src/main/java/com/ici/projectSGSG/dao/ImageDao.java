package com.ici.projectSGSG.dao;

import com.ici.projectSGSG.dto.ImageDto;

public interface ImageDao {

	//첨부파일용 dao
	public void fileInsert(String filename, String orifilename, String fileurl, String fileextension);
	//파일 업로드(파일이 첨부된 게시글번호, 변경된 파일이름, 원본 파일이름, 파일저장경로, 파일의 확장자)
	public ImageDto GetImageInfo(int imageid);//이미지 아이디로 검색
	public int GetFileId(String filename);//변경된이름으로 id 검색
}
