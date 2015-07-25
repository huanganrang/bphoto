package jb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@SuppressWarnings("serial")
@Entity
@Table(name = "tbasedata")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Tbasedata implements java.io.Serializable{
	
	private String id;
	private String pid;
	private String name;
	private Integer seq;
	private Tbasetype baseType;
	private String description;
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	@Column(name = "NAME",nullable = false, length = 100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "SEQ",length = 10)
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "basetype_code",nullable = false)
	public Tbasetype getBaseType() {
		return baseType;
	}
	public void setBaseType(Tbasetype baseType) {
		this.baseType = baseType;
	}
	@Column(name = "description", length = 256)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	
}
