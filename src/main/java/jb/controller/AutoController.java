package jb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jb.absx.UUID;
import jb.pageModel.Json;
import jb.pageModel.Resource;
import jb.pageModel.SessionInfo;
import jb.service.ResourceServiceI;
import jb.service.ResourceTypeServiceI;
import jb.util.ConfigUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自动化开发管理控制器
 * 
 * @author John
 * 
 */
@Controller
@RequestMapping("/autoController")
public class AutoController extends BaseController {

	@Autowired
	private ResourceServiceI resourceService;

	@Autowired
	private ResourceTypeServiceI resourceTypeService;

	/**
	 * 跳转到自动化开发管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/admin/autodev";
	}

	

	/**
	 * 添加资源配置
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(HttpServletRequest request, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		String tableName = request.getParameter("tableName");
		String tableLabel = request.getParameter("tableLabel");
		Json j = new Json();
		//菜单
		Resource p = new Resource();
		p.setId(UUID.uuid());
		p.setName(tableLabel+"管理");
		p.setSeq(100);
		p.setUrl("/"+tableName+"Controller/manager");
		p.setTypeId("0");
		resourceService.add(p, sessionInfo);
		
		Resource son = new Resource();
		son.setId(UUID.uuid());
		son.setName(tableLabel+"列表查询");
		son.setSeq(5);
		son.setUrl("/"+tableName+"Controller/dataGrid");
		son.setTypeId("1");
		son.setPid(p.getId());		
		resourceService.add(son, sessionInfo);
		
		Resource son1 = new Resource();
		son1.setId(UUID.uuid());
		son1.setName("添加"+tableLabel+"页面");
		son1.setSeq(10);
		son1.setUrl("/"+tableName+"Controller/addPage");
		son1.setTypeId("1");
		son1.setPid(p.getId());		
		resourceService.add(son1, sessionInfo);
		
		
		Resource son2 = new Resource();
		son2.setId(UUID.uuid());
		son2.setName("添加"+tableLabel);
		son2.setSeq(15);
		son2.setUrl("/"+tableName+"Controller/add");
		son2.setTypeId("1");
		son2.setPid(p.getId());		
		resourceService.add(son2, sessionInfo);
		
		Resource son3 = new Resource();
		son3.setId(UUID.uuid());
		son3.setName("修改"+tableLabel+"页面");
		son3.setSeq(20);
		son3.setUrl("/"+tableName+"Controller/editPage");
		son3.setTypeId("1");
		son3.setPid(p.getId());		
		resourceService.add(son3, sessionInfo);
		
		Resource son4 = new Resource();
		son4.setId(UUID.uuid());
		son4.setName("修改"+tableLabel+"页面");
		son4.setSeq(25);
		son4.setUrl("/"+tableName+"Controller/edit");
		son4.setTypeId("1");
		son4.setPid(p.getId());		
		resourceService.add(son4, sessionInfo);
		
		Resource son5 = new Resource();
		son5.setId(UUID.uuid());
		son5.setName("删除"+tableLabel);
		son5.setSeq(30);
		son5.setUrl("/"+tableName+"Controller/delete");
		son5.setTypeId("1");
		son5.setPid(p.getId());		
		resourceService.add(son5, sessionInfo);
		
		
		Resource son6 = new Resource();
		son6.setId(UUID.uuid());
		son6.setName("查看"+tableLabel);
		son6.setSeq(35);
		son6.setUrl("/"+tableName+"Controller/view");
		son6.setTypeId("1");
		son6.setPid(p.getId());		
		resourceService.add(son6, sessionInfo);
		
		Resource son7 = new Resource();
		son7.setId(UUID.uuid());
		son7.setName("下载"+tableLabel);
		son7.setSeq(40);
		son7.setUrl("/"+tableName+"Controller/download");
		son7.setTypeId("1");
		son7.setPid(p.getId());		
		resourceService.add(son7, sessionInfo);
		
		j.setSuccess(true);
		j.setMsg("添加成功！");
		
		return j;
	}


}
