<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Redirecting...</title>
</head>
<body>
	<%	
		int Flag = Integer.parseInt(request.getAttribute("Flag").toString());
		if(Flag == 1) {	
			String Flagmsg = request.getAttribute("Flagmsg").toString();
	%>
		<script type="text/javascript">
			alert("${Flagmsg}");
			history.go(-1);
		</script>
	<%
		} else if(Flag==0){
			response.sendRedirect("index");
		} else {
			String Flagmsg = request.getAttribute("Flagmsg").toString();
			%>
			<script type="text/javascript">
			alert("${Flagmsg}");
			</script>
			<%
			response.sendRedirect("index"); 
		}
	%>
</body>
</html>