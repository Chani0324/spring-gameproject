<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%    
response.setHeader("Cache-Control","no-store");    
response.setHeader("Pragma","no-cache");    
response.setDateHeader("Expires",0);    
if (request.getProtocol().equals("HTTP/1.1"))  
        response.setHeader("Cache-Control", "no-cache");  
%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="login.css">
    <title>Document</title>
</head>
<body>
    <div class="login-box">
        <h2 class="flux">Login</h2>
        <form action="login" method="post">
            <div class="user-box">
                <input type="text" name="id" required>
                <label>ID</label>
            </div>
            <div class="user-box">
                <input type="password" name="pw" required>
                <label>Password</label>
            </div>
            <button type="submit" id="btu" class="login">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                Login
            </button>
        </form>
    </div>
    
    <c:if test="${not empty message}">
		<script type="text/javascript">
			
			 let msg = "<c:out value='${message}'/>";
			 
			 (() => {
				 if (msg != "") {
				 	alert(msg);
				 }
			 })();
		</script>
	</c:if>
	
</body>
</html>