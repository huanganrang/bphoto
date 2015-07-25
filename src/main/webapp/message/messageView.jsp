<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jb.model.Tmessage" %>
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
					<th><%=Tmessage.ALIAS_MTYPE%></th>	
					<td>
						${message.mtype}							
					</td>							
					<th><%=Tmessage.ALIAS_USER_ID%></th>	
					<td>
						${message.userId}							
					</td>							
				</tr>		
				<tr>	
					<th><%=Tmessage.ALIAS_IS_READ%></th>	
					<td>
						${message.isRead}							
					</td>							
					<th><%=Tmessage.ALIAS_RELATION_ID%></th>	
					<td>
						${message.relationId}							
					</td>							
				</tr>		
				<tr>	
					<th><%=Tmessage.ALIAS_CONTENT%></th>	
					<td>
						${message.content}							
					</td>							
					<th><%=Tmessage.ALIAS_CREATEDATETIME%></th>	
					<td>
						${message.createdatetime}							
					</td>							
				</tr>		
		</table>
	</div>
</div>