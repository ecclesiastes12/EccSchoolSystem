package com.sch.admin.subject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sch.common.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer>{

	Long countById(Integer id);
	
	//for search
	@Query("SELECT s FROM Subject s WHERE s.code LIKE %:keyword% or s.name LIKE %:keyword%")
	List<Subject> findByKeyword(@Param("keyword") String keyword);

}
