package com.codeunlu.HrmsOdev.dataAccess.abstracts;

import com.codeunlu.HrmsOdev.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {
    List<JobPosition> findAllByTitle(String title);
}
