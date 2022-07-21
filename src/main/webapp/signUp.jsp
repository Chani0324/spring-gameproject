<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="signUp.css">
<title>Document</title>
</head>
<body>
	<div class="login-box">
		<h2 class="flux">SignUP</h2>
		<form action="signup" method="post">
			<div class="user-box">
				<input type="text" name="name" required> <label>Name</label>
			</div>
			<div class="user-box">
				<input type="text" name="id" id="id" required> <label>ID</label>
				<div id="checkId"></div>
			</div>
			<div class="user-box">
				<input type="password" name="pw" required> <label>Password</label>
			</div>
			<div class="user-box">
				<input type="email" name="mail" required> <label>E-mail</label>
			</div>
			<div class="user-box">
				<input type="text" name="nickname" required> <label>Nick-Name</label>
			</div>
			<button type="submit" id="btu" class="login">
				<span></span> <span></span> <span></span> <span></span> SignUp
			</button>
		</form>
	</div>

	<script type="text/javascript">
	    document.getElementById("id").addEventListener("blur", function() {
			let getId = document.getElementById("id")
			
			const xhttp = new XMLHttpRequest();
			xhttp.onload = function() {
				document.getElementById("checkId").innerHTML = this.responseText;
			}
			xhttp.open("POST", "checkId", true);
			xhttp.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			xhttp.send("id=" + getId.value);
		});
    </script>

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