<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jb.model.Tcar" %>
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
					<th><%=Tcar.ALIAS_NAME%></th>	
					<td>
						${car.name}							
					</td>							
					<th><%=Tcar.ALIAS_CODE%></th>	
					<td>
						${car.code}							
					</td>							
				</tr>		
				<tr>	
					<th><%=Tcar.ALIAS_USER_NAME%></th>	
					<td>
						${car.userName}							
					</td>							
				</tr>		
		</table>
	</div>
</div>