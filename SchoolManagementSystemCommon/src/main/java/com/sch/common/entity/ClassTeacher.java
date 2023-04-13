package com.sch.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "class_teacher")
public class ClassTeacher extends IdBaseEntity{

	@OneToOne
	@JoinColumn(name = "lecture_room_id")
	LectureRoom lectureRoom;
	
	@OneToOne
	@JoinColumn(name = "section_id")
	Section section;
	
	@ManyToOne
	@JoinColumn(name = "staff_id")
	Staff staff;

	public ClassTeacher() {
	}

	public ClassTeacher(LectureRoom lectureRoom, Section section, Staff staff) {
		
		this.lectureRoom = lectureRoom;
		this.section = section;
		this.staff = staff;
	}

	public LectureRoom getLectureRoom() {
		return lectureRoom;
	}

	public void setLectureRoom(LectureRoom lectureRoom) {
		this.lectureRoom = lectureRoom;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	
}
