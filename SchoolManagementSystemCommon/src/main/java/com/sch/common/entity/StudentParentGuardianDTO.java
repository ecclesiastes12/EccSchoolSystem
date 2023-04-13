package com.sch.common.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentParentGuardianDTO {

	//final Student studentEntityObject;
	
	
	String firstName;
	
	String lastName;
	
	String otherName;
	
	Gender gender;
	
	String email;
	
	//String password;
	
	String phoneNumber;
	
	String height;
	
	String weight;

	Long admissionNumber;

	String religion;
	
	String caste;

	String homeTown;

	String ethnicGroup;

	Date registrationDate;

	LectureRoom lectureRoom;

	Section section;
	
	String studentPhoto;

	String getAdmissionDateOnForm;
	
	String getRegistrationDateOnForm;

	BloodGroup bloodGroup;

	StudentCategory studentCategory;

	SchoolHouse schoolHouse;
	
	String fatherName;
	
	String fatherOccupation;
	
	String fatherPhoneNumber;
	
	String motherName;
	
	String motherOccupation;
	
	String motherPhoneNumber;
	
	String guardianName;
	
	String guardianRelation;
	
	String guardianOccupation;
	
	String guardianEmail;
	
	String guardianPhoneNumber;
	
	String guardianAddress;
	
	String isGuardianFatherMotherOther;
	
	String photo;
	
	ParentGuardian parentGuardian;
	
	String getDobOnForm;
	
//	public StudentParentGuardianDTO(Student student) {
//		this.studentEntityObject = student;
//	}
	
//	public void addStudents(Student student ) {
//		this.student.add(student);
//	}
	
}
