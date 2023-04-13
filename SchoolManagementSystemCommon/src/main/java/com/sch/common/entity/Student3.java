//package com.sch.common.entity;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Parameter;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//import jakarta.persistence.Transient;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "students")
//public class Student3 extends UserBasicInfo{
//
//	/*
//	 * @GeneratedValue(generator = "sequence-generator")
//	 * 
//	 * @GenericGenerator(name = "sequence-generator", strategy =
//	 * "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
//	 * 
//	 * @Parameter(name = "sequence_name", value = "student_admission_number"),
//	 * 
//	 * @Parameter(name= "initial_value", value = "4000"),
//	 * 
//	 * @Parameter(name = "increment_size", value = "1") } )
//	 */
//	@Column(name = "admission_number")
//	Long admissionNumber;
//	
//	@Column(name = "date_of_birth")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	Date dob;
//	
//	//@Column(name = "date_of_birth")
//	//Date dob;
//	
//	String religion;
//	
//	String caste;
//	
//	@Column(name = "home_town")
//	String homeTown;
//	
//	@Column(name = "ethnic_group")
//	String ethnicGroup;
//	
//	@Column(name = "registration_date")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	Date registrationDate;
//	
//	@ManyToOne
//	@JoinColumn(name = "lectureroom_id")
//	LectureRoom lectureRoom;
//	
//	@ManyToOne
//	@JoinColumn(name = "section_id")
//	Section section;
//	
//	String photo;
//	
//	@JoinColumn(name = "admission_date")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	Date admissionDate;
//	
//	@Enumerated(EnumType.STRING)
//	BloodGroup bloodGroup;
//	
//	@Enumerated(EnumType.STRING)
//	StudentCategory studentCategory;
//
//	@ManyToOne
//	@JoinColumn(name = "school_house_id")
//	SchoolHouse schoolHouse;
//	
//	/*
//	 * @OneToMany
//	 * 
//	 * @JoinColumn(name = "address_id") Address address;
//	 */
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "parentGuarduan_id")
//	ParentGuardian parentGuardian;
//	
//	public Student3(Integer id, Long admissionNumber, Date dob, String religion, String caste, String homeTown, String ethnicGroup,
//			Date registrationDate, LectureRoom lectureRoom, Section section, String photo, Date admissionDate,
//			BloodGroup bloodGroup, StudentCategory studentCategory, SchoolHouse schoolHouse,
//			ParentGuardian parentGuardian) {
//		this.id = id;
//		this.admissionNumber = admissionNumber;
//		this.dob = dob;
//		this.religion = religion;
//		this.caste = caste;
//		this.homeTown = homeTown;
//		this.ethnicGroup = ethnicGroup;
//		this.registrationDate = registrationDate;
//		this.lectureRoom = lectureRoom;
//		this.section = section;
//		this.photo = photo;
//		this.admissionDate = admissionDate;
//		this.bloodGroup = bloodGroup;
//		this.studentCategory = studentCategory;
//		this.schoolHouse = schoolHouse;
//		this.parentGuardian = parentGuardian;
//	}
//	 
//	public Student3(Long admissionNumber, Date dob, String religion, String caste, String homeTown, String ethnicGroup,
//			Date registrationDate, LectureRoom lectureRoom, Section section,Date admissionDate,
//			BloodGroup bloodGroup, StudentCategory studentCategory, SchoolHouse schoolHouse,
//			ParentGuardian parentGuardian) {
//		this.admissionNumber = admissionNumber;
//		this.dob = dob;
//		this.religion = religion;
//		this.caste = caste;
//		this.homeTown = homeTown;
//		this.ethnicGroup = ethnicGroup;
//		this.registrationDate = registrationDate;
//		this.lectureRoom = lectureRoom;
//		this.section = section;
//		this.admissionDate = admissionDate;
//		this.bloodGroup = bloodGroup;
//		this.studentCategory = studentCategory;
//		this.schoolHouse = schoolHouse;
//		this.parentGuardian = parentGuardian;
//	}
//	
//	/*
//	 * public void addParentGuardian(String fatherName, String fatherOccupation,
//	 * String fatherPhoneNumber, String motherName, String motherOccupation, String
//	 * motherPhoneNumber, String guardianName, String guardianRelation, String
//	 * guardianOccupation, String guardianEmail, String guardianPhoneNumber, String
//	 * guardianAddress, String isGuardianFatherMotherOther, String photo) {
//	 * 
//	 * this.parentGuardian.add(new ParentGuardian(fatherName, fatherOccupation,
//	 * fatherPhoneNumber, motherName, motherOccupation, motherPhoneNumber,
//	 * guardianName, guardianRelation, guardianOccupation, guardianEmail,
//	 * guardianPhoneNumber, guardianAddress, isGuardianFatherMotherOther, photo,
//	 * this)); }
//	 */
//
//
//	@Transient
//	public String getDobOnForm() {
//		DateFormat dateFomatter = new SimpleDateFormat("yyyy-MM-dd");
//		return dateFomatter.format(this.dob);
//	}
//	
//	//without this setter method you will get error on the date on the form
//	public void setDobOnForm(String dateString) {
//		DateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
//		
//		try {
//			this.dob = dateformatter.parse(dateString);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Transient
//	public String getAdmissionDateOnForm() {
//		DateFormat dateFomatter = new SimpleDateFormat("yyyy-MM-dd");
//		return dateFomatter.format(this.admissionDate);
//	}
//	
//	//without this setter method you will get error on the date on the form
//	public void setAdmissionDateOnForm(String dateString) {
//		DateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
//		
//		try {
//			this.admissionDate = dateformatter.parse(dateString);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Transient
//	public String getRegistrationDateOnForm() {
//		DateFormat dateFomatter = new SimpleDateFormat("yyyy-MM-dd");
//		return dateFomatter.format(this.registrationDate);
//	}
//	
//	//without this setter method you will get error on the date on the form
//	public void setRegistrationDateOnForm(String dateString) {
//		DateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
//		
//		try {
//			this.registrationDate = dateformatter.parse(dateString);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//	}
//
//	
//}
