package jb.pageModel;

import java.util.Date;

@SuppressWarnings("serial")
public class DivePraise implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private java.lang.String id;	
	private java.lang.String businessId;	
	private java.lang.String businessType;	
	private Date addtime;			

	

	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}

	
	public void setBusinessId(java.lang.String businessId) {
		this.businessId = businessId;
	}
	
	public java.lang.String getBusinessId() {
		return this.businessId;
	}
	public void setBusinessType(java.lang.String businessType) {
		this.businessType = businessType;
	}
	
	public java.lang.String getBusinessType() {
		return this.businessType;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	
	public Date getAddtime() {
		return this.addtime;
	}

}
