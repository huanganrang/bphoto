<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jb.model.TuserMessage" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		$('#form').form({
			url : '${pageContext.request.contextPath}/userMessageController/edit',
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
				<input type="hidden" name="id" value = "${userMessage.id}"/>
			<table class="table table-hover table-condensed">
				<tr>	
					<th><%=TuserMessage.ALIAS_USER_ID%></th>	
					<td>
					<input class="span2" name="userId" type="text" class="span2"  value="${userMessage.userId}"/>
					</td>							
					<th><%=TuserMessage.ALIAS_UM_TYPE%></th>	
					<td>
					<input class="span2" name="umType" type="text" class="span2"  value="${userMessage.umType}"/>
					</td>							
			</tr>	
				<tr>	
					<th><%=TuserMessage.ALIAS_UM_MESSAGE%></th>	
					<td>
					<input class="span2" name="umMessage" type="text" class="span2"  value="${userMessage.umMessage}"/>
					</td>							
					<th><%=TuserMessage.ALIAS_UM_REMARK%></th>	
					<td>
					<input class="span2" name="umRemark" type="text" class="span2"  value="${userMessage.umRemark}"/>
					</td>							
			</tr>	
				<tr>	
					<th><%=TuserMessage.ALIAS_CREATE_DATETIME%></th>	
					<td>
					<input class="span2" name="createDatetime" type="text" onclick="WdatePicker({dateFmt:'<%=TuserMessage.FORMAT_CREATE_DATETIME%>'})"   maxlength="0" value="${userMessage.createDatetime}"/>
					</td>							
					<th><%=TuserMessage.ALIAS_UPDATE_DATETIME%></th>	
					<td>
					<input class="span2" name="updateDatetime" type="text" onclick="WdatePicker({dateFmt:'<%=TuserMessage.FORMAT_UPDATE_DATETIME%>'})"   maxlength="0" value="${userMessage.updateDatetime}"/>
					</td>							
			</tr>	
				<tr>	
					<th><%=TuserMessage.ALIAS_CREATE_PERSON%></th>	
					<td>
					<input class="span2" name="createPerson" type="text" class="span2"  value="${userMessage.createPerson}"/>
					</td>							
					<th><%=TuserMessage.ALIAS_UPDATE_PERSON%></th>	
					<td>
					<input class="span2" name="updatePerson" type="text" class="span2"  value="${userMessage.updatePerson}"/>
					</td>							
			</tr>	
			</table>				
		</form>
	</div>
</div>