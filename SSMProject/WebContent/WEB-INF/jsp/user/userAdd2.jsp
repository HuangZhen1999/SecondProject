<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/js/jquery-1.12.4.min.js">
	
</script>
</head>
<body>
	<h1>添加用户</h1>
	<div>
		<fm:form method="post" modelAttribute="user">
			登录名称：  <fm:input path="userCode" /> <fm:errors path="userCode"/>
			<br />
			用户名称:     <fm:input path="userName" /> <fm:errors path="userName"/>
			<br>
			用户密码:	<fm:password path="userPassword" /><fm:errors path="userPassword"/>
			<br>
			性别：	<fm:radiobutton path="gender" value="1" />男
					<fm:radiobutton path="gender" value="2" />女<br>
			出生日期：	<fm:input path="birthday"/> <fm:errors path="birthday"/>
			<br>
			联系电话：	<fm:input path="phone" />
			<br>
			家庭地址：	<fm:input path="address" />
			<br>
			用户角色:	<fm:select path="userRole">
			<fm:option value="0">请选择</fm:option>
			<c:forEach items="${roleList}" var="role">
				<fm:option value="${role.id}">${role.roleName}</fm:option>
			</c:forEach>
			</fm:select>
			<br />
			<input type="submit" value="添加" />
			<input type="reset" value="清空" />
			<input type="button" value="返回" />
		</fm:form>
	</div>
</body>
</html>