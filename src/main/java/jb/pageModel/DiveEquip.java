package jb.pageModel;

import java.util.Date;

@SuppressWarnings("serial")
public class DiveEquip implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private java.lang.String id;	
	private java.lang.String equipIcon;	
	private java.lang.String equipSumary;	
	private java.lang.String equipName;	
	private java.lang.String status;	
	private java.lang.String equipBrand;	
	private java.lang.String equipDes;	
	private Date addtime;			

	

	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}

	
	public void setEquipIcon(java.lang.String equipIcon) {
		this.equipIcon = equipIcon;
	}
	
	public java.lang.String getEquipIcon() {
		return this.equipIcon;
	}
	public void setEquipSumary(java.lang.String equipSumary) {
		this.equipSumary = equipSumary;
	}
	
	public java.lang.String getEquipSumary() {
		return this.equipSumary;
	}
	public void setEquipName(java.lang.String equipName) {
		this.equipName = equipName;
	}
	
	public java.lang.String getEquipName() {
		return this.equipName;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}
	public void setEquipBrand(java.lang.String equipBrand) {
		this.equipBrand = equipBrand;
	}
	
	public java.lang.String getEquipBrand() {
		return this.equipBrand;
	}
	public void setEquipDes(java.lang.String equipDes) {
		this.equipDes = equipDes;
	}
	
	public java.lang.String getEquipDes() {
		return this.equipDes;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	
	public Date getAddtime() {
		return this.addtime;
	}

}
