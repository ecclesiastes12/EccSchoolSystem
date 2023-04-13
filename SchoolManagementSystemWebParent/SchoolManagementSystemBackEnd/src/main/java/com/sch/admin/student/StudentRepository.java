package com.sch.admin.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sch.common.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Long countById(Integer id);

	@Query("SELECT s FROM Student s WHERE s.email = :email")
	public Student findStudentByEmail(@Param("email") String email);

}
