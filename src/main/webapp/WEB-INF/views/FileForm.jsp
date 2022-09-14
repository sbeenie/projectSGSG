<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- 다운로드시 필요 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 파일 업로드 할때 -->
	<form action="filesavetest" method="post" enctype="multipart/form-data">
	
		<input type="file" name="file"  accept=".gif, .jpg, .png, .bmp">
		<input type="submit" value="저장">
	</form>
	
	<!-- 파일 표시	
	<p id="image_view">  	
  		<img src="${pageContext.request.contextPath }/resources/uploadfiles/${ImageDto.iFilename}">
  	</p>
	 -->  
</body>
</html>