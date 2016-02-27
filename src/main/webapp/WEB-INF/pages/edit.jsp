<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>编辑页</title>
<script type="text/javascript" src="/js/show.js"></script>
</head>
<body>
	<div>
		${caption.id}
	</div>
	<div>
		${caption.orderNo}
	</div>
	<div>
		${caption.chinese}
	</div>
	<div>
		${caption.english}
	</div>
	<div>
		${caption.movieId}
	</div>
	<div>
		${caption.startTime}
	</div>
	<div>
		${caption.endTime}
	</div>
</body>
</html>