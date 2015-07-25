
/*
 * @author John
 * @date - 2015-05-30
 */

package jb.model;

import javax.persistence.*;

import java.util.Date;

import jb.util.Constants;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@SuppressWarnings("serial")
@Entity
@Table(name = "bshoot_to_square")
@DynamicInsert(true)
@DynamicUpdate(true)
public class TbshootToSquare implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "BshootToSquare";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_BSHOOT_ID = "视频";
	public static final String ALIAS_SQUARE_ID = "广场";
	public static final String ALIAS_AUDITOR_ID = "审核人";
	public static final String ALIAS_AUDITOR_TIME = "审核时间";
	public static final String ALIAS_REASON = "申请理由";
	public static final String ALIAS_STATUS = "申请状态";
	
	//date formats
	public static final String FORMAT_AUDITOR_TIME = Constants.DATE_FORMAT;
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//@Length(max=36)
	private java.lang.String id;
	//@Length(max=36)
	private java.lang.String bshootId;
	//@Length(max=4)
	private java.lang.String squareId;
	//@Length(max=36)
	private java.lang.String auditorId;
	//
	private java.util.Date auditorTime;
	//@Length(max=256)
	private java.lang.String reason;
	//@Length(max=4)
	private java.lang.String status;
	//columns END


		public TbshootToSquare(){
		}
		public TbshootToSquare(String id) {
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
	
	@Column(name = "bshoot_id", unique = false, nullable = true, insertable = true, updatable = true, length = 36)
	public java.lang.String getBshootId() {
		return this.bshootId;
	}
	
	public void setBshootId(java.lang.String bshootId) {
		this.bshootId = bshootId;
	}
	
	@Column(name = "square_id", unique = false, nullable = true, insertable = true, updatable = true, length = 4)
	public java.lang.String getSquareId() {
		return this.squareId;
	}
	
	public void setSquareId(java.lang.String squareId) {
		this.squareId = squareId;
	}
	
	@Column(name = "auditor_id", unique = false, nullable = true, insertable = true, updatable = true, length = 36)
	public java.lang.String getAuditorId() {
		return this.auditorId;
	}
	
	public void setAuditorId(java.lang.String auditorId) {
		this.auditorId = auditorId;
	}
	

	@Column(name = "auditor_Time", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public java.util.Date getAuditorTime() {
		return this.auditorTime;
	}
	
	public void setAuditorTime(java.util.Date auditorTime) {
		this.auditorTime = auditorTime;
	}
	
	@Column(name = "reason", unique = false, nullable = true, insertable = true, updatable = true, length = 256)
	public java.lang.String getReason() {
		return this.reason;
	}
	
	public void setReason(java.lang.String reason) {
		this.reason = reason;
	}
	
	@Column(name = "status", unique = false, nullable = true, insertable = true, updatable = true, length = 4)
	public java.lang.String getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	
	
	/*
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("BshootId",getBshootId())
			.append("SquareId",getSquareId())
			.append("AuditorId",getAuditorId())
			.append("AuditorTime",getAuditorTime())
			.append("Reason",getReason())
			.append("Status",getStatus())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BshootToSquare == false) return false;
		if(this == obj) return true;
		BshootToSquare other = (BshootToSquare)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}*/
}

