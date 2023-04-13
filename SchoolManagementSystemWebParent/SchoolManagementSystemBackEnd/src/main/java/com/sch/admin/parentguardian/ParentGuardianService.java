package com.sch.admin.parentguardian;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sch.admin.student.StudentNotFoundException;
import com.sch.common.entity.ParentGuardian;
import com.sch.common.entity.Student;

@Service
public class ParentGuardianService {

	@Autowired ParentGuardianRepository parentGuardianRepo;
	
	public ParentGuardian saveParentGuardian(ParentGuardian parentGuardian) {
		
		return parentGuardianRepo.save(parentGuardian);
	}
	
	//service method that get student by id
	public ParentGuardian getParentGuardiantId(Integer id) throws ParentGuardianNotFoundException {
		try {
			return parentGuardianRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			throw new ParentGuardianNotFoundException("Could not find ParentGuardian ID " + id);
		}
	}
}
