package com.sch.common.entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "time_table")
public class TimeTable extends IdBaseEntity {
	
	String day;
	
	@Column(name="start_time")
	LocalTime startTime;
	
	@Column(name = "end_time")
	LocalTime endTime;
	
	@Column(name = "room_number", length = 64)
	String roomNumber;

//	String day;
//	
//	@Column(name="start_time")
//	String startTime[];
//	
//	@Column(name = "end_time")
//	String endTime[];
//	
//	@Column(name = "room_number", length = 64)
//	String roomNumber[];
//	
//	@OneToOne
//	@JoinColumn(name = "subject_id")
//	Subject subject;
}
