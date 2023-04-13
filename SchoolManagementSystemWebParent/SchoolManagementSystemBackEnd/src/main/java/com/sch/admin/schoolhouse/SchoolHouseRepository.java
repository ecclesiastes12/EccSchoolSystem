package com.sch.admin.schoolhouse;

import org.springframework.data.repository.CrudRepository;

import com.sch.common.entity.SchoolHouse;

public interface SchoolHouseRepository extends CrudRepository<SchoolHouse, Integer> {

	Long countById(Integer id);

}
