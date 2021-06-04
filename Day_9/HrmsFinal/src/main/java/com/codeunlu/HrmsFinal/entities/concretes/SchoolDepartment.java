package com.codeunlu.HrmsFinal.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schools_departments")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educations"})
public class SchoolDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "school_department_name")
    @NotBlank
    @NotNull
    private String schoolDepartmentName;

    @JsonIgnore
    @OneToMany(mappedBy = "schoolDepartment")
    private List<Education> educations;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
