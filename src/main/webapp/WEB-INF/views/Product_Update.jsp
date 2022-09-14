<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/Product_Update_css.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css">
<title>상품 수정</title>
</head>
<body>
    <div id="page">
		<%@ include file="include/header.jsp" %>
		<main>
	<h2>상품 수정창</h2>
	
	<table border ="1"  class="table">
		<tr>
			<th>상품ID번호</th>
			<th>상품이미지</th>
			<th>상품명</th>
			<th>가격</th>
			<th>설명</th>
			<th>관리</th>
		</tr>
			<c:forEach var="pm" items="${proMana}">
			<form action = "ProupdateOk_btn">
				<tr>
					<td align="center">
						<input type="hidden" value="${pm.pId}" name="pid">
						${pm.pId}
					</td>
					<td align="center">
						<img src="${pageContext.request.contextPath }/resources/uploadfiles/${pm.imageurl}" width="120px" height="120px">
					</td>
					<td align="center">
						${pm.pName}<br>
						<input class="table2" type="text" name="name_text" style="width:100px;height:20px">
					
					</td>
					<td align="center">
						${pm.pPrice} 원<br>
						<input class="table2" type="text" name="price_text" style="width:100px; height:20px " >
					</td>
					<td align="center">
						${pm.pDesc }<br>
						<input class="table2" type="textarea" name="desc_text" style="width:200px; height:120px">
					</td>
					<td align="center">

							<input class="button" type="submit" name="UpdateOk" value="수정하기">
						
					</td>
				</tr>
			</form>
			</c:forEach>	
	</table>

		</main>
		<%@ include file="include/footer.jsp" %>
    </div>
</body>
</html>