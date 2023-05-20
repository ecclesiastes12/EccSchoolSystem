package com.sch.admin.parentguardian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sch.common.entity.ParentGuardian;

public interface ParentGuardianRepository extends JpaRepository<ParentGuardian, Integer>{

	@Query("SELECT p FROM ParentGuardian p WHERE p.guardianEmail = ?1")
	public ParentGuardian findParentGuardianByEmail(String email);
}
