package com.sch.admin.schoolhouse;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sch.common.entity.SchoolHouse;

@Controller
public class SchooHouseController {

	@Autowired SchoolHouseService schoolHouseService;
	
	//handler method that list all school houses
	@GetMapping("/schoolhouses")
	public ModelAndView listSchoolHouse() {
		SchoolHouse schoolHouse = new SchoolHouse();
		Iterable<SchoolHouse> listSchoolHouse  = schoolHouseService.listSchoolHouse();
		
		ModelAndView modelAndView = new ModelAndView("school_house/school_house");
		
		modelAndView.addObject("listSchoolHouse", listSchoolHouse);
		modelAndView.addObject("schoolHouse", schoolHouse);
		modelAndView.addObject(modelAndView);
		return modelAndView;
	}
	
	//handler method that save student house
	@PostMapping("/schoolhouses/save")
	public String save(SchoolHouse schoolHouse, RedirectAttributes ra) {
		
		schoolHouseService.save(schoolHouse);
		ra.addFlashAttribute("message", "Student house has been assigned to class successfully ");
		
		return "redirect:/schoolhouses";
	}
	
	//handler method that update student house
	@GetMapping("/schoolhouses/edit/{id}")
	public String editSchoolHouse(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
		
		try {
			SchoolHouse schoolHouse = schoolHouseService.getSchoolHouseId(id);
			Iterable<SchoolHouse> listSchoolHouse  = schoolHouseService.listSchoolHouse();
			
			model.addAttribute("schoolHouse", schoolHouse);
			model.addAttribute("listSchoolHouse", listSchoolHouse);
		} catch (SchoolHouseNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
		}
		
		return "school_house/school_house";
	}
	
	//handler method that delete student house
	@GetMapping("/schoolhouses/delete/{id}")
	public String deleteSchoolHouse(@PathVariable("id") Integer id, RedirectAttributes ra) {
		
		try {
			schoolHouseService.deleteSchoolHouse(id);
			ra.addFlashAttribute("message", "Student House has been deleted successfully");
		} catch (SchoolHouseNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
		}
		
		return "redirect:/schoolhouses";
	}
}
