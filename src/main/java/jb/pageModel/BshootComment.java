package jb.pageModel;

import java.util.Date;

public class BshootComment implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private java.lang.String id;	
	private java.lang.String userId;	
	private java.lang.String bshootId;	
	private java.lang.String parentId;	
	private java.lang.String bsCommentText;	
	private Date commentDatetime;			
	private java.lang.Integer commentPraise;
	

	private String praised; //是否赞过

	

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
	public void setParentId(java.lang.String parentId) {
		this.parentId = parentId;
	}
	
	public java.lang.String getParentId() {
		return this.parentId;
	}
	public void setBsCommentText(java.lang.String bsCommentText) {
		this.bsCommentText = bsCommentText;
	}
	
	public java.lang.String getBsCommentText() {
		return this.bsCommentText;
	}
	public void setCommentDatetime(Date commentDatetime) {
		this.commentDatetime = commentDatetime;
	}
	
	public Date getCommentDatetime() {
		return this.commentDatetime;
	}

	public java.lang.Integer getCommentPraise() {
		return commentPraise;
	}

	public void setCommentPraise(java.lang.Integer commentPraise) {
		this.commentPraise = commentPraise;
	}

	public String getPraised() {
		return praised;
	}

	public void setPraised(String praised) {
		this.praised = praised;
	}
	
	

}
