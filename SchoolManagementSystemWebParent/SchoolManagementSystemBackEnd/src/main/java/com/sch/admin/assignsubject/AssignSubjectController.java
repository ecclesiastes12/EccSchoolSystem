package com.sch.admin.assignsubject;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sch.admin.staff.StaffService;
import com.sch.admin.subject.SubjectService;
import com.sch.common.entity.AssignSubject;
import com.sch.common.entity.Staff;
import com.sch.common.entity.StaffCategory;
import com.sch.common.entity.Subject;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AssignSubjectController {

	@Autowired StaffService staffService;
	@Autowired SubjectService subjectService;
	
	@GetMapping("/assignSubjects")
	public String viewAssignSubject(Model model) {
		
		//list subjects and staffs
		List<Subject> listSubjects = subjectService.listSubjects(null);
		List<Staff> listStaffs = staffService.findByStaffCategory(StaffCategory.TEACHING);
		
		model.addAttribute("listSubjects", listSubjects);
		model.addAttribute("listStaffs", listStaffs);
		
		return "academics/assign_subject";
	}
	
	//saves assign subject teacher
	@PostMapping("/assignSubjects/save")
	public String saveAssignSubjects(AssignSubject assignSubject, HttpServletRequest request) {
		
		String[] arrayTeachers = request.getParameterValues("selectTeacher");
		String[] arraySubjects = request.getParameterValues("selectSubject");
		
		
		return "";
	}
	
//	//saves assign subject teacher
//	@PostMapping("/assignSubjects/save")
//	public String saveAssignSubjects(@RequestParam(name = "selectTeacher", required = false) String[] selectTeacher,
//			@RequestParam(name = "selectSubject", required = false) String[] selectSubject) {
//		
//		setAssignSubjects(selectTeacher,selectSubject);
//		
//		return "";
//	}


//	private void setAssignSubjects(String[] selectTeacher, String[] selectSubject) {
//		
//		//check if selectTeacher is null or length is 0
//		if(selectTeacher == null || selectTeacher.length == 0) return;
//		
//		//iterate through each selected teacher in the array
//		for (int count = 0; count < selectTeacher.length; count++) {
//			//get the selected teacher from the array at the index of the element
//			String teacherName = selectTeacher[count];
//			String subjectName = selectSubject[count];
//			
//			//check if teacher and subject are not empty
//			if(!teacherName.isEmpty() && !subjectName.isEmpty()) {
//				
//			}
//			
//			
//		}
//		
//	}
	
}
