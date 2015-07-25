package jb.pageModel;

import java.util.Date;

public class CommentPraise implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private java.lang.String id;	
	private java.lang.String commentId;	
	private java.lang.String userId;	
	private Date praiseDatetime;	

	


	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}

	
	public void setCommentId(java.lang.String commentId) {
		this.commentId = commentId;
	}
	
	public java.lang.String getCommentId() {
		return this.commentId;
	}
	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}
	
	public java.lang.String getUserId() {
		return this.userId;
	}
	public void setPraiseDatetime(Date praiseDatetime) {
		this.praiseDatetime = praiseDatetime;
	}
	
	public Date getPraiseDatetime() {
		return this.praiseDatetime;
	}

}
