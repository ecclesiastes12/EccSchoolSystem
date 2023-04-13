package com.sch.admin.student;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sch.admin.parentguardian.ParentGuardianRepository;
import com.sch.common.entity.ParentGuardian;
import com.sch.common.entity.Student;

@Service
public class StudentService {
	
	@Autowired StudentRepository studentRepo;
	@Autowired ParentGuardianRepository parentGuardianRepo;

	//service that list all student
	public List<Student> listStudents(){
		return studentRepo.findAll();
	}
	
	//service the create save student
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}
	
	//method that check the uniqueness of student email
	public boolean isStudentEmailUnique(String email) {
		Student studentByEmail = studentRepo.findStudentByEmail(email);
		
		return studentByEmail == null; //if null value is return it means email is unique
	}
	
	//service method that get student by id
	public Student getStudentId(Integer id) throws StudentNotFoundException {
		try {
			return studentRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			throw new StudentNotFoundException("Could not find Student ID " + id);
		}
	}
	
	//service method that delete student
	public void deleteStudent(Integer id) throws StudentNotFoundException {
		 
		Long countById = studentRepo.countById(id);
		
		if(countById == null || countById == 0) {
			throw new StudentNotFoundException("Could not find Student ID " + id);
		}
		
		studentRepo.deleteById(id);
	}
}
