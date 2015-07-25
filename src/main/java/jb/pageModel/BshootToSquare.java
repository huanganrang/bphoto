package jb.pageModel;

import java.util.Date;

@SuppressWarnings("serial")
public class BshootToSquare implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private java.lang.String id;	
	private java.lang.String bshootId;	
	private java.lang.String squareId;	
	private java.lang.String auditorId;	
	private Date auditorTime;			
	private java.lang.String reason;	
	private java.lang.String status;	

	

	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}

	
	public void setBshootId(java.lang.String bshootId) {
		this.bshootId = bshootId;
	}
	
	public java.lang.String getBshootId() {
		return this.bshootId;
	}
	public void setSquareId(java.lang.String squareId) {
		this.squareId = squareId;
	}
	
	public java.lang.String getSquareId() {
		return this.squareId;
	}
	public void setAuditorId(java.lang.String auditorId) {
		this.auditorId = auditorId;
	}
	
	public java.lang.String getAuditorId() {
		return this.auditorId;
	}
	public void setAuditorTime(Date auditorTime) {
		this.auditorTime = auditorTime;
	}
	
	public Date getAuditorTime() {
		return this.auditorTime;
	}
	public void setReason(java.lang.String reason) {
		this.reason = reason;
	}
	
	public java.lang.String getReason() {
		return this.reason;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}

}
