package com.sch.admin.classteacher;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sch.common.entity.ClassTeacher;

@Service
public class ClassTeacherService {
	@Autowired ClassTeacherRepository classTeacherRepo;

	//service method that list all assigned class teacher list
	public List<ClassTeacher> listClassTeachers() {
		return classTeacherRepo.findAll();
	}
	
	//service method that saves assigned class teacher
	public ClassTeacher saveClassTeacher(ClassTeacher classTeacher) {
		
		return classTeacherRepo.save(classTeacher);
	}
	
	//service method that get assigned class teachers list by id
	public ClassTeacher geClassTeacherId(Integer id) throws ClassTeacherNotFoundException {
		try {
			return classTeacherRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			throw new ClassTeacherNotFoundException("Could not find assigned class teacher ID " + id);
		}
	}
	
	//service method that delete assigned class teacher
	public void deleteClassTeacher(Integer id) throws ClassTeacherNotFoundException {
		Long countById = classTeacherRepo.countById(id);
		
		if(countById == 0 || countById == null) {
			throw new ClassTeacherNotFoundException("Could not find assigned class teacher ID (" + id + ")");
		}
		
		classTeacherRepo.deleteById(id);
	}
}
