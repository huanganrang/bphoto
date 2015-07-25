<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jb.model.TuserAttention" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');		
	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false">
		<table class="table table-hover table-condensed">
				<tr>	
					<th><%=TuserAttention.ALIAS_USER_ID%></th>	
					<td>
						${userAttention.userId}							
					</td>							
					<th><%=TuserAttention.ALIAS_ATT_USER_ID%></th>	
					<td>
						${userAttention.attUserId}							
					</td>							
				</tr>		
				<tr>	
					<th><%=TuserAttention.ALIAS_ATTENTION_DATETIME%></th>	
					<td>
						${userAttention.attentionDatetime}							
					</td>							
				</tr>		
		</table>
	</div>
</div>