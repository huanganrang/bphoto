package jb.interceptors;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jb.pageModel.SessionInfo;
import jb.util.ConfigUtil;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 权限拦截器
 * 
 * @author John
 * 
 */
public class TokenInterceptor implements HandlerInterceptor {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(TokenInterceptor.class);

	private List<String> excludeUrls;// 不需要拦截的资源

	private List<String> tokenUrls;  //tocken认证资源
	
	private TokenManage tokenManage;
	
	public List<String> getTokenUrls() {
		return tokenUrls;
	}

	public void setTokenUrls(List<String> tokenUrls) {
		this.tokenUrls = tokenUrls;
	}

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	/**
	 * 完成页面的render后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {

	}

	/**
	 * 在调用controller具体方法后拦截
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在调用controller具体方法前拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		

		if (url.indexOf("/baseController/") > -1 || excludeUrls.contains(url)) {// 如果要访问的资源是不需要验证的
			return true;
		}
		String tokenId = request.getParameter(TokenManage.TOKEN_FIELD);			
		return tokenManage.validToken(tokenId);
	}

	public void setTokenManage(TokenManage tokenManage) {
		this.tokenManage = tokenManage;
	}
	
}
