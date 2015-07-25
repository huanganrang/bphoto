
/*
 * @author John
 * @date - 2015-04-08
 */

package jb.model;

import javax.persistence.*;

import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@SuppressWarnings("serial")
@Entity
@Table(name = "user_message")
@DynamicInsert(true)
@DynamicUpdate(true)
public class TuserMessage implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "UserMessage";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USER_ID = "用户ID";
	public static final String ALIAS_UM_TYPE = "消息类型";
	public static final String ALIAS_UM_MESSAGE = "消息";
	public static final String ALIAS_UM_REMARK = "备注";
	public static final String ALIAS_CREATE_DATETIME = "创建时间";
	public static final String ALIAS_UPDATE_DATETIME = "修改时间";
	public static final String ALIAS_CREATE_PERSON = "创建人";
	public static final String ALIAS_UPDATE_PERSON = "修改人";
	
	//date formats
	//public static final String FORMAT_CREATE_DATETIME = DATE_FORMAT;
	//public static final String FORMAT_UPDATE_DATETIME = DATE_FORMAT;
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//@Length(max=36)
	private java.lang.String id;
	//@Length(max=36)
	private java.lang.String userId;
	//@Length(max=4)
	private java.lang.String umType;
	//@Length(max=512)
	private java.lang.String umMessage;
	//@Length(max=256)
	private java.lang.String umRemark;
	//
	private java.util.Date createDatetime;
	//
	private java.util.Date updateDatetime;
	//@Length(max=36)
	private java.lang.String createPerson;
	//@Length(max=36)
	private java.lang.String updatePerson;
	//columns END


		public TuserMessage(){
		}
		public TuserMessage(String id) {
			this.id = id;
		}
	

	public void setId(java.lang.String id) {
		this.id = id;
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 36)
	public java.lang.String getId() {
		return this.id;
	}
	
	@Column(name = "user_id", unique = false, nullable = true, insertable = true, updatable = true, length = 36)
	public java.lang.String getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}
	
	@Column(name = "um_type", unique = false, nullable = true, insertable = true, updatable = true, length = 4)
	public java.lang.String getUmType() {
		return this.umType;
	}
	
	public void setUmType(java.lang.String umType) {
		this.umType = umType;
	}
	
	@Column(name = "um_message", unique = false, nullable = true, insertable = true, updatable = true, length = 512)
	public java.lang.String getUmMessage() {
		return this.umMessage;
	}
	
	public void setUmMessage(java.lang.String umMessage) {
		this.umMessage = umMessage;
	}
	
	@Column(name = "um_remark", unique = false, nullable = true, insertable = true, updatable = true, length = 256)
	public java.lang.String getUmRemark() {
		return this.umRemark;
	}
	
	public void setUmRemark(java.lang.String umRemark) {
		this.umRemark = umRemark;
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
			.append("UserId",getUserId())
			.append("UmType",getUmType())
			.append("UmMessage",getUmMessage())
			.append("UmRemark",getUmRemark())
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
		if(obj instanceof UserMessage == false) return false;
		if(this == obj) return true;
		UserMessage other = (UserMessage)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}*/
}

