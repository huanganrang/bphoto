
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
@Table(name = "comment_praise")
@DynamicInsert(true)
@DynamicUpdate(true)
public class TcommentPraise implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "CommentPraise";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_COMMENT_ID = "评论ID";
	public static final String ALIAS_USER_ID = "用户ID";
	public static final String ALIAS_PRAISE_DATETIME = "praiseDatetime";
	
	//date formats
	public static final String FORMAT_PRAISE_DATETIME = Constants.DATE_FORMAT;
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//@Length(max=36)
	private java.lang.String id;
	//@NotBlank @Length(max=36)
	private java.lang.String commentId;
	//@NotBlank @Length(max=36)
	private java.lang.String userId;
	//
	private java.util.Date praiseDatetime;
	//columns END


		public TcommentPraise(){
		}
		public TcommentPraise(String id) {
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
	
	@Column(name = "comment_id", unique = false, nullable = false, insertable = true, updatable = true, length = 36)
	public java.lang.String getCommentId() {
		return this.commentId;
	}
	
	public void setCommentId(java.lang.String commentId) {
		this.commentId = commentId;
	}
	
	@Column(name = "user_id", unique = false, nullable = false, insertable = true, updatable = true, length = 36)
	public java.lang.String getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}
	

	@Column(name = "praise_datetime", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public java.util.Date getPraiseDatetime() {
		return this.praiseDatetime;
	}
	
	public void setPraiseDatetime(java.util.Date praiseDatetime) {
		this.praiseDatetime = praiseDatetime;
	}
	
	
	/*
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("CommentId",getCommentId())
			.append("UserId",getUserId())
			.append("PraiseDatetime",getPraiseDatetime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof CommentPraise == false) return false;
		if(this == obj) return true;
		CommentPraise other = (CommentPraise)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}*/
}

