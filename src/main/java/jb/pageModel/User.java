package jb.pageModel;

import java.util.Date;

import javax.persistence.Column;

import jb.util.PathUtil;

@SuppressWarnings("serial")
public class User implements java.io.Serializable {

	private String id;
	private String name;
	private String pwd;
	private Date createdatetime;
	private Date modifydatetime;

	private Date createdatetimeStart;
	private Date createdatetimeEnd;
	private Date modifydatetimeStart;
	private Date modifydatetimeEnd;

	private String roleIds;
	private String roleNames;

	private java.lang.String utype;	
	private java.lang.String thirdUser;	
	private java.lang.String headImage;	
	private java.lang.String nickname;	
	private java.lang.String areaCode;	
	private java.lang.String birthday;	
	private java.lang.String bardian;	
	private java.lang.String memberV;	
	
	private String attred; //是否被关注过
	
	private Boolean isStar;
	private Boolean isTarento;
	
	private String headImageAbsolute;	
	
	public Date getCreatedatetimeStart() {
		return createdatetimeStart;
	}

	public void setCreatedatetimeStart(Date createdatetimeStart) {
		this.createdatetimeStart = createdatetimeStart;
	}

	public Date getCreatedatetimeEnd() {
		return createdatetimeEnd;
	}

	public void setCreatedatetimeEnd(Date createdatetimeEnd) {
		this.createdatetimeEnd = createdatetimeEnd;
	}

	public Date getModifydatetimeStart() {
		return modifydatetimeStart;
	}

	public void setModifydatetimeStart(Date modifydatetimeStart) {
		this.modifydatetimeStart = modifydatetimeStart;
	}

	public Date getModifydatetimeEnd() {
		return modifydatetimeEnd;
	}

	public void setModifydatetimeEnd(Date modifydatetimeEnd) {
		this.modifydatetimeEnd = modifydatetimeEnd;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getCreatedatetime() {
		return createdatetime;
	}

	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}

	public Date getModifydatetime() {
		return modifydatetime;
	}

	public void setModifydatetime(Date modifydatetime) {
		this.modifydatetime = modifydatetime;
	}

	public java.lang.String getUtype() {
		return utype;
	}

	public void setUtype(java.lang.String utype) {
		this.utype = utype;
	}

	public java.lang.String getThirdUser() {
		return thirdUser;
	}

	public void setThirdUser(java.lang.String thirdUser) {
		this.thirdUser = thirdUser;
	}

	public java.lang.String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(java.lang.String headImage) {
		this.headImage = headImage;
	}

	public java.lang.String getNickname() {
		return nickname;
	}

	public void setNickname(java.lang.String nickname) {
		this.nickname = nickname;
	}

	public java.lang.String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(java.lang.String areaCode) {
		this.areaCode = areaCode;
	}

	public java.lang.String getBirthday() {
		return birthday;
	}

	public void setBirthday(java.lang.String birthday) {
		this.birthday = birthday;
	}

	public java.lang.String getBardian() {
		return bardian;
	}

	public void setBardian(java.lang.String bardian) {
		this.bardian = bardian;
	}

	public java.lang.String getMemberV() {
		return memberV;
	}

	public void setMemberV(java.lang.String memberV) {
		this.memberV = memberV;
	}

	public String getAttred() {
		return attred;
	}

	public void setAttred(String attred) {
		this.attred = attred;
	}

	public Boolean getIsStar() {
		return isStar;
	}

	public void setIsStar(Boolean isStar) {
		this.isStar = isStar;
	}

	public Boolean getIsTarento() {
		return isTarento;
	}

	public void setIsTarento(Boolean isTarento) {
		this.isTarento = isTarento;
	}

	public String getHeadImageAbsolute() {
		return PathUtil.getHeadImagePath(headImage);
	}	
	
}
