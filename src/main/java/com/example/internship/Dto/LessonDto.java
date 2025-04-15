package com.example.internship.Dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonDto {
    private Long id;
    private String name;
    private String description;
    private String content;
    private int order;
    private Long chapterId;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
