package com.sch.admin.TimeTable;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sch.common.entity.TimeTable;
import com.sch.common.entity.TimeTableForm;

@Controller
public class TimeTableController {

	@Autowired TimeTableService timeTableService;
	
	//handler method that list all time table
	@GetMapping("/timetable")
	public String listTimeTable(Model model) {
		List<TimeTable> listTimeTables = timeTableService.listTimeTable();
		
		model.addAttribute("listTimeTables", listTimeTables);
		
		return "timetable/timetable";
	}
	
	//handler method that create new timetable
	@GetMapping("/timetable/new")
	public String newTimetable(Model model) {
		//TimeTable timeTable = new TimeTable();
		List<TimeTable> rows = new ArrayList<>();
		

		
		rows.add(new TimeTable("Monday", null, null, null));
		rows.add(new TimeTable("Tuesday", null, null, null));
		rows.add(new TimeTable("Wednesday", null, null, null));
		rows.add(new TimeTable("Thusday", null, null, null));
		rows.add(new TimeTable("Friday", null, null, null));
		rows.add(new TimeTable("Saturday", null, null, null));
		rows.add(new TimeTable("Sunday", null, null, null));
		
		TimeTableForm timetableForm = new TimeTableForm();
		timetableForm.setRows(rows);
		
		model.addAttribute("timetableForm", timetableForm);
		model.addAttribute("rows", rows);
		
		return "timetable/timetable_new";
	}
	
	//handler method that save timetable
	@PostMapping("/timetable/save")
	public String saveTimetable(@ModelAttribute("timeTableForm") TimeTableForm timeTableForm) {
		
			timeTableService.saveTimeTable(timeTableForm);
		
		
		return "redirect:/timetable";
	}
}
