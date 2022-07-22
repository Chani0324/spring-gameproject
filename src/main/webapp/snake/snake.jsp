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
        <meta charset="utf-8">
        <title>snake</title>
    </head>
    <link rel="stylesheet" type="text/css" href="snake.css">
    <body>
        <jsp:include page="snakejs.jsp" flush="true"/>
        <div id="score">Snake</div>
        <div id="plus"></div>
    </body>
</html>