<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jb.model.TbshootComment" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		$('#form').form({
			url : '${pageContext.request.contextPath}/bshootCommentController/edit',
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
				<input type="hidden" name="id" value = "${bshootComment.id}"/>
			<table class="table table-hover table-condensed">
				<tr>	
					<th><%=TbshootComment.ALIAS_USER_ID%></th>	
					<td>
					<input class="span2" name="userId" type="text" class="span2"  value="${bshootComment.userId}"/>
					</td>							
					<th><%=TbshootComment.ALIAS_BSHOOT_ID%></th>	
					<td>
					<input class="span2" name="bshootId" type="text" class="span2"  value="${bshootComment.bshootId}"/>
					</td>							
			</tr>	
				<tr>	
					<th><%=TbshootComment.ALIAS_PARENT_ID%></th>	
					<td>
					<input class="span2" name="parentId" type="text" class="span2"  value="${bshootComment.parentId}"/>
					</td>							
					<th><%=TbshootComment.ALIAS_BS_COMMENT_TEXT%></th>	
					<td>
					<input class="span2" name="bsCommentText" type="text" class="span2"  value="${bshootComment.bsCommentText}"/>
					</td>							
			</tr>	
				<tr>	
					<th><%=TbshootComment.ALIAS_COMMENT_DATETIME%></th>	
					<td>
					<input class="span2" name="commentDatetime" type="text" onclick="WdatePicker({dateFmt:'<%=TbshootComment.FORMAT_COMMENT_DATETIME%>'})"   maxlength="0" value="${bshootComment.commentDatetime}"/>
					</td>							
			</tr>	
			</table>				
		</form>
	</div>
</div>