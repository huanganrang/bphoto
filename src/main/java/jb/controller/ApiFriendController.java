package jb.controller;

import javax.servlet.http.HttpServletRequest;

import jb.interceptors.TokenManage;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;
import jb.pageModel.SessionInfo;
import jb.pageModel.User;
import jb.service.BshootCollectServiceI;
import jb.service.BshootServiceI;
import jb.service.UserAttentionServiceI;
import jb.service.UserServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 好友管理控制器
 * 
 * @author John
 * 
 */
@Controller
@RequestMapping("/api/apiFriendController")
public class ApiFriendController extends BaseController {
	@Autowired
	private UserServiceI userService;
	
	@Autowired
	private TokenManage tokenManage;
	
	@Autowired
	private BshootServiceI bshootService;
	
	@Autowired
	private BshootCollectServiceI bshootCollectService;
	
	@Autowired
	private UserAttentionServiceI userAttentionService;
	
	
	private SessionInfo getSessionInfo(HttpServletRequest request){
		SessionInfo s = tokenManage.getSessionInfo(request);
		return s;		
	}
	
	
	
	/**
	 * 好友视频列表
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/friend_bshoots")
	@ResponseBody
	public DataGrid dataGridMyFriend(PageHelper ph,HttpServletRequest request) {
		SessionInfo s = getSessionInfo(request);
		DataGrid dg = bshootService.dataGridByFriend(ph,s.getId());
		return dg;
	}	
	
	/**
	 * 明星名人
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/friend_star")
	@ResponseBody
	public DataGrid dataGridStar(PageHelper ph,HttpServletRequest request) {
		SessionInfo s = getSessionInfo(request);
		User user = new User();
		user.setId(s.getId());
		user.setIsStar(true);
		DataGrid dg = userService.dataGridForApi(user, ph);
		return dg;
	}	
	/**
	 * 达人
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/friend_tarento")
	@ResponseBody
	public DataGrid dataGridTarento(PageHelper ph,HttpServletRequest request) {
		SessionInfo s = getSessionInfo(request);
		User user = new User();
		user.setId(s.getId());
		user.setIsTarento(true);
		DataGrid dg = userService.dataGridForApi(user, ph);
		return dg;
	}	
	
	/**
	 * id or nickname查询
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/friend_search")
	@ResponseBody
	public DataGrid dataGridSearch(PageHelper ph,HttpServletRequest request) {
		SessionInfo s = getSessionInfo(request);
		User user = new User();
		user.setId(s.getId());
		String name = request.getParameter("name");
		user.setName(name);
		user.setNickname(name);
		DataGrid dg = userService.dataGridForApi(user, ph);
		return dg;
	}	
	
	/**
	 * id or nickname查询
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/friend_hobby")
	@ResponseBody
	public DataGrid dataGridHobby(PageHelper ph,HttpServletRequest request) {
		SessionInfo s = getSessionInfo(request);
		User user = new User();
		user.setId(s.getId());
		DataGrid dg = userService.dataGridHobby(user, ph);
		return dg;
	}	
}
