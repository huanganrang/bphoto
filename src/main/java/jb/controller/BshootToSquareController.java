package jb.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jb.pageModel.Colum;
import jb.pageModel.BshootToSquare;
import jb.pageModel.DataGrid;
import jb.pageModel.Json;
import jb.pageModel.PageHelper;
import jb.service.BshootToSquareServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * BshootToSquare管理控制器
 * 
 * @author John
 * 
 */
@Controller
@RequestMapping("/bshootToSquareController")
public class BshootToSquareController extends BaseController {

	@Autowired
	private BshootToSquareServiceI bshootToSquareService;


	/**
	 * 跳转到BshootToSquare管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/bshoottosquare/bshootToSquare";
	}

	/**
	 * 获取BshootToSquare数据表格
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(BshootToSquare bshootToSquare, PageHelper ph) {
		return bshootToSquareService.dataGrid(bshootToSquare, ph);
	}
	/**
	 * 获取BshootToSquare数据表格excel
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
	public void download(BshootToSquare bshootToSquare, PageHelper ph,String downloadFields,HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException{
		DataGrid dg = dataGrid(bshootToSquare,ph);		
		downloadFields = downloadFields.replace("&quot;", "\"");
		downloadFields = downloadFields.substring(1,downloadFields.length()-1);
		List<Colum> colums = JSON.parseArray(downloadFields, Colum.class);
		downloadTable(colums, dg, response);
	}
	/**
	 * 跳转到添加BshootToSquare页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		BshootToSquare bshootToSquare = new BshootToSquare();
		bshootToSquare.setId(UUID.randomUUID().toString());
		return "/bshoottosquare/bshootToSquareAdd";
	}

	/**
	 * 添加BshootToSquare
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(BshootToSquare bshootToSquare) {
		Json j = new Json();		
		bshootToSquareService.add(bshootToSquare);
		j.setSuccess(true);
		j.setMsg("添加成功！");		
		return j;
	}

	/**
	 * 跳转到BshootToSquare查看页面
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view(HttpServletRequest request, String id) {
		BshootToSquare bshootToSquare = bshootToSquareService.get(id);
		request.setAttribute("bshootToSquare", bshootToSquare);
		return "/bshoottosquare/bshootToSquareView";
	}

	/**
	 * 跳转到BshootToSquare修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		BshootToSquare bshootToSquare = bshootToSquareService.get(id);
		request.setAttribute("bshootToSquare", bshootToSquare);
		return "/bshoottosquare/bshootToSquareEdit";
	}

	/**
	 * 修改BshootToSquare
	 * 
	 * @param bshootToSquare
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(BshootToSquare bshootToSquare) {
		Json j = new Json();		
		bshootToSquareService.edit(bshootToSquare);
		j.setSuccess(true);
		j.setMsg("编辑成功！");		
		return j;
	}

	/**
	 * 删除BshootToSquare
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id) {
		Json j = new Json();
		bshootToSquareService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}
