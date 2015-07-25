
/*
 * @author John
 * @date - 2015-04-08
 */

package jb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "user_attention")
@DynamicInsert(true)
@DynamicUpdate(true)
public class TuserAttention implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "UserAttention";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USER_ID = "关注人";
	public static final String ALIAS_ATT_USER_ID = "被关注人";
	public static final String ALIAS_ATTENTION_DATETIME = "时间";
	
	//date formats
	//public static final String FORMAT_ATTENTION_DATETIME = DATE_FORMAT;
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//@Length(max=36)
	private java.lang.String id;
	//@Length(max=36)
	private java.lang.String userId;
	//@Length(max=36)
	private java.lang.String attUserId;
	//
	private java.util.Date attentionDatetime;
	//columns END


		public TuserAttention(){
		}
		public TuserAttention(String id) {
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
	
	@Column(name = "att_user_id", unique = false, nullable = true, insertable = true, updatable = true, length = 36)
	public java.lang.String getAttUserId() {
		return this.attUserId;
	}
	
	public void setAttUserId(java.lang.String attUserId) {
		this.attUserId = attUserId;
	}
	

	@Column(name = "attention_datetime", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public java.util.Date getAttentionDatetime() {
		return this.attentionDatetime;
	}
	
	public void setAttentionDatetime(java.util.Date attentionDatetime) {
		this.attentionDatetime = attentionDatetime;
	}
	
	
	/*
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("UserId",getUserId())
			.append("AttUserId",getAttUserId())
			.append("AttentionDatetime",getAttentionDatetime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof UserAttention == false) return false;
		if(this == obj) return true;
		UserAttention other = (UserAttention)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}*/
}

