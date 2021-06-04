package com.codeunlu.HrmsFinal.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDto {
    private int id;
    private String employerName;
    private String jobPostions;
    private int quantity;
    private LocalDate releaseDate;
    private LocalDate deadlineDate;

}
