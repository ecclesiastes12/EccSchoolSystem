package com.sch.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Addresses")
public class Address extends IdBaseEntity{

	@Column(name = "address_line_1")
	String addressLine1;
	
	@Column(name = "address_line-2")
	String addressLine2;
	
	@Column(name = "phone_number")
	String phoneNumber;
	
	
	
	public Address() {
	}
	
	public Address(String addressLine1, String addressLine2, String phoneNumber) {
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.phoneNumber = phoneNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
