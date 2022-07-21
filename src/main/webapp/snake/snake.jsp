<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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