package com.sch.admin.assignsubject;

import org.springframework.data.repository.CrudRepository;

import com.sch.common.entity.AssignSubject;

public interface AssignSubjectRepository extends CrudRepository<AssignSubject, Integer>{

	Long countById(Integer id);
}
