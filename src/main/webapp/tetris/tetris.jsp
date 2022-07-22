<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%    
response.setHeader("Cache-Control","no-store");    
response.setHeader("Pragma","no-cache");    
response.setDateHeader("Expires",0);    
if (request.getProtocol().equals("HTTP/1.1"))  
        response.setHeader("Cache-Control", "no-cache");  
%>
    
    
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Tetris</title>
    <link rel="stylesheet" type="text/css" href="tetris.css">
</head>

<body>
    <div id="gameField">
        <div id="gameover">
            <center>
                <h1>Game Over</h1>
                <h4>press 'F5' to restart</h4>
            </center>
        </div>
        <div id="pause">
            <center>
                <h1>Pause</h1>
                <h4>press 'F5' to resume</h4>
            </center>
        </div>
        <table id="nextTable" border=0>
            <tr>
                <td id="00"></td>
                <td id="01"></td>
                <td id="02"></td>
                <td id="03"></td>
            </tr>
            <tr>
                <td id="10"></td>
                <td id="11"></td>
                <td id="12"></td>
                <td id="13"></td>
            </tr>
            <tr>
                <td id="20"></td>
                <td id="21"></td>
                <td id="22"></td>
                <td id="23"></td>
            </tr>
            <tr>
                <td id="30"></td>
                <td id="31"></td>
                <td id="32"></td>
                <td id="33"></td>
            </tr>
        </table>
        <div id="scoreField">
            <p class="sub">LEVEL</p>
            <p id="level">1</p>
            <p class="sub">SCORE</p>
            <p id="score">0</p>
            <p class="sub">NEXT</p>
            <p><br><br><br></p>
            <p class="sub">HELP</p>
            <p id="help">← ↓ →</p>
            <p id="help">Space Bar</p>
            <p id="help">P to pause</p>
            <p class="sub" id="about" onclick="info()">ABOUT</p>
            <div id="comboField"><i></i></div>
        </div>
        <jsp:include page="tetrisjs.jsp" flush="true"/>
</body>

</html>