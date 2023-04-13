package com.sch.admin.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sch.common.entity.Staff;

@Controller
public class StaffController {

	@Autowired StaffService staffService;

	//handler method that list all staffs
	@GetMapping("/staffs")
	public String viewStaff(Model model) {
		
		List<Staff> listStaff = staffService.listAllStaffs();
		model.addAttribute("listStaff", listStaff);
		
		return "staffs/teachers";
	}
	
	//handler method that display enrollment form
	@GetMapping("/staffs/new")
	public String viewStaffForm(Model model) {
		
		Staff staff = new Staff();
		model.addAttribute("staff", staff);
		
		return "staffs/staff_form_modal";
	}
	
	//handler method that create staff
	@PostMapping("/staffs/save")
	public String saveStaff(Staff staff) {
		
		staffService.CreateNewStaff(staff);
		
		return "redirect:/staffs";
	}
	
	@GetMapping("/staffs/edit/{id}")
	public String editStaff(Model model, @PathVariable("id") Integer id,
			RedirectAttributes ra) {
		
		//get staff by id
		try {
			Staff staff = staffService.getStaffById(id);
			model.addAttribute("staff", staff);
			
		} catch (StaffNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
		}
		
		return "staffs/staff_form_modal";
	}
}
