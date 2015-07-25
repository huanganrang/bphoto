package jb.pageModel;

import java.util.Date;

public class UserAttention implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private java.lang.String id;	
	private java.lang.String userId;	
	private java.lang.String attUserId;	
	private Date attentionDatetime;			

	

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
	public void setAttUserId(java.lang.String attUserId) {
		this.attUserId = attUserId;
	}
	
	public java.lang.String getAttUserId() {
		return this.attUserId;
	}
	public void setAttentionDatetime(Date attentionDatetime) {
		this.attentionDatetime = attentionDatetime;
	}
	
	public Date getAttentionDatetime() {
		return this.attentionDatetime;
	}

}
