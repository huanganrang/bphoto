
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
@Table(name = "bshoot_collect")
@DynamicInsert(true)
@DynamicUpdate(true)
public class TbshootCollect implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "BshootCollect";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USER_ID = "用户ID";
	public static final String ALIAS_BSHOOT_ID = "视频";
	public static final String ALIAS_COLLECT_DATETIME = "收藏时间";
	
	//date formats
	//public static final String FORMAT_COLLECT_DATETIME = DATE_FORMAT;
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//@Length(max=36)
	private java.lang.String id;
	//@Length(max=36)
	private java.lang.String userId;
	//@Length(max=36)
	private java.lang.String bshootId;
	//
	private java.util.Date collectDatetime;
	//columns END


		public TbshootCollect(){
		}
		public TbshootCollect(String id) {
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
	
	@Column(name = "bshoot_id", unique = false, nullable = true, insertable = true, updatable = true, length = 36)
	public java.lang.String getBshootId() {
		return this.bshootId;
	}
	
	public void setBshootId(java.lang.String bshootId) {
		this.bshootId = bshootId;
	}
	

	@Column(name = "collect_datetime", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public java.util.Date getCollectDatetime() {
		return this.collectDatetime;
	}
	
	public void setCollectDatetime(java.util.Date collectDatetime) {
		this.collectDatetime = collectDatetime;
	}
	
	
	/*
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("UserId",getUserId())
			.append("BshootId",getBshootId())
			.append("CollectDatetime",getCollectDatetime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BshootCollect == false) return false;
		if(this == obj) return true;
		BshootCollect other = (BshootCollect)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}*/
}

