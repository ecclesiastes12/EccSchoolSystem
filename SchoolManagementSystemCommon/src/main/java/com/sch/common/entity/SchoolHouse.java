package com.sch.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "school_house")
public class SchoolHouse extends IdBaseEntity{

	String name;
	
	String description;

	public SchoolHouse() {
	}

	public SchoolHouse(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
