package com.sch.admin;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sch.admin.assignsubject.AssignSubjectRepository;
import com.sch.admin.staff.StaffRepository;
import com.sch.admin.subject.SubjectRepository;
import com.sch.common.entity.AssignSubject;
import com.sch.common.entity.Staff;
import com.sch.common.entity.Subject;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class AssignSubjectTest {

	@Autowired AssignSubjectRepository assignSubjectRepo;
	@Autowired StaffRepository staffRepo;
	@Autowired SubjectRepository subjectRepo;
	
	@Test
	public void newSubjectAssign() {
		
		Staff staffId = staffRepo.findById(2).get();
		Subject subjectId = subjectRepo.findById(1).get();
		
		AssignSubject assignSubject = new AssignSubject(subjectId, staffId);
		
		AssignSubject savedAssignSubject = assignSubjectRepo.save(assignSubject);
		
		assertThat(savedAssignSubject).isNotNull();
		assertThat(savedAssignSubject.getId()).isGreaterThan(0);
		
	}
}
