<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Product_Management_css.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css">
<title>상품 관리</title>
</head>
<body>
    <div id="page">
		<%@ include file="include/header.jsp" %>
		<main>
		
	<h2>상품 관리</h2>
	<table class="table">
		<tr>
			<th class="table2">상품ID번호</th>
			<th class="table2">상품이미지</th>
			<th class="table2">상품명</th>
			<th class="table2">가격</th>
			<th class="table2">관리</th>
		</tr>
			<c:forEach var="pm" items="${proMana}">
			<form action = "Proupdate_btn">
				<tr>
					<td class="table2">
						${pm.pId }
					</td>
					<td class="table2">
						<img src="${pageContext.request.contextPath }/resources/uploadfiles/${pm.imageurl}" width="120px" height="120px">
					</td>
					<td class="table2">
						${pm.pName}
					</td>
					<td class="table2">
						${pm.pPrice}
					</td>
					<td class="table2">
							<input  type="hidden" value="${pm.pId}" name="pid"> 
							<input class="button" type="submit" name="Proupdate_btn" value="수정">			
			 </form>
								
						<form action="Prodelete_btn">
							<input type="hidden" value="${pm.pId}" name="pid">
							<input class="button" type="submit" name="Prodelete_btn" value="삭제">
						</form>
					</td>
				</tr>

			</c:forEach>	
	</table>

		</main>
		<%@ include file="include/footer.jsp" %>
    </div>
</body>
</html>