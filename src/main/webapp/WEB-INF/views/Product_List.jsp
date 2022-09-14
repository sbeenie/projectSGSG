<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Product_List_css.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css">
<title>상품 목록</title>
</head>
<body>
    <div id="page">
		<%@ include file="include/header.jsp" %>
		<main class="large">
			<table class="table">
				<tr>
					<c:forEach items="${prolist}" var="pro">
						<form action="go_explain" id="go_explain">
							<td class="table2" >
								<table >
									<tr>
										<td>
											<img class="imgclass" src="${pageContext.request.contextPath }/resources/uploadfiles/${pro.imageurl}" alt="사진 없어용" >
										</td> 
									</tr>
									<tr>
										<td> 
							                		<strong class="">
							                			<input type="hidden" value="${pro.pId}" name="pid"> 	
							                				<span class="">
							                					<span>상품명</span> :
							                				</span> 
							                				<span><c:out value="${pro.pName}"/>
							                				</span>
							                		</strong> 
									                	<div class="">
															<span >판매가</span> : 
															<span ><c:out value="${pro.pPrice}"/>원<br>
															<input class="button" type="submit" name="show_explain" value="상세보기">
															
															</form>
															
															
															<%
																if(sessionAuth==2){
															
															%>	    
															<form action="go_management">
															<input type="hidden" value="${pro.pId}" name="pid">
															<input class="button" type="submit" name="show_update" value="수정하기" >
															</form>
																 
															<%
																}
															%>
															</span>
														</div> 
										</td>
									</tr>
								</table>
							</td>
						</c:forEach>
						
						<c:if test="${fn:length(prolist)==0}">
										<div class="description">
							            	<span>검색 결과가 없습니다!</span>
										</div>
						</c:if>
						
						
				</tr>
			</table>
		</main>
		<%@ include file="include/footer.jsp" %>
    </div>
	</body>
	</html>