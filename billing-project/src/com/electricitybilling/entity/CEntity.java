package com.electricitybilling.entity;

public class CEntity {
	String name;
	int meter_no;
	String address;
	String state;
	String city;
	String phone_no;
	public CEntity() {
		}
	public CEntity(String name, int meter_no, String address, String state, String city, String phone_no) {
		super();
		this.name = name;
		this.meter_no = meter_no;
		this.address = address;
		this.state = state;
		this.city = city;
		this.phone_no = phone_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMeter_no() {
		return meter_no;
	}
	public void setMeter_no(int meter_no) {
		this.meter_no = meter_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	
	

}
