package jb.util;

import jb.absx.F;
import jb.listener.Application;

public abstract class PathUtil {
	public static String getBathPath(){
		return Application.getString("SV200");
	}
	
	public static String getBshootPath(String dbPath){
		if(F.empty(dbPath))return null;
		return getBathPath()+"/"+Constants.UPLOADFILE+"/"+dbPath;
	}
	
	public static String getHeadImagePath(String dbPath){
		if(F.empty(dbPath))return null;
		return getBathPath()+"/"+dbPath;
	}
	
	public static String getBshootSquarePath(String dbPath){
		if(F.empty(dbPath))return null;
		return getBathPath()+"/"+Constants.UPLOADFILE_SQUARE+"/"+dbPath;
	}
	
}
