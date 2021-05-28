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
@Table(name="employers")
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User{
    @Column(name="company_name")
    private String companyName;

    @Column(name="company_email",nullable = false)
    private String email;

    @Column(name="telephone")
    private String telephone;

    @Column(name="web_site")
    private String webSite;

    @Column(name = "is_verified")
    private boolean isVerified;

}
