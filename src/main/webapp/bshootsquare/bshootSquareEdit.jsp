<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jb.model.TbshootSquare" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		$('#form').form({
			url : '${pageContext.request.contextPath}/bshootSquareController/edit',
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
		<form id="form" method="post" enctype="multipart/form-data">
				<input type="hidden" name="id" value = "${bshootSquare.id}"/>
			<table class="table table-hover table-condensed">
			<tr>	
					<th>Code</th>	
					<td>
						${bshootSquare.id}
					</td>
					<th><%=TbshootSquare.ALIAS_BSS_NAME%></th>	
					<td>
						<input class="span2" name="bssName" type="text" class="easyui-validatebox span2" data-options="required:true" value="${bshootSquare.bssName}"/>
					</td>																	
			</tr>	
			<tr>
				<th><%=TbshootSquare.ALIAS_BSS_USER_ID%></th>	
				<td>
					<select name="bssUserId" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
						<c:forEach items="${userList}" var="user">
							<option value="${user.id}" <c:if test="${user.id == bshootSquare.bssUserId}">selected="selected"</c:if>>${user.name}</option>
						</c:forEach>
					</select>	
				</td>
				<th><%=TbshootSquare.ALIAS_BSS_TYPE%></th>	
				<td>
					<select name="bssType" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
						<option value=""></option>
						<c:forEach items="${btlist}" var="bt">
							<option value="${bt.id}" <c:if test="${bt.id == bshootSquare.bssType}">selected="selected"</c:if>>${bt.name}</option>
						</c:forEach>
					</select>	
				</td>
			</tr>	
			<tr>	
				<th><%=TbshootSquare.ALIAS_BSS_ICON%></th>	
				<td colspan="3">
					<input class="span2" name="bssIconFile" type="file" class="span2" />
				</td>																		
			</tr>	
			<tr>	
				<th><%=TbshootSquare.ALIAS_BSS_ICON%></th>	
				<td colspan="3">
					<img alt="" src="${bshootSquare.bssIcon}"  style="width:100px;height:100px;" >
				</td>														
			</tr>	
			<tr>	
				<th><%=TbshootSquare.ALIAS_BSS_DESCRIPTION%></th>	
				<td colspan="3">
					<textarea rows="3" cols="" class="span2" name="bssDescription" class="span2" style="width: 80%">${bshootSquare.bssDescription} </textarea>
				</td>								
			</tr>	
	
			</table>				
		</form>
	</div>
</div>