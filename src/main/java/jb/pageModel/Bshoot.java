package jb.pageModel;

import java.util.Date;

import jb.util.PathUtil;

public class Bshoot implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private java.lang.String id;	
	private java.lang.String bsTitle;	
	private java.lang.String bsTopic;	
	private java.lang.String bsIcon;	
	private java.lang.String bsStream;	
	private java.lang.Integer bsCollect;	
	private java.lang.Integer bsPraise;	
	private java.lang.String bsType;	
	private java.lang.String bsComment;	
	private java.lang.String userId;	
	private String userHeadImage;
	
	private String userHeadImageAbsolute;
	private java.lang.String bsIconAbsolute;	
	private java.lang.String bsStreamAbsolute;	
	
	private java.lang.String bsDescription;	
	private java.lang.String bsRemark;	
	private Date createDatetime;			
	private Date updateDatetime;			
	private java.lang.String createPerson;	
	private java.lang.String updatePerson;	
	private java.lang.String lgX;	
	private java.lang.String lgY;	
	private java.lang.String lgName;	
	private java.lang.String parentId;
	private double distance; //距离
	private String praised; //是否赞过
	

	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}

	
	public void setBsTitle(java.lang.String bsTitle) {
		this.bsTitle = bsTitle;
	}
	
	public java.lang.String getBsTitle() {
		return this.bsTitle;
	}
	public void setBsTopic(java.lang.String bsTopic) {
		this.bsTopic = bsTopic;
	}
	
	public java.lang.String getBsTopic() {
		return this.bsTopic;
	}
	public void setBsIcon(java.lang.String bsIcon) {
		this.bsIcon = bsIcon;
	}
	
	public java.lang.String getBsIcon() {
		return this.bsIcon;
	}
	public void setBsStream(java.lang.String bsStream) {
		this.bsStream = bsStream;
	}
	
	public java.lang.String getBsStream() {
		return this.bsStream;
	}
	public void setBsCollect(java.lang.Integer bsCollect) {
		this.bsCollect = bsCollect;
	}
	
	public java.lang.Integer getBsCollect() {
		return this.bsCollect;
	}
	public void setBsPraise(java.lang.Integer bsPraise) {
		this.bsPraise = bsPraise;
	}
	
	public java.lang.Integer getBsPraise() {
		return this.bsPraise;
	}
	public void setBsType(java.lang.String bsType) {
		this.bsType = bsType;
	}
	
	public java.lang.String getBsType() {
		return this.bsType;
	}
	public void setBsComment(java.lang.String bsComment) {
		this.bsComment = bsComment;
	}
	
	public java.lang.String getBsComment() {
		return this.bsComment;
	}
	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}
	
	public java.lang.String getUserId() {
		return this.userId;
	}
	public void setBsDescription(java.lang.String bsDescription) {
		this.bsDescription = bsDescription;
	}
	
	public java.lang.String getBsDescription() {
		return this.bsDescription;
	}
	public void setBsRemark(java.lang.String bsRemark) {
		this.bsRemark = bsRemark;
	}
	
	public java.lang.String getBsRemark() {
		return this.bsRemark;
	}
	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}
	
	public Date getCreateDatetime() {
		return this.createDatetime;
	}
	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
	
	public Date getUpdateDatetime() {
		return this.updateDatetime;
	}
	public void setCreatePerson(java.lang.String createPerson) {
		this.createPerson = createPerson;
	}
	
	public java.lang.String getCreatePerson() {
		return this.createPerson;
	}
	public void setUpdatePerson(java.lang.String updatePerson) {
		this.updatePerson = updatePerson;
	}
	
	public java.lang.String getUpdatePerson() {
		return this.updatePerson;
	}
	public void setLgX(java.lang.String lgX) {
		this.lgX = lgX;
	}
	
	public java.lang.String getLgX() {
		return this.lgX;
	}
	public void setLgY(java.lang.String lgY) {
		this.lgY = lgY;
	}
	
	public java.lang.String getLgY() {
		return this.lgY;
	}
	public void setLgName(java.lang.String lgName) {
		this.lgName = lgName;
	}
	
	public java.lang.String getLgName() {
		return this.lgName;
	}
	public void setParentId(java.lang.String parentId) {
		this.parentId = parentId;
	}
	
	public java.lang.String getParentId() {
		return this.parentId;
	}

	public String getUserHeadImage() {
		return userHeadImage;
	}

	public void setUserHeadImage(String userHeadImage) {
		this.userHeadImage = userHeadImage;
	}

	public String getPraised() {
		return praised;
	}

	public void setPraised(String praised) {
		this.praised = praised;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getUserHeadImageAbsolute() {
		return PathUtil.getHeadImagePath(userHeadImage);
	}

	public java.lang.String getBsIconAbsolute() {
		return PathUtil.getBshootPath(bsIcon);
	}

	public java.lang.String getBsStreamAbsolute() {
		return PathUtil.getBshootPath(bsStream);
	}

	
	
	
}
