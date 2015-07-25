package jb.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jb.pageModel.Colum;
import jb.pageModel.BshootComment;
import jb.pageModel.DataGrid;
import jb.pageModel.Json;
import jb.pageModel.PageHelper;
import jb.service.BshootCommentServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * BshootComment管理控制器
 * 
 * @author John
 * 
 */
@Controller
@RequestMapping("/bshootCommentController")
public class BshootCommentController extends BaseController {

	@Autowired
	private BshootCommentServiceI bshootCommentService;


	/**
	 * 跳转到BshootComment管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/bshootcomment/bshootComment";
	}

	/**
	 * 获取BshootComment数据表格
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(BshootComment bshootComment, PageHelper ph) {
		return bshootCommentService.dataGrid(bshootComment, ph);
	}
	/**
	 * 获取BshootComment数据表格excel
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
	public void download(BshootComment bshootComment, PageHelper ph,String downloadFields,HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException{
		DataGrid dg = dataGrid(bshootComment,ph);		
		downloadFields = downloadFields.replace("&quot;", "\"");
		downloadFields = downloadFields.substring(1,downloadFields.length()-1);
		List<Colum> colums = JSON.parseArray(downloadFields, Colum.class);
		downloadTable(colums, dg, response);
	}
	/**
	 * 跳转到添加BshootComment页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		BshootComment bshootComment = new BshootComment();
		bshootComment.setId(UUID.randomUUID().toString());
		return "/bshootcomment/bshootCommentAdd";
	}

	/**
	 * 添加BshootComment
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(BshootComment bshootComment) {
		Json j = new Json();		
		bshootCommentService.add(bshootComment);
		j.setSuccess(true);
		j.setMsg("添加成功！");		
		return j;
	}

	/**
	 * 跳转到BshootComment查看页面
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view(HttpServletRequest request, String id) {
		BshootComment bshootComment = bshootCommentService.get(id);
		request.setAttribute("bshootComment", bshootComment);
		return "/bshootcomment/bshootCommentView";
	}

	/**
	 * 跳转到BshootComment修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		BshootComment bshootComment = bshootCommentService.get(id);
		request.setAttribute("bshootComment", bshootComment);
		return "/bshootcomment/bshootCommentEdit";
	}

	/**
	 * 修改BshootComment
	 * 
	 * @param bshootComment
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(BshootComment bshootComment) {
		Json j = new Json();		
		bshootCommentService.edit(bshootComment);
		j.setSuccess(true);
		j.setMsg("编辑成功！");		
		return j;
	}

	/**
	 * 删除BshootComment
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id) {
		Json j = new Json();
		bshootCommentService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}
