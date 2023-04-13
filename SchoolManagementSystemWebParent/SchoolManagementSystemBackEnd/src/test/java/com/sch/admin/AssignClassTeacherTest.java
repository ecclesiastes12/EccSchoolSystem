package com.sch.admin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sch.admin.classteacher.ClassTeacherRepository;
import com.sch.admin.classteacher.ClassTeacherService;
import com.sch.admin.lectureroom.LectureRoomNotFoundException;
import com.sch.admin.lectureroom.LectureroomService;
import com.sch.admin.section.SectionNotFoundException;
import com.sch.admin.section.SectionService;
import com.sch.admin.staff.StaffNotFoundException;
import com.sch.admin.staff.StaffService;
import com.sch.common.entity.LectureRoom;
import com.sch.common.entity.Section;
import com.sch.common.entity.Staff;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class AssignClassTeacherTest {

	@Mock
	ClassTeacherRepository classTeacherRepo;
	
	@InjectMocks ClassTeacherService classTeacherService;
	@InjectMocks StaffService staffService;
	
	@InjectMocks SectionService sectionService;
	@InjectMocks LectureroomService lectureroomService;
	
	@Test
	public void testSaveService() {
		Integer sectionId = 1;
		Integer lectureroomId= 1;
		Integer staffId = 1;
		
		Mockito.when(null);
		
	}
}
