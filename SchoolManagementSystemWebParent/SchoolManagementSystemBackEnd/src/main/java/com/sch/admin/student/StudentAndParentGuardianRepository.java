package com.sch.admin.student;

import com.sch.common.entity.ParentGuardian;
import com.sch.common.entity.Student;

public interface StudentAndParentGuardianRepository {
	void save(Student student, ParentGuardian parentGuardian);
}
