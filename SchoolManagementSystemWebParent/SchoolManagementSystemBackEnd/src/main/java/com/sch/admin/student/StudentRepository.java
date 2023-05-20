package com.sch.admin.student;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sch.common.entity.BloodGroup;
import com.sch.common.entity.Gender;
import com.sch.common.entity.LectureRoom;
import com.sch.common.entity.ParentGuardian;
import com.sch.common.entity.SchoolHouse;
import com.sch.common.entity.Section;
import com.sch.common.entity.Student;

import jakarta.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Long countById(Integer id);

	@Query("SELECT s FROM Student s WHERE s.email = :email")
	public Student findStudentByEmail(@Param("email") String email);


	public Student findFirstByOrderByAdmissionNumberDesc();

//	//custom query to delete student
//	@Modifying
//    @Transactional
//    @Query("DELETE FROM Student s WHERE s.id = :id")
//    void deleteById(@Param("id") Long id);
}
