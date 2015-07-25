package jb.pageModel;

import java.util.Date;

@SuppressWarnings("serial")
public class MessageCount implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private java.lang.String id;	
	private java.lang.String mtype;	
	private java.lang.String userId;	
	private java.lang.Integer mnumber;	

	

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
	public void setMnumber(java.lang.Integer mnumber) {
		this.mnumber = mnumber;
	}
	
	public java.lang.Integer getMnumber() {
		return this.mnumber;
	}

}
