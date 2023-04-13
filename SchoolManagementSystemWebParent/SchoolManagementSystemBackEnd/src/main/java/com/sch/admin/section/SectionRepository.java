package com.sch.admin.section;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sch.common.entity.Section;


public interface SectionRepository extends CrudRepository<Section, Integer>{

	Long countById(Integer id);

	public List<Section> findAllByOrderByNameAsc();
}
