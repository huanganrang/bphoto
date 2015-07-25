package jb.pageModel;

import jb.util.PathUtil;

public class BshootPraiseExt extends BshootPraise {
	private static final long serialVersionUID = 5454155825314635342L;			
	@SuppressWarnings("unused")
	private String headImage;	
	private String nickname;	
	private String headImageAbsolute;
	@SuppressWarnings("unused")
	private String bsIcon;
	private String bsIconAbsolute;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeadImageAbsolute() {
		return PathUtil.getHeadImagePath(headImage);
	}
	public void setHeadImageAbsolute(String headImageAbsolute) {
		this.headImageAbsolute = headImageAbsolute;
	}
	public String getBsIconAbsolute() {
		return PathUtil.getBshootPath(bsIcon);
	}
	public void setBsIconAbsolute(String bsIconAbsolute) {
		this.bsIconAbsolute = bsIconAbsolute;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	public void setBsIcon(String bsIcon) {
		this.bsIcon = bsIcon;
	}	
	
}
