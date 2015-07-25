<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jb.model.TbshootPraise" %>
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
					<th><%=TbshootPraise.ALIAS_USER_ID%></th>	
					<td>
						${bshootPraise.userId}							
					</td>							
					<th><%=TbshootPraise.ALIAS_BSHOOT_ID%></th>	
					<td>
						${bshootPraise.bshootId}							
					</td>							
				</tr>		
				<tr>	
					<th><%=TbshootPraise.ALIAS_PRAISE_DATETIME%></th>	
					<td>
						${bshootPraise.praiseDatetime}							
					</td>							
				</tr>		
		</table>
	</div>
</div>