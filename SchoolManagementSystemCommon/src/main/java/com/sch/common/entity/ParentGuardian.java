package com.sch.common.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parent_guardian")
public class ParentGuardian extends IdBaseEntity{

	
	@Column(name = "father_name")
	String fatherName;
	
	@Column(name = "father_occupation")
	String fatherOccupation;
	
	@Column(name = "father_phone_number")
	String fatherPhoneNumber;
	
	@Column(name = "mother_name")
	String motherName;
	
	@Column(name = "mother_occupation")
	String motherOccupation;
	
	@Column(name = "mother_phone_number")
	String motherPhoneNumber;
	
	
	@Column(name = "guardian_name")
	String guardianName;
	
	
	@Column(name = "guardian_relation")
	String guardianRelation;
	
	@Column(name = "guardian_occupation")
	String guardianOccupation;
	
	@Column(name = "guardian_email",  length = 45, unique = true)
	String guardianEmail;
	
	
	@Column(name = "guardian_phone_number")
	String guardianPhoneNumber;
	
	@Column(name = "guardian_address")
	String guardianAddress;
	
	@Column(name = "guardian_father_mother_other")
	String isGuardianFatherMotherOther;
	
	String photo;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	Student student;
	
}
