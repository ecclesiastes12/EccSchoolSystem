package com.sch.admin.assignsubject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sch.admin.staff.StaffService;
import com.sch.admin.subject.SubjectRepository;
import com.sch.common.entity.Staff;
import com.sch.common.entity.StaffCategory;
import com.sch.common.entity.Subject;

@RestController
public class AssignSubjectRestController {

	@Autowired SubjectRepository subjectRepo;
	@Autowired StaffService staffService;
	
	@GetMapping("/assignSubjects/subjects")
	public List<Subject> listAll(){
		return (List<Subject>) subjectRepo.findAll();
	}
	
	@GetMapping("/assignSubjects/teachers")
	public List<Staff> listAllTeacher(){
		return staffService.findByStaffCategory(StaffCategory.TEACHING);
	}
}
