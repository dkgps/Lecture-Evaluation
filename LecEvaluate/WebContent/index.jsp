<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>우리의 첫 번째 페이지</title>
</head>
<body>
	Hello World!
	<form action = "./userJoinAction.jsp" method ="post"> <!-- 보안 -->
		<input type="text" name="userID">
		<input type="password" name="userPassword">
		<input type="submit" value="회원가입">
	</form>
</body>
</html>