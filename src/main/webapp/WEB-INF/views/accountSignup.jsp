<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/AccountForm.css">
<title>회원가입</title>
</head>
<body>
		
    <div id="page">
		<%@ include file="include/header.jsp" %>
		<main class="small">
		
	<section id="main"> 
	  <h2 id="board_title"><img class="img1" src="${pageContext.request.contextPath }/resources/img/header_logo.png" alt="Logo" width="180px" height="auto"></h2>
	  <div id="write_title"><h2>회원 정보 입력</h2></div>
	  <form action="account_SignupOk" method="post">
		  <table id="write_table">
				<tr id="atr">
				      <td class="col1">아이디</td>
				      <td class="col2"><input type="text" name="A_LOGINID"></td>
			    </tr>
			    <tr id="atr">
			      <td class="col1">비밀번호</td>
			      <td class="col2"><input type="password" name="A_LOGINPW"></td>
			    </tr>		
			    <tr id="atr">
			      <td class="col1">이름</td>
			      <td class="col2"><input type="text" name="A_NAME"></td>
			    </tr>
		  </table>
		  <div id="buttons"> 
		  		
			  	<input type="submit"  value="회원가입" class="btn_word">
				<input type="button" value="돌아가기" onclick="location.href='account_Login'" class="btn_word">
		  </div>
	  </form>
	</section> <!-- section main -->
	    
		</main>
		<%@ include file="include/footer.jsp" %>
    </div>
</body>
</html>