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
<link rel="stylesheet" href="style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap"
	rel="stylesheet">
<title>Document</title>
</head>

<body>
	<div class="title">
		<div class="neon">Classic GAME</div>

		<div class="menu">

			<c:if
				test="${empty sessionScope.user || sessionScope.user.id eq null}">
				<a href="login.jsp">로그인</a>
				<a href="signUp.jsp">회원가입</a>
			</c:if>

			<c:if
				test="${not empty sessionScope.user && sessionScope.user.id ne null}">
				<a href="#" id="myInfo">내정보</a>
				<a href="logout">로그아웃</a>
			</c:if>
		</div>
	</div>

	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<ul>
			<li>${sessionScope.user.nickname}</li>
			<li id="score"></li>
		</ul>
		 <a href="userUpdate.jsp"> 정보변경하기 </a>
		 <a href="" id="userDelete" onclick="confirmDelete()"> 계정삭제하기 </a>
	</div>

	<br>
	<br>

	<ul class="game-list">
		<c:if
			test="${empty sessionScope.user || sessionScope.user.id eq null}">
			<li><a href="" onclick="showAlert()"> <img
					src="https://trees.gamemeca.com/wp-content/uploads/2018/03/tree_paleblue_tetris2-120x120.png"
					alt="Tetris">
			</a>
				<p>Tetris</p></li>
			<li><a href="" onclick="showAlert()"> <img
					src="https://yjyoon-dev.github.io/assets/post_images/js_game/ex_snake.png"
					alt="Snake" height="100px">
			</a>
				<p>Snake</p></li>
			<li><a href="" onclick="showAlert()"> <img
					src="https://yjyoon-dev.github.io/assets/post_images/js_game/ex_2048.png"
					alt="2048" height="100px">
					<p>2048</p>
			</a></li>
		</c:if>

		<c:if
			test="${not empty sessionScope.user && sessionScope.user.id ne null}">
			<li><a href="tetris/tetris.jsp"> <img
					src="https://trees.gamemeca.com/wp-content/uploads/2018/03/tree_paleblue_tetris2-120x120.png"
					alt="Tetris">
			</a>
				<p>Tetris</p></li>
			<li><a href="snake/snake.jsp"> <img
					src="https://yjyoon-dev.github.io/assets/post_images/js_game/ex_snake.png"
					alt="Snake" height="100px">
			</a>
				<p>Snake</p></li>
			<li><a href="2048/2048.jsp"> <img
					src="https://yjyoon-dev.github.io/assets/post_images/js_game/ex_2048.png"
					alt="2048" height="100px">
					<p>2048</p>
			</a></li>
		</c:if>

		<li><a href=""> <img
				src="https://xotgame.com/static/upload/games/20210731/2d305d28f63c8f2913fc24a653b850e2.png"
				alt="Among Us!">
				<p>Among Us</p>
		</a></li>
		<li><a href=""> <img
				src="https://xotgame.com/static/upload/games/20210802/5d5d9831cdc2cdb95cafb3764b7b9575.png"
				alt="Geometry Dash">
				<p>Geometry Dash</p>
		</a></li>
		<li><a href=""> <img
				src="https://xotgame.com/static/upload/games/20220416/2b4ff60a5f758f0a848a7237317b0b04.png"
				alt="slither.io">
				<p>slither.io</p>
		</a></li>
		<li><a href=""> <img
				src="https://xotgame.com//static/upload/games/20220416/47e950c533e314caaaa8f040937d720c.png"
				alt="Subway Surfers">
				<p>Subway Surfers</p>
		</a></li>
		<li><a href=""> <img
				src="https://xotgame.com/static/upload/games/20210824/6ba8794db158ffe2ab9207cc334bceed.png"
				alt="Clash of Clans">
				<p>Clash of Clans</p>
		</a></li>
		<li><a href=""> <img
				src="https://xotgame.com/static/upload/games/20210802/45dc196cb8def7f1a02008466ccb831a.png"
				alt="Minecreaft">
				<p>Minecreaft</p>
		</a></li>
		<li><a href=""> <img
				src="https://xotgame.com/static/upload/games/20220416/9b1c2f100547330b731a34ac68498d3c.png"
				alt="Call of Duty">
				<p>Call of Duty</p>
		</a></li>
		<li><a href=""> <img
				src="https://xotgame.com/static/upload/games/20220416/a69f683ba09950e71437b33c89c251b7.png"
				alt="Minion Rush">
				<p>Minion Rush</p>
		</a></li>
		<li><a href=""> <img
				src="https://xotgame.com/static/upload/games/20210802/feabe10a22ecd92d30ac7998b525dc5f.jpg"
				alt="Clash Royale">
				<p>Clash Royale</p>
		</a></li>
		<li><a href=""> <img
				src="https://xotgame.com/static/upload/games/20211011/21ac777aea834b0fadb743eb0f44832e.png"
				alt="Cookie Run: Kingdom">
				<p>Cookie Run: Kingdom</p>
		</a></li>
		<li><a href=""> <img
				src="https://xotgame.com/static/upload/games/20211012/8457aeb8b4464636ef698a52032bef12.png"
				alt="Pokémon UNITE">
				<p>Pokémon UNITE</p>
		</a></li>
		<li><a href=""> <img
				src="https://xotgame.com/static/upload/games/20210802/02edb6fcd1f965cea255ac91cf55e2ca.png"
				alt="Mob Control">
				<p>Mob Control</p>
		</a></li>
	</ul>

	<script>
		
		if (document.getElementById("myInfo")) {
			document.getElementById("myInfo").addEventListener("click", openNav);
	
			document.getElementById("myInfo").addEventListener("click", function() {
				let getId = document.getElementById("id");
				
				const xhttp = new XMLHttpRequest();
				
				xhttp.onload = function() {
	 				document.getElementById("score").innerHTML = this.responseText;
					}
				
				xhttp.open("GET", "userTotal", true);
				xhttp.setRequestHeader("Content-type",
						"application/x-www-form-urlencoded;charset=UTF-8");
				xhttp.send();
				}, {once:true});
		}
		
	
		function openNav() {
			document.getElementById("mySidenav").style.width = "300px";
			document.getElementById("mySidenav").style.borderColor = "#f98f4d";
			document.getElementById("mySidenav").style.borderStyle = "solid";
		}

		function closeNav() {
			document.getElementById("mySidenav").style.width = "0";
			document.getElementById("mySidenav").style.borderStyle = "none";
		}
		
		function confirmDelete() {
			if(window.confirm("정말 삭제하시겠습니까?")) {
				document.getElementById("userDelete").setAttribute("href", "deleteUser");
			}else {
				document.getElementById("userDelete").setAttribute("href", "#");
			}
		}
		
        function showAlert() {
        	alert("로그인 후 이용해 주세요");
        }
        
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