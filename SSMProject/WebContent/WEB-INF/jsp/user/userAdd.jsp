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
<h1>添加用户</h1>
	<div>
		<form action="javascript:;" id="addForm" method="post" enctype="multipart/form-data">
			登录名称：<input type="text" name="userCode" id="userCode"/><span></span><br/>
			用户名称：<input type="text" name="userName" id="userName"/><br/>
			用户密码：<input type="password" name="userPassword" id="userPassword"/><br/>
			性别：<input type="radio" name="gender" value="1" checked="checked"/>男
				  <input type="radio" name="gender" value="2"/>女<br/>
			出生日期：<input type="text" name="birthday" id="birthday"/><br/>
			联系电话：<input type="text" name="phone" id="phone"/><br/>
			家庭地址：<input type="text" name="address" id="address"/><br/>
			用户角色: 	<select name="userRole" id="userRole">
						<option value="0">请选择</option>
						<c:forEach items="${roleList}" var="role">
							<option value="${role.id }">${role.roleName }</option>
						</c:forEach>
					</select><br/>
			个人证件照片: <input type="file" name="attachs" id="a_idPicPath"/><br>
			工作证件照片: <input type="file" name="attachs" id="a_wokPicPath"/><br>
			<input type="submit" value="添加"/>
			<input type="reset" value="清空"/>
			<input type="button" value="返回"/>
		</form>
	</div>
	
	
	<script type="text/javascript">
		$("form").submit(function(){
			/* var data = $(this).serialize(); */
			var data = new FormData(document.getElementById("addForm"));
			$.ajax({
				url:"${pageContext.request.contextPath}/sys/user/userAddSave",
				data:data,
				processData:false,
				contentType:false,
				type:"post",
				dataType:"html",
				success:function(data){
					$("body").html(data);
				}
			});
		});
	</script>
</body>
</html>