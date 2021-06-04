package com.codeunlu.HrmsFinal.dataAccess.abstracts;

import com.codeunlu.HrmsFinal.entities.concretes.SchoolDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDepartmentDao extends JpaRepository<SchoolDepartment,Integer> {
}
