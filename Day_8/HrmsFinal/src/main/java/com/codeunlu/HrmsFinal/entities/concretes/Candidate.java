package com.codeunlu.HrmsFinal.entities.concretes;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name = "candidates")
public class Candidate extends User{
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "national_id",length = 11)
    private String nationalId;
    @Column(name = "date_of_birth")
    private LocalDate dateofBirth;
    @Column(name = "is_verified")
    private boolean isVerified;
}
