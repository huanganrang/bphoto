
/*
 * @author John
 * @date - 2015-04-26
 */

package jb.model;

import javax.persistence.*;

import java.util.Date;

import jb.util.Constants;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@SuppressWarnings("serial")
@Entity
@Table(name = "bshoot_square")
@DynamicInsert(true)
@DynamicUpdate(true)
public class TbshootSquare implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "BshootSquare";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_BSS_NAME = "名称";
	public static final String ALIAS_BSS_DESCRIPTION = "描述";
	public static final String ALIAS_BSS_ICON = "图标";
	public static final String ALIAS_BSS_USER_ID = "所有者";
	public static final String ALIAS_BSS_TYPE = "广场类型";
	public static final String ALIAS_CREATE_DATETIME = "createDatetime";
	public static final String ALIAS_UPDATE_DATETIME = "updateDatetime";
	public static final String ALIAS_CREATE_PERSON = "createPerson";
	public static final String ALIAS_UPDATE_PERSON = "updatePerson";
	
	//date formats
	public static final String FORMAT_CREATE_DATETIME = Constants.DATE_FORMAT;
	public static final String FORMAT_UPDATE_DATETIME = Constants.DATE_FORMAT;
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//@Length(max=4)
	private java.lang.String id;
	//@NotBlank @Length(max=64)
	private java.lang.String bssName;
	//@Length(max=256)
	private java.lang.String bssDescription;
	//@Length(max=256)
	private java.lang.String bssIcon;
	//@Length(max=36)
	private java.lang.String bssUserId;
	//
	private java.util.Date createDatetime;
	//
	private java.util.Date updateDatetime;
	//@Length(max=36)
	private java.lang.String createPerson;
	//@Length(max=36)
	private java.lang.String updatePerson;
	
	private String bssType;
	//columns END


		public TbshootSquare(){
		}
		public TbshootSquare(String id) {
			this.id = id;
		}
	

	public void setId(java.lang.String id) {
		this.id = id;
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 4)
	public java.lang.String getId() {
		return this.id;
	}
	
	@Column(name = "bss_name", unique = false, nullable = false, insertable = true, updatable = true, length = 64)
	public java.lang.String getBssName() {
		return this.bssName;
	}
	
	public void setBssName(java.lang.String bssName) {
		this.bssName = bssName;
	}
	
	@Column(name = "bss_description", unique = false, nullable = true, insertable = true, updatable = true, length = 256)
	public java.lang.String getBssDescription() {
		return this.bssDescription;
	}
	
	public void setBssDescription(java.lang.String bssDescription) {
		this.bssDescription = bssDescription;
	}
	
	@Column(name = "bss_icon", unique = false, nullable = true, insertable = true, updatable = true, length = 256)
	public java.lang.String getBssIcon() {
		return this.bssIcon;
	}
	
	public void setBssIcon(java.lang.String bssIcon) {
		this.bssIcon = bssIcon;
	}
	
	@Column(name = "bss_type", unique = false, nullable = true, insertable = true, updatable = true, length = 4)
	public String getBssType() {
		return bssType;
	}
	public void setBssType(String bssType) {
		this.bssType = bssType;
	}
	@Column(name = "bss_userId", unique = false, nullable = true, insertable = true, updatable = true, length = 36)
	public java.lang.String getBssUserId() {
		return this.bssUserId;
	}
	
	public void setBssUserId(java.lang.String bssUserId) {
		this.bssUserId = bssUserId;
	}
	

	@Column(name = "create_datetime", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public java.util.Date getCreateDatetime() {
		return this.createDatetime;
	}
	
	public void setCreateDatetime(java.util.Date createDatetime) {
		this.createDatetime = createDatetime;
	}
	

	@Column(name = "update_datetime", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public java.util.Date getUpdateDatetime() {
		return this.updateDatetime;
	}
	
	public void setUpdateDatetime(java.util.Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
	
	@Column(name = "create_person", unique = false, nullable = true, insertable = true, updatable = true, length = 36)
	public java.lang.String getCreatePerson() {
		return this.createPerson;
	}
	
	public void setCreatePerson(java.lang.String createPerson) {
		this.createPerson = createPerson;
	}
	
	@Column(name = "update_person", unique = false, nullable = true, insertable = true, updatable = true, length = 36)
	public java.lang.String getUpdatePerson() {
		return this.updatePerson;
	}
	
	public void setUpdatePerson(java.lang.String updatePerson) {
		this.updatePerson = updatePerson;
	}
	
	
	/*
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("BssName",getBssName())
			.append("BssDescription",getBssDescription())
			.append("BssIcon",getBssIcon())
			.append("BssUserId",getBssUserId())
			.append("CreateDatetime",getCreateDatetime())
			.append("UpdateDatetime",getUpdateDatetime())
			.append("CreatePerson",getCreatePerson())
			.append("UpdatePerson",getUpdatePerson())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BshootSquare == false) return false;
		if(this == obj) return true;
		BshootSquare other = (BshootSquare)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}*/
}

