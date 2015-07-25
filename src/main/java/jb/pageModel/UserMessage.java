package jb.pageModel;


public class UserMessage implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private java.lang.String id;	
	private java.lang.String userId;	
	private java.lang.String umType;	
	private java.lang.String umMessage;	
	private java.lang.String umRemark;	
	private String createDatetime;			
	private String updateDatetime;			
	private java.lang.String createPerson;	
	private java.lang.String updatePerson;	

	

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
	public void setUmType(java.lang.String umType) {
		this.umType = umType;
	}
	
	public java.lang.String getUmType() {
		return this.umType;
	}
	public void setUmMessage(java.lang.String umMessage) {
		this.umMessage = umMessage;
	}
	
	public java.lang.String getUmMessage() {
		return this.umMessage;
	}
	public void setUmRemark(java.lang.String umRemark) {
		this.umRemark = umRemark;
	}
	
	public java.lang.String getUmRemark() {
		return this.umRemark;
	}
	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}
	
	public String getCreateDatetime() {
		return this.createDatetime;
	}
	public void setUpdateDatetime(String updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
	
	public String getUpdateDatetime() {
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

}
