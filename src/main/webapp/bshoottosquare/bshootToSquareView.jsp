<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jb.model.TbshootToSquare" %>
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
					<th><%=TbshootToSquare.ALIAS_BSHOOT_ID%></th>	
					<td>
						${bshootToSquare.bshootId}							
					</td>							
					<th><%=TbshootToSquare.ALIAS_SQUARE_ID%></th>	
					<td>
						${bshootToSquare.squareId}							
					</td>							
				</tr>		
				<tr>	
					<th><%=TbshootToSquare.ALIAS_AUDITOR_ID%></th>	
					<td>
						${bshootToSquare.auditorId}							
					</td>							
					<th><%=TbshootToSquare.ALIAS_AUDITOR_TIME%></th>	
					<td>
						${bshootToSquare.auditorTime}							
					</td>							
				</tr>		
				<tr>	
					<th><%=TbshootToSquare.ALIAS_REASON%></th>	
					<td>
						${bshootToSquare.reason}							
					</td>							
					<th><%=TbshootToSquare.ALIAS_STATUS%></th>	
					<td>
						${bshootToSquare.status}							
					</td>							
				</tr>		
		</table>
	</div>
</div>