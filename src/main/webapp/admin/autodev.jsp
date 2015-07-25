<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>自动化生成管理</title>
<jsp:include page="../inc.jsp"></jsp:include>

<script type="text/javascript">		
	$(function() {
		$('#searchForm').form({
			url : '${pageContext.request.contextPath}/autoController/add',
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
				result = $.parseJSON(result);
				if (result.success) {
					parent.$.messager.alert('提示', result.msg, 'info');
				} else {
					parent.$.messager.alert('错误', result.msg, 'error');
				}
			}
		});	
		parent.$.messager.progress('close');
	});
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">		
		<div data-options="region:'center',border:false">
			<form id="searchForm" method="post">
				<table class="table table-hover table-condensed">
					<tr>
						<th>表名（例：userRole）</th>
						<td><input name="tableName" class="easyui-validatebox span2" data-options="required:true"/></td>
						<th>名称</th>
						<td><input name="tableLabel" class="easyui-validatebox span2" data-options="required:true"/></td>
					</tr>					
				</table>
			</form>
			<a href="javascript:void(0)" onclick="javascipt:$('#searchForm').submit();" class="easyui-linkbutton" >提交</a>
		</div>
	</div>	
</body>
</html>