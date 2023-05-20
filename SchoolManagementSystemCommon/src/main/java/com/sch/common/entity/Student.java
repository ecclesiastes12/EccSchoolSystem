package com.sch.common.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student extends UserBasicInfo{

	/*
	 * @GeneratedValue(generator = "sequence-generator")
	 * 
	 * @GenericGenerator(name = "sequence-generator", strategy =
	 * "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
	 * 
	 * @Parameter(name = "sequence_name", value = "student_admission_number"),
	 * 
	 * @Parameter(name= "initial_value", value = "4000"),
	 * 
	 * @Parameter(name = "increment_size", value = "1") } )
	 */
	@Column(name = "admission_number", nullable = false)
	String admissionNumber;
	
	@Column(name = "date_of_birth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date dob;
	
	//@Column(name = "date_of_birth")
	//Date dob;
	
	String religion;
	
	String caste;
	
	@Column(name = "home_town")
	String homeTown;
	
	@Column(name = "ethnic_group")
	String ethnicGroup;
	
	@Column(name = "registration_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date registrationDate;
	
//	@ManyToOne(cascade = CascadeType.REMOVE)
//	@JoinColumn(name = "lectureroom_id")
//	LectureRoom lectureRoom;
	
	@ManyToMany
	@JoinTable(
			name="student_lectureroom",
			joinColumns = @JoinColumn(name="student_id"),
			inverseJoinColumns=@JoinColumn(name="lectureroom_id")
			)
	Set<LectureRoom> lectureRoom;
	
	@ManyToOne
	@JoinColumn(name = "section_id")
	Section section;
	
	@Column(length= 64)
	String photo;
	
	@JoinColumn(name = "admission_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date admissionDate;
	
	@Enumerated(EnumType.STRING)
	BloodGroup bloodGroup;
	
	@Enumerated(EnumType.STRING)
	StudentCategory studentCategory;

	@ManyToOne
	@JoinColumn(name = "school_house_id")
	SchoolHouse schoolHouse;
	
	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name = "address_id") Address address;
	 */
	
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	ParentGuardian parentGuardian;

	public Student(Integer id, String email) {
		this.id = id;
		this.email = email;
	}

	@Transient
	public String getDobOnForm() {
		DateFormat dateFomatter = new SimpleDateFormat("yyyy-MM-dd");
		return dateFomatter.format(this.dob);
	}
	
	//without this setter method you will get error on the date on the form
	public void setDobOnForm(String dateString) {
		DateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			this.dob = dateformatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Transient
	public String getAdmissionDateOnForm() {
		DateFormat dateFomatter = new SimpleDateFormat("yyyy-MM-dd");
		return dateFomatter.format(this.admissionDate);
	}
	
	//without this setter method you will get error on the date on the form
	public void setAdmissionDateOnForm(String dateString) {
		DateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			this.admissionDate = dateformatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Transient
	public String getRegistrationDateOnForm() {
		DateFormat dateFomatter = new SimpleDateFormat("yyyy-MM-dd");
		return dateFomatter.format(this.registrationDate);
	}
	
	//without this setter method you will get error on the date on the form
	public void setRegistrationDateOnForm(String dateString) {
		DateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			this.registrationDate = dateformatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Transient
	public String getFullName() {
		return firstName + " " + otherName + " " + lastName;
	}

	@Transient
	public String getStudentPhotoImagePath() {
		if(id == null || photo == null) return "/images/default-user.png";
		
		return "/student-photos/" + this.id + "/" + this.photo;
	}

//	@Override
//	public String toString() {
//		return "Student admissionNumber=" + admissionNumber ;
//	}

//	//method that add lectureroom to student
//	public void addLectureroom(LectureRoom lectureRoom) {
//		this.lectureRoom.add(lectureRoom);
//	}
	
}
