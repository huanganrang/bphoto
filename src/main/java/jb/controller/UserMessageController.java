package jb.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jb.pageModel.Colum;
import jb.pageModel.UserMessage;
import jb.pageModel.DataGrid;
import jb.pageModel.Json;
import jb.pageModel.PageHelper;
import jb.service.UserMessageServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * UserMessage管理控制器
 * 
 * @author John
 * 
 */
@Controller
@RequestMapping("/userMessageController")
public class UserMessageController extends BaseController {

	@Autowired
	private UserMessageServiceI userMessageService;


	/**
	 * 跳转到UserMessage管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/usermessage/userMessage";
	}

	/**
	 * 获取UserMessage数据表格
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(UserMessage userMessage, PageHelper ph) {
		return userMessageService.dataGrid(userMessage, ph);
	}
	/**
	 * 获取UserMessage数据表格excel
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
	public void download(UserMessage userMessage, PageHelper ph,String downloadFields,HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException{
		DataGrid dg = dataGrid(userMessage,ph);		
		downloadFields = downloadFields.replace("&quot;", "\"");
		downloadFields = downloadFields.substring(1,downloadFields.length()-1);
		List<Colum> colums = JSON.parseArray(downloadFields, Colum.class);
		downloadTable(colums, dg, response);
	}
	/**
	 * 跳转到添加UserMessage页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		UserMessage userMessage = new UserMessage();
		userMessage.setId(UUID.randomUUID().toString());
		return "/usermessage/userMessageAdd";
	}

	/**
	 * 添加UserMessage
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(UserMessage userMessage) {
		Json j = new Json();		
		userMessageService.add(userMessage);
		j.setSuccess(true);
		j.setMsg("添加成功！");		
		return j;
	}

	/**
	 * 跳转到UserMessage查看页面
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view(HttpServletRequest request, String id) {
		UserMessage userMessage = userMessageService.get(id);
		request.setAttribute("userMessage", userMessage);
		return "/usermessage/userMessageView";
	}

	/**
	 * 跳转到UserMessage修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		UserMessage userMessage = userMessageService.get(id);
		request.setAttribute("userMessage", userMessage);
		return "/usermessage/userMessageEdit";
	}

	/**
	 * 修改UserMessage
	 * 
	 * @param userMessage
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(UserMessage userMessage) {
		Json j = new Json();		
		userMessageService.edit(userMessage);
		j.setSuccess(true);
		j.setMsg("编辑成功！");		
		return j;
	}

	/**
	 * 删除UserMessage
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id) {
		Json j = new Json();
		userMessageService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}
