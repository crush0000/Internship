package com.example.internship.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="courses")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;


    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Chapter> chapters;

}
