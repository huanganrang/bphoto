package jb.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jb.pageModel.Colum;
import jb.pageModel.BshootCollect;
import jb.pageModel.DataGrid;
import jb.pageModel.Json;
import jb.pageModel.PageHelper;
import jb.service.BshootCollectServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * BshootCollect管理控制器
 * 
 * @author John
 * 
 */
@Controller
@RequestMapping("/bshootCollectController")
public class BshootCollectController extends BaseController {

	@Autowired
	private BshootCollectServiceI bshootCollectService;


	/**
	 * 跳转到BshootCollect管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/bshootcollect/bshootCollect";
	}

	/**
	 * 获取BshootCollect数据表格
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(BshootCollect bshootCollect, PageHelper ph) {
		return bshootCollectService.dataGrid(bshootCollect, ph);
	}
	/**
	 * 获取BshootCollect数据表格excel
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
	public void download(BshootCollect bshootCollect, PageHelper ph,String downloadFields,HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException{
		DataGrid dg = dataGrid(bshootCollect,ph);		
		downloadFields = downloadFields.replace("&quot;", "\"");
		downloadFields = downloadFields.substring(1,downloadFields.length()-1);
		List<Colum> colums = JSON.parseArray(downloadFields, Colum.class);
		downloadTable(colums, dg, response);
	}
	/**
	 * 跳转到添加BshootCollect页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		BshootCollect bshootCollect = new BshootCollect();
		bshootCollect.setId(UUID.randomUUID().toString());
		return "/bshootcollect/bshootCollectAdd";
	}

	/**
	 * 添加BshootCollect
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(BshootCollect bshootCollect) {
		Json j = new Json();		
		bshootCollectService.add(bshootCollect);
		j.setSuccess(true);
		j.setMsg("添加成功！");		
		return j;
	}

	/**
	 * 跳转到BshootCollect查看页面
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view(HttpServletRequest request, String id) {
		BshootCollect bshootCollect = bshootCollectService.get(id);
		request.setAttribute("bshootCollect", bshootCollect);
		return "/bshootcollect/bshootCollectView";
	}

	/**
	 * 跳转到BshootCollect修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		BshootCollect bshootCollect = bshootCollectService.get(id);
		request.setAttribute("bshootCollect", bshootCollect);
		return "/bshootcollect/bshootCollectEdit";
	}

	/**
	 * 修改BshootCollect
	 * 
	 * @param bshootCollect
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(BshootCollect bshootCollect) {
		Json j = new Json();		
		bshootCollectService.edit(bshootCollect);
		j.setSuccess(true);
		j.setMsg("编辑成功！");		
		return j;
	}

	/**
	 * 删除BshootCollect
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id) {
		Json j = new Json();
		bshootCollectService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}
