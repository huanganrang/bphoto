package jb.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jb.pageModel.Colum;
import jb.pageModel.CommentPraise;
import jb.pageModel.DataGrid;
import jb.pageModel.Json;
import jb.pageModel.PageHelper;
import jb.service.CommentPraiseServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * CommentPraise管理控制器
 * 
 * @author John
 * 
 */
@Controller
@RequestMapping("/commentPraiseController")
public class CommentPraiseController extends BaseController {

	@Autowired
	private CommentPraiseServiceI commentPraiseService;


	/**
	 * 跳转到CommentPraise管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/commentpraise/commentPraise";
	}

	/**
	 * 获取CommentPraise数据表格
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(CommentPraise commentPraise, PageHelper ph) {
		return commentPraiseService.dataGrid(commentPraise, ph);
	}
	/**
	 * 获取CommentPraise数据表格excel
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
	public void download(CommentPraise commentPraise, PageHelper ph,String downloadFields,HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException{
		DataGrid dg = dataGrid(commentPraise,ph);		
		downloadFields = downloadFields.replace("&quot;", "\"");
		downloadFields = downloadFields.substring(1,downloadFields.length()-1);
		List<Colum> colums = JSON.parseArray(downloadFields, Colum.class);
		downloadTable(colums, dg, response);
	}
	/**
	 * 跳转到添加CommentPraise页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		CommentPraise commentPraise = new CommentPraise();
		commentPraise.setId(UUID.randomUUID().toString());
		return "/commentpraise/commentPraiseAdd";
	}

	/**
	 * 添加CommentPraise
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(CommentPraise commentPraise) {
		Json j = new Json();		
		commentPraiseService.add(commentPraise);
		j.setSuccess(true);
		j.setMsg("添加成功！");		
		return j;
	}

	/**
	 * 跳转到CommentPraise查看页面
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view(HttpServletRequest request, String id) {
		CommentPraise commentPraise = commentPraiseService.get(id);
		request.setAttribute("commentPraise", commentPraise);
		return "/commentpraise/commentPraiseView";
	}

	/**
	 * 跳转到CommentPraise修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		CommentPraise commentPraise = commentPraiseService.get(id);
		request.setAttribute("commentPraise", commentPraise);
		return "/commentpraise/commentPraiseEdit";
	}

	/**
	 * 修改CommentPraise
	 * 
	 * @param commentPraise
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(CommentPraise commentPraise) {
		Json j = new Json();		
		commentPraiseService.edit(commentPraise);
		j.setSuccess(true);
		j.setMsg("编辑成功！");		
		return j;
	}

	/**
	 * 删除CommentPraise
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id) {
		Json j = new Json();
		commentPraiseService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}
