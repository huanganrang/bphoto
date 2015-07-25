package jb.pageModel;


public class Car implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private java.lang.String id;	
	private java.lang.String name;	
	private java.lang.String code;	
	private java.lang.String userName;	

	

	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}

	
	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setCode(java.lang.String code) {
		this.code = code;
	}
	
	public java.lang.String getCode() {
		return this.code;
	}
	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}
	
	public java.lang.String getUserName() {
		return this.userName;
	}

}
