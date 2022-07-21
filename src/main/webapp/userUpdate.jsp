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
<link rel="stylesheet" href="userUpdate.css">
<script src="userUpdate.js"></script>
<title>Document</title>
</head>
<body>
	<div class="login-box">
		<h2 class="flux">UserInfo</h2>
		<form action="updateUser" method="post">
			<div class="user-box">${user.id} 님</div> <br>
			<div class="user-box">
				<input type="text" name="name" value="${user.name}" required>
				<label>Name</label>
			</div>
			<div class="user-box">
				<input type="password" name="pw" value="${user.pw}" required>
				<label>Password</label>
			</div>
			<div class="user-box">
				<input type="email" id="mail" name="mail" value="${user.mail}"
					required> <label>E-mail</label>
			</div>
			<div id="checkMail"></div>
			<div class="user-box">
				<input type="text" id="nickname" name="nickname"
					value="${user.nickname}" required> <label>Nick-Name</label>
			</div>
			<div id="checkNick"></div>
			<button type="submit" id="btu" class="login">
				<span></span> <span></span> <span></span> <span></span> InfoUpdate
			</button>
		</form>
	</div>


	<script type="text/javascript">

		document.getElementById("mail").addEventListener("blur", function() {
			let getMail = document.getElementById("mail")

			const xhttp = new XMLHttpRequest();
			xhttp.onload = function() {
			document.getElementById("checkMail").innerHTML = this.responseText;
				}
			xhttp.open("POST", "checkMail", true);
			xhttp.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			xhttp.send("mail=" + getMail.value);
			});
		
		
		document.getElementById("nickname").addEventListener("blur", function() {
			let getNick = document.getElementById("nickname")

			const xhttp = new XMLHttpRequest();
			xhttp.onload = function() {
			document.getElementById("checkNick").innerHTML = this.responseText;
				}
			xhttp.open("POST", "checkNickname", true);
			xhttp.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			xhttp.send("nickname=" + getNick.value);
			});
	</script>

</body>
</html>