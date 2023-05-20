//package com.sch.admin.TimeTable;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.sch.common.entity.TimeTable;
//
//@Controller
//public class TimeTableController2 {
//
//	@Autowired TimeTableService timeTableService;
//	
//	//handler method that list all time table
//	@GetMapping("/timetable")
//	public String listTimeTable(Model model) {
//		List<TimeTable> listTimeTables = timeTableService.listTimeTable();
//		
//		model.addAttribute("listTimeTables", listTimeTables);
//		
//		return "timetable/timetable";
//	}
//	
//	//handler method that create new timetable
//	@GetMapping("/timetable/new")
//	public String newTimetable(Model model) {
//		//TimeTable timeTable = new TimeTable();
//		List<TimeTable> rows = new ArrayList<>();
//		/*
//		 * rows.add(new TimeTable("Monday", "", "", null)); rows.add(new
//		 * TimeTable("Tuesday", "", "", null)); rows.add(new TimeTable("Wednesday", "",
//		 * "", null)); rows.add(new TimeTable("Thusday", "", "", null)); rows.add(new
//		 * TimeTable("Friday", "", "", null)); rows.add(new TimeTable("Saturday", "",
//		 * "", null)); rows.add(new TimeTable("Sunday", "", "", null));
//		 */
//		
//		rows.add(new TimeTable("Monday", null, null, null));
//		rows.add(new TimeTable("Tuesday", null, null, null));
//		rows.add(new TimeTable("Wednesday", null, null, null));
//		rows.add(new TimeTable("Thusday", null, null, null));
//		rows.add(new TimeTable("Friday", null, null, null));
//		rows.add(new TimeTable("Saturday", null, null, null));
//		rows.add(new TimeTable("Sunday", null, null, null));
//		
//		
//		model.addAttribute("timeTable", new TimeTable());
//		model.addAttribute("rows", rows);
//		
//		return "timetable/timetable_new";
//	}
//	
//	//handler method that save timetable
//	@PostMapping("/timetable/save")
//	public String saveTimetable(TimeTable timeTable) {
//		
//		timeTableService.saveTimeTable(timeTable);
//		
//		return "redirect:/timetable";
//	}
//}
