package jb.util;

import java.text.SimpleDateFormat;

/**
 * @author huangzhi
 *
 */
public interface Constants {
	
	/**
	 * 系统发布环境：正式、开发、测试
	 */
	public static String SYSTEM_PUBLISH_SETTING = "SV004";
	
	/**
	 * 全局异常提示
	 */
	public static String SYSTEM_GLOBAL_MESSAGE = "EX0001";
	
	/**
	 * 短格式日期
	 */
	public static final SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 时分秒格式日期
	 */
	public static final SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	
	/**
	 * 日期格式
	 */
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 时分秒格式日期
	 */
	public static final SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * ID模式
	 */
	public static final SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmssS");
	
	/**
	 * 文件存储目录
	 */
	public static final String UPLOADFILE = "uploadfiles";
	
	/**
	 * 广场ICON 存储
	 */
	public static final String UPLOADFILE_SQUARE = "squarefiles";
	
	/**
	 * 存储头相
	 */
	public static final String UPLOADFILE_HEADIMAGE = "headimagefiles";
	
	/**
	 * 未登录状态
	 */
	public static final String GLOBAL_NOT_LOGIN = "-1";
	
	/**
	 * 布尔true
	 */
	public static final String GLOBAL_BOOLEAN_TRUE = "1";
	
	/**
	 * 布尔false
	 */
	public static final String GLOBAL_BOOLEAN_FALSE = "0";
}
