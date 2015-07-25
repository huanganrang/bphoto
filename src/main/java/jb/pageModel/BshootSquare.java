package jb.pageModel;

import java.util.Date;

import jb.util.PathUtil;

public class BshootSquare implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private java.lang.String id;	
	private java.lang.String bssName;	
	private java.lang.String bssDescription;	
	private java.lang.String bssIcon;	
	private java.lang.String bssUserId;	
	private Date createDatetime;			
	private Date updateDatetime;			
	private java.lang.String createPerson;	
	private java.lang.String updatePerson;	
	private String bssType;
	private String bssIconAbsolute;
	

	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}

	
	public void setBssName(java.lang.String bssName) {
		this.bssName = bssName;
	}
	
	public java.lang.String getBssName() {
		return this.bssName;
	}
	public void setBssDescription(java.lang.String bssDescription) {
		this.bssDescription = bssDescription;
	}
	
	public java.lang.String getBssDescription() {
		return this.bssDescription;
	}
	public void setBssIcon(java.lang.String bssIcon) {
		this.bssIcon = bssIcon;
	}
	
	public java.lang.String getBssIcon() {
		return this.bssIcon;
	}
	public void setBssUserId(java.lang.String bssUserId) {
		this.bssUserId = bssUserId;
	}
	
	public java.lang.String getBssUserId() {
		return this.bssUserId;
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

	public String getBssType() {
		return bssType;
	}

	public void setBssType(String bssType) {
		this.bssType = bssType;
	}

	public String getBssIconAbsolute() {
		return PathUtil.getBshootSquarePath(bssIcon);
	}	
	
	
	
}
