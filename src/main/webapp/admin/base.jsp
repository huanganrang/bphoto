<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>基础数据管理</title>
<jsp:include page="../inc.jsp"></jsp:include>
<c:if test="${fn:contains(sessionInfo.resourceList, '/basedataController/basedataEditPage')}">
	<script type="text/javascript">
		$.canEdit = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.resourceList, '/basedataController/basedatadelete')}">
	<script type="text/javascript">
		$.canDelete = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.resourceList, '/basedataController/basetypeEdit')}">
	<script type="text/javascript">
		$.canBasetypeEdit = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.resourceList, '/basedataController/basetypeAddPage')}">
	<script type="text/javascript">
		$.canBasetypeAddPage = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.resourceList, '/basedataController/basetypedelete')}">
	<script type="text/javascript">
		$.canBasetypeDelete = true;
	</script>
</c:if>
</head>
<body>
<script type="text/javascript">
	var layout_west_tree;
	var layout_west_tree_url = '';
	var sessionInfo_userId = '${sessionInfo.id}';
	if (sessionInfo_userId) {
		layout_west_tree_url = '${pageContext.request.contextPath}/basedataController/treeGrid';
	}
	$(function() {
		layout_west_tree = $('#layout_west_tree').tree({
			url : layout_west_tree_url,
			parentField : 'pid',
			//lines : true,
			onClick : function(node) {
				if(node.id!="root"){
					dataGrid.datagrid('load', {"basetypeCode":node.id});
				}else{
					dataGrid.datagrid('load', {});
				}				
			},
			onDblClick : function(node){
				if($.canBasetypeEdit&&node.id!="root"){
					$(this).tree('beginEdit',node.target);
				}	
			},
			onAfterEdit : function(node){
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});				
				var baseType = node.attributes;
				var oldName = baseType.name;
				baseType.name = node.text;				 
				$.post("${pageContext.request.contextPath}/basedataController/basetypeEdit",baseType,     
						   function (result){        
								parent.$.messager.progress('close');
								result = $.parseJSON(result);
								if (!result.success){
									parent.$.messager.alert('错误', result.msg, 'error');
									$(this).tree('cancelEdit',node.target);
									baseType.name = oldName;
								}else{
									dataGrid.datagrid('load', {"basetypeCode":node.id});
								}
						});
			},
			onContextMenu: function(e,node){
				e.preventDefault();
				$(this).tree('select',node.target);
				$('#menu').menu('show',{
				left: e.pageX,
				top: e.pageY
				});},
			onBeforeLoad : function(node, param) {
				if (layout_west_tree_url) {//只有刷新页面才会执行这个方法
					parent.$.messager.progress({
						title : '提示',
						text : '数据处理中，请稍后....'
					});
				}
			},
			onLoadSuccess : function(node, data) {
				parent.$.messager.progress('close');
			}
		});
	});	
	
	var dataGrid;
	$(function() {
		dataGrid = $('#dataGrid').datagrid({
			url : '${pageContext.request.contextPath}/basedataController/basedataDataGrid',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			idField : 'id',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'seq',
			sortOrder : 'desc',
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : false,
			striped : true,
			rownumbers : true,
			singleSelect : true,
			frozenColumns : [ [ {
				field : 'id',
				title : '编码',
				width : 80,
				hidden : false
			}] ],
			columns : [ [{
				field : 'name',
				title : '名称',
				width : 150,
				sortable : true
			} ,{
				field : 'pid',
				title : '上级',
				width : 80,
				sortable : true
			} , {
				field : 'seq',
				title : '排序',
				width : 50,
				sortable : true
			}, {
				field : 'basetypeCode',
				title : '类型',
				width : 50,
				sortable : false
			}, {
				field : 'codeName',
				title : '类型名称',
				width : 80,
				hidden : false
			}, {
				field : 'description',
				title : '描述',
				width : 150,
				hidden : false
			}, {
				field : 'action',
				title : '操作',
				width : 100,
				formatter : function(value, row, index) {
					var str = '';
					if ($.canEdit) {
						str += $.formatString('<img onclick="editFun(\'{0}\');" src="{1}" title="编辑"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png');
					}
					str += '&nbsp;';
					if ($.canDelete) {
						str += $.formatString('<img onclick="deleteFun(\'{0}\');" src="{1}" title="删除"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/cancel.png');
					}				
					return str;
				}
			} ] ],
			toolbar : '#toolbar',
			onLoadSuccess : function() {
				//$('#searchForm table').show();
				parent.$.messager.progress('close');

				$(this).datagrid('tooltip');
			}
		});
	});
	function addFun() {
		var node  = layout_west_tree.tree('getSelected');
		if(!(node!=null&&node.id!="root")){
			parent.$.messager.show({
				title : '提示',
				msg : '请选择数据类型！'
			});
			return 
		}
		//console.info(node.attributes);
		parent.$.modalDialog({
			title : '添加基础数据',
			width : 780,
			height : 360,
			href : '${pageContext.request.contextPath}/basedataController/basedataAddPage?code='+node.attributes.code+"&name="+node.attributes.name,
			buttons : [ {
				text : '添加',
				handler : function() {					
						parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
						var f = parent.$.modalDialog.handler.find('#form');
						f.submit(); 					
				}
			} ]
		});
	}
	function deleteFun(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		}
		parent.$.messager.confirm('询问', '您是否要删除当前基础数据？', function(b) {
			if (b) {
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
				$.post('${pageContext.request.contextPath}/basedataController/basedatadelete', {
					id : id
				}, function(result) {
					if (result.success) {
						parent.$.messager.alert('提示', result.msg, 'info');
						dataGrid.datagrid('reload');
					}
					parent.$.messager.progress('close');
				}, 'JSON');
			}
		});
	}

	function editFun(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		}
		parent.$.modalDialog({
			title : '编辑基础数据',
			width : 780,
			height : 360,
			href : '${pageContext.request.contextPath}/basedataController/basedataEditPage?id=' + id,
			buttons : [ {
				text : '编辑',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	}

	function appendFun(){
		
		parent.$.modalDialog({
			title : '添加基础类型',
			width : 780,
			height : 150,
			href : '${pageContext.request.contextPath}/basedataController/basetypeAddPage',
			buttons : [ {
				text : '添加',
				handler : function() {					
						parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
						parent.$.modalDialog.openner_tree = layout_west_tree;
						var f = parent.$.modalDialog.handler.find('#form');
						f.submit(); 					
				}
			} ]
		});
	}
	function removeitFun(){
		var node  = layout_west_tree.tree('getSelected');
		if(!(node!=null&&node.id!="root")){
			parent.$.messager.show({
				title : '提示',
				msg : '请选择数据类型！'
			});
			return 
		}
		parent.$.messager.confirm('询问', '您是否要删除当前基础类型？', function(b) {
			if (b) {
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
				$.post('${pageContext.request.contextPath}/basedataController/basetypedelete', {
					id : node.id
				}, function(result) {
					if (result.success) {
						parent.$.messager.alert('提示', result.msg, 'info');
						layout_west_tree.tree('remove',node.target);
					}
					parent.$.messager.progress('close');
				}, 'JSON');
			}
		});
	}
</script>
	<div class="easyui-layout" data-options="fit:true,border:false">
		<div data-options="region:'west',split:true" title="基础类型" style="width: 200px; overflow: hidden;">
			<div class="well well-small">
				<ul id="layout_west_tree"></ul>
			</div>
		</div>
	
		<div data-options="region:'center',border:false" title="" style="overflow: hidden;">
			<table id="dataGrid"></table>
		</div>
	</div>	
	<div id="toolbar" style="display: none;">
		<c:if test="${fn:contains(sessionInfo.resourceList, '/basedataController/basedataAddPage')}">
			<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'pencil_add'">添加</a>
		</c:if>
		<a onclick="dataGrid.datagrid('reload');" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'transmit'">刷新</a>
	</div>
	<div id="menu" class="easyui-menu" style="width:120px;">
		<c:if test="${fn:contains(sessionInfo.resourceList, '/basedataController/basetypeAddPage')}">
			<div onclick="appendFun()" data-options="iconCls:'pencil_add'">添加</div>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.resourceList, '/basedataController/basetypedelete')}">
			<div onclick="removeitFun()" data-options="iconCls:'cancel'">删除</div>
		</c:if>		
	</div>
</body>
</html>