package com.sch.admin.subject;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sch.common.entity.Subject;

@Service
public class SubjectService {

	@Autowired SubjectRepository subjectRepo;
	
//	//service method that list subject
//	public List<Subject> listSubjects(){
//		
//		return subjectRepo.findAll();
//	}
	
	//service method that list subject
	//modified with keyword. NB no paging and sorting
	public List<Subject> listSubjects(String keyword){
		
		if(keyword != null) {
			return subjectRepo.findByKeyword(keyword);
		}
		return subjectRepo.findAll();
	}
	
	//service method that saves subjects
	public Subject saveSubject(Subject subject) {
		return subjectRepo.save(subject);
	}
	
	//service method that get subjecd by id
	public Subject getSubjectId(Integer id) throws SubjectNotFoundException {
		
		try {
			return subjectRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			
			throw new SubjectNotFoundException("Could not find Subject ID (" + id + ")");
		}
	}
	
	//service that delete subject
	public void deleteSubject(Integer id) throws SubjectNotFoundException {
		Long countById = subjectRepo.countById(id);
		
		if(countById == null || countById == 0) {
			throw new SubjectNotFoundException("Could not find Subject ID (" + id + ")");
		}
		
		subjectRepo.deleteById(id);
	}
	
	//NB this is without paging and sorting
	//get subject by keyword thus for searching a subject
	public List<Subject> getByKeyword(String keyword){
		return subjectRepo.findByKeyword(keyword);
	}
}
