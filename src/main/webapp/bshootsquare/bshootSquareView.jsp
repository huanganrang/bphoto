<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jb.model.TbshootSquare" %>
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
					<th>Code</th>	
					<td>
						${bshootSquare.id}							
					</td>
					<th><%=TbshootSquare.ALIAS_BSS_NAME%></th>	
					<td>
						${bshootSquare.bssName}							
					</td>							
				</tr>		
				<tr>												
					<th><%=TbshootSquare.ALIAS_BSS_USER_ID%></th>	
					<td colspan="3">
						${bshootSquare.bssUserId}							
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
						${bshootSquare.bssDescription}							
					</td>							
				</tr>		
				<tr>	
					<th><%=TbshootSquare.ALIAS_CREATE_DATETIME%></th>	
					<td>
						${bshootSquare.createDatetime}							
					</td>							
					<th><%=TbshootSquare.ALIAS_UPDATE_DATETIME%></th>	
					<td>
						${bshootSquare.updateDatetime}							
					</td>							
				</tr>		
				<tr>	
					<th><%=TbshootSquare.ALIAS_CREATE_PERSON%></th>	
					<td>
						${bshootSquare.createPerson}							
					</td>							
					<th><%=TbshootSquare.ALIAS_UPDATE_PERSON%></th>	
					<td>
						${bshootSquare.updatePerson}							
					</td>							
				</tr>		
		</table>
	</div>
</div>