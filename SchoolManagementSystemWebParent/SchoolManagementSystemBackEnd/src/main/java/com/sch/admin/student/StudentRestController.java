package com.sch.admin.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sch.admin.parentguardian.ParentGuardianService;

@RestController
public class StudentRestController {
	@Autowired StudentService studentService;
	@Autowired ParentGuardianService parentGuardianService;

	//rest method that check email uniqueness before new student is added
	@PostMapping("/students/check_unique_email")
	public String checkDuplicateEmail4Students(Integer id, String email) {
		
		return studentService.isStudentEmailUnique(id,email) ? "OK" : "Duplicated";
	}
	
	//rest method that check email uniqueness before new student is added
//	@PostMapping("/parentguardians/check_unique_email")
//	public String checkDuplicateEmail4ParentGuardian(@Param("guardianEmail") String email) {
//		
//		return studentService.isParentGuardianEmailUnique(email) ? "OK" : "Duplicated";
//	}


}
