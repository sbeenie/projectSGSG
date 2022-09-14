<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>반려견 추가</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/dogAdd.css">
</head>
<body>
    <div id="page">
		<%@ include file="include/header.jsp" %>
		<main>
			<section id="main"> 
			
   <form action="DogAddOk" enctype="multipart/form-data" method="post">
      <table border="1">
      <tr>
         <td  class="first">강아지 이름</td>
         <td><input type="text" name="dogName" id="dogName" class="dname"></td>
      </tr>
      <tr>
         <td class="second">강아지 종류</td>
         <td>
         	<select id="D_BREEDS" name="dogBreeds" class="dbreeds" size="1">
         		<c:forEach var="AdogBreedsDto" items="${dogbreedslist}">
         			<option value="${AdogBreedsDto.dBreeds}">${AdogBreedsDto.dBreeds}</option>
         		</c:forEach>
         	</select>
		</td>
      </tr>
      <tr>
         <td class="third">강아지 성별</td>
         <td>
         	 <input type="radio" name="dogGender" class="dgender" value=0>수컷
			 <input type="radio" name="dogGender" class="dgender" value=1>암컷
		 </td>
      </tr>
      
      <tr>
         <td class="fourth">강아지 나이</td>
         <td><input type="date" name="dogAge" id="dogAge" class="dage"></td>
      </tr>
      <tr>
         <td class="fifth">강아지 사진</td>
         <td>
      			<input type="file" name="uploadFiles" class="dpicture" accept=".gif, .jpg, .png, .bmp">
   		 </td>
         	
      </tr>
      <tr>
        	<td colspan="2" alogn="center">
            	<input type = "submit" class="DogAddBtn" value="등록" id="addBtn">
            	
            	<button type="button" class="listBtn" onclick="location.href='DogList'">목록</button>
            	
         	</td>
      </tr>
      </table>
   </form>
			
			
			</section>
		</main>
		<%@ include file="include/footer.jsp" %>
    </div>
</body>
</html>