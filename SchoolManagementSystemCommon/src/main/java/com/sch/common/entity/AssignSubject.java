package com.sch.common.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "assign_subjects")
public class AssignSubject extends IdBaseEntity{
	
	@ManyToOne
	@JoinColumn(name = "subject_id")
	Subject subjects;
	
	@ManyToOne
	@JoinColumn(name = "staff_id")
	Staff staffs;
	
	public AssignSubject() {}

	public AssignSubject(Subject subjects, Staff staffs) {
		
		this.subjects = subjects;
		this.staffs = staffs;
	}
	
	

	
	public AssignSubject(String[] subjects, String[] staffs) {
		List<Subject> subj = new ArrayList<>();
			
	}
	 

	public Subject getSubjects() {
		return subjects;
	}
	
	public void setSubjects(Subject subjects) {
		this.subjects = subjects;
	}

	public Staff getStaffs() {
		return staffs;
	}

	public void setStaffs(Staff staffs) {
		this.staffs = staffs;
	}


	
	
	
}
