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
	  <h2 id="board_title">싸개싸개 회원 정보 수정 </h2>
	  <div id="write_title"><h2>회원 정보 수정</h2></div>
	  <form action="account_ModifyOk" method="post">
  		  <input type="hidden" name="A_ID" value="${Aid }">
		  <table id="write_table">
				<tr id="memberid">
				      <td class="col1">아이디</td>
				      <td class="col2"><input type="text" name="A_LOGINID" value="${Aloginid}" readonly></td>
			    </tr>
			    <tr id="memberpw">
			      <td class="col1">기존 비밀번호</td>
			      <td class="col2"><input type="text" name="A_ORIGINPW" value=""></td>
			    </tr>
			    <tr id="memberpw">
			      <td class="col1">새 비밀번호</td>
			      <td class="col2"><input type="text" name="A_NEWPW" value=""></td>
			    </tr>		
			    <tr id="membername">
			      <td class="col1">이름</td>
			      <td class="col2"><input type="text" name="A_NAME" value="${Aname}"></td>
			    </tr>
		  </table>
		  <div id="buttons"> 
				<input class="button" type="submit" value="수정">
				<input class="button" type="button" value="취소" onclick="location.href='index'">
		  </div>
	  </form>
	</section> <!-- section main -->
	    
		</main>
		<%@ include file="include/footer.jsp" %>
    </div>
</body>
</html>