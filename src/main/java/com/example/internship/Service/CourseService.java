package com.example.internship.Service;



import com.example.internship.Dto.CourseDto;

import java.util.List;

public interface CourseService {
    CourseDto createCourse(CourseDto dto);
    List<CourseDto> getAllCourses();
    CourseDto getCourseById(Long id);
    void deleteCourse(Long id);
}
