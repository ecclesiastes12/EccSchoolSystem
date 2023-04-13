package com.sch.admin.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {
	@Autowired StudentService studentService;

	//rest method that check email uniqueness before new student is added
	@PostMapping("/students/check_unique_email")
	public String checkDuplicateEmail4Students(@Param("email") String email) {
		
		return studentService.isStudentEmailUnique(email) ? "OK" : "Duplicated";
	}
	
	
	
}
