package com.codeunlu.HrmsFinal.dataAccess.abstracts;

import com.codeunlu.HrmsFinal.entities.concretes.JobAdvert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert,Integer> {
    @Query("FROM JobAdvert WHERE isActive = true")
    List<JobAdvert> getByActiveTrue();

    @Query("FROM JobAdvert WHERE isActive = true ORDER BY releaseDate DESC")
    List<JobAdvert> getByReleaseDateDesc();

    @Query("FROM JobAdvert WHERE isActive = true ORDER BY releaseDate ASC")
    List<JobAdvert> getByReleaseDateAsc();

    @Query("FROM JobAdvert WHERE isActive = true AND employers.id = :id")
    List<JobAdvert> getByEmployersId(int id);

    @Query("FROM JobAdvert WHERE employers.id = :id")
    List<JobAdvert> findByEmployers(int id);

    @Query("From JobAdvert WHERE id = :id")
    JobAdvert findById(int id);
}
