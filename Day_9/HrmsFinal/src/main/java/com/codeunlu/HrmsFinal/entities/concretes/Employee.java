package com.codeunlu.HrmsFinal.entities.concretes;
import com.codeunlu.HrmsFinal.entities.concretes.Department;

import com.codeunlu.HrmsFinal.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name = "employees")
public class Employee extends User {
    @Column(name = "name")
    @NotBlank
    @NotNull
    private String name;
    @Column(name = "surname")
    @NotBlank
    @NotNull
    private String surname;


    @OneToOne
    @JoinColumn(name = "department_id")
    private Department departments;

    @Column(name = "is_active")
    private boolean isActive;
}
