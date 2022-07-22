<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<meta charset="UTF-8">
<title></title>
<style>
    #mySidenav ul li:nth-child(2),
    #mySidenav ul li:nth-child(3),
    #mySidenav ul li:nth-child(4) {
        color: #F98F4D;
        margin-left: -10%;
        padding-bottom: 10px;
    }
</style>
</head>
<body>
    <div id=“mySidenav” class=“sidenav”>
        <ul>
        <li></li>
            <li>테트리스 점수 : ${userTotal.score1}</li>
            <li>snake 점수 : ${userTotal.score2}</li>
            <li>2048 점수 : ${userTotal.score3}</li>
        </ul>
    </div>
</body>
</html>