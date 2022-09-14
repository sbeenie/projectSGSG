<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"> 
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css"> 
</head>
<body> 
		<%
			int sessionId;
			int sessionAuth =1;
			String sessionName = (String)session.getAttribute("Aname");    
			if(sessionName!=null){
				sessionId = (int)session.getAttribute("Aid");
				sessionAuth = (int)session.getAttribute("Aauth");
			}
		%>

        <header>
            <div id="logo">
             	<a href="index">
                <img class="img1" src="${pageContext.request.contextPath }/resources/img/header_logo.png" alt="Logo" width="220px" height="auto">
                </a>
            </div>
            <div class="gnb_search">
                <s_search>
                    <fieldset>
                    	<form action="search_name" id="searchname">
	                        <input type="text" name="search" value="" placeholder="찾을 내용을 입력하세요." onkeypress="if (event.keyCode == 13 ) { document.getElementById('searchname').submit(); }">
	                        <img src="${pageContext.request.contextPath }/resources/img/search.png" id="searchbarbutton" onclick="document.getElementById('searchname').submit();">
                        </form>
                    </fieldset>
                </s_search>
            </div>
 
            <nav>
                <ul>
                    <li class="headerClick"><a href="DogList">강아지 관리</a></li>
                    
                    
                    <li class="headerClick"><a href="searchCustomized">맞춤 검색</a></li>
                    
                    
                	<%
                		if(sessionAuth ==2){
                		
                	%>
                    <li class="headerClick"><a href="Product_Add">상품 등록</a></li>
                    
                    <%
                    } else{
                    %> 
                    <li class="headerClick"><a href="introduction">소개</a></li>
                    
                    <%
                    }
                    %>
                    
                    	<li class="headerClick"><a href="wishlist">장바구니</a></li>
					<%   
						if(sessionName == null) { 
					%>
                    	<li class="headerClick"><a href="account_Login">로그인</a></li>
                    <%
						} else {
                    %>
                     	<li class="headerClick"><a href="account_Mypage">마이 페이지</a></li>
                    <%
						}                   
                    %>
                    
                    
                    
                </ul>
            </nav>
 
        </header>
</body>
</html>