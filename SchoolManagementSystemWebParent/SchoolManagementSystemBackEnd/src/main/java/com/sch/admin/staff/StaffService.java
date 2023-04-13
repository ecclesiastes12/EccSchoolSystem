package com.sch.admin.staff;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sch.common.entity.Staff;
import com.sch.common.entity.StaffCategory;

@Service
public class StaffService {

@Autowired StaffRepository staffRepo;
	
	//service method that list all staff
	public List<Staff> listAllStaffs(){
		return staffRepo.findAll();
	}
	
	//service method that get staff by id
	public Staff getStaffById(Integer id) throws StaffNotFoundException {
		
		try {
			return staffRepo.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new StaffNotFoundException("Could not find Staff with ID: " + id + "");
		}
		
	}
	
	//service method that list teaching staffs only
	public List<Staff> findByStaffCategory(StaffCategory staffCategory){
		return staffRepo.findByCategory(staffCategory);
	}
	
	//service method that save new staff and edit staff
	public Staff CreateNewStaff(Staff staff) {
		
		//check if staff id is not null
		boolean isUpdating = staff.getId() != null;
		
		if(isUpdating) {
			//retrieve staff details from the db
			Staff existingStaff = staffRepo.findById(staff.getId()).get();
			
			//Staff existingStaffRoles = staffRepo.findByStaffRole(staff.getId());
			if(staff.getStaffCategory().equals(StaffCategory.TEACHING)) {
				staff.setStaffCategory(StaffCategory.TEACHING);
			}
			if(existingStaff.getRoles() != null) {
				staff.setRoles(staff.getRoles());
				System.out.println(staff.getRoles());
			}
		}else {
			staff.setStaffCategory(StaffCategory.NON_TEACHING);
		}
		
		return staffRepo.save(staff);
	}
	
	
	//service method that delete staff
	public void deleteStaff(Integer id) throws StaffNotFoundException{
		
		Long countById = staffRepo.countById(id);
		
		if (countById == null || countById == 0) {
			throw new StaffNotFoundException("Could not find Staff with ID: " + id + "");
		}
		
		staffRepo.deleteById(id);
	}
}
