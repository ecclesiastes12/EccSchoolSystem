package com.sch.admin.staff;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sch.common.entity.Staff;
import com.sch.common.entity.StaffCategory;

public interface StaffRepository extends JpaRepository<Staff, Integer>{

	//method to be used to check the existence of  user before deletion
	public Long countById(Integer id);
	
	//custom query that select staff by category
	@Query("SELECT s FROM Staff s WHERE s.staffCategory = :TEACHING")
	public List<Staff> findByCategory(@Param("TEACHING") StaffCategory teaching);
}
