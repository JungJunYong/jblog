<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>${vo.title }</h1>
			<ul>
			<c:import url="/WEB-INF/views/includes/blogheader.jsp"/>
			</ul>
		</div>
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>${postvo.title }</h4>
					<pre style="font-size:13px">
						${postvo.contents }
					</pre>
				</div>
				<ul class="blog-list">
				<c:forEach items="${postList}" var="vo">
					<li><a href="${pageContext.request.contextPath}/${id}/${vo.categoryNo}/${vo.no}">${vo.title}</a> <span>${vo.regDate }</span></li>
				</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}${vo.logo}">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${categoryList }" var="vo">
				
				<li><a href="${pageContext.request.contextPath}/${vo.id}/${vo.no}">${vo.name }</a></li>
				</c:forEach>
			</ul>
		</div>
		
		<div id="footer">
			<p>
				<strong>${vo.title }</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>