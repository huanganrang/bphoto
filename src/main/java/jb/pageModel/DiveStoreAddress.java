package jb.pageModel;

import java.util.Date;

@SuppressWarnings("serial")
public class DiveStoreAddress implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private java.lang.String id;	
	private java.lang.String storeId;	
	private java.lang.String addressId;	
	private Date addtime;			

	

	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}

	
	public void setStoreId(java.lang.String storeId) {
		this.storeId = storeId;
	}
	
	public java.lang.String getStoreId() {
		return this.storeId;
	}
	public void setAddressId(java.lang.String addressId) {
		this.addressId = addressId;
	}
	
	public java.lang.String getAddressId() {
		return this.addressId;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	
	public Date getAddtime() {
		return this.addtime;
	}

}
