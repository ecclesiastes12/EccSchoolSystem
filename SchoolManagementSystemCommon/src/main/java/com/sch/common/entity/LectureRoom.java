package com.sch.common.entity;

import java.util.HashSet;
import java.util.Set;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "lecture_room")
public class LectureRoom extends IdBaseEntity{

	@Column(length = 45, nullable = false)
	String name;
	
	//NB Set does not allow duplucate elements whiles Collection allows duplicate elements
	
	
	
	@ManyToMany(fetch = FetchType.EAGER )
	@JoinTable(
			name="Lectureroom_sections",
			joinColumns = @JoinColumn(name="lectureroom_id"),
			inverseJoinColumns = @JoinColumn(name="section_id")
			)		
	Set<Section> sections = new HashSet<>();
	
	public LectureRoom() {}
	
	

	public LectureRoom(String name, Set<Section> sections) {
		this.name = name;
		this.sections = sections;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Section> getSections() {
		return sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}
	
	// method that add section to lecture hall
		public void addSections(Section sections) {
			this.sections.add(sections);
		}



		@Override
		public String toString() {
			return "LectureRoom [name=" + name + ", sections=" + sections + "]";
		}
		
	
}
