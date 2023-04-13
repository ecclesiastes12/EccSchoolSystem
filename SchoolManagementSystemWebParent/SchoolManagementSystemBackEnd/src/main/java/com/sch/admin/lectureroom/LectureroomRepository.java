package com.sch.admin.lectureroom;



import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sch.common.entity.LectureRoom;
import com.sch.common.entity.Section;
import com.sch.common.entity.Subject;

public interface LectureroomRepository extends CrudRepository<LectureRoom, Integer>{

	@Query("SELECT l FROM LectureRoom l ORDER BY l.sections ASC ")
	public List<LectureRoom> findAllBySectionsSortrdBy();
	
	Long countById(Integer id);
	
	//for search
	@Query("SELECT l FROM LectureRoom l WHERE l.name LIKE %:keyword%")
	List<LectureRoom> findByKeyword(@Param("keyword") String keyword);


}
