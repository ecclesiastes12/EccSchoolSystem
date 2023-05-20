package com.sch.admin.TimeTable;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sch.common.entity.TimeTable;

public interface TimeTableRepository extends CrudRepository<TimeTable, Integer>{

	TimeTable save(List<TimeTable> list);

}
