package com.example.internship.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "lessons")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "lesson_order")
    private int order;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;
}
