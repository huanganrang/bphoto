<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jb.model.TmessageCount" %>
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
					<th><%=TmessageCount.ALIAS_MTYPE%></th>	
					<td>
						${messageCount.mtype}							
					</td>							
					<th><%=TmessageCount.ALIAS_USER_ID%></th>	
					<td>
						${messageCount.userId}							
					</td>							
				</tr>		
				<tr>	
					<th><%=TmessageCount.ALIAS_MNUMBER%></th>	
					<td>
						${messageCount.mnumber}							
					</td>							
				</tr>		
		</table>
	</div>
</div>