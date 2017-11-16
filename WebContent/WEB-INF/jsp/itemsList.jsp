<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	function postJson() {
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath }/items/json.action",
			contentType:"application/json;charset=utf-8",
			data:'{"id":"5","name":"杯子","price":"10.0"}',
			success:function(data) {
				alert(data.name);
			}
		});
	}
</script>
</head>
<body> 
<form action="${pageContext.request.contextPath }/items/queryItems.action" method="post">
<%-- <form action="${pageContext.request.contextPath }/items/deleteItmes.action" method="post"> --%>
查询条件：
<table width="100%" border=1>
<tr>
<td>商品id：<input type="text" name="items.id"/></td>
<td>订单id：<input type="text" name="orders.id"/></td>
<td><input type="submit" value="查询"/></td>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
	<td>ID</td>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${itemsList }" var="items" varStatus="s">
<tr>
	<td>
		<input type="checkbox" name="ids" value="${items.id }">
		<input type="hidden" name="itemsList[${s.index }].id" value="${items.id }">
	</td>
	<td><input type="text" name="itemsList[${s.index }].name" value="${items.name }"/></td>
	<td><input type="text" name="itemsList[${s.index }].price" value="${items.price }"/></td>
	<td><input type="text" name="itemsList[${s.index }].createtime" value="<fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
	<td><input type="text" name="itemsList[${s.index }].detail" value="${items.detail }"/></td>
	
	<td><a href="${pageContext.request.contextPath }/items/editItems/${items.id}">修改</a></td>

</tr>
</c:forEach>

</table>
</form>
<button value="" onclick="postJson()">请求json数据</button>
</body>

</html>