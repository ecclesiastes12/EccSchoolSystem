package com.sch.admin.schoolhouse;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sch.common.entity.SchoolHouse;

@Service
public class SchoolHouseService {
	
	@Autowired SchoolHouseRepository schoolHouseRepo;

	//service method that list school houses
	public Iterable<SchoolHouse> listSchoolHouse(){
		return  schoolHouseRepo.findAll();
	}
	
	//service method that find school house by id
	public SchoolHouse getSchoolHouseId(Integer id) throws SchoolHouseNotFoundException{
		
		try {
			return schoolHouseRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			throw new SchoolHouseNotFoundException("Could not find school house ID (" + id + ")");
		}
		
	}
	
	//service method that save school house
	public SchoolHouse save(SchoolHouse schoolHouse) {
		return schoolHouseRepo.save(schoolHouse);
	}
	
	
	//service method that delete school house
	public void deleteSchoolHouse(Integer id) throws SchoolHouseNotFoundException {
		
		Long countById = schoolHouseRepo.countById(id);
		
		if(countById == null || countById == 0 ) {
			throw new SchoolHouseNotFoundException("Could not find school house ID (" + id + ")");
		}
		
		schoolHouseRepo.deleteById(id);
	}
	
}
