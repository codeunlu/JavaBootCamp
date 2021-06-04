package com.codeunlu.HrmsFinal.dataAccess.abstracts;

import com.codeunlu.HrmsFinal.entities.concretes.Employer;
import com.codeunlu.HrmsFinal.entities.concretes.JobAdvert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
    List<Employer> findByEmail(String email);
    @Query("FROM JobAdvert WHERE isActive = true AND employers.id = :id")
    List<JobAdvert> getByJobAdvertsId(int id);
    Employer findById(int id);

}
