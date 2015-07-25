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
			<div title="好友视频" data-options="href:'api_friend_getBshootByFriend.jsp'"
				style="padding: 1px"></div>
			<div title="可能感兴趣" data-options="href:'api_friend_hobby.jsp'"
				style="padding: 1px"></div>
			<div title="达人" data-options="href:'api_friend_tarento.jsp'"
				style="padding: 1px"></div>	
			<div title="明星名人" data-options="href:'api_friend_star.jsp'"
				style="padding: 1px"></div>
			<div title="帐号ID搜索" data-options="href:'api_friend_search.jsp'"
				style="padding: 1px"></div>									
		</div>

</body>
</html>