package com.codeunlu.HrmsFinal.dataAccess.abstracts;

import com.codeunlu.HrmsFinal.entities.concretes.JobCity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobCityDao extends JpaRepository<JobCity,Integer> {
}
