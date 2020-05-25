<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'insert.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	* {margin:0; padding:0;}
	div {
	margin:0 auto;
	width:600px;
	}
	table{
	margin:0 auto;
	width:600px;
	border-collapse: collapse;
	}
	table td ,.h{
	text-align:center;
	}
	.title {
	font-weight:bolder;
	background-color:#408080;
	}
	table:first-of-type {
	height:50px;
	line-height:50px;
	}
	table:first-of-type td {
	font-size:18px;
	font-weight:bolder;
	}
	.tit tr:nth-child(even){
	background:#E8E8D0;
	}
</style>
  </head>
  
  <body>
    <div>
    <table border="1" cellpadding="0" cellspacing="0" class="tit">
    	
	    <tr class="title">
	        <td>用户名</td>
	        <td>账号</td>
	        <td>密码</td>
	        <td>操作</td>
	    </tr>
	    <c:if test="${empty list}">
			<tr>
				<td colspan="6"><h2>未查到符合您的查询的条件！</h2></td>
			</tr>
		</c:if>
		<c:if test="${not empty list}">
	    <c:forEach var="fp" items="${list}">
			
			<tr>
	        <td>${fp.userName }</td>
	        <td>${fp.accountName }</td>
	        <td>${fp.password }</td>
	        <td><a href="javascript:void(0)" onclick="querenDelete(${fp.id},this)">删除</a>
	        	<a href="selectOne.html?pk=${fp.id}">修改</a></td>
	    </tr>
	    </c:forEach>
	    </c:if>
	</table>
	</div>
  </body>
</html>
