<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body >

		<div id="index_find_tabs" class="easyui-tabs" data-options="fit:true">
			<div title="热门" data-options="href:'api_find_hotBshoot.jsp'"
				style="padding: 1px"></div>
			<div title="广场" data-options="href:'api_find_bshootSquare.jsp'"
				style="padding: 1px"></div>
			<div title="广场（话题）" data-options="href:'api_find_bshootSquareTopic.jsp'"
				style="padding: 1px"></div>	
			<div title="广场详情页主" data-options="href:'api_find_bshootSquareDetail.jsp'"
				style="padding: 1px"></div>
			<div title="广场详情页从页" data-options="href:'api_find_getBshootByCode.jsp'"
				style="padding: 1px"></div>	
			<div title="附近" data-options="href:'api_find_nearbyBshoot.jsp'"
				style="padding: 1px"></div>				
			<div title="点赞" data-options="href:'api_bshoot_praise.jsp'"
				style="padding: 1px"></div>
			<div title="取消赞" data-options="href:'api_bshoot_dispraise.jsp'"
				style="padding: 1px"></div>	
			<div title="详情" data-options="href:'api_bshoot_detail.jsp'"
				style="padding: 1px"></div>	
			<div title="发表评论" data-options="href:'api_bshoot_addcomment.jsp'"
				style="padding: 1px"></div>	
			<div title="取消评论赞" data-options="href:'api_comment_dispraise.jsp'"
				style="padding: 1px"></div>	
			<div title="评论赞" data-options="href:'api_comment_praise.jsp'"
				style="padding: 1px"></div>		
			<div title="评论分页查" data-options="href:'api_bshoot_comments.jsp'"
				style="padding: 1px"></div>
			<div title="收藏" data-options="href:'api_bshoot_collect.jsp'"
				style="padding: 1px"></div>	
			<div title="收藏取消" data-options="href:'api_bshoot_discollect.jsp'"
				style="padding: 1px"></div>		
			<div title="转发" data-options="href:'api_bshoot_transupload.jsp'"
				style="padding: 1px"></div>					
		</div>

</body>
</html>