//package com.sch.admin.student;
//
//import java.util.Collections;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.sch.admin.lectureroom.LectureroomService;
//import com.sch.admin.parentguardian.ParentGuardianNotFoundException;
//import com.sch.admin.parentguardian.ParentGuardianService;
//import com.sch.admin.schoolhouse.SchoolHouseService;
//import com.sch.admin.section.SectionService;
//import com.sch.common.entity.LectureRoom;
//import com.sch.common.entity.ParentGuardian;
//import com.sch.common.entity.SchoolHouse;
//import com.sch.common.entity.Section;
//import com.sch.common.entity.Student;
//import com.sch.common.entity.StudentParentGuardianDTO;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//@Controller
//public class StudentController2 {
//
//	@Autowired StudentService studentService;
//	@Autowired LectureroomService lectureroomService;
//	@Autowired SectionService sectionService;
//	@Autowired SchoolHouseService schoolHouseService;
//	@Autowired ParentGuardianService parentGuardianService;
//	
//	//handler method that list all student
//	@GetMapping("/students")
//	public String viewStudent(@ModelAttribute("student") Student student) {
//		
//		
//		return "students/students";
//	}
//	
//	//handler method that display student form
//	@GetMapping("/students/new")
//	public String showStudentForm(@ModelAttribute("student") Student student,
//			 Model model) {
//		
//		List<LectureRoom> listLectureRooms = lectureroomService.listAllLectureRooms(null);
//		List<Section> listSections = sectionService.listAllSections();
//		List<SchoolHouse> listSchoolHouses = (List<SchoolHouse>) schoolHouseService.listSchoolHouse();
//		
//		//model.addAttribute("student", new Student());
//		model.addAttribute("listLectureRooms", listLectureRooms);
//		model.addAttribute("listSections", listSections);
//		model.addAttribute("listSchoolHouses", listSchoolHouses);
//		
//		return "students/student_admission3";
//	}
//	
////	//handler method that save students
////	@PostMapping("/students/save")
////	public String saveStudent(Student student, HttpServletRequest request) {
////		String fatherName = request.getParameter("fatherName");
////		String fatherOccupation = request.getParameter("fatherOccupation");
////		String fatherPhoneNumber = request.getParameter("fatherPhoneNumber");
////		String motherName = request.getParameter("motherName");
////		String motherOccupation = request.getParameter("motherOccupation");
////		String motherPhoneNumber = request.getParameter("motherPhoneNumber");
////		String guardianName = request.getParameter("guardianName");
////		String guardianRelation = request.getParameter("guardianRelation");
////		String guardianOccupation = request.getParameter("guardianOccupation");
////		String guardianEmail = request.getParameter("guardianEmail");
////		String guardianPhoneNumber = request.getParameter("guardianPhoneNumber");
////		String guardianAddress = request.getParameter("guardianAddress");
////		String isGuardianFatherMotherOther = request.getParameter("isGuardianFatherMotherOther");
////		String photo = request.getParameter("photo");
////		
////		
////		
////		studentService.saveStudent(student);
////		
////		return "students/student_admission";
////	}
//	
//	//handler method that save students
//	@PostMapping("/students/save")
//	public String saveStudent(@ModelAttribute("student") Student student) 
//			
//			{
//	
//		ParentGuardian parentGuardian = student.getParentGuardian();
//		parentGuardianService.saveParentGuardian(parentGuardian);
//		
//		studentService.saveStudent(student);
//		
//	//	setStudentAndParentGuardian(studentParentGuardianDTO);
//		
//		
//		return "redirect:/students/new";
//	}
//	
//	
////	//handler method that save students
////	@PostMapping("/students/save")
////	public String saveStudent(@ModelAttribute("studentParentGuardianDto") StudentParentGuardianDTO studentParentGuardianDto ) 
////			throws StudentNotFoundException, ParentGuardianNotFoundException 
////			{
////		
//////		ParentGuardian parentGuardian = student.getParentGuardian();
//////		
//////		studentService.saveStudent(student);
//////		
//////		parentGuardian.getStudent().add(student);
//////		
//////		parentGuardianService.saveParentGuardian(parentGuardian);
////		
////		setStudentAndParentGuardian(studentParentGuardianDto);
////		
////		
////		return "redirect:/students/new";
////	}
//	
//	//private method  that set students and parentGuardian
//		private void setStudentAndParentGuardian(StudentParentGuardianDTO studentParentGuardianDTO) 
//				
//				{
//			ParentGuardian parentGuardian = new ParentGuardian();
//
//			parentGuardian.setIsGuardianFatherMotherOther(studentParentGuardianDTO.getIsGuardianFatherMotherOther());
//			//parentGuardian.setStudent(studentParentGuardianDTO.getStudentEntityObject());;
//			parentGuardian.setFatherName(studentParentGuardianDTO.getFatherName());
//			parentGuardian.setFatherOccupation(studentParentGuardianDTO.getFatherOccupation());
//			parentGuardian.setFatherPhoneNumber(studentParentGuardianDTO.getFatherPhoneNumber());
//			parentGuardian.setMotherName(studentParentGuardianDTO.getMotherName());
//			parentGuardian.setMotherOccupation(studentParentGuardianDTO.getMotherOccupation());
//			parentGuardian.setMotherPhoneNumber(studentParentGuardianDTO.getMotherPhoneNumber());
//			parentGuardian.setGuardianName(studentParentGuardianDTO.getGuardianName());
//			parentGuardian.setGuardianEmail(studentParentGuardianDTO.getGuardianEmail());
//			parentGuardian.setGuardianOccupation(studentParentGuardianDTO.getGuardianOccupation());
//			parentGuardian.setGuardianRelation(studentParentGuardianDTO.getGuardianRelation());
//			parentGuardian.setGuardianAddress(studentParentGuardianDTO.getGuardianAddress());
//			parentGuardian.setGuardianPhoneNumber(studentParentGuardianDTO.getGuardianPhoneNumber());
//									
//			Student student = new Student();
//			
//			student.setAdmissionNumber(studentParentGuardianDTO.getAdmissionNumber());
//			student.setFirstName(studentParentGuardianDTO.getFirstName());
//			student.setLastName(studentParentGuardianDTO.getLastName());
//			student.setOtherName(studentParentGuardianDTO.getOtherName());
//			student.setEmail(studentParentGuardianDTO.getEmail());
//			student.setGender(studentParentGuardianDTO.getGender());
//			//student.setPassword(studentParentGuardianDTO.getPassword());
//			student.setDobOnForm(studentParentGuardianDTO.getGetDobOnForm());
//			student.setReligion(studentParentGuardianDTO.getReligion());
//			student.setCaste(studentParentGuardianDTO.getCaste());
//			student.setWeight(studentParentGuardianDTO.getWeight());
//			student.setHeight(studentParentGuardianDTO.getHeight());
//			student.setPhoneNumber(studentParentGuardianDTO.getPhoneNumber());
//			student.setHomeTown(studentParentGuardianDTO.getHomeTown());
//			student.setEthnicGroup(studentParentGuardianDTO.getEthnicGroup());
//			student.setBloodGroup(studentParentGuardianDTO.getBloodGroup());
//			student.setRegistrationDate(studentParentGuardianDTO.getRegistrationDate());
//			student.setLectureRoom(studentParentGuardianDTO.getLectureRoom());
//			student.setSection(studentParentGuardianDTO.getSection());
//			student.setAdmissionDateOnForm(studentParentGuardianDTO.getGetAdmissionDateOnForm());
//			student.setRegistrationDateOnForm(studentParentGuardianDTO.getGetRegistrationDateOnForm());
//			student.setStudentCategory(studentParentGuardianDTO.getStudentCategory());
//			student.setSchoolHouse(studentParentGuardianDTO.getSchoolHouse());
//			//student.setParentGuardian(parentGuardian);;0
//			//			//student.setParentGuardian(studentParentGuardianDTO.getParentGuardian());
//			//parentGuardian.setStudent(Collections.singletonList(student));	
//			
//			
//			parentGuardianService.saveParentGuardian(parentGuardian);
//			studentService.saveStudent(student);	
//			
//			
//		}
//		
//	
//	
//		
//	//handler method that update students
//	
//}
