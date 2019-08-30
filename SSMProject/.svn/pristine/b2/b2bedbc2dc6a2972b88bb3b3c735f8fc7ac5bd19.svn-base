<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.12.4.min.js">
</script>
</head>
<body>
	<h1>用户列表</h1>
	<a id="userAdd"  href="javascript:;">添加用户</a>
	<div>
		<form action="javascript:;" method="get">
			用户名称:<input type="text" name="userName" id="userName"/>
			<input type="submit" value="查询"/>
		</form>
	</div>
	<div>
		<table>
			<thead>
				<tr>
					<th>id</th>
					<th>用户编号</th>
					<th>用户名称</th>
					<th>用户生日</th>
					<th>用户地址</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>
							<a href="javascript:showDetail(${user.id});">
								${user.userCode}
							</a>
						</td>
						<td>${user.userName}</td>
						<td>${user.birthday}</td>
						<td>${user.address}</td>
						<td>
							<a href="javascript:updateUser(${user.id});">修改</a>
							<a href="javascript:deleteUser(${user.id });">删除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
			登录名称：<input type="text" name="v_userCode" id="v_userCode" readonly="readonly"/><br/>
			用户名称：<input type="text" name="v_userName" id="v_userName" readonly="readonly"/><br/>
			用户密码：<input type="text" name="v_userPassword" id="v_userPassword" readonly="readonly"/><br/>
			出生日期：<input type="text" name="v_birthday" id="v_birthday" readonly="readonly"/><br/>
			联系电话：<input type="text" name="v_phone" id="v_phone" readonly="readonly"/><br/>
			家庭地址：<input type="text" name="v_address" id="v_address" readonly="readonly"/><br/>
			创建时间:	 <input type="text" name="v_creationDate" id="v_creationDate" readonly="readonly"><br/>
	</div>
	<script type="text/javascript">
		$("form").submit(function(){
			var userName=$("#userName").val();
			$("body").load("${pageContext.request.contextPath}/sys/user/userList","userName="+userName);
		});
		$("#userAdd").click(function(){
			$("body").load("${pageContext.request.contextPath}/sys/user/userAdd");
		});
		function updateUser(id){
			$.ajax({
				url:"${pageContext.request.contextPath}/sys/user/userUpdate/"+id,
				/* data:{"id":id}, */
				type:"get",
				dataType:"html",
				success:function(data){
					$("body").html(data);
				}
			});
		}
		function showDetail(id){
			$.ajax({
				url:"${pageContext.request.contextPath}/sys/user/showDetail",
				data:{"id":id},
				type:"get",
				dataType:"json",
				success:function(data){
					$("#v_userCode").val(data.userCode);
					$("#v_userName").val(data.userName);
					$("#v_userPassword").val(data.userPassword);
					$("#v_birthday").val(data.birthday);
					$("#v_phone").val(data.phone);
					$("#v_address").val(data.address);
					$("#v_creationDate").val(data.creationDate);
				}
			});
		}
		
	</script>
</body>
</html>