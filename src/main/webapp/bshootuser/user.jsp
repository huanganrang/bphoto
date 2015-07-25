<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>用户管理</title>
<jsp:include page="../inc.jsp"></jsp:include>
<c:if test="${fn:contains(sessionInfo.resourceList, '/userController/editPage')}">
	<script type="text/javascript">
		$.canEdit = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.resourceList, '/userController/delete')}">
	<script type="text/javascript">
		$.canDelete = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.resourceList, '/userController/grantPage')}">
	<script type="text/javascript">
		$.canGrant = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.resourceList, '/userController/editPwdPage')}">
	<script type="text/javascript">
		$.canEditPwd = true;
	</script>
</c:if>
<script type="text/javascript">
	var dataGrid;
	$(function() {
		dataGrid = $('#dataGrid').datagrid({
			url : '${pageContext.request.contextPath}/userController/dataGrid',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			idField : 'id',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'name',
			sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : false,
			frozenColumns : [ [ {
				field : 'id',
				title : '编号',
				width : 150,
				checkbox : true
			}, {
				field : 'name',
				title : '登录名称',
				width : 80,
				sortable : true
			} ] ],
			columns : [ [ {
				field : 'nickName',
				title : '昵称',
				width : 60
			}, {
				field : 'isStar',
				title : '明星',
				width : 50
			}, {
				field : 'isTarento',
				title : '达人',
				width : 50,
				sortable : true
			} ] ],
			toolbar : '#toolbar',
			onLoadSuccess : function() {
				$('#searchForm table').show();
				parent.$.messager.progress('close');

				$(this).datagrid('tooltip');
			},
			onRowContextMenu : function(e, rowIndex, rowData) {
				e.preventDefault();
				$(this).datagrid('unselectAll').datagrid('uncheckAll');
				$(this).datagrid('selectRow', rowIndex);
				$('#menu').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			}
		});
	});
		
	function batchUpateToTarento() {
		var rows = dataGrid.datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			parent.$.messager.confirm('确认', '您是否要修改当前选中的项目？', function(r) {
				if (r) {
					parent.$.messager.progress({
						title : '提示',
						text : '数据处理中，请稍后....'
					});
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);						
					}
					$.getJSON('${pageContext.request.contextPath}/userController/batchUpateToTarento', {
						ids : ids.join(',')
					}, function(result) {
						if (result.success) {
							dataGrid.datagrid('load');
							dataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
						}
						
						parent.$.messager.progress('close');
					});
				}
			});
		} else {
			parent.$.messager.show({
				title : '提示',
				msg : '请勾选要修改的记录！'
			});
		}
	}
	
	function batchUpateToStar() {
		var rows = dataGrid.datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			parent.$.messager.confirm('确认', '您是否要修改当前选中的项目？', function(r) {
				if (r) {
					parent.$.messager.progress({
						title : '提示',
						text : '数据处理中，请稍后....'
					});
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);						
					}
					$.getJSON('${pageContext.request.contextPath}/userController/batchUpateToStar', {
						ids : ids.join(',')
					}, function(result) {
						if (result.success) {
							dataGrid.datagrid('load');
							dataGrid.datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
						}
						
						parent.$.messager.progress('close');
					});
				}
			});
		} else {
			parent.$.messager.show({
				title : '提示',
				msg : '请勾选要修改的记录！'
			});
		}
	}

	

	function searchFun() {
		dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
	}
	function cleanFun() {
		$('#searchForm input').val('');
		dataGrid.datagrid('load', {});
	}
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'north',title:'查询条件',border:false" style="height: 60px; overflow: hidden;">
			<form id="searchForm">
				<table class="table table-hover table-condensed" style="display: none;">
					<tr>
						<th>登录名</th>
						<td><input name="name" placeholder="可以模糊查询登录名" class="span2" /></td>
					</tr>					
				</table>
			</form>
		</div>
		<div data-options="region:'center',border:false">
			<table id="dataGrid"></table>
		</div>
	</div>
	<div id="toolbar" style="display: none;">		
		<c:if test="${fn:contains(sessionInfo.resourceList, '/userController/batchUpateToStar')}">
			<a onclick="batchUpateToStar();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'tux'">批量明星</a>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/userController/batchUpateToTarento')}">
			<a onclick="batchUpateToTarento();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'tux'">批量达人</a>
		</c:if>
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'brick_add',plain:true" onclick="searchFun();">查询</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'brick_delete',plain:true" onclick="cleanFun();">清空条件</a>
	</div>
</body>
</html>