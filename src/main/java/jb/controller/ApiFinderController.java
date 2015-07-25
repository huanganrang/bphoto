package jb.controller;

import java.util.HashMap;
import java.util.Map;

import jb.interceptors.TokenManage;
import jb.pageModel.BshootSquare;
import jb.pageModel.DataGrid;
import jb.pageModel.Json;
import jb.pageModel.PageHelper;
import jb.pageModel.User;
import jb.service.BshootCollectServiceI;
import jb.service.BshootServiceI;
import jb.service.BshootSquareServiceI;
import jb.service.UserAttentionServiceI;
import jb.service.UserServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * finder发现模块接口
 * 
 * @author John
 * 
 */
@Controller
@RequestMapping("/api/apiFinderController")
public class ApiFinderController extends BaseController {
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
	private BshootSquareServiceI bshootSquareService;
	
	
	/**
	 * 热门视频
	 * @param ph
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/hotBshoot")
	public DataGrid hotBshoot(PageHelper ph) {
		ph.setOrder("desc");
		ph.setSort("bsPraise");
		DataGrid dg = bshootService.dataGridHot(ph);
		return dg;
	}	
	
	/**
	 * 附近视频
	 * @param ph
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/nearbyBshoot")
	public DataGrid nearbyBshoot(PageHelper ph,String lg_x,String lg_y) {
		DataGrid dg = bshootService.dataGridNearby(ph,lg_x,lg_y);
		return dg;
	}	
	
	/**
	 * 根据广场code获取视频信息
	 * @param ph
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBshootByCode")
	public DataGrid getBshootByCode(PageHelper ph,String id) {
		ph.setOrder("desc");
		ph.setSort("bsPraise");
		DataGrid dg = bshootService.dataGridByCode(ph, id);
		return dg;
	}	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping("/getBshootSquareDetail")
	public Json getBshootSquareDetail(String id) {
		Json j = new Json();
		Map map = new HashMap();
		BshootSquare bs = bshootSquareService.get(id);
		User user = userService.get(bs.getBssUserId());
		map.put("square", bs);
		map.put("user", user);
		j.setObj(map);
		j.success();
		return j;
	}	
	
	
	/**
	 * 广场列表
	 * @param bshootSquare
	 * @param ph
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/bshootSquare")
	public DataGrid bshootSquare(BshootSquare bshootSquare,PageHelper ph) {
		bshootSquare.setBssType("BT02");
		DataGrid dg = bshootSquareService.dataGrid(bshootSquare, ph);
		return dg;
	}
	
	/**
	 * 广场话题列表
	 * @param bshootSquare
	 * @param ph
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/bshootSquareTopic")
	public DataGrid bshootSquareTopic(BshootSquare bshootSquare,PageHelper ph) {
		bshootSquare.setBssType("BT01");
		DataGrid dg = bshootSquareService.dataGrid(bshootSquare, ph);
		return dg;
	}
}
