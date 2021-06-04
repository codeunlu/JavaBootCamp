package com.codeunlu.HrmsFinal.dataAccess.abstracts;

import com.codeunlu.HrmsFinal.entities.concretes.JobAdvert;
import com.codeunlu.HrmsFinal.entities.dto.JobAdvertDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert,Integer> {

    @Query("FROM JobAdvert WHERE employers.id = :id")
    List<JobAdvert> findByEmployers(int id);

    @Query("From JobAdvert WHERE id = :id")
    JobAdvert findById(int id);

    @Query("Select new com.codeunlu.HrmsFinal.entities.dto.JobAdvertDto(j.id,e.companyName,p.title,j.quantity,j.releaseDate,j.deadlineDate) from JobAdvert j inner join j.employers e inner join j.jobPositions p where j.isActive = true")
    List<JobAdvertDto> getActiveAdverts();

    @Query("Select new com.codeunlu.HrmsFinal.entities.dto.JobAdvertDto(j.id,e.companyName,p.title,j.quantity,j.releaseDate,j.deadlineDate) from JobAdvert j inner join j.employers e inner join j.jobPositions p where j.isActive = true ORDER BY j.releaseDate DESC")
    List<JobAdvertDto> getActiveAdvertsDesc();

    @Query("Select new com.codeunlu.HrmsFinal.entities.dto.JobAdvertDto(j.id,e.companyName,p.title,j.quantity,j.releaseDate,j.deadlineDate) from JobAdvert j inner join j.employers e inner join j.jobPositions p where j.isActive = true ORDER BY j.releaseDate ASC")
    List<JobAdvertDto> getActiveAdvertsAsc();

    @Query("Select new com.codeunlu.HrmsFinal.entities.dto.JobAdvertDto(j.id,e.companyName,p.title,j.quantity,j.releaseDate,j.deadlineDate) from JobAdvert j inner join j.employers e inner join j.jobPositions p where j.isActive = true and j.employers = :id")
    List<JobAdvertDto> getActiveAdvertsEmployer(int id);
}
