package com.billing.entity;

public class Billdata {
	int meter_no;
	String month;
	int unit;
	double amount;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Billdata() {

	}

	public Billdata(int meter_no, String month, int unit) {
		super();
		this.meter_no = meter_no;
		this.month = month;
		this.unit = unit;
	}

	public int getMeter_no() {
		return meter_no;
	}

	public void setMeter_no(int meter_no) {
		this.meter_no = meter_no;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

}
