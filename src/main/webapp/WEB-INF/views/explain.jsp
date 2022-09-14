<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/explain_css.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css">

<link href="/resources/css/star.css" rel="stylesheet"/>

<title>상품 설명창</title>
</head>
<body>

    <div id="page">
		<%@ include file="include/header.jsp" %>
		<main>
	 
		<table border="1" class="Prolist">
 
	<tr>

		<td>
			<img src="${pageContext.request.contextPath }/resources/uploadfiles/${pro.imageurl}" width="340" height="300">
		</td>
		<td>
					<form action="addWish">
			<table border="1" style="height:300px; width: 400px;border-collapse: collapse; border:#ffcf53">
				<tr class="info">
					<td>상품명</td>
					<td>${pro.pName}</td>
				</tr>
				<tr class="info">
					<td>가격</td>
					<td>${pro.pPrice }원</td>
				</tr>
				<tr class="info">
					<td>구매 갯수</td>
					<td><input class="button" type='number' name="count"></input>개</td>
				</tr>
				<tr class="info1">
					<td colspan="2">
					<input type="hidden" value="${pro.pId}" name="pid">
					<input type="submit" class="button" value="장바구니 담기" style="height:50px; width: 100%;">
				</tr>
			</table>
					</form>
		</td>
	</tr>
		</td>
	</tr>
	
	<tr>
	<td class="proex">상품 설명</td><br>
	<td><p><textarea readonly onfocus="this.blur()" class="Product_des" rows="10" cols="33">${pro.pDesc }</textarea></p></td><br>
	

	</tr>
			</table>
		


		</main>
		<%@ include file="include/footer.jsp" %>
    </div>
</body>
</html>