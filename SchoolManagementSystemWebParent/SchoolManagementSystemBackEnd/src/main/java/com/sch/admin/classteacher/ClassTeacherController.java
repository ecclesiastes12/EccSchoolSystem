package com.sch.admin.classteacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sch.admin.lectureroom.LectureroomService;
import com.sch.admin.section.SectionService;
import com.sch.admin.staff.StaffService;
import com.sch.common.entity.ClassTeacher;
import com.sch.common.entity.LectureRoom;
import com.sch.common.entity.Section;
import com.sch.common.entity.Staff;
import com.sch.common.entity.StaffCategory;

@Controller
public class ClassTeacherController {
	
	@Autowired ClassTeacherService classTeacherService;
	@Autowired SectionService sectionService;
	@Autowired LectureroomService lectureRoomService;
	@Autowired StaffService staffService;
	

	//handler method that list teachers
	@GetMapping("/assignTeachers")
	public String viewAssignClassTeachers(Model model) {
		
		List<ClassTeacher> listClassTeachers = classTeacherService.listClassTeachers();
		
		model.addAttribute("listClassTeachers", listClassTeachers);
		model.addAttribute("placeHoler", "Search by class name or section name or teacher name");
		
		return "academics/assign_class_teacher";
	}
	
	@GetMapping("/assignTeachers/new")
	public ModelAndView showAssignClassTeacherForm() {
		ClassTeacher classTeacherObject = new ClassTeacher();
		List<Section> listSections = sectionService.listAllSections();
		List<LectureRoom> listLectureRooms = lectureRoomService.listAllLectureRooms(null);
		List<Staff> listStaff = staffService.findByStaffCategory(StaffCategory.TEACHING);
		
		ModelAndView modelAndView = new ModelAndView("academics/assign_class_teacher_form_modal");
		
		modelAndView.addObject("classTeacherObject", classTeacherObject);
		modelAndView.addObject("listSections", listSections);
		modelAndView.addObject("listLectureRooms", listLectureRooms);
		modelAndView.addObject("listStaff", listStaff);
		modelAndView.addObject("pageTitle", "Add");
		
		modelAndView.addObject(modelAndView);
		return modelAndView;
	}
	
	//handler method for saving assigned class teacher
	@PostMapping("/assignTeachers/save")
	public String save(ClassTeacher classTeacher, RedirectAttributes ra) {
		
		classTeacherService.saveClassTeacher(classTeacher);
		
		ra.addFlashAttribute("message", "Teacher has been assigned to class successfully ");
		
		return "redirect:/assignTeachers";
	}
	
	
	@GetMapping("/assignTeachers/edit/{id}")
	public String editAssignTeacher(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
		
		try {
			ClassTeacher classTeacher = classTeacherService.geClassTeacherId(id);
			List<Section> listSections = sectionService.listAllSections();
			List<LectureRoom> listLectureRooms = lectureRoomService.listAllLectureRooms(null);
			List<Staff> listStaff = staffService.findByStaffCategory(StaffCategory.TEACHING);
			
			
			model.addAttribute("classTeacherObject", classTeacher);
			model.addAttribute("listSections", listSections);
			model.addAttribute("listLectureRooms", listLectureRooms);
			model.addAttribute("listStaff", listStaff);
		} catch (ClassTeacherNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
		}
		
		return "academics/assign_class_teacher_form_modal";
	}
	
	
	//handler method that delete assigned teacher to class
	@GetMapping("/assignTeachers/delete/{id}")
	public String deleteAssignedClassTeacher(@PathVariable("id") Integer id, RedirectAttributes ra) {
		
		 try {
			classTeacherService.deleteClassTeacher(id);
			
			ra.addFlashAttribute("message", "Assigned Class Teacher ID (" + id + ") has been deleted successfully");
		} catch (ClassTeacherNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
		}
		
		return "redirect:/assignTeachers";
	}
	
}
