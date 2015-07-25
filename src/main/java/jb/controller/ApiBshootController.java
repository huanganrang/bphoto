package jb.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jb.interceptors.TokenManage;
import jb.model.TbshootComment;
import jb.pageModel.Bshoot;
import jb.pageModel.BshootCollect;
import jb.pageModel.BshootComment;
import jb.pageModel.BshootPraise;
import jb.pageModel.DataGrid;
import jb.pageModel.Json;
import jb.pageModel.PageHelper;
import jb.pageModel.SessionInfo;
import jb.pageModel.User;
import jb.service.BshootCollectServiceI;
import jb.service.BshootCommentServiceI;
import jb.service.BshootPraiseServiceI;
import jb.service.BshootServiceI;
import jb.service.UserAttentionServiceI;
import jb.service.UserServiceI;
import jb.util.Constants;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Bshoot管理控制器
 * 
 * @author John
 * 
 */
@Controller
@RequestMapping("/api/bshootController")
public class ApiBshootController extends BaseController {
	@Autowired
	private UserServiceI userService;
	
	@Autowired
	private TokenManage tokenManage;
	
	@Autowired
	private BshootServiceI bshootService;
	
	@Autowired
	private BshootCollectServiceI bshootCollectService;
	
	@Autowired
	private BshootPraiseServiceI bshootPraiseService;
	
	@Autowired
	private UserAttentionServiceI userAttentionService;
	
	@Autowired
	private BshootCommentServiceI bshootCommentService;
	
	
	
	
	/**
	 * 用户登录
	 * 
	 * @param user
	 *            用户对象
	 * @param session
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login")
	public Json login(User user, HttpSession session, HttpServletRequest request) {
		Json j = new Json();
		User u = userService.login(user);
		if (u != null) {
			j.setSuccess(true);
			j.setMsg("登陆成功！");

			/*SessionInfo sessionInfo = new SessionInfo();
			BeanUtils.copyProperties(u, sessionInfo);*/
			String tid = tokenManage.buildToken(user.getId(),user.getName());
			j.setObj(tid);
		} else {
			j.setMsg("用户名或密码错误！");
		}
		return j;
	}
	
	@ResponseBody
	@RequestMapping("/register")
	public Json register(User user, HttpServletRequest request) {
		Json j = new Json();
		try {
			user.setMemberV(null);
			user.setUtype(null);
			user.setThirdUser(null);
			userService.reg(user);
			j.setSuccess(true);
			j.setMsg("注册成功");
			j.setObj(user);
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}
	
	
	private SessionInfo getSessionInfo(HttpServletRequest request){
		SessionInfo s = tokenManage.getSessionInfo(request);
		return s;
		
	}
	
	@ResponseBody
	@RequestMapping("/bshoot_collect")
	public Json bshootCollect(BshootCollect bshoot,HttpServletRequest request) {
		Json j = new Json();
		SessionInfo s = getSessionInfo(request);
		bshoot.setUserId(s.getId());
		int r = bshootCollectService.add(bshoot);
		if(r==-1){
			j.setSuccess(false);
			j.setMsg("已经收藏！");
		}else{
			j.setSuccess(true);
			j.setMsg("成功！");
		}
		/*bshootCollectService.add(bshoot);			
		j.setSuccess(true);
		j.setMsg("成功！");*/
		return j;
	}
	
	@ResponseBody
	@RequestMapping("/bshoot_discollect")
	public Json bshootCollectCancle(BshootCollect bshoot,HttpServletRequest request) {
		Json j = new Json();
		SessionInfo s = getSessionInfo(request);
		bshoot.setUserId(s.getId());
		int r = bshootCollectService.deleteCollect(bshoot);
		if(r==-1){
			j.setSuccess(false);
			j.setMsg("已经取消！");
		}else{
			j.setSuccess(true);
			j.setMsg("成功！");
		}
		/*bshootCollectService.add(bshoot);			
		j.setSuccess(true);
		j.setMsg("成功！");*/
		return j;
	}
	
	
	@ResponseBody
	@RequestMapping("/bshoot_praise")
	public Json bshootPraise(BshootPraise bshootPraise,HttpServletRequest request) {
		Json j = new Json();
		SessionInfo s = getSessionInfo(request);
		bshootPraise.setUserId(s.getId());
		int r = bshootPraiseService.add(bshootPraise);
		if(r==-1){
			j.setSuccess(false);
			j.setMsg("已经赞过了！");
		}else{
			j.setSuccess(true);
			j.setMsg("成功！");
			Bshoot bshoot = bshootService.get(bshootPraise.getBshootId());
			addMessage("MT04", bshoot.getUserId(), bshootPraise.getId());
		}
		return j;
	}
	
	@ResponseBody
	@RequestMapping("/bshoot_dispraise")
	public Json bshootPraiseCancle(BshootPraise bshootPraise,HttpServletRequest request) {
		Json j = new Json();
		SessionInfo s = getSessionInfo(request);
		bshootPraise.setUserId(s.getId());
		int r = bshootPraiseService.deleteBshootPraise(bshootPraise);
		if(r==-1){
			j.setSuccess(false);
			j.setMsg("已经取消！");
		}else{
			j.setSuccess(true);
			j.setMsg("成功！");
			addMessage("MT04",bshootPraise.getBshootId());
		}
		return j;
	}
	
	@ResponseBody
	@RequestMapping("/bshoot_detail")
	public Json bshootDetail(Bshoot b,HttpServletRequest request) {
		Json j = new Json();
		SessionInfo s = getSessionInfo(request);		
		Bshoot bshoot = bshootService.get(b.getId());
		User user = userService.get(bshoot.getUserId());
		PageHelper ph = new PageHelper();
		ph.setPage(1);
		ph.setRows(20);
		ph.setSort("commentDatetime");
		BshootComment bc = new BshootComment();
		bc.setBshootId(b.getId());
		DataGrid dataGrid  = null;
		//登录情况下
		if(s != null){
			//是否赞过
			
			if(bshootPraiseService.get(b.getId(), user.getId()) != null){
				bshoot.setPraised(Constants.GLOBAL_BOOLEAN_TRUE);
			}else{
				bshoot.setPraised(Constants.GLOBAL_BOOLEAN_FALSE);
			}
			
			//用户是否关注过
			if(userAttentionService.get(s.getId(), user.getId()) != null){
				user.setAttred(Constants.GLOBAL_BOOLEAN_TRUE);
			}else{
				user.setAttred(Constants.GLOBAL_BOOLEAN_FALSE);
			}
			
			//评论是否赞过	
			dataGrid  = bshootCommentService.dataGrid(bc, ph,user.getId());
			
		}else{
			user.setAttred(Constants.GLOBAL_NOT_LOGIN);
			bshoot.setPraised(Constants.GLOBAL_NOT_LOGIN);
			dataGrid  = bshootCommentService.dataGrid(bc, ph);
		}
		
		Map<String,Object> obj = new HashMap<String,Object>();
		obj.put("bshoot", bshoot);
		obj.put("user", user);
		obj.put("comments", dataGrid);
		j.setObj(obj);		
		j.setSuccess(true);
		return j;
	}
	
	/**
	 * 添加Bshoot
	 * 
	 * @return
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public Json uploadBshoot(Bshoot bshoot,@RequestParam MultipartFile[] movies,@RequestParam MultipartFile[] icons, HttpServletRequest request) {
		Json j = new Json();		
		SessionInfo s = getSessionInfo(request);
		String realPath = request.getSession().getServletContext().getRealPath("/"+Constants.UPLOADFILE+"/"+s.getName());  
		File file = new File(realPath);
		bshoot.setId(UUID.randomUUID().toString());
		bshoot.setUserId(s.getId());
		if(!file.exists())
			file.mkdir();
		
		for(MultipartFile f : movies){
			String suffix = f.getOriginalFilename().substring(f.getOriginalFilename().lastIndexOf("."));
			String fileName = bshoot.getId()+suffix;
			bshoot.setBsStream(s.getName()+"/"+fileName);
			 try {
				FileUtils.copyInputStreamToFile(f.getInputStream(), new File(realPath, fileName));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		for(MultipartFile f : icons){
			String suffix = f.getOriginalFilename().substring(f.getOriginalFilename().lastIndexOf("."));
			String fileName = bshoot.getId()+suffix;
			bshoot.setBsIcon(s.getName()+"/"+fileName);
			 try {
				FileUtils.copyInputStreamToFile(f.getInputStream(), new File(realPath, fileName));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		bshootService.add(bshoot);	
		j.setSuccess(true);
		j.setMsg("添加成功！");		
		return j;
	}
	
	
	/**
	 * 添加Bshoot
	 * 
	 * @return
	 */
	@RequestMapping("/bshoot_transupload")
	@ResponseBody
	public Json uploadBshoot(Bshoot bshoot, HttpServletRequest request) {
		Json j = new Json();		
		SessionInfo s = getSessionInfo(request);
		Bshoot parent = bshootService.get(bshoot.getParentId());
		bshoot.setId(UUID.randomUUID().toString());
		bshoot.setUserId(s.getId());		
		bshoot.setBsStream(parent.getBsStream());
		bshoot.setBsIcon(parent.getBsIcon());
		bshootService.add(bshoot);	
		j.setSuccess(true);
		j.setMsg("添加成功！");		
		return j;
	}
	
	
	
	
	/**
	 * 获取Bshoot数据表格
	 * 
	 * @param user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(Bshoot bshoot, PageHelper ph,HttpServletRequest request) {
		DataGrid dg = bshootService.dataGrid(bshoot, ph);
		List<Bshoot> bshoots = dg.getRows();
		
		return dg;
	}
	
	/**
	 * 视频评论分页找
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/bshoot_comments")
	@ResponseBody
	public DataGrid dataGridBshoot(BshootComment bshootComment, PageHelper ph,HttpServletRequest request) {
		ph.setSort("commentDatetime");
		DataGrid dg = bshootCommentService.dataGrid(bshootComment, ph);
		return dg;
	}
	
	/**
	 * 添加评论
	 * 
	 * @return
	 */
	@RequestMapping("/bshoot_addcomment")
	@ResponseBody
	public Json addComment(BshootComment bshootComment, HttpServletRequest request) {
		Json j = new Json();		
		SessionInfo s = getSessionInfo(request);
		bshootComment.setUserId(s.getId());
		TbshootComment tbc = bshootCommentService.add(bshootComment);
		j.setSuccess(true);
		j.setMsg("添加成功！");		
		addMessage("MT03",tbc.getId());
		return j;
	}
	
}
