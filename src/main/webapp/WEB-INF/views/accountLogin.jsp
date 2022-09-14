<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/AccountForm.css">
<title>로그인</title> 
</head>
<body>

    <div id="page">
		<%@ include file="include/header.jsp" %>
     	<main class="small">
     	   
		<section id="main">  
		  	<div id="write_title">
                <img class="img1" src="${pageContext.request.contextPath }/resources/img/header_logo.png" alt="Logo" width="180px" height="auto"></div>
		  	<article id="login_box">  
		    	<div id="login_box">
		    		<form action="account_Login" method="post" class="accountform">
		    		<br>
						<ul id="login_input">
						      <li><input type="text" name="A_LOGINID" placeholder="아이디"  class="tf"></li>
						      <li><input type="password" name="A_LOGINPW" placeholder="비밀번호" class="tf"></li>
					    </ul>
					    <div>
					    <input type="submit" class="bt" id="login" value="로그인">
					    </div>
						<input type="button" value="회원가입" onclick="location.href='account_Signup'" class="btn_word"> 
					    <br><br>
		    		</form>
		    	</div> 
		    	<div class="clear"></div>
		    	<div id="join_search"></div>
		  </article>
	   	</section>
	  
     	</main>
		<%@ include file="include/footer.jsp" %>
	  
</body>
</html>