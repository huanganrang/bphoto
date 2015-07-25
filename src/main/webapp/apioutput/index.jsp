<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <jsp:include page="../inc.jsp"></jsp:include>
</head>
<body class="easyui-layout">	

	<div data-options="region:'center',border:false">
		<div id="index_tabs" class="easyui-tabs" data-options="fit:true">
			<div title="好友" data-options="href:'api_friend.jsp'"
				style="padding: 1px"></div>
			<div title="用户" data-options="href:'api_user.jsp'"
				style="padding: 1px"></div>
			<div title="发现" data-options="href:'api_find.jsp'"
				style="padding: 1px"></div>	
			<div title="消息" data-options="href:'api_message.jsp'"
				style="padding: 1px"></div>	
			<div title="视频一览表" data-options="href:'api_bshootlist.jsp'"
				style="padding: 1px"></div>
			<div title="上传文件" data-options="href:'api_upload.jsp'"
				style="padding: 1px"></div>
		</div>
	</div>	
</body>
</html>