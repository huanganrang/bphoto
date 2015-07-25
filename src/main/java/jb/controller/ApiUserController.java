package jb.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jb.absx.F;
import jb.interceptors.TokenManage;
import jb.pageModel.Bshoot;
import jb.pageModel.BshootToSquare;
import jb.pageModel.DataGrid;
import jb.pageModel.Json;
import jb.pageModel.PageHelper;
import jb.pageModel.SessionInfo;
import jb.pageModel.User;
import jb.pageModel.UserAttention;
import jb.service.BshootCollectServiceI;
import jb.service.BshootServiceI;
import jb.service.BshootToSquareServiceI;
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
@RequestMapping("/api/apiUserController")
public class ApiUserController extends BaseController {
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
	
	@Autowired
	private BshootToSquareServiceI bshootToSquareService;
	
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
	public Json register(User user,@RequestParam MultipartFile headImageFile, HttpServletRequest request) {
		Json j = new Json();
		try {
			user.setMemberV(null);
			user.setUtype(null);
			user.setThirdUser(null);
			uploadFile(request, user, headImageFile);
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
	
	private void uploadFile(HttpServletRequest request,User user,MultipartFile headImageFile){
		if(headImageFile==null||headImageFile.isEmpty())
			return;
		String realPath = request.getSession().getServletContext().getRealPath("/"+Constants.UPLOADFILE_HEADIMAGE+"/"+user.getName());  
		File file = new File(realPath);
		if(!file.exists())
			file.mkdir();
		String suffix = headImageFile.getOriginalFilename().substring(headImageFile.getOriginalFilename().lastIndexOf("."));
		String fileName = user.getName()+suffix;		
		 try {
			FileUtils.copyInputStreamToFile(headImageFile.getInputStream(), new File(realPath, fileName));
			user.setHeadImage(Constants.UPLOADFILE_HEADIMAGE+"/"+user.getName()+"/"+fileName);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	private SessionInfo getSessionInfo(HttpServletRequest request){
		SessionInfo s = tokenManage.getSessionInfo(request);
		return s;		
	}
	
	/**
	 * 关注用户
	 * @param ua
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/user_attention")
	public Json userAttention(UserAttention ua,HttpServletRequest request) {
		Json j = new Json();		
		SessionInfo s = getSessionInfo(request);
		ua.setUserId(s.getId());		
		int r = userAttentionService.add(ua);
		if(r==-1){
			j.setSuccess(false);
			j.setMsg("已经关注！");
		}else{
			j.setSuccess(true);
			j.setMsg("成功！");
			addMessage("MT01",ua.getAttUserId(),ua.getUserId());
		}
		
		return j;
	}
	
	
	
	/**
	 * 取消关注用户
	 * @param ua
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/user_disattention")
	public Json disUserAttention(UserAttention ua,HttpServletRequest request) {
		Json j = new Json();
		SessionInfo s = getSessionInfo(request);
		ua.setUserId(s.getId());
		int r = userAttentionService.deleteUa(ua);
		if(r==-1){
			j.setSuccess(false);
			j.setMsg("已经取消！");
		}else{
			j.setSuccess(true);
			j.setMsg("成功！");
		}
		return j;
	}
	
	/**
	 * 我的首页
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	@ResponseBody
	@RequestMapping("/user_index")
	public Json userIndex(HttpServletRequest request) {
		Json j = new Json();
		String userId = request.getParameter("userId");
		SessionInfo s = getSessionInfo(request);
		if(F.empty(userId)){
			userId = s.getId();
		}
		Map map = userService.userIndex(userId);
		if(s!=null){
			if(userAttentionService.get(s.getId(), userId)!=null){
				map.put("attred", Constants.GLOBAL_BOOLEAN_TRUE);
			}else{
				map.put("attred", Constants.GLOBAL_BOOLEAN_FALSE);
			}
		}else{
			map.put("attred", Constants.GLOBAL_NOT_LOGIN);
		}
		if(map == null){
			j.setSuccess(false);
			j.setMsg("不存在该用户");
		}else{
			j.setSuccess(true);
			j.setObj(map);
		}
		return j;
	}
	
	/**
	 * 用户信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/user_info")
	public Json userInfo(HttpServletRequest request) {
		Json j = new Json();
		SessionInfo s = getSessionInfo(request);
		User user = userService.get(s.getId());
		if(user == null){
			j.setSuccess(false);
			j.setMsg("不存在该用户");
		}else{
			user.setPwd(null);
			j.setSuccess(true);
			j.setObj(user);
		}
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
	 * 我的美拍
	 * 
	 * @param user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/user_mybshoots")
	@ResponseBody
	public DataGrid dataGridMyBs(Bshoot bshoot, PageHelper ph,HttpServletRequest request) {
		if(F.empty(bshoot.getUserId())){
			SessionInfo s = getSessionInfo(request);
			bshoot.setUserId(s.getId());
		}
		DataGrid dg = bshootService.dataGrid(bshoot, ph,1);
		List<Bshoot> bshoots = dg.getRows();
		
		return dg;
	}
	

	/**
	 * 我的转发
	 * @param bshoot
	 * @param ph
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/user_mytranspond")
	@ResponseBody
	public DataGrid dataGridMytranspond(Bshoot bshoot, PageHelper ph,HttpServletRequest request) {
		if(F.empty(bshoot.getUserId())){
			SessionInfo s = getSessionInfo(request);
			bshoot.setUserId(s.getId());
		}
		DataGrid dg = bshootService.dataGrid(bshoot, ph,2);
		List<Bshoot> bshoots = dg.getRows();
		
		return dg;
	}
	
	/**
	 * 我关注好友
	 * @param bshoot
	 * @param ph
	 * @param request
	 * @return
	 */
	@RequestMapping("/user_myattruser")
	@ResponseBody
	public DataGrid dataGridMyattruser(UserAttention userAttention, PageHelper ph,HttpServletRequest request) {
		if(F.empty(userAttention.getUserId())){
			SessionInfo s = getSessionInfo(request);
			userAttention.setUserId(s.getId());
		}
		DataGrid dg = userAttentionService.dataGridUser(userAttention, ph);
		return dg;
	}
	
	/**
	 * 我的粉丝
	 * @param bshoot
	 * @param ph
	 * @param request
	 * @return
	 */
	@RequestMapping("/user_myattreduser")
	@ResponseBody
	public DataGrid dataGridMyattreduser(UserAttention userAttention, PageHelper ph,HttpServletRequest request) {
		if(F.empty(userAttention.getUserId())){
			SessionInfo s = getSessionInfo(request);
			userAttention.setAttUserId(s.getId());
		}else{
			userAttention.setAttUserId(userAttention.getUserId());
		}
		userAttention.setUserId(null);
		DataGrid dg = userAttentionService.dataGridUser(userAttention, ph);
		return dg;
	}
	
	@RequestMapping("/user_bshootToSquare")
	@ResponseBody
	public Json bshootToSquare(BshootToSquare bshootToSquare, HttpServletRequest request) {
		Json j = new Json();		
		SessionInfo s = getSessionInfo(request);
		int i = bshootToSquareService.addFromUser(bshootToSquare);
		if(i==1){
			j.setSuccess(true);
			j.setMsg("添加成功！");		
		}else if(i==-1){
			j.setSuccess(false);
			j.setMsg("在审核中或已经上传到广场");	
		}else{
			j.setSuccess(false);
			j.setMsg("失败");
		}
		return j;
	}
}
