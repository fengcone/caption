<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
</head>
<body>
	<form action="/edit.html">
		<select name="movieId">
			<c:forEach items="${movies}" var="movie">
				<option value="${movie.movieId}">${movie.movieName}</option>
			</c:forEach>
		</select>
		<input type="submit"/>
	</form>
	<input type="text" value="test"/>
</body>
</html>