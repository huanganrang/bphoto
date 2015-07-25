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
		$('#bshoot_addcomment_Form').form({
			url : '${pageContext.request.contextPath}/api/bshootController/bshoot_addcomment',
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
				$("#bshoot_addcomment_result").text(result);
			}
		});
	});
</script>

	<div class="easyui-layout" data-options="fit:true">
		
		<div data-options="region:'center'">
			<form id="bshoot_addcomment_Form" action="">
				<table align="center" width="90%" class="tablex">
					<tr>
						<td align="right" style="width: 80px;"><label>url：</label></td>
						<td>${pageContext.request.contextPath}/api/bshootController/bshoot_addcomment</td>
					</tr>
					
					<tr>
						<td align="right" style="width: 180px;"><label>bshootId(*视频)：</label></td>
						<td><input name="bshootId" type="text" class="span2" value=""/></td>
					</tr>
					<tr>
						<td align="right" style="width: 180px;"><label>tokenId(*token值)：</label></td>
						<td><input name="tokenId" type="text" class="span2" value=""/></td>
					</tr>
					<tr>
						<td align="right" style="width: 180px;"><label>parentId（父评论）：</label></td>
						<td><input name="parentId" type="text" class="span2" value=""/></td>
					</tr>
					
					<tr>
						<td align="right" style="width: 180px;"><label>bsCommentText(*评论内容)：</label></td>
						<td><input name="bsCommentText" type="text" class="span2" value=""/></td>
					</tr>
					
					
					
					<tr>
						<td colspan="2" align="center">
						<input type="button"
							value="提交" onclick="javascript:$('#bshoot_addcomment_Form').submit();" /></td>
					</tr>
				</table>
			</form>
			<label>结果：</label>
				<div id="bshoot_addcomment_result">
				</div>
			<div>
				结果说明：1、json格式<br/>
					2、success:true 成功<br/>
					 

					  
			</div>
		</div>
	</div>
</body>
</html>