<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>반려견 관리</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/AccountForm.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/dogList.css">
</head>
<body>
    <div id="page">
		<%@ include file="include/header.jsp" %>
     	<main class="big">
			<section  > 
			
			
          <div class="col-4">
              <c:forEach var="dog" items="${ doglist }" varStatus="dogStatus">
              	<form action="DogDelete">
                      <div class = "dogcardlist">
                            <img src="${pageContext.request.contextPath }/resources/uploadfiles/${dog.iUrl}" alt="" class="card-img-top" />	
                            <div class="card-body">
                               <input type="hidden" name="dId" value="${dog.dId }">
                               <h5 class="card-title"><c:out value="${dog.dName}"/></h5>
                               <p class="card-text1">${dog.dBreeds}</p>
                               <c:if test="${dog.dGender eq 0}">
                               <p class="card-text2" >수컷</p>
                               </c:if>
                               <c:if test="${dog.dGender eq 1}">
                               <p class="card-text2" >암컷</p>
                               </c:if>
                               <p class="card-text3">${dog.dAge}</p> 
                               <button type="submit" class="btn btn-danger" id="delete-btn" name="delete">삭제</button>
                            </div>
                         </div> 
                </form>
              </c:forEach>
          </div>
          <div class="col-4">
          		<div class = "dogcardlist" id="box">
                           
                           <div class="card-body">
                              <h5 class="card-title"></h5>
                              <p class="card-text"></p>
                              <p class="card-text"></p>
                              <p class="card-text"></p>
                              <input class="button" type="button" value="Add" onclick="location.href='DogAdd'">
                           </div>
                         </div>
          </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
			
			</section>
		</main>
		<%@ include file="include/footer.jsp" %>
    </div>
</body>
</html>