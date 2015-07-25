<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
	$(function() {
		$('#form').form({
			url : '${pageContext.request.contextPath}/basedataController/basetypeAdd',
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
					parent.$.modalDialog.openner_tree.tree('reload');
					parent.$.modalDialog.openner_dataGrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为user.jsp页面预定义好了
					parent.$.modalDialog.handler.dialog('close');
				} else {
					parent.$.messager.alert('错误', result.msg, 'error');
				}
			}
		});
		parent.$.messager.progress('close');
	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;">
		<form id="form" method="post">
			<table class="table table-hover table-condensed">
				<tr>
					<th>编码</th>
					<td><input name="code" type="text" class="span2" maxlength="2"></td>
					<th>名称</th>
					<td><input name="name" type="text" placeholder="请输入名称" class="easyui-validatebox span2" data-options="required:true" value=""></td>
					<th>类型</th>
					<td>
						<select name="type" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
								<option value="0">系统</option>
								<option value="1">业务</option>
						</select>
					</td>
				</tr>			
			</table>
		</form>
	</div>
</div>