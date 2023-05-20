package com.sch.admin.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sch.admin.lectureroom.LectureroomService;
import com.sch.admin.parentguardian.ParentGuardianRepository;
import com.sch.admin.parentguardian.ParentGuardianService;
import com.sch.admin.schoolhouse.SchoolHouseService;
import com.sch.admin.section.SectionService;
import com.sch.common.entity.LectureRoom;
import com.sch.common.entity.Section;
import com.sch.common.entity.Student;

@Controller
public class StudentReportController {
	
	@Autowired StudentService studentService;
	@Autowired LectureroomService lectureroomService;
	@Autowired SectionService sectionService;
	@Autowired SchoolHouseService schoolHouseService;
	@Autowired ParentGuardianService parentGuardianService;
	@Autowired ParentGuardianRepository parentGuardianRepository;
	
	
	//viewStudentDetails change to listFirstPage and modified
	@GetMapping("/students/report")
	public String viewStudentGeneralReport(Model model) {
		
		
		return listByPage(1, model,"admissionNumber","desc");
	}
	
		
	
		
	//handler method that list  students by page.
	//method modified for column sorting
	@GetMapping("/students/report/page/{pageNum}")
	public String listByPage(@PathVariable(name = "pageNum") int pageNum, Model model,
			@Param("sortField") String sortField,
			@Param("sortDir") String sortDir) {
		
		List<LectureRoom> listLectureRooms = lectureroomService.listAllLectureRooms(null);
		List<Section> listSections = sectionService.listAllSections();
		
		Page<Student> page = studentService.listByPage(pageNum, sortField, sortDir);
		
		List<Student> listAllStudents = page.getContent();
		
		//count pages
		long startCount = (pageNum - 1) * StudentService.STUDENTS_PER_PAGE + 1;
		long endCount = startCount + StudentService.STUDENTS_PER_PAGE - 1;
		
		//gets the last page number
		if(endCount > page.getTotalElements()) {
			endCount = page.getTotalElements();
		}
		
		//reverse sort
		String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";

		model.addAttribute("listLectureRooms", listLectureRooms);
		model.addAttribute("listSections", listSections);
		
		model.addAttribute("listAllStudents", listAllStudents);
		
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("startCount", startCount);
		model.addAttribute("endCount", endCount);
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", reverseSortDir);
		
		return "students/student_general_report";

	}
		
	
	@GetMapping("/parentguardian/report")
	public String viewParentGuardianGeneralReport(Model model) {
		
		
		return listByParentGuardianPage(1, model,"admissionNumber","desc");
	}	
	
	//handler method that list  students by page.
		//method modified for column sorting
		@GetMapping("/parentguardian/report/page/{pageNum}")
		public String listByParentGuardianPage(@PathVariable(name = "pageNum") int pageNum, Model model,
				@Param("sortField") String sortField,
				@Param("sortDir") String sortDir) {
			
			List<LectureRoom> listLectureRooms = lectureroomService.listAllLectureRooms(null);
			List<Section> listSections = sectionService.listAllSections();
			
			Page<Student> page = studentService.listByPage(pageNum, sortField, sortDir);
			
			List<Student> listAllStudents = page.getContent();
			
			//count pages
			long startCount = (pageNum - 1) * StudentService.STUDENTS_PER_PAGE + 1;
			long endCount = startCount + StudentService.STUDENTS_PER_PAGE - 1;
			
			//gets the last page number
			if(endCount > page.getTotalElements()) {
				endCount = page.getTotalElements();
			}
			
			//reverse sort
			String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";

			model.addAttribute("listLectureRooms", listLectureRooms);
			model.addAttribute("listSections", listSections);
			
			model.addAttribute("listAllStudents", listAllStudents);
			
			model.addAttribute("currentPage", pageNum);
			model.addAttribute("totalPages", page.getTotalPages());
			model.addAttribute("startCount", startCount);
			model.addAttribute("endCount", endCount);
			model.addAttribute("totalItems", page.getTotalElements());
			
			model.addAttribute("sortField", sortField);
			model.addAttribute("sortDir", sortDir);
			model.addAttribute("reverseSortDir", reverseSortDir);
			
			return "students/parentguardian_general_report";

		}
		
}
