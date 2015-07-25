<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jb.model.Tmessage" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		$('#form').form({
			url : '${pageContext.request.contextPath}/messageController/edit',
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
	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;">
		<form id="form" method="post">
				<input type="hidden" name="id" value = "${message.id}"/>
			<table class="table table-hover table-condensed">
				<tr>	
					<th><%=Tmessage.ALIAS_MTYPE%></th>	
					<td>
					<input class="span2" name="mtype" type="text" class="span2"  value="${message.mtype}"/>
					</td>							
					<th><%=Tmessage.ALIAS_USER_ID%></th>	
					<td>
					<input class="span2" name="userId" type="text" class="span2"  value="${message.userId}"/>
					</td>							
			</tr>	
				<tr>	
					<th><%=Tmessage.ALIAS_IS_READ%></th>	
					<td>
					<input class="span2" name="isRead" type="text" class="span2"  value="${message.isRead}"/>
					</td>							
					<th><%=Tmessage.ALIAS_RELATION_ID%></th>	
					<td>
					<input class="span2" name="relationId" type="text" class="span2"  value="${message.relationId}"/>
					</td>							
			</tr>	
				<tr>	
					<th><%=Tmessage.ALIAS_CONTENT%></th>	
					<td>
					<input class="span2" name="content" type="text" class="span2"  value="${message.content}"/>
					</td>							
					<th><%=Tmessage.ALIAS_CREATEDATETIME%></th>	
					<td>
					<input class="span2" name="createdatetime" type="text" onclick="WdatePicker({dateFmt:'<%=Tmessage.FORMAT_CREATEDATETIME%>'})"   maxlength="0" value="${message.createdatetime}"/>
					</td>							
			</tr>	
			</table>				
		</form>
	</div>
</div>