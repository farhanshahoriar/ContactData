package com.farhanshahoriar.rwmydata.models;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class ContactData {
	@Id
	public ObjectId _id;
	  
	  public String name;
	  public String phone;
	  public String email;
	  public ContactData() {}
	  public ContactData(ObjectId _id, String name, String phone, String email) {
		super();
		this._id = _id;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String get_id() { return _id.toHexString(); }
	  public void set_id(ObjectId _id) { this._id = _id; }
	  
	  public String getName() { return name; }
	  public void setName(String name) { this.name = name; }
	  
	  
}

