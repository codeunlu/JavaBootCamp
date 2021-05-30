package com.codeunlu.HrmsFinal.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_adverts")
public class JobAdvert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPositions;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private JobCity jobCities;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employers;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "salary_min")
    private double salaryMin;

    @Column(name = "salary_max")
    private double salaryMax;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "deadline_date")
    private LocalDate deadlineDate;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private boolean isActive = true;
}
