<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/js/ejs/ejs.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/js/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript">


	var listTemplate = new EJS(
			{
				url : "${pageContext.request.contextPath }/assets/js/ejs/list-template.ejs"
			});
	
	
	var listItemTemplate = new EJS(
			{
				url : "${pageContext.request.contextPath }/assets/js/ejs/list-item-template.ejs"
			});
	
	
	$(function() {
		list();
		$("#categoryAdd").click(categoryAdd);
		$(document).on("click",".admin-cat td a",categoryDelete);
	});

	var list = function() {
		$.ajax({
			url : '${pageContext.request.contextPath }/${vo.id}/api/category/list/',
			async : true,
			type : 'get',
			dataType : 'json',
			data : '',
			success : function(response) {
				var contextpath = '${pageContext.request.contextPath }';
				response.contextpath = contextpath;
				console.log(response);
				var html = listTemplate.render(response);
				$("#category-headlist").after(html);
			},
			error : function(xhr, status, e) {
				console.error(status + ":" + e);
			}
		});

	};

	var categoryAdd = function(event) {
		event.preventDefault();
		var vo = {}
		vo.name = $("#categoryName").val();
		vo.description = $("#categoryDescription").val();
		vo.id = '${authUser.name}';
		$.ajax({
			url : '${pageContext.request.contextPath }/${vo.id}/api/category/list/'
					+ 'add',
			async : true,
			type : 'post',
			dataType : 'json',
			contentType : 'application/json',
			data : JSON.stringify(vo),
			success : function(response) {
				if (response.result != "success") {
					console.error(response.message);
					return;
				}
				console.log(response);
				var contextpath = '${pageContext.request.contextPath }';
				response.data.contextpath = contextpath;
				response.data.count = 0;
				response.data.listCount = Number($('.admin-cat tr:last-child td')[0].innerText)+ 1;
				var html = listItemTemplate.render(response.data);
				$(".admin-cat tr:last-child").after(html);
				$("#add-form")[0].reset();
				
			},
			error : function(xhr, status, e) {
				console.error(status + ":" + e);
			}
		});

	};

	
	
	var categoryDelete = function() {
		event.preventDefault();
		var no = $(this).data('no');

		$(this).parents('tr').remove();
		$.ajax({
			url : '${pageContext.request.contextPath }/${vo.id}/api/category/list/delete/'
					+ no,
			async : true,
			type : 'delete',
			dataType : 'json',
			data : '',
			success : function(response) {
				for(var i = 0,j = 0; i < $('.admin-cat tr td').length; i+=5,j++){
					$('.admin-cat tr td')[i].innerText = j+1;
				};
				
				if (response.result != "success") {
					console.error(response.message);
					return;
				}
			},
			error : function(xhr, status, e) {
				console.error(status + ":" + e);
			}
		});
	};
</script>

</head>
<body>
	<div id="container">
		<div id="header">
			<h1>${vo.title }</h1>
			<c:import url="/WEB-INF/views/includes/blogheader.jsp" />
		</div>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<c:import url="/WEB-INF/views/includes/adminMenu.jsp" />
				<table class="admin-cat">
					<tr id='category-headlist'>
						<th>번호</th>
						<th>카테고리명</th>
						<th>포스트 수</th>
						<th>설명</th>
						<th>삭제</th>
					</tr>
					<%-- <c:forEach items="#{categoryList }" var="vo">
		      		<tr >
						<td>${vo.no }</td>
						<td>${vo.name }</td>
						<td>${vo.count }</td>
						<td>${vo.description }</td>
						<c:choose>

							<c:when test="${vo.count == 0 }">
							<td><a href="${pageContext.request.contextPath}/${vo.id}/admin/category/delete/${vo.no}"><img src="${pageContext.request.contextPath}/assets/images/delete.jpg"></a></td>
							</c:when>
							<c:otherwise>
							<td></td>
							</c:otherwise>
						</c:choose>
						
					</tr>  
		      		
		      		</c:forEach> --%>

				</table>

				<h4 class="n-c">새로운 카테고리 추가</h4>
				<form id= 'add-form'
					action="${pageContext.request.contextPath }/${vo.id }/admin/category"
					method="post">
					<table id="admin-cat-add">
						<tr>
							<td class="t">카테고리명</td>
							<td><input id='categoryName' type="text" name="name"></td>
						</tr>
						<tr>
							<td class="t">설명</td>
							<td><input id='categoryDescription' type="text"
								name="description"></td>
						</tr>
						<tr>
							<td class="s">&nbsp;</td>
							<td><input id="categoryAdd" type="submit" value="카테고리 추가"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>