package com.codeunlu.HrmsFinal.entities.concretes;

import com.codeunlu.HrmsFinal.core.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name = "employers")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class Employer extends User {
    @Column(name = "company_name")
    @NotBlank
    @NotNull
    private String companyName;
    @Column(name = "telephone")
    @NotBlank
    @NotNull
    private String telephone;
    @Column(name = "web_site")
    @NotBlank
    @NotNull
    private String webURI;
    @Column(name = "is_verified")
    private boolean isVerified;

    @OneToMany(
            mappedBy = "employers",
            fetch = FetchType.LAZY
    )
    private List<JobAdvert> jobAdverts;
}
