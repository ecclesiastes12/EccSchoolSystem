package com.sch.admin.TimeTable;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sch.common.entity.TimeTable;

@Service
public class TimeTableService {

	@Autowired TimeTableRepository timeTableRepo;
	
	//service method that list time table
	public List<TimeTable> listTimeTable() {
		 return (List<TimeTable>) timeTableRepo.findAll();
		
	}
	
	//service method that save time table
	public TimeTable saveTimeTable(TimeTable timetable) {
		
		return timeTableRepo.save(timetable);
	}
	
	//service that get time table by id
	public TimeTable geTimeTableById(Integer id) throws NoTimeTableFoundException {
		try {
			return timeTableRepo.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new NoTimeTableFoundException("Could not find Time table ID " + id);
		}
	}
	
	
	
}
