
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
@Table(name = "bshoot")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Tbshoot implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Bshoot";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_BS_TITLE = "标题";
	public static final String ALIAS_BS_TOPIC = "主题";
	public static final String ALIAS_BS_ICON = "icon";
	public static final String ALIAS_BS_STREAM = "视频文件";
	public static final String ALIAS_BS_COLLECT = "收藏数";
	public static final String ALIAS_BS_PRAISE = "赞数";
	public static final String ALIAS_BS_TYPE = "类别";
	public static final String ALIAS_BS_COMMENT = "评论数";
	public static final String ALIAS_USER_ID = "用户ID";
	public static final String ALIAS_BS_DESCRIPTION = "描述";
	public static final String ALIAS_BS_REMARK = "备注";
	public static final String ALIAS_CREATE_DATETIME = "创建时间";
	public static final String ALIAS_UPDATE_DATETIME = "修改时间";
	public static final String ALIAS_CREATE_PERSON = "创建人";
	public static final String ALIAS_UPDATE_PERSON = "修改人";
	public static final String ALIAS_LG_X = "经度";
	public static final String ALIAS_LG_Y = "纬度";
	public static final String ALIAS_LG_NAME = "坐标地点";
	public static final String ALIAS_PARENT_ID = "转发ID";
	
	//date formats
	/*public static final String FORMAT_CREATE_DATETIME = DATE_FORMAT;
	public static final String FORMAT_UPDATE_DATETIME = DATE_FORMAT;*/
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//@Length(max=36)
	private java.lang.String id;
	//@NotBlank @Length(max=256)
	private java.lang.String bsTitle;
	//@Length(max=64)
	private java.lang.String bsTopic;
	//@Length(max=256)
	private java.lang.String bsIcon;
	//@Length(max=256)
	private java.lang.String bsStream;
	//
	private java.lang.Integer bsCollect;
	//
	private java.lang.Integer bsPraise;
	//@Length(max=4)
	private java.lang.String bsType;
	//@Length(max=10)
	private java.lang.String bsComment;
	//@Length(max=36)
	private java.lang.String userId;
	//@Length(max=512)
	private java.lang.String bsDescription;
	//@Length(max=256)
	private java.lang.String bsRemark;
	//
	private java.util.Date createDatetime;
	//
	private java.util.Date updateDatetime;
	//@Length(max=36)
	private java.lang.String createPerson;
	//@Length(max=36)
	private java.lang.String updatePerson;
	//columns END
	//@Length(max=18)
	private java.lang.String lgX;
	//@Length(max=18)
	private java.lang.String lgY;
	//@Length(max=36)
	private java.lang.String lgName;
	//@Length(max=36)
	private java.lang.String parentId;

		public Tbshoot(){
		}
		public Tbshoot(String id) {
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
	
	@Column(name = "bs_title", unique = false, nullable = false, insertable = true, updatable = true, length = 256)
	public java.lang.String getBsTitle() {
		return this.bsTitle;
	}
	
	public void setBsTitle(java.lang.String bsTitle) {
		this.bsTitle = bsTitle;
	}
	
	@Column(name = "bs_topic", unique = false, nullable = true, insertable = true, updatable = true, length = 64)
	public java.lang.String getBsTopic() {
		return this.bsTopic;
	}
	
	public void setBsTopic(java.lang.String bsTopic) {
		this.bsTopic = bsTopic;
	}
	
	@Column(name = "bs_icon", unique = false, nullable = true, insertable = true, updatable = true, length = 256)
	public java.lang.String getBsIcon() {
		return this.bsIcon;
	}
	
	public void setBsIcon(java.lang.String bsIcon) {
		this.bsIcon = bsIcon;
	}
	
	@Column(name = "bs_stream", unique = false, nullable = true, insertable = true, updatable = true, length = 256)
	public java.lang.String getBsStream() {
		return this.bsStream;
	}
	
	public void setBsStream(java.lang.String bsStream) {
		this.bsStream = bsStream;
	}
	
	@Column(name = "bs_collect", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getBsCollect() {
		return this.bsCollect;
	}
	
	public void setBsCollect(java.lang.Integer bsCollect) {
		this.bsCollect = bsCollect;
	}
	
	@Column(name = "bs_praise", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getBsPraise() {
		return this.bsPraise;
	}
	
	public void setBsPraise(java.lang.Integer bsPraise) {
		this.bsPraise = bsPraise;
	}
	
	@Column(name = "bs_type", unique = false, nullable = true, insertable = true, updatable = true, length = 4)
	public java.lang.String getBsType() {
		return this.bsType;
	}
	
	public void setBsType(java.lang.String bsType) {
		this.bsType = bsType;
	}
	
	@Column(name = "bs_comment", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.String getBsComment() {
		return this.bsComment;
	}
	
	public void setBsComment(java.lang.String bsComment) {
		this.bsComment = bsComment;
	}
	
	@Column(name = "user_id", unique = false, nullable = true, insertable = true, updatable = true, length = 36)
	public java.lang.String getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}
	
	@Column(name = "bs_description", unique = false, nullable = true, insertable = true, updatable = true, length = 512)
	public java.lang.String getBsDescription() {
		return this.bsDescription;
	}
	
	public void setBsDescription(java.lang.String bsDescription) {
		this.bsDescription = bsDescription;
	}
	
	@Column(name = "bs_remark", unique = false, nullable = true, insertable = true, updatable = true, length = 256)
	public java.lang.String getBsRemark() {
		return this.bsRemark;
	}
	
	public void setBsRemark(java.lang.String bsRemark) {
		this.bsRemark = bsRemark;
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
	
	@Column(name = "lg_x", unique = false, nullable = true, insertable = true, updatable = true, length = 18)
	public java.lang.String getLgX() {
		return this.lgX;
	}
	
	public void setLgX(java.lang.String lgX) {
		this.lgX = lgX;
	}
	
	@Column(name = "lg_y", unique = false, nullable = true, insertable = true, updatable = true, length = 18)
	public java.lang.String getLgY() {
		return this.lgY;
	}
	
	public void setLgY(java.lang.String lgY) {
		this.lgY = lgY;
	}
	
	@Column(name = "lg_name", unique = false, nullable = true, insertable = true, updatable = true, length = 36)
	public java.lang.String getLgName() {
		return this.lgName;
	}
	
	public void setLgName(java.lang.String lgName) {
		this.lgName = lgName;
	}
	
	@Column(name = "parent_id", unique = false, nullable = true, insertable = true, updatable = true, length = 36)
	public java.lang.String getParentId() {
		return this.parentId;
	}
	
	public void setParentId(java.lang.String parentId) {
		this.parentId = parentId;
	}
	/*
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("BsTitle",getBsTitle())
			.append("BsTopic",getBsTopic())
			.append("BsIcon",getBsIcon())
			.append("BsStream",getBsStream())
			.append("BsCollect",getBsCollect())
			.append("BsPraise",getBsPraise())
			.append("BsType",getBsType())
			.append("BsComment",getBsComment())
			.append("UserId",getUserId())
			.append("BsDescription",getBsDescription())
			.append("BsRemark",getBsRemark())
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
		if(obj instanceof Bshoot == false) return false;
		if(this == obj) return true;
		Bshoot other = (Bshoot)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}*/
}

