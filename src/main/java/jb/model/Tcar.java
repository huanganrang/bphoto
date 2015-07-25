
/*
 * @author John
 * @date - 2015-01-15
 */

package jb.model;

import javax.persistence.*;

import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@SuppressWarnings("serial")
@Entity
@Table(name = "car")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Tcar implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Car";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_NAME = "名称";
	public static final String ALIAS_CODE = "车牌号";
	public static final String ALIAS_USER_NAME = "司机名称";
	
	//date formats
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//@Length(max=32)
	private java.lang.String id;
	//@Length(max=32)
	private java.lang.String name;
	//@Length(max=32)
	private java.lang.String code;
	//@Length(max=32)
	private java.lang.String userName;
	//columns END


		public Tcar(){
		}
		public Tcar(String id) {
			this.id = id;
		}
	

	public void setId(java.lang.String id) {
		this.id = id;
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 32)
	public java.lang.String getId() {
		return this.id;
	}
	
	@Column(name = "name", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	@Column(name = "code", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setCode(java.lang.String code) {
		this.code = code;
	}
	
	@Column(name = "user_name", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getUserName() {
		return this.userName;
	}
	
	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}
	
	
	/*
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Name",getName())
			.append("Code",getCode())
			.append("UserName",getUserName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Car == false) return false;
		if(this == obj) return true;
		Car other = (Car)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}*/
}

