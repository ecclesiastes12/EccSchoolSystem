package com.sch.admin;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.sch.admin.staff.StaffRepository;
import com.sch.common.entity.Staff;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class StaffTest {

	@Autowired StaffRepository staffRepo;
	
	//test method that create new staff
	@Test
	public void testStaff() {
		Staff staff = new Staff("Joseph","Obeng","Ntim","obeng1@gmail.com","obeng12345","Masters");
		
		Staff savedStaff = staffRepo.save(staff);
		
		assertThat(savedStaff).isNotNull();
		assertThat(savedStaff.getId()).isGreaterThan(0);
	}
}
