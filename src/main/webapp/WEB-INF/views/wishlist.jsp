<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>장바구니</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/wishlist.css">
</head>
<body>
    <div id="page">
		<%@ include file="include/header.jsp" %>
		<main>

					<c:forEach items="${prolist}" var="pro">
						<div class="wishList">
					              	<form action="deleteWish">
					                      <div class = "wishlistview"> 
					                            <div class="buy-body">
					                               <input type="hidden" name="pId" value="${pro.pId}"> 
					                               <table>
					                                <tr>
					                                  <td class= "first"><img src="${pageContext.request.contextPath }/resources/uploadfiles/${pro.imageurl}" alt="" class="wishImg" /></td>
					                                  <td class= "second"><p class="proName">${pro.pName}</p></td>
					                                  <td class= "third"><p class="proPrice">${pro.pPrice }원</p></td>
					                                  <td class= "fourth"><p class="proCount" >${pro.count }개</p></td>
					                                  <td class= "fifth"><button type="submit" class="btn delete" id="delete-btn" name="delete">삭제</button></td>
					                                 </tr>
					                               </table> 
					                            </div>
					                      </div>
					                </form>
					                
					     </div>
					</c:forEach>
					<c:if test="${fn:length(prolist)==0}">
										           <table>
					                                <tr> 
					                                  <td><p class="proName">장바구니에 상품이 없습니다</p></td> 
					                                 </tr> 
					                               </table> 
					</c:if>
					
			<div class="Buy">
	          		<div class = "buy" id="box">
	                	<div class="BuyBtn">
	                	<input class="buybtn" type="button" value="구매하기" onclick="location.href='buyWish'">
	            	</div>
	        	</div>
	        </div>
		</main>
		<%@ include file="include/footer.jsp" %>
    </div>
</body>
</html>