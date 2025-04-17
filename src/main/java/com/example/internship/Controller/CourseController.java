package com.example.internship.Controller;

import com.example.internship.Dto.CourseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
@Tag(name = "Courses", description = "Управление курсами")
public class CourseController {

    @PostMapping
    @Operation(summary = "Создать курс", description = "Создает новый курс и возвращает его DTO")
    public CourseDto createCourse(@RequestBody CourseDto dto) {
        // логика создания курса
        return dto;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить курс по ID", description = "Возвращает курс по его ID")
    public CourseDto getCourse(@PathVariable Long id) {
        // логика получения курса
        return new CourseDto();
    }
}
