<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Product_Add_css.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css">
<title>상품 등록</title>
</head>
<body>
    <div id="page">
		<%@ include file="include/header.jsp" %>
		<main>
		 
	<form action="Product_AddOk" name="form1" enctype="multipart/form-data" method="post">
		<table class="table1">

		<tr class="tr1">
			<td>상품명</td>
			<td><input type="text" name="PNAME" ></td>
		</tr>
		<tr class="tr1">
			<td>가격</td>
			<td><input type="text" name="PPRICE"></td>
		</tr>
		<tr class="tr1">
			<td>분류</td>
			<td>
			<select name="dogSize">
	    		<option value="10">사이즈</option>
	    		<option value="1">소형견</option>
	    		<option value="2">중형견</option>
	    		<option value="3">대형견</option>
	    		<option value="10">크기무관</option>
			</select>
			
			<select name="dogGender">
	    		<option value="11">성별</option>
	    		<option value="4">수컷</option>
	    		<option value="5">암컷</option>
	    		<option value="11">성별무관</option>
			</select>
			
			<select name="dogAge">
	    		<option value="12">나이</option>
	    		<option value="6">아기</option>
	    		<option value="7">청년</option>
	    		<option value="8">중년</option>
	    		<option value="9">노년</option>
	    		<option value="12">나이무관</option>
			</select>
			</td>
		</tr>
		<tr class="tr1">
			<td>상품설명</td>
			<td><textarea rows="5" cols="60" name="PDESC"></textarea></td>
		</tr>
		<tr class="tr1">
			<td>상품이미지</td>
			  
   			<td><input type="file" name="uploadFiles" accept=".gif, .jpg, .png, .bmp"><td>
      

			
		</tr>
		<tr class="tr1">
			<td colspan="2" align="center">
				<input type = "submit" class = "button"  value="등록" id="addBtn">
			</td>
		</tr>
		</table>
	</form>
		</main>
		<%@ include file="include/footer.jsp" %>
    </div>
</body>
</html>