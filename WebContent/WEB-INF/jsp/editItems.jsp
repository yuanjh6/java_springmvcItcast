<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>

</head>
<body> 
<!-- 显示错误消息 -->
<ul>
	<c:forEach items="${errors }" var="error" >
	<li>${error.defaultMessage }</li>
	</c:forEach>
</ul>
<!-- 上传图片是需要指定属性 enctype="multipart/form-data" -->
<form id="itemsForm" action="updateItems.action" method="post" enctype="multipart/form-data">
<!-- <form id="itemsForm" action="updateItems.action" method="post"> -->
<input type="hidden" name="id" value="${items1.id }"/>
修改商品信息：
<table width="100%" border=1>
<tr>
	<td>商品名称</td>
	<td><input type="text" name="name" value="${items1.name }"/></td>
</tr>
<tr>
	<td>商品价格</td>
	<td><input type="text" name="price" value="${items1.price }"/></td>
</tr>
<tr>
	<td>商品生产日期</td>
	<td><input type="text" name="createtime" value="<fmt:formatDate value="${items1.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
</tr>

<tr>
	<td>商品图片</td>
	<td>
		<c:if test="${items1.pic !=null}">
			<img src="/pic/${items1.pic}" width=100 height=100/>
			<br/>
		</c:if>
		<input type="file"  name="pictureFile"/> 
	</td>
</tr>

<tr>
	<td>商品简介</td>
	<td>
	<textarea rows="3" cols="30" name="detail">${items1.detail }</textarea>
	</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>

</html>