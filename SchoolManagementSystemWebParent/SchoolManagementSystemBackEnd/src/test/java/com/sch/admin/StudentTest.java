package com.sch.admin;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sch.admin.student.StudentRepository;
import com.sch.admin.student.StudentService;
import com.sch.common.entity.Student;

//@ExtendWith(MockitoExtension.class)
//@ExtendWith(SpringExtension.class)

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class StudentTest {

//	@MockBean
//	private StudentRepository studentRepository;
//	
//	@InjectMocks
//	private StudentService studentService;
	
	@Autowired
	StudentRepository studentRepository;
	
//	@Test
//	public void testIsStudentEmailUnique() {
//		Integer id = 1;
//		String email = "Jones@gmail.com";
//		
//		Student student = new Student(id, email);
//		
//		Mockito.when(studentRepository.findStudentByEmail(email)).thenReturn(student);
//		
//		boolean result = studentService.isStudentEmailUnique(id, email);
//		
//		assertThat(result).isEqualTo("Duplicated");
//	}
	
	@Test
	public void testLastInsertedRecord() {
		
		Iterable<Student> student = studentRepository.findAll();
		//assertThat(student).isNotNull();
		student.forEach(stude -> System.out.println(student));;
	}
	
	@Test
	public void testGetStudentById() {
		String admissionNumber = "2023050001";
		Student student = studentRepository.findFirstByOrderByAdmissionNumberDesc();
		
		String studentString = student.getAdmissionNumber().toString();
		
		System.out.println("Converted Student object to String :" + studentString);
		
		int number = Integer.parseInt(studentString) + 1;
		
		System.out.println("Converted String object to integer :" + number);
		
		assertThat(student).isNotNull();
	}
}
