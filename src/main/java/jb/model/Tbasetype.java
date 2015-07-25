package jb.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@SuppressWarnings("serial")
@Entity
@Table(name = "tbasetype")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Tbasetype implements java.io.Serializable{
	
	private String code;
	private String name;
	private Integer type;
	private Set<Tbasedata> tbasedata = new HashSet<Tbasedata>(0);
	@Id
	@Column(name = "code", unique = true, nullable = false, length = 2)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Column(name = "NAME",nullable = false, length = 100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "type",nullable = false, length = 2)
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "baseType")
	public Set<Tbasedata> getTbasedata() {
		return tbasedata;
	}
	public void setTbasedata(Set<Tbasedata> tbasedata) {
		this.tbasedata = tbasedata;
	}	
	
}
