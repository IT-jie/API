<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<head>
	<title>${requestScope.title}</title>
	   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<style type="text/css">
	.gotop{
		width: 40px;
		height: 40px;
		background-color: yellow;
		color: blue;
		text-align: center;
		font-size: 20px;
		font-weight: bold;
		line-height: 40px;
		position: absolute;
	    right: 0px;
	    cursor: pointer;
	}
	.gotop:hover{
		background-color: red;
	}
</style>

<script type="text/javascript">
	// 置顶
	function goTop(){
		scrollTo(0,0);
	}
</script>

</head>

<body>
	<div id="content">${requestScope.content}</div>
	<div class="gotop" onclick="goTop()">↑</div>
</body>
</html>
