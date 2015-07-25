<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	$(function() {
	 	parent.$.messager.progress('close');
		$('#user_register_Form').form({
			url : '${pageContext.request.contextPath}/api/apiUserController/register',
			onSubmit : function() {
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
				var isValid = $(this).form('validate');
				if (!isValid) {
					parent.$.messager.progress('close');
				}
				return isValid;
			},
			success : function(result) {
				parent.$.messager.progress('close');
				$("#user_register_result").text(result);
			}
		});
	});
</script>

	<div class="easyui-layout" data-options="fit:true">
		
		<div data-options="region:'center'">
			<form id="user_register_Form" method="post"  enctype="multipart/form-data">
				<table align="center" width="90%" class="tablex">
					<tr>
						<td align="right" style="width: 80px;"><label>url：</label></td>
						<td>${pageContext.request.contextPath}/api/apiUserController/register</td>
					</tr>
					
					<tr>
						<td align="right" style="width: 180px;"><label>name(账号)：</label></td>
						<td><input name="name" type="text" class="span2" value="测试美拍"/></td>
					</tr>
					<tr>
						<td align="right" style="width: 180px;"><label>pwd(密码)：</label></td>
						<td><input name="pwd" type="text" class="span2" value=""/></td>
					</tr>
					<tr>
						<td align="right" style="width: 180px;"><label>nickname(昵称)：</label></td>
						<td><input name="nickname" type="text" class="span2" value=""/></td>
					</tr>
					<tr>
						<td align="right" style="width: 180px;"><label>usex(性别：SX01|SX02,男女)：</label></td>
						<td><input name="usex" type="text" class="span2" value=""/></td>
					</tr>
					<tr>
						<td align="right" style="width: 180px;"><label>areaCode(地区)：</label></td>
						<td><input name="areaCode" type="text" class="span2" value=""/></td>
					</tr>
					<tr>
						<td align="right" style="width: 180px;"><label>headImage(头像)：</label></td>
						<td><input name="headImageFile" type="file" class="span2" value=""/></td>
					</tr>
					<tr>
						<td align="right" style="width: 180px;"><label>birthday(生日)：</label></td>
						<td><input name="birthday" type="text" class="span2" value=""/></td>
					</tr>
					<tr>
						<td align="right" style="width: 180px;"><label>bardian(个性签名)：</label></td>
						<td><input name="bardian" type="text" class="span2" value=""/></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<input type="button"
							value="提交" onclick="javascript:$('#user_register_Form').submit();" /></td>
					</tr>
				</table>
			</form>
			<label>结果：</label>
				<div id="user_register_result">
				</div>
			<div>
				结果说明：1、json格式<br/>
					2、success:true 成功<br/>
			</div>
		</div>
	</div>
</body>
</html>