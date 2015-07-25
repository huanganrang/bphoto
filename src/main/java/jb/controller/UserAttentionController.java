package jb.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jb.pageModel.Colum;
import jb.pageModel.UserAttention;
import jb.pageModel.DataGrid;
import jb.pageModel.Json;
import jb.pageModel.PageHelper;
import jb.service.UserAttentionServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * UserAttention管理控制器
 * 
 * @author John
 * 
 */
@Controller
@RequestMapping("/userAttentionController")
public class UserAttentionController extends BaseController {

	@Autowired
	private UserAttentionServiceI userAttentionService;


	/**
	 * 跳转到UserAttention管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/userattention/userAttention";
	}

	/**
	 * 获取UserAttention数据表格
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(UserAttention userAttention, PageHelper ph) {
		return userAttentionService.dataGrid(userAttention, ph);
	}
	/**
	 * 获取UserAttention数据表格excel
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
	public void download(UserAttention userAttention, PageHelper ph,String downloadFields,HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException{
		DataGrid dg = dataGrid(userAttention,ph);		
		downloadFields = downloadFields.replace("&quot;", "\"");
		downloadFields = downloadFields.substring(1,downloadFields.length()-1);
		List<Colum> colums = JSON.parseArray(downloadFields, Colum.class);
		downloadTable(colums, dg, response);
	}
	/**
	 * 跳转到添加UserAttention页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		UserAttention userAttention = new UserAttention();
		userAttention.setId(UUID.randomUUID().toString());
		return "/userattention/userAttentionAdd";
	}

	/**
	 * 添加UserAttention
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(UserAttention userAttention) {
		Json j = new Json();		
		userAttentionService.add(userAttention);
		j.setSuccess(true);
		j.setMsg("添加成功！");		
		return j;
	}

	/**
	 * 跳转到UserAttention查看页面
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view(HttpServletRequest request, String id) {
		UserAttention userAttention = userAttentionService.get(id);
		request.setAttribute("userAttention", userAttention);
		return "/userattention/userAttentionView";
	}

	/**
	 * 跳转到UserAttention修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		UserAttention userAttention = userAttentionService.get(id);
		request.setAttribute("userAttention", userAttention);
		return "/userattention/userAttentionEdit";
	}

	/**
	 * 修改UserAttention
	 * 
	 * @param userAttention
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(UserAttention userAttention) {
		Json j = new Json();		
		userAttentionService.edit(userAttention);
		j.setSuccess(true);
		j.setMsg("编辑成功！");		
		return j;
	}

	/**
	 * 删除UserAttention
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id) {
		Json j = new Json();
		userAttentionService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}
