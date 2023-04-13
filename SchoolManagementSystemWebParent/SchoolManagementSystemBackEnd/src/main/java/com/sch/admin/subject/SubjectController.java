package com.sch.admin.subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sch.common.entity.Subject;

@Controller
public class SubjectController {

	@Autowired SubjectService subjectService;
	
	/*
	 * @GetMapping("/subjects") public String viewSubjects(Model model) {
	 * 
	 * List<Subject> listAllSubjects = subjectService.listSubjects();
	 * model.addAttribute("listSubjects", listAllSubjects);
	 * 
	 * return "academics/subjects"; }
	 */
	
	//Modified with search parameter. NB this is without paging and sorting
	@GetMapping("/subjects")
	public String viewSubjects(Model model, String keyword) {
		
		List<Subject> listAllSubjects = subjectService.listSubjects(keyword);
		model.addAttribute("listSubjects", listAllSubjects);
		
		model.addAttribute("placeHoler", "Search by subject or subject code");
		
		return "academics/subjects";
	}
	
	@GetMapping("/subjects/new")
	public String viewSubjectsForm(Model model) {
		
		Subject subject = new Subject();
		model.addAttribute("subject", subject);
		model.addAttribute("pageTitle", "Add");
		
		return "academics/subject_form_modal";
	}
	//handler method that saves subject
	@PostMapping("/subjects/save")
	public String saveSubjects(Subject subject, RedirectAttributes ra) {
		
		subjectService.saveSubject(subject);
		
		ra.addFlashAttribute("message", "Subject saved successfully");
		
		return "redirect:/subjects";
	}
	
	
	
	// handler method that display edit form

	
	@GetMapping("/subjects/edit/{id}")
	public String editSubject( @PathVariable("id") Integer id, Model model,RedirectAttributes ra) {
		try {
			Subject subject = subjectService.getSubjectId(id);
			model.addAttribute("subject", subject);
		} catch (SubjectNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
		}

		return "academics/subject_form_modal";
	}
	 
	 
	/*
	 * @GetMapping("/subjects/edit/{id}") public Subject
	 * editSubject(@PathVariable("id") Integer id, RedirectAttributes ra){ try {
	 * Subject subject = subjectService.getSubjectId(id); } catch
	 * (SubjectNotFoundException e) { ra.addFlashAttribute("message",
	 * e.getMessage()); }
	 * 
	 * return "academics/subject_form_modal"; }
	 */
	
	//handler method that deletes subject
	@GetMapping("/subjects/delete/{id}")
	public String deleteSubject(@PathVariable(name = "id") Integer id, RedirectAttributes ra) {
		
		try {
			subjectService.deleteSubject(id);
			ra.addFlashAttribute("message", "Subject ID " + id + " has been deleted successfully");
		} catch (SubjectNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
		}
		
		return "redirect:/subjects";
	}
}
