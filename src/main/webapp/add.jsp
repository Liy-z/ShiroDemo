<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
	* {margin:0; padding:0;}
	div {
	margin:0 auto;
	width:420px;
	}
	table {
	width:420px;
	border-collapse: collapse;
	}
	.title {
	font-size:30px;
	height:50px;
	line-height:50px;
	text-align:center;
	}
	.center {
	text-align:center;
	}
	</style>
	
  </head>
  
  <body>
    <div>
	   <%--  <form action="<%=basePath%>/insert.jsp" method="post"> --%>
	    <form action="addUser" method="post">
	        <table border="0" cellpadding="0" cellspacing="0">
	            <tr class="title">
	                <td colspan="3">注册</td>
	            </tr>
	            <tr>
	                <td>用户名：</td>
	                <td><input type="text" name="userName" /></td>
	                <td><span id="ajax_info"></span></td>
	            </tr>
	            <tr>
	                <td>账号：</td>
	                <td><input type="text" name="accountName" /></td>
	                <td><span id="ajax_info"></span></td>
	            </tr>
	            <tr>
	                <td>密码：</td>
	               <td><input type="password" name="password"  /></td>
	                <td></td>
	            </tr>
	            <tr>
	                <td>角色：</td>
	               <td>
	               <select name="roleId" >
					  <option value="">请选择</option>
					  <c:forEach var="role" items="${list}">
					  	<option value="${role.id}">${role.name}</option>
					  </c:forEach>
					</select>
					</td>
	                <td></td>
	            </tr>
	            <tr class="center">
	                <td colspan="3">
	                	<input type="submit" value="保存"/>&nbsp;
	                	<input type="button" value="返回" onclick="runback()"/></td>
	            </tr>
	        </table>
	    </form>
	</div>
  </body>
</html>