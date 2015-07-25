package jb.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jb.listener.Application;
import jb.pageModel.BshootSquare;
import jb.pageModel.Colum;
import jb.pageModel.DataGrid;
import jb.pageModel.Json;
import jb.pageModel.PageHelper;
import jb.pageModel.User;
import jb.service.BasedataServiceI;
import jb.service.BasetypeServiceI;
import jb.service.BshootSquareServiceI;
import jb.service.RoleServiceI;
import jb.service.UserServiceI;
import jb.util.Constants;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

/**
 * BshootSquare管理控制器
 * 
 * @author John
 * 
 */
@Controller
@RequestMapping("/bshootSquareController")
public class BshootSquareController extends BaseController {

	@Autowired
	private BshootSquareServiceI bshootSquareService;
	@Autowired
	private UserServiceI userService;
	@Autowired
	private RoleServiceI roleService;
	@Autowired
	private BasedataServiceI basedataService;
	

	/**
	 * 跳转到BshootSquare管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/bshootsquare/bshootSquare";
	}

	/**
	 * 获取BshootSquare数据表格
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(BshootSquare bshootSquare, PageHelper ph) {
		return bshootSquareService.dataGrid(bshootSquare, ph);
	}
	/**
	 * 获取BshootSquare数据表格excel
	 * 
	 * @param user
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws IOException 
	 */
	@RequestMapping("/download")
	public void download(BshootSquare bshootSquare, PageHelper ph,String downloadFields,HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException{
		DataGrid dg = dataGrid(bshootSquare,ph);		
		downloadFields = downloadFields.replace("&quot;", "\"");
		downloadFields = downloadFields.substring(1,downloadFields.length()-1);
		List<Colum> colums = JSON.parseArray(downloadFields, Colum.class);
		downloadTable(colums, dg, response);
	}
	/**
	 * 跳转到添加BshootSquare页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		BshootSquare bshootSquare = new BshootSquare();
		bshootSquare.setId(UUID.randomUUID().toString());
		request.setAttribute("userList", getSquareUserManage());
		request.setAttribute("btlist", basedataService.getBaseDatas("BT"));
		return "/bshootsquare/bshootSquareAdd";
	}

	private List<User> getSquareUserManage(){
		/*User user = new User();
		user.*/
		String roleId = Application.getString("SV300");
		return roleService.getUsers(roleId);
	}
	
	/**
	 * 添加BshootSquare
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(BshootSquare bshootSquare,@RequestParam MultipartFile bssIconFile,HttpServletRequest request) {
		Json j = new Json();		
		uploadFile(request, bshootSquare, bssIconFile);
		bshootSquareService.add(bshootSquare);
		
		j.setSuccess(true);
		j.setMsg("添加成功！");		
		return j;
	}

	private void completePath(HttpServletRequest request,BshootSquare bshootSquare){
		String fpath = request.getContextPath()+"/"+Constants.UPLOADFILE_SQUARE+"/";
		bshootSquare.setBssIcon(fpath+bshootSquare.getBssIcon());
	}
	
	/**
	 * 跳转到BshootSquare查看页面
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view(HttpServletRequest request, String id) {
		BshootSquare bshootSquare = bshootSquareService.get(id);
		request.setAttribute("bshootSquare", bshootSquare);
		completePath(request, bshootSquare);
		return "/bshootsquare/bshootSquareView";
	}

	/**
	 * 跳转到BshootSquare修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		BshootSquare bshootSquare = bshootSquareService.get(id);
		completePath(request, bshootSquare);
		request.setAttribute("bshootSquare", bshootSquare);
		request.setAttribute("userList", getSquareUserManage());
		request.setAttribute("btlist", basedataService.getBaseDatas("BT"));
		return "/bshootsquare/bshootSquareEdit";
	}

	private void uploadFile(HttpServletRequest request,BshootSquare bshootSquare,MultipartFile bssIcon){
		if(bssIcon==null||bssIcon.isEmpty())return;
		String realPath = request.getSession().getServletContext().getRealPath("/"+Constants.UPLOADFILE_SQUARE+"/"+bshootSquare.getId());  
		File file = new File(realPath);
		if(!file.exists())
			file.mkdir();
		String suffix = bssIcon.getOriginalFilename().substring(bssIcon.getOriginalFilename().lastIndexOf("."));
		String fileName = bshootSquare.getId()+suffix;		
		 try {
			FileUtils.copyInputStreamToFile(bssIcon.getInputStream(), new File(realPath, fileName));
			bshootSquare.setBssIcon(bshootSquare.getId()+"/"+fileName);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * 修改BshootSquare
	 * 
	 * @param bshootSquare
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(BshootSquare bshootSquare,@RequestParam MultipartFile bssIconFile,HttpServletRequest request) {
		Json j = new Json();		
		if(bssIconFile!=null){
			uploadFile(request, bshootSquare, bssIconFile);
		}
		bshootSquareService.edit(bshootSquare);
		j.setSuccess(true);
		j.setMsg("编辑成功！");		
		return j;
	}

	/**
	 * 删除BshootSquare
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id) {
		Json j = new Json();
		bshootSquareService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}
