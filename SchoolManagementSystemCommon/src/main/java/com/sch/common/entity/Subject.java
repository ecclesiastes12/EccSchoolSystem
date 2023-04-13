package com.sch.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject extends IdBaseEntity{

	@Column(nullable = false, unique = true)
	String name;
	
	@Column(nullable = false, unique = true)
	String code;

	public Subject() {
		
	}

	public Subject(String name, String code) {super();
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
