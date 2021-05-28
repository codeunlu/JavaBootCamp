package com.codeunlu.HrmsOdev.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends User{
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "national_id")
    private String nationalId;

    @Column(name = "date_year")
    private String dateYear;

    @Column(name = "is_verified")
    private boolean isVerified;
}
