package com.sch.admin.lectureroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sch.admin.section.SectionService;
import com.sch.common.entity.LectureRoom;
import com.sch.common.entity.Section;

@Controller
public class LectureroomController {

	@Autowired SectionService sectionService;
	@Autowired LectureroomService lectureroomService;
	
	@GetMapping("/lecturerooms")
	public String viewLectureRoom(Model model, String keyword) {
		
		LectureRoom lectureroom = new LectureRoom();
		//List<Section> listSections = sectionService.listAllSections();
		
		//list lecture rooms
		List<LectureRoom> listLecturerooms = lectureroomService.listAllLectureRooms(keyword);
		
		List<Section> listSectionWithSort = lectureroomService.listAllSections();
		
		model.addAttribute("lectureroom", lectureroom);
		//model.addAttribute("listSections", listSections);
		model.addAttribute("listSectionWithSort", listSectionWithSort);
		model.addAttribute("placeHoler", "Search by class name");
		model.addAttribute("listLecturerooms", listLecturerooms);
		model.addAttribute("pageTitle", "Add");
		return "academics/lectureRoom";
	}
	
	//handler method that save lecture room
	@PostMapping("/lecturerooms/save")
	public String saveLectureRoom(LectureRoom lectureRoom, RedirectAttributes ra) {
		
		lectureroomService.saveLectureRoom(lectureRoom);
		ra.addFlashAttribute("message", "Lecture room save succesffully");
		return "redirect:/lecturerooms";
		
		
	}
	
	//handler method that display edit form
	@GetMapping("/lecturerooms/edit/{id}")
	public String editLectureRoom(Model model, @PathVariable("id") Integer id, RedirectAttributes ra,String keyword) {
		
		try {
			
			LectureRoom lectureroom = lectureroomService.getLectureRoomId(id);
			List<Section> listSections = sectionService.listAllSections();
			
			//list lecture rooms
			List<LectureRoom> listLecturerooms = lectureroomService.listAllLectureRooms(keyword);
			
			
			model.addAttribute("lectureroom", lectureroom);
			model.addAttribute("listSections", listSections);
			
			model.addAttribute("listLecturerooms", listLecturerooms);
			model.addAttribute("pageTitle", "Edit");
		} catch (LectureRoomNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
		}
		
		
		
		return "academics/lectureRoom";
	}
	
	//handler method that delete lecture room
	@GetMapping("/lecturerooms/delete/{id}")
	public String deleteLectureRoom(@PathVariable("id") Integer id, RedirectAttributes ra) {
		
		try {
			lectureroomService.deleteLectureRoom(id);
			ra.addFlashAttribute("message", "Lecture room with ID ( " + id + " ) has been deleted successfully");
		} catch (LectureRoomNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
		}
		
		return "redirect:/lecturerooms";
	}
}
