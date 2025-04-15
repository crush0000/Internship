package com.example.internship.Dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDto {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}

