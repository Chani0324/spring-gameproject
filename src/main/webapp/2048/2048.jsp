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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="2048.css">
    <title>2048</title>
</head>
<body>
    <table id="titleBar" border=0>
        <tr>
            <td id="titlePad">
                <p id="title">2048</p>
            </td>
            <td id="scorePad">
                <p id="scoreType">Score</p>
                <p id="score"></p>
        </tr>
    </table>
    <table id="board" border=0>
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
    <p id="info">2048 Copyright (c) YJYOON All rights reserved.</p>
<jsp:include page="2048js.jsp" flush="true"/>
</body>
</html>