//package com.sch.admin.student;
//
//
//import java.io.IOException;
//import java.util.List;
//
//import org.apache.catalina.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.sch.admin.FileUploadUtil;
//import com.sch.admin.lectureroom.LectureroomService;
//import com.sch.admin.parentguardian.ParentGuardianRepository;
//import com.sch.admin.parentguardian.ParentGuardianService;
//import com.sch.admin.schoolhouse.SchoolHouseService;
//import com.sch.admin.section.SectionService;
//import com.sch.common.entity.LectureRoom;
//import com.sch.common.entity.ParentGuardian;
//import com.sch.common.entity.SchoolHouse;
//import com.sch.common.entity.Section;
//import com.sch.common.entity.Student;
//
//@Controller
//public class StudentController {
//
//	@Autowired StudentService studentService;
//	@Autowired LectureroomService lectureroomService;
//	@Autowired SectionService sectionService;
//	@Autowired SchoolHouseService schoolHouseService;
//	@Autowired ParentGuardianService parentGuardianService;
//	@Autowired ParentGuardianRepository parentGuardianRepository;
//	
//	/*
//	 * //handler method that list all student
//	 * 
//	 * @GetMapping("/students") public String
//	 * viewStudentDetails(@ModelAttribute("student") Student student, Model model) {
//	 * 
//	 * List<Student> listAllStudents = studentService.listStudents();
//	 * List<LectureRoom> listLectureRooms =
//	 * lectureroomService.listAllLectureRooms(null); List<Section> listSections =
//	 * sectionService.listAllSections();
//	 * 
//	 * model.addAttribute("listAllStudents", listAllStudents);
//	 * model.addAttribute("listLectureRooms", listLectureRooms);
//	 * model.addAttribute("listSections", listSections);
//	 * 
//	 * return "students/student_details"; }
//	 */
//	
//	
//	//viewStudentDetails change to listFirstPage and modified
//	@GetMapping("/students")
//	public String listFirstPage(Model model) {
//		return listByPage(1, model,"admissionNumber","asc");
//	}
//	
//	/*
//	 * //handler method that list students by page
//	 * 
//	 * @GetMapping("/students/page/{pageNum}") public String
//	 * listByPage(@PathVariable(name = "pageNum") int pageNum, Model model) {
//	 * Page<Student> page = studentService.listByPage(pageNum); List<Student>
//	 * listAllStudents = page.getContent();
//	 * 
//	 * List<LectureRoom> listLectureRooms =
//	 * lectureroomService.listAllLectureRooms(null); List<Section> listSections =
//	 * sectionService.listAllSections();
//	 * 
//	 * //count pages long startCount = (pageNum - 1) *
//	 * StudentService.STUDENTS_PER_PAGE + 1; long endCount = startCount +
//	 * StudentService.STUDENTS_PER_PAGE - 1;
//	 * 
//	 * //gets the last page number if(endCount > page.getTotalElements()) { endCount
//	 * = page.getTotalElements(); }
//	 * 
//	 * model.addAttribute("listLectureRooms", listLectureRooms);
//	 * model.addAttribute("listSections", listSections);
//	 * 
//	 * model.addAttribute("listAllStudents", listAllStudents);
//	 * 
//	 * model.addAttribute("currentPage", pageNum); model.addAttribute("totalPages",
//	 * page.getTotalPages()); model.addAttribute("startCount", startCount);
//	 * model.addAttribute("endCount", endCount); model.addAttribute("totalItems",
//	 * page.getTotalElements());
//	 * 
//	 * return "students/student_details";
//	 * 
//	 * }
//	 */
//	
//	//handler method that list  students by page.
//	//method modified for column sorting
//	@GetMapping("/students/page/{pageNum}")
//	public String listByPage(@PathVariable(name = "pageNum") int pageNum, Model model,
//			@Param("sortField") String sortField,
//			@Param("sortDir") String sortDir) {
//		
//		List<LectureRoom> listLectureRooms = lectureroomService.listAllLectureRooms(null);
//		List<Section> listSections = sectionService.listAllSections();
//		
//		Page<Student> page = studentService.listByPage(pageNum, sortField, sortDir);
//		
//		List<Student> listAllStudents = page.getContent();
//		
//		//count pages
//		long startCount = (pageNum - 1) * StudentService.STUDENTS_PER_PAGE + 1;
//		long endCount = startCount + StudentService.STUDENTS_PER_PAGE - 1;
//		
//		//gets the last page number
//		if(endCount > page.getTotalElements()) {
//			endCount = page.getTotalElements();
//		}
//		
//		//reverse sort
//		String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
//
//		model.addAttribute("listLectureRooms", listLectureRooms);
//		model.addAttribute("listSections", listSections);
//		
//		model.addAttribute("listAllStudents", listAllStudents);
//		
//		model.addAttribute("currentPage", pageNum);
//		model.addAttribute("totalPages", page.getTotalPages());
//		model.addAttribute("startCount", startCount);
//		model.addAttribute("endCount", endCount);
//		model.addAttribute("totalItems", page.getTotalElements());
//		
//		model.addAttribute("sortField", sortField);
//		model.addAttribute("sortDir", sortDir);
//		model.addAttribute("reverseSortDir", reverseSortDir);
//		
//		return "students/student_details";
//
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
//	
//		
//		//model.addAttribute("student", new Student());
//		model.addAttribute("listLectureRooms", listLectureRooms);
//		model.addAttribute("listSections", listSections);
//		model.addAttribute("listSchoolHouses", listSchoolHouses);
//		
//		return "students/student_admission";
//	}
//	
//
//	
//	
//	/*
//	 * //works perfectly without constraint parentGuardian email field //handler
//	 * method that save students
//	 * 
//	 * @PostMapping("/students/save") public String
//	 * saveStudent(@ModelAttribute("student") Student student){
//	 * 
//	 * studentService.saveStudent(student); ParentGuardian parentGuardian =
//	 * student.getParentGuardian(); parentGuardian.setStudent(student);
//	 * parentGuardianService.saveParentGuardian(parentGuardian);
//	 * 
//	 * return "redirect:/students/new"; }
//	 */
//	
//	
////	@PostMapping("/students/save")	
////	public String saveStudent(@ModelAttribute("student") Student student, @Param("guardianEmail") String email){
////		
////		studentService.saveStudent(student);
////		ParentGuardian parentGuardian = student.getParentGuardian();
////		parentGuardian.setStudent(student);
////		parentGuardianService.saveParentGuardian(parentGuardian);
////
////		return "redirect:/students/new";
////	}
//	
//	//modified with multipartfile for image upload
//	@PostMapping("/students/save")	
//	public String saveStudent(@ModelAttribute("student") Student student,
//			@RequestParam("image") MultipartFile multipartFile,
//			@RequestParam("fatherImage") MultipartFile fatherMultipartFile, 
//			@RequestParam("motherImage") MultipartFile motherMultipartFile,
//			@RequestParam("guardianImage") MultipartFile guardianMultipartFile,
//			RedirectAttributes ra) throws IOException{
//		
//		//check if the form has a file upload by checking the mulitpart file object
//		if(!multipartFile.isEmpty() || !fatherMultipartFile.isEmpty() || !motherMultipartFile.isEmpty() || !guardianMultipartFile.isEmpty()) {//if the mulitpart file object is not empty it means the form has an upload file
//			//clean the path and get the file name from multipart file object
//			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//			String fatherFileName = StringUtils.cleanPath(fatherMultipartFile.getOriginalFilename());
//			String motherFileName = StringUtils.cleanPath(motherMultipartFile.getOriginalFilename());
//			String guardianFileName = StringUtils.cleanPath(guardianMultipartFile.getOriginalFilename());
//			
//			//set the phote field to store the file name in the db
//			student.setPhoto(fileName);
//			student.getParentGuardian().setFatherPhoto(fatherFileName);
//			student.getParentGuardian().setMotherPhoto(motherFileName);
//			student.getParentGuardian().setGuardianPhoto(guardianFileName);
//			
//			
//			ParentGuardian parentGuardian = student.getParentGuardian();
//			parentGuardian.setStudent(student);
//			Student savedStudent = studentService.saveStudent(student);
//			
//			//upload directory, the folder that the actual image will be stored in
//			//this directory will be created with the student id
//			String uploadDir = "student-photos/" + savedStudent.getId();
//			String uploadFatherDir = "father-photos/" + savedStudent.getParentGuardian().getId();
//			String uploadMotherDir = "mother-photos/" + savedStudent.getParentGuardian().getId();
//			String uploadGuardianDir = "guardian-photos/" + savedStudent.getParentGuardian().getId();
//			
//			//clean image directory
//			FileUploadUtil.cleanDir(uploadGuardianDir);
//			FileUploadUtil.cleanDir(uploadFatherDir);
//			FileUploadUtil.cleanDir(uploadMotherDir);
//			FileUploadUtil.cleanDir(uploadGuardianDir);
//			
//			
////			//save or upload the photo
////			FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
////			FileUploadUtil.saveFile(uploadFatherDir, fatherFileName, fatherMultipartFile);
////			FileUploadUtil.saveFile(uploadMotherDir, motherFileName, motherMultipartFile);
////			FileUploadUtil.saveFile(uploadGuardianDir, guardianFileName, guardianMultipartFile);
//			
//			//save or upload the photo
//			if(student.getPhoto().isEmpty()) {
//				student.setPhoto(null);
//			}else {
//				FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//			}
//			
//			if(student.getParentGuardian().getFatherPhoto().isEmpty()) {
//				student.setPhoto(null);
//			}else {
//				FileUploadUtil.saveFile(uploadFatherDir, fatherFileName, fatherMultipartFile);
//			}
//			
//			if(student.getParentGuardian().getMotherPhoto().isEmpty()) {
//				student.setPhoto(null);
//			}else {
//				FileUploadUtil.saveFile(uploadMotherDir, motherFileName, motherMultipartFile);
//			}
//			
//			if(student.getParentGuardian().getGuardianPhoto().isEmpty()) {
//				student.setPhoto(null);
//			}else {
//				FileUploadUtil.saveFile(uploadGuardianDir, guardianFileName, guardianMultipartFile);
//			}
//			
//			
//		}else {
//			if(student.getPhoto().isEmpty()) {
//				student.setPhoto(null);
//			}else if (student.getParentGuardian().getFatherPhoto().isEmpty()) {
//				student.getParentGuardian().setFatherPhoto(null);
//			}else if (student.getParentGuardian().getMotherPhoto().isEmpty()) {
//				student.getParentGuardian().setMotherPhoto(null);
//			}else if (student.getParentGuardian().getGuardianPhoto().isEmpty()) {
//				student.getParentGuardian().setGuardianPhoto(null);
//			}
//			
//			ParentGuardian parentGuardian = student.getParentGuardian();
//			parentGuardian.setStudent(student);
//			studentService.saveStudent(student);
//		}
//		
//		/*
//		 * //clean the path and get the file name from multipart file object String
//		 * fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//		 * 
//		 * //upload directory, the folder that the actual image will be stored in String
//		 * uploadDir = "student-photos";
//		 * 
//		 * //save or upload the photo FileUploadUtil.saveFile(uploadDir, fileName,
//		 * multipartFile);
//		 */
////		studentService.saveStudent(student);
////		ParentGuardian parentGuardian = student.getParentGuardian();
////		parentGuardian.setStudent(student);
////		parentGuardianService.saveParentGuardian(parentGuardian);
//
//		ra.addFlashAttribute("message", "The Student has been saved successfully!");
//		
//		return "redirect:/students/new";
//	}
//	
//	
//	//handler method that edit student
//	@GetMapping("/students/edit/{id}")
//	public String editStudent(@PathVariable("id") Integer id, 
//		RedirectAttributes ra, Model model) {
//		
//		//get student by id
//		try {
//			Student student = studentService.getStudentId(id);
//			List<LectureRoom> listLectureRooms = lectureroomService.listAllLectureRooms(null);
//			List<Section> listSections = sectionService.listAllSections();
//			List<SchoolHouse> listSchoolHouses = (List<SchoolHouse>) schoolHouseService.listSchoolHouse();
//			
//			model.addAttribute("student", student);
//			model.addAttribute("listLectureRooms", listLectureRooms);
//			model.addAttribute("listSections", listSections);
//			model.addAttribute("listSchoolHouses", listSchoolHouses);
//			
//		} catch (StudentNotFoundException e) {
//			ra.addFlashAttribute("message", e.getMessage());
//		}
//		
//		return "students/student_admission";
//	}
//	
//	
//	
//	//method handler that show student profile details
//	@GetMapping("/students/profile/{id}")
//	public String studentProfileDetails(@PathVariable(name = "id") Integer id, 
//			Model model, RedirectAttributes ra) {
//		try {
//			Student student = studentService.getStudentId(id);
//			//List<Student> listAllStudents = studentService.listStudents();
//			model.addAttribute("student", student);
//			//model.addAttribute("listAllStudents", listAllStudents);
//		} catch (StudentNotFoundException e) {
//			ra.addFlashAttribute("message", e.getMessage());
//		}
//		
//		return "students/student_profile";
//	}
//		
//	
//	  //handler method that students report
//	  
//		@GetMapping("/students/history")
//		public String viewStudentHistory(Model model) {
//
//			return listPageByStudentHistory(1, model, "admissionNumber", "desc");
//		}
//	 
//	
//		@GetMapping("/students/history/page/{pageNum}")
//		public String listPageByStudentHistory(@PathVariable(name = "pageNum") int pageNum, Model model,
//				@Param("sortField") String sortField,
//				@Param("sortDir") String sortDir) {
//			
//			List<LectureRoom> listLectureRooms = lectureroomService.listAllLectureRooms(null);
//			List<Section> listSections = sectionService.listAllSections();
//			
//			Page<Student> page = studentService.listByPage(pageNum, sortField, sortDir);
//			
//			List<Student> listAllStudents = page.getContent();
//			
//			//count pages
//			long startCount = (pageNum - 1) * StudentService.STUDENTS_PER_PAGE + 1;
//			long endCount = startCount + StudentService.STUDENTS_PER_PAGE - 1;
//			
//			//gets the last page number
//			if(endCount > page.getTotalElements()) {
//				endCount = page.getTotalElements();
//			}
//			
//			//reverse sort
//			String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
//
//			model.addAttribute("listLectureRooms", listLectureRooms);
//			model.addAttribute("listSections", listSections);
//			
//			model.addAttribute("listAllStudents", listAllStudents);
//			
//			model.addAttribute("currentPage", pageNum);
//			model.addAttribute("totalPages", page.getTotalPages());
//			model.addAttribute("startCount", startCount);
//			model.addAttribute("endCount", endCount);
//			model.addAttribute("totalItems", page.getTotalElements());
//			
//			model.addAttribute("sortField", sortField);
//			model.addAttribute("sortDir", sortDir);
//			model.addAttribute("reverseSortDir", reverseSortDir);
//			
//			return "students/student_history";
//
//		}
//}
