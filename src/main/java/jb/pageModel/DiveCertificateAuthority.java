package jb.pageModel;

import java.util.Date;

@SuppressWarnings("serial")
public class DiveCertificateAuthority implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private java.lang.String id;	
	private java.lang.String orgCode;	
	private java.lang.String levelCode;	
	private Date authDate;			
	private java.lang.String reverseSide;	
	private java.lang.String rightSide;	
	private Date auditDate;			
	private java.lang.String status;	
	private Date addtime;			

	

	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}

	
	public void setOrgCode(java.lang.String orgCode) {
		this.orgCode = orgCode;
	}
	
	public java.lang.String getOrgCode() {
		return this.orgCode;
	}
	public void setLevelCode(java.lang.String levelCode) {
		this.levelCode = levelCode;
	}
	
	public java.lang.String getLevelCode() {
		return this.levelCode;
	}
	public void setAuthDate(Date authDate) {
		this.authDate = authDate;
	}
	
	public Date getAuthDate() {
		return this.authDate;
	}
	public void setReverseSide(java.lang.String reverseSide) {
		this.reverseSide = reverseSide;
	}
	
	public java.lang.String getReverseSide() {
		return this.reverseSide;
	}
	public void setRightSide(java.lang.String rightSide) {
		this.rightSide = rightSide;
	}
	
	public java.lang.String getRightSide() {
		return this.rightSide;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	
	public Date getAuditDate() {
		return this.auditDate;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	
	public Date getAddtime() {
		return this.addtime;
	}

}
