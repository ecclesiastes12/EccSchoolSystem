package com.sch.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Section extends IdBaseEntity{

	@Column(nullable = false, unique = true)
	String name;
	
	public Section() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	
}
