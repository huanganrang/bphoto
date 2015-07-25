package jb.pageModel;

import java.util.Date;

@SuppressWarnings("serial")
public class DiveAccount implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private java.lang.String id;	
	private java.lang.String userName;	
	private java.lang.String password;	
	private java.lang.String icon;	
	private java.lang.String nickname;	
	private java.lang.String sex;	
	private java.lang.String city;	
	private java.lang.String personality;	
	private java.lang.String email;	
	private Date addtime;			

	

	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}

	
	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}
	
	public java.lang.String getUserName() {
		return this.userName;
	}
	public void setPassword(java.lang.String password) {
		this.password = password;
	}
	
	public java.lang.String getPassword() {
		return this.password;
	}
	public void setIcon(java.lang.String icon) {
		this.icon = icon;
	}
	
	public java.lang.String getIcon() {
		return this.icon;
	}
	public void setNickname(java.lang.String nickname) {
		this.nickname = nickname;
	}
	
	public java.lang.String getNickname() {
		return this.nickname;
	}
	public void setSex(java.lang.String sex) {
		this.sex = sex;
	}
	
	public java.lang.String getSex() {
		return this.sex;
	}
	public void setCity(java.lang.String city) {
		this.city = city;
	}
	
	public java.lang.String getCity() {
		return this.city;
	}
	public void setPersonality(java.lang.String personality) {
		this.personality = personality;
	}
	
	public java.lang.String getPersonality() {
		return this.personality;
	}
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	
	public java.lang.String getEmail() {
		return this.email;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	
	public Date getAddtime() {
		return this.addtime;
	}

}
