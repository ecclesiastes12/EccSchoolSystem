package com.sch.common.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
	
	@Column(name = "guardian_email",  length = 45, nullable = true)
	String guardianEmail;
	
	
	@Column(name = "guardian_phone_number")
	String guardianPhoneNumber;
	
	@Column(name = "guardian_address")
	String guardianAddress;
	
	@Enumerated(EnumType.STRING)
	IsGuradianFatherOrMotherOrOther isGuardianFatherMotherOther;
	
	String fatherPhoto;
	
	String motherPhoto;
	
	String guardianPhoto;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	Student student;
	
	@Transient
	public String getFatherPhotoImagePath() {
		if(id == null || fatherPhoto == null) return "/images/default-user.png";
		
		return "/father-photos/" + this.id + "/" + this.fatherPhoto;
	}
	
	@Transient
	public String getMotherPhotoImagePath() {
		if(id == null || motherPhoto == null) return "/images/default-user.png";
		
		return "/mother-photos/" + this.id + "/" + this.motherPhoto;
	}
	
	@Transient
	public String getGuardianPhotoImagePath() {
		if(id == null || guardianPhoto == null) return "/images/default-user.png";
		
		return "/guardian-photos/" + this.id + "/" + this.guardianPhoto;
	}
}
