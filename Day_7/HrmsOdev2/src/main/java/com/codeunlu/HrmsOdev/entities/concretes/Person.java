package com.codeunlu.HrmsOdev.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@Table(name="persons")
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
public class Person extends User{

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name="department_id")
    private int departmentId;

    @Column(name="is_active")
    private boolean isActive;
}
