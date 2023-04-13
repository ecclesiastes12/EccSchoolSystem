package com.sch.admin.section;

import java.util.List;
import java.util.logging.Handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sch.common.entity.Section;

@Controller
public class SectionController {

	@Autowired SectionService sectionService;
	
	//handler method that display section form
	@GetMapping("/sections")
	public String viewSection(Model model) {
		
		Section section = new Section();
		List<Section> listSections = sectionService.listAllSections();
		
		model.addAttribute("section", section);
		model.addAttribute("listSections", listSections);
		
		
		
		return "academics/sections";
	}
	
	@PostMapping("/sections/save")
	public String createSection(Section section,RedirectAttributes ra) {

		sectionService.createSection(section);
		ra.addFlashAttribute("message", "The Section has been saved successfully");
		return "redirect:/sections";
	}
	
	//edit section
	@GetMapping("/sections/edit/{id}")
	public String editSection(Model model, @PathVariable("id") Integer id,
			RedirectAttributes ra) throws SectionNotFoundException {
		
		try {
			Section section = sectionService.getSectionId(id);
			
			List<Section> listSections = sectionService.listAllSections();
			model.addAttribute("listSections", listSections);
			model.addAttribute("section", section);
		} catch (SectionNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
		}
		
		return "academics/sections";
		
	}
	
	//Handler method that delete section
	@GetMapping("/sections/delete/{id}")
	public String deleteSection(@PathVariable("id") Integer id,
			RedirectAttributes ra) {
		//section id
		try {
			sectionService.deleteSection(id);
			ra.addFlashAttribute("message", "Section ID " + id + " has been deleted successfully");
		} catch (SectionNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
		}
		
		
		
		return "redirect:/sections";
	}
}
