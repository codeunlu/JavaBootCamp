package com.codeunlu.HrmsOdev.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="verifaction_persons")
@AllArgsConstructor
@NoArgsConstructor
public class VerifactionPerson{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int Id;

    @Column(name = "user_id")
    private int userId;

    @Column(name="person_id")
    private int personId;
}
