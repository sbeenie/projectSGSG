<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/AccountForm.css">
</head>
<body> 
    <div id="page">
		<%@ include file="include/header.jsp" %>
		<main class="small">
			 <section id="main">  
			  <div id="write_title"><h2>마이 페이지</h2></div>
			  	<article id="login_box">
			    <div class="center"><br>
			    	<%=sessionName %>님 환영합니다<br> 
			    	<table>
			    		<tr>
			    			<td> 
			    			</td>
						</tr>
			    		<tr>
			    			<td>
			    				<input type="button" value="정보 수정" onclick="location.href='account_Modify'"  class="btn_word">
			    			</td>
						</tr>
			    		<tr>
			    			<td>
			    				<input type="button" value="반려견 관리" onclick="location.href='DogList'"  class="btn_word">
			    			</td>
						</tr>
			    		<tr>
			    			<td>
			    				<input type="button" value="로그아웃" onclick="location.href='account_Logout'"  class="btn_word">
			    			</td>
						</tr>
			    	
			    	</table>
			    </div>
			  </article> 
			  </section>
		</main>
		<%@ include file="include/footer.jsp" %>
    </div>
</body>
</html>