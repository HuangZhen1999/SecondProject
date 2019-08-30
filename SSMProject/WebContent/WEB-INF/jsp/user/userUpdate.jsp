<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<h1>修改用户</h1>
	<div>
		<form action="javascript:;">
			<input type="hidden" name="id" value="${user.id}" /> 登录名称：<input
				type="text" name="userCode" id="userCode" value="${user.userCode}" /><span></span><br />
			用户名称：<input type="text" name="userName" id="userName"
				value="${user.userName}" /><br /> 用户密码：<input type="password"
				name="userPassword" id="userPassword" value="${user.userPassword}" /><br />
			性别：
			<c:if test="${user.gender==1}">
				<input type="radio" name="gender" value="1" checked="checked" />男
				  	<input type="radio" name="gender" value="2" />女
			</c:if>
			<c:if test="${user.gender==2} }">
				<input type="radio" name="gender" value="1" />男
				  	<input type="radio" name="gender" value="2" checked="checked" />女
			</c:if>
			<br /> 出生日期：<input type="text" name="birthday" id="birthday"
				value='<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" />' /><br />
			联系电话：<input type="text" name="phone" id="phone" value="${user.phone}" /><br />
			家庭地址：<input type="text" name="address" id="address"
				value="${user.address}" /><br /> 用户角色: <select name="userRole"
				id="userRole">
				<option value="0">请选择</option>
				<c:forEach items="${roles }" var="role">
					<c:if test="${user.userRole==role.id }">
						<option value="${role.id }" selected="selected">${role.roleName }</option>
					</c:if>
					<c:if test="${user.userRole!=role.id }">
						<option value="${role.id }">${role.roleName }</option>
					</c:if>
				</c:forEach>
			</select><br /> <input type="submit" value="修改" /> <input type="reset"
				value="重置" /> <input type="button" value="返回" />
		</form>
	</div>


	<script type="text/javascript">
		$("form")
				.submit(
						function() {
							var data = $(this).serialize();
							$
									.ajax({
										url : "${pageContext.request.contextPath}/sys/user/userUpdateSave",
										data : data,
										type : "post",
										dataType : "json",
										success : function(data) {
											if (data == 1) {
												alert("修改成功!!!");
												$("body")
														.load(
																"${pageContext.request.contextPath}/sys/user/userList");
											} else {
												alert("修改失败!!!");
											}
										}
									});
						});
	</script>
</body>
</html>