<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jb.model.TcommentPraise" %>
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
					<th><%=TcommentPraise.ALIAS_COMMENT_ID%></th>	
					<td>
						${commentPraise.commentId}							
					</td>							
					<th><%=TcommentPraise.ALIAS_USER_ID%></th>	
					<td>
						${commentPraise.userId}							
					</td>							
				</tr>		
				<tr>	
					<th><%=TcommentPraise.ALIAS_PRAISE_DATETIME%></th>	
					<td>
						${commentPraise.praiseDatetime}							
					</td>							
				</tr>		
		</table>
	</div>
</div>