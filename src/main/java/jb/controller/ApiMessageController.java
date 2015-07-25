package jb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jb.interceptors.TokenManage;
import jb.pageModel.BshootPraise;
import jb.pageModel.DataGrid;
import jb.pageModel.MessageCount;
import jb.pageModel.PageHelper;
import jb.pageModel.SessionInfo;
import jb.pageModel.User;
import jb.service.BshootCollectServiceI;
import jb.service.BshootPraiseServiceI;
import jb.service.BshootServiceI;
import jb.service.MessageCountServiceI;
import jb.service.UserAttentionServiceI;
import jb.service.UserServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 消息管理控制器
 * 
 * @author John
 * 
 */
@Controller
@RequestMapping("/api/apiMessageController")
public class ApiMessageController extends BaseController {
	@Autowired
	private UserServiceI userService;
	
	@Autowired
	private TokenManage tokenManage;
	
	@Autowired
	private BshootServiceI bshootService;
	
	@Autowired
	private MessageCountServiceI messageCountService; 
	
	@Autowired
	private BshootCollectServiceI bshootCollectService;
	
	@Autowired
	private UserAttentionServiceI userAttentionService;
	
	@Autowired
	private BshootPraiseServiceI bshootPraiseService;
	
	
	private SessionInfo getSessionInfo(HttpServletRequest request){
		SessionInfo s = tokenManage.getSessionInfo(request);
		return s;		
	}
	
	
	
	/**
	 * 新朋友
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/message_newFriend")
	@ResponseBody
	public DataGrid dataGridNewFriend(PageHelper ph,HttpServletRequest request) {
		SessionInfo s = getSessionInfo(request);
		User user = new User();
		user.setId(s.getId());
		DataGrid dg = userService.dataGridNewFriend(user, ph);
		clearMessageCount(s.getId(),"MT01");
		return dg;
	}	
	
	/**
	 * 
	 * 喜欢的
	 * @param user
	 * @return
	 */
	@RequestMapping("/message_like")
	@ResponseBody
	public DataGrid dataGridLike(PageHelper ph,HttpServletRequest request) {
		SessionInfo s = getSessionInfo(request);
		BshootPraise bshootPraise = new BshootPraise();
		bshootPraise.setUserId(s.getId());		
		DataGrid dg = bshootPraiseService.dataGridLike(bshootPraise, ph);
		clearMessageCount(s.getId(),"MT04");
		return dg;
	}	
	
	/**
	 * 统计消息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/message_count")
	@ResponseBody
	public List<MessageCount> getMessageCounts(HttpServletRequest request) {
		SessionInfo s = getSessionInfo(request);
		MessageCount messageCount = new MessageCount();
		messageCount.setUserId(s.getId());
		List<MessageCount> list = messageCountService.getMessageCounts(messageCount);		
		return list;
	}	
	
	
	/**
	 * 删除消息统计数据
	 * @param userId
	 * @param mtype
	 */
	private void clearMessageCount(String userId,String mtype){
		messageCountService.deleteMessageCount(userId, mtype);
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
