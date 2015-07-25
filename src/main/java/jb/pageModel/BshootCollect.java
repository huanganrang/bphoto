package jb.pageModel;

import java.util.Date;

public class BshootCollect implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private java.lang.String id;	
	private java.lang.String userId;	
	private java.lang.String bshootId;	
	private Date collectDatetime;			

	

	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}

	
	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}
	
	public java.lang.String getUserId() {
		return this.userId;
	}
	public void setBshootId(java.lang.String bshootId) {
		this.bshootId = bshootId;
	}
	
	public java.lang.String getBshootId() {
		return this.bshootId;
	}
	public void setCollectDatetime(Date collectDatetime) {
		this.collectDatetime = collectDatetime;
	}
	
	public Date getCollectDatetime() {
		return this.collectDatetime;
	}

}
