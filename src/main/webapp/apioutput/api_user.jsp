<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body >

		<div id="index_user_tabs" class="easyui-tabs" data-options="fit:true">
			<div title="注册用户" data-options="href:'api_user_register.jsp'"
				style="padding: 1px"></div>
			<div title="用户登录" data-options="href:'api_login.jsp'"
				style="padding: 1px"></div>
			<div title="用户关注" data-options="href:'api_user_attr.jsp'"
				style="padding: 1px"></div>				
			<div title="取消用户关注" data-options="href:'api_user_disattr.jsp'"
				style="padding: 1px"></div>
			<div title="我首页" data-options="href:'api_user_index.jsp'"
				style="padding: 1px"></div>					
			<div title="我的美拍" data-options="href:'api_user_mybshoots.jsp'"
				style="padding: 1px"></div>
			<div title="我的转发" data-options="href:'api_user_mytranspond.jsp'"
				style="padding: 1px"></div>	
			<div title="我的信息" data-options="href:'api_user_info.jsp'"
				style="padding: 1px"></div>	
			<div title="我的关注" data-options="href:'api_user_myattruser.jsp'"
				style="padding: 1px"></div>	
			<div title="我的粉丝" data-options="href:'api_user_myattreduser.jsp'"
				style="padding: 1px"></div>		
			<div title="视频投稿到广场" data-options="href:'api_user_bshootToSquare.jsp'"
				style="padding: 1px"></div>						
		</div>

</body>
</html>