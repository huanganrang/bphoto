<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jb.model.TbshootComment" %>
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
					<th><%=TbshootComment.ALIAS_USER_ID%></th>	
					<td>
						${bshootComment.userId}							
					</td>							
					<th><%=TbshootComment.ALIAS_BSHOOT_ID%></th>	
					<td>
						${bshootComment.bshootId}							
					</td>							
				</tr>		
				<tr>	
					<th><%=TbshootComment.ALIAS_PARENT_ID%></th>	
					<td>
						${bshootComment.parentId}							
					</td>							
					<th><%=TbshootComment.ALIAS_BS_COMMENT_TEXT%></th>	
					<td>
						${bshootComment.bsCommentText}							
					</td>							
				</tr>		
				<tr>	
					<th><%=TbshootComment.ALIAS_COMMENT_DATETIME%></th>	
					<td>
						${bshootComment.commentDatetime}							
					</td>							
				</tr>		
		</table>
	</div>
</div>