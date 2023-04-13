package com.sch.admin.classteacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.sch.common.entity.ClassTeacher;

public interface ClassTeacherRepository extends JpaRepository<ClassTeacher, Integer>{

	Long countById(Integer id);
}
