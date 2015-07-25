<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
	$(function() {
		$('#form').form({
			url : '${pageContext.request.contextPath}/basedataController/basedataEdit',
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
					<td><input name="id" type="text" class="span2" value="${basedata.id}" readonly="readonly"></td>
					<th>名称</th>
					<td><input name="name" type="text" placeholder="请输入名称" class="easyui-validatebox span2" data-options="required:true" value="${basedata.name}"></td>
				</tr>
				<tr>
					<th>上级编码</th>
					<td><input name="pid" type="text" class="span2" maxlength="32" value="${basedata.pid}"></td>
					<th>排序</th>
					<td><input name="seq"  value="${basedata.seq}" class="easyui-numberspinner" style="width: 140px; height: 29px;" required="required" data-options="editable:false,min:100"></td>
				</tr>
				<tr>
					<th>类型</th>
					<td><input name="basetypeCode" type="text" class="span2" value="${basedata.basetypeCode}" readonly="readonly" >
					</td>
					<th>类型名称</th>
					<td><input name="codeName" type="text" class="span2" value="${basedata.codeName}" readonly="readonly" ></td>
				</tr>
				<tr>
					<th>描述</th>
					<td colspan="3"><textarea name="description" id="description" cols="50" rows="4" style="width:90%">${basedata.description}</textarea></td>
				</tr>
			</table>
		</form>
	</div>
</div>