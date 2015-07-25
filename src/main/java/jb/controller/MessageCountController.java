package jb.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jb.pageModel.Colum;
import jb.pageModel.MessageCount;
import jb.pageModel.DataGrid;
import jb.pageModel.Json;
import jb.pageModel.PageHelper;
import jb.service.MessageCountServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * MessageCount管理控制器
 * 
 * @author John
 * 
 */
@Controller
@RequestMapping("/messageCountController")
public class MessageCountController extends BaseController {

	@Autowired
	private MessageCountServiceI messageCountService;


	/**
	 * 跳转到MessageCount管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/messagecount/messageCount";
	}

	/**
	 * 获取MessageCount数据表格
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(MessageCount messageCount, PageHelper ph) {
		return messageCountService.dataGrid(messageCount, ph);
	}
	/**
	 * 获取MessageCount数据表格excel
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
	public void download(MessageCount messageCount, PageHelper ph,String downloadFields,HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException{
		DataGrid dg = dataGrid(messageCount,ph);		
		downloadFields = downloadFields.replace("&quot;", "\"");
		downloadFields = downloadFields.substring(1,downloadFields.length()-1);
		List<Colum> colums = JSON.parseArray(downloadFields, Colum.class);
		downloadTable(colums, dg, response);
	}
	/**
	 * 跳转到添加MessageCount页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		MessageCount messageCount = new MessageCount();
		messageCount.setId(UUID.randomUUID().toString());
		return "/messagecount/messageCountAdd";
	}

	/**
	 * 添加MessageCount
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(MessageCount messageCount) {
		Json j = new Json();		
		messageCountService.add(messageCount);
		j.setSuccess(true);
		j.setMsg("添加成功！");		
		return j;
	}

	/**
	 * 跳转到MessageCount查看页面
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view(HttpServletRequest request, String id) {
		MessageCount messageCount = messageCountService.get(id);
		request.setAttribute("messageCount", messageCount);
		return "/messagecount/messageCountView";
	}

	/**
	 * 跳转到MessageCount修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		MessageCount messageCount = messageCountService.get(id);
		request.setAttribute("messageCount", messageCount);
		return "/messagecount/messageCountEdit";
	}

	/**
	 * 修改MessageCount
	 * 
	 * @param messageCount
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(MessageCount messageCount) {
		Json j = new Json();		
		messageCountService.edit(messageCount);
		j.setSuccess(true);
		j.setMsg("编辑成功！");		
		return j;
	}

	/**
	 * 删除MessageCount
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id) {
		Json j = new Json();
		messageCountService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}
