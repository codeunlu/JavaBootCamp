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
@Table(name = "images")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateResumes"})
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "image_url")
    @NotBlank
    @NotNull
    private String imageUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "image")
    private List<CandidateResume> candidateResumes;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
