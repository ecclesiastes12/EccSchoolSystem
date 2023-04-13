package com.sch.admin.assignsubject;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import com.sch.common.entity.AssignSubject;

public class AssignSubjectService {
	
	@Autowired AssignSubjectRepository assignSubRepo;
	
	public List<AssignSubject> listAllAssignSubjects(){
		
		return (List<AssignSubject>) assignSubRepo.findAll();
	}
	
	public AssignSubject saveAssignSubject(AssignSubject assignSubject) {
		return assignSubRepo.save(assignSubject);
	}
	
	public AssignSubject getAssignSubjectId(Integer id) throws AssignSubjectNotFoundException {
		try {
			return assignSubRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			throw new AssignSubjectNotFoundException("Could not find Teacher Assigned subject ID " + id);
		}
	}
	
	public void deleteAssignSubject(Integer id) throws AssignSubjectNotFoundException {
		Long countById = assignSubRepo.countById(id);
		
		if(countById == null || countById == 0) {
			throw new AssignSubjectNotFoundException("Could not find Teacher Assigned subject ID " + id);
		}
	}

}
