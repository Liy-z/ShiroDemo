<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	width:420px;
	}
	table {
	width:420px;
	border-collapse: collapse;
	}
	tr {
	border-sapcing:30px 50px;
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
	<script type="text/javascript" src="<%=basePath%>/scripts/jquery-1.12.4.js"></script>
	<script type="text/javascript">
	var base = "<%=basePath%>";
	
	
	</script>
  </head>
  
  <body>
    <div>
	   <%--  <form action="<%=basePath%>/insert.jsp" method="post"> --%>
	    <form action="userlogin" method="post">
	    	<a href="roleShow">注册用户</a>
	        <table border="0" cellpadding="0" cellspacing="0">
	            <tr class="title">
	                <td colspan="4">登录用户</td>
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
	            <tr class="center">
	                <td colspan="4">
	                	<input type="submit" value="保存"/>&nbsp;
	                	<input type="button" value="返回" onclick="runback()"/></td>
	            </tr>
	        </table>
	    </form>
	</div>
  </body>
</html>
