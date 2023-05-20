package com.sch.admin.student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sch.admin.parentguardian.ParentGuardianRepository;
import com.sch.common.entity.IsGuradianFatherOrMotherOrOther;
import com.sch.common.entity.ParentGuardian;
import com.sch.common.entity.Student;

@Service
public class StudentService {
	//constant variable for page size thus total number of list per page
	public static final int STUDENTS_PER_PAGE = 4;
		
	@Autowired StudentRepository studentRepo;
	@Autowired ParentGuardianRepository parentGuardianRepo;

	//service that list all student
	public List<Student> listStudents(){
		return studentRepo.findAll();
	}
	
	//service the create save student
	public Student saveStudent(Student student) {
		
		// checks if the form is in the edit or new user mode before saving the data
		boolean isUpdatingStudent = (student.getId() != null);
		boolean isUpdatingParentGuardian = (student.getParentGuardian().getId() != null);
		
		if(isUpdatingStudent) {
			//get the details of existing student
			Student existingStudent = studentRepo.findById(student.getId()).get();
			
//			if(student.getPhoto().isEmpty()) {
//				student.setPhoto(existingStudent.getPhoto());
//			}else {
//				student.setPhoto(student.getPhoto());
//			}
//				
//			if(student.getParentGuardian().getFatherPhoto().isEmpty()) {
//				
//				student.getParentGuardian().setFatherPhoto(existingStudent.getParentGuardian().getFatherPhoto());
//			}else {
//				student.getParentGuardian().setFatherPhoto(student.getParentGuardian().getFatherPhoto());
//			}
//			
//			if(student.getParentGuardian().getMotherPhoto().isEmpty()) {
//				
//				student.getParentGuardian().setMotherPhoto(existingStudent.getParentGuardian().getMotherPhoto());
//			}else {
//				student.getParentGuardian().setFatherPhoto(student.getParentGuardian().getMotherPhoto());
//			}
				
			
			
//			if(student.getParentGuardian().getGuardianPhoto().isEmpty()) {
//				
//				student.getParentGuardian().setGuardianPhoto(existingStudent.getParentGuardian().getGuardianPhoto());
//			}else {
//				student.getParentGuardian().setGuardianPhoto(student.getParentGuardian().getGuardianPhoto());
//			}
				
			
			
			
			
			if((student.getParentGuardian().getIsGuardianFatherMotherOther().equals(IsGuradianFatherOrMotherOrOther.Father)) || 
					(student.getParentGuardian().getIsGuardianFatherMotherOther().equals(IsGuradianFatherOrMotherOrOther.Mother))) {
				student.getParentGuardian().setGuardianName("");
				student.getParentGuardian().setGuardianAddress(null);
				student.getParentGuardian().setGuardianEmail(null);
				student.getParentGuardian().setGuardianOccupation(null);
				student.getParentGuardian().setGuardianPhoneNumber(null);
				student.getParentGuardian().setGuardianRelation(null);
			}
		}
		
		return studentRepo.save(student);
	}
	
//	//service the create save student
//	public Student updateStudent(Student student) {
//		
//		// checks if the form is in the edit or new user mode before saving the data
//		boolean isUpdatingStudent = (student.getId() != null);
//		
//		if(isUpdatingStudent) {
//			//retrieves user details from the database
//			Student studentInDB = studentRepo.findById(student.getId()).get();
//			studentInDB.getEmail();
//			if(studentInDB.getParentGuardian().getIsGuardianFatherMotherOther() == "Father" || studentInDB.getParentGuardian().getIsGuardianFatherMotherOther() == "Mother") {
//				studentInDB.getParentGuardian().setGuardianName("");
//				studentInDB.getParentGuardian().setGuardianAddress("");
//				studentInDB.getParentGuardian().setGuardianEmail("");
//				studentInDB.getParentGuardian().setGuardianOccupation("");
//				studentInDB.getParentGuardian().setGuardianPhoneNumber("");
//				studentInDB.getParentGuardian().setGuardianRelation("");
//				studentInDB.setEmail("");
//				studentInDB.setEmail(studentInDB.getEmail());
//				
//				
//			}
//		
//			
//		}
//		return studentRepo.save(student);
//	}
	
	/*
	 * //service method that list students per page public Page<Student>
	 * listByPage(int pageNumber){ Pageable pageable = PageRequest.of(pageNumber -
	 * 1, STUDENTS_PER_PAGE); return studentRepo.findAll(pageable); }
	 */
	
	
	//service method that list students per page.
	//method modified for sorting purpose
	public Page<Student> listByPage(int pageNumber, String sortField, String sortDir){
		//sort field by field name
		Sort sort = Sort.by(sortField);
		
		//sort in ascending or descending order
		sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
		
		Pageable pageable = PageRequest.of(pageNumber - 1, STUDENTS_PER_PAGE, sort);
		return studentRepo.findAll(pageable);
	}
		
	//method that check the uniqueness of student email
	public boolean isStudentEmailUnique(Integer id, String email) {
		Student studentByEmail = studentRepo.findStudentByEmail(email);
		
//		//return studentByEmail == null; //if null value is return it means email is unique
//		if(studentByEmail == null) {
//			return true;
//		}
//		
//		// if id is null meaning the form is in the new mode
//		// if id is not null meaning the form is in the edit mode
//		boolean isCreatingNewStudent = (id == null);
//		
//		if(isCreatingNewStudent) {
//			// if email is not null meaning the email exist in the db
//			// therefore the email is not unique. New email must be provided
//			if(studentByEmail != null) {
//				return false;
//			}
//		}else {
//			// if the ID of the student find by email is different from the ID
//			// of the student being edited then email is not unique
//			if(studentByEmail.getId() != id) {
//				return false;
//			}
//		}
		
//		if(studentByEmail != null && studentByEmail.getId() != id) {
//			return false;
//		}
		
		if(studentByEmail != null && studentByEmail.getId() != id ) {
			return false;
		}
		
		return true;
	}
	
	
	//service method that find email of a guardian
	/*
	 * public boolean isParentGuardianEmailUnique(String email) { if(email == null
	 * || email.isEmpty()) { return true; }
	 * 
	 * ParentGuardian parentGuardianByEmail =
	 * parentGuardianRepo.findParentGuardianByEmail(email);
	 * 
	 * return parentGuardianByEmail == null; }
	 */
	
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
	
//	 public String generateAdmissionNumber() {
//	        Date date = new Date();
//	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
//	        String yearMonth = dateFormat.format(date);
//	        Integer latestNumber = admissionRepository.findLatestAdmissionNumberByYearMonth(yearMonth);
//	        if (latestNumber == null) {
//	            latestNumber = 0;
//	        }
//	        Integer nextNumber = latestNumber + 1;
//	        String admissionNumber = yearMonth + String.format("%04d", nextNumber);
//	        return admissionNumber;
//	    }
	
//	public String generateAdmissionNumber() {
//		LocalDate currentDate = LocalDate.now();
//		String yearMonth = currentDate.format(DateTimeFormatter.ofPattern("yyyyMM"));
//		Student latestAdmissionNumber = studentRepo.findFirstByOrderByAdmissionNumberDesc();
//		int number = 1;
//		if (latestAdmissionNumber != null) {
//			String latestAdmissionNumberToString = latestAdmissionNumber.getAdmissionNumber().toString();
//		  
//				number = Integer.parseInt(latestAdmissionNumberToString) + 1;
//				
//				System.out.println("printed number :" + number);
//			
//		}
//		String newAdmissionNumber = yearMonth + String.format("%04d", number);
//		Student student = new Student();
//		student.setAdmissionNumber(newAdmissionNumber);
//		System.out.println("Set admission number :" + newAdmissionNumber);
//		return newAdmissionNumber;
//	}
	
	public String generateAdmissionNumber() {
		LocalDate currentDate = LocalDate.now();
		String yearMonth = currentDate.format(DateTimeFormatter.ofPattern("yyyyMM"));
		Student latestAdmissionNumber = studentRepo.findFirstByOrderByAdmissionNumberDesc();
		int number = 1;
		Student student = new Student();
		if (latestAdmissionNumber == null) {
			String newAdmissionNumber = (yearMonth + String.format("%04d", number));
			student.setAdmissionNumber(newAdmissionNumber);
			return newAdmissionNumber;
		}else {
			String latestAdmissionNumberToString = latestAdmissionNumber.getAdmissionNumber().toString();
			number = Integer.parseInt(latestAdmissionNumberToString) + 1;
			String newAdmissionNumber = Integer.toString(number).trim();
			student.setAdmissionNumber(newAdmissionNumber);
			return newAdmissionNumber;
		}
		
	}
}
