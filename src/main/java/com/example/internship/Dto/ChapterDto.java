package com.example.internship.Dto;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChapterDto {
    private Long id;
    private String name;
    private String description;
    private int order;
    private Long courseId;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}

