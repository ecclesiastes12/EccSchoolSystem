package com.sch.admin.lectureroom;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sch.admin.section.SectionRepository;
import com.sch.common.entity.LectureRoom;
import com.sch.common.entity.Section;

@Service
public class LectureroomService {
	
	@Autowired LectureroomRepository lectureroomRepo;
	@Autowired SectionRepository sectionRepo;
	
//	//service that list all lecture room
//	public List<LectureRoom> listAllLectureRooms(){
//		return (List<LectureRoom>) lectureroomRepo.findAll();
//	}
	
	//service that list all lecture room
	//modified parameter with keyword for searching. NB no paging and sorting applied
	public List<LectureRoom> listAllLectureRooms(String keyword){
		
		if(keyword != null) {
			return lectureroomRepo.findByKeyword(keyword);
		}
		return (List<LectureRoom>) lectureroomRepo.findAll();
	}

	//list sections for lecture room
	public List<Section> listAllSections(){
		return sectionRepo.findAllByOrderByNameAsc();
	}
	
	//service method that save lecture room
	public LectureRoom saveLectureRoom(LectureRoom lectureRoom) {
		
		return lectureroomRepo.save(lectureRoom);
	}
	
	public LectureRoom getLectureRoomId(Integer id) throws LectureRoomNotFoundException {
		
		try {
			return lectureroomRepo.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new LectureRoomNotFoundException("Could not find Lecture Room ID " + id);
		}
	}
	
	
	public void deleteLectureRoom(Integer id) throws LectureRoomNotFoundException {
		
		Long countById = lectureroomRepo.countById(id);
		
		if(countById == null || countById == 0) {
			throw new LectureRoomNotFoundException("Could not find Lecture Room ID " + id);
		}
		
		lectureroomRepo.deleteById(id);
	}
}
