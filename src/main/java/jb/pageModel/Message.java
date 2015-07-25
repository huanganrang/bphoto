package jb.pageModel;

import java.util.Date;

@SuppressWarnings("serial")
public class Message implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private java.lang.String id;	
	private java.lang.String mtype;	
	private java.lang.String userId;	
	private java.lang.Boolean isRead;	
	private java.lang.String relationId;	
	private java.lang.String content;	
	private Date createdatetime;			

	

	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}

	
	public void setMtype(java.lang.String mtype) {
		this.mtype = mtype;
	}
	
	public java.lang.String getMtype() {
		return this.mtype;
	}
	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}
	
	public java.lang.String getUserId() {
		return this.userId;
	}
	public void setIsRead(java.lang.Boolean isRead) {
		this.isRead = isRead;
	}
	
	public java.lang.Boolean getIsRead() {
		return this.isRead;
	}
	public void setRelationId(java.lang.String relationId) {
		this.relationId = relationId;
	}
	
	public java.lang.String getRelationId() {
		return this.relationId;
	}
	public void setContent(java.lang.String content) {
		this.content = content;
	}
	
	public java.lang.String getContent() {
		return this.content;
	}
	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}
	
	public Date getCreatedatetime() {
		return this.createdatetime;
	}

}
