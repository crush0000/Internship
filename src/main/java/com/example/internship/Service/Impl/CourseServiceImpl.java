package com.example.internship.Service.Impl;

import lombok.extern.slf4j.Slf4j;
import com.example.internship.Dto.CourseDto;
import com.example.internship.Entity.Course;
import com.example.internship.Mapper.CourseMapper;
import com.example.internship.Repository.CourseRepository;
import com.example.internship.Service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;


    @Override
    public CourseDto createCourse(CourseDto dto) {

        log.info("Creating new course");
        log.debug("Course data: {}", dto);

        Course course = courseMapper.toEntity(dto);
        course.setCreatedTime(LocalDateTime.now());
        course.setUpdatedTime(LocalDateTime.now());

        Course savedCourse = courseRepository.save(course);

        return courseMapper.toDto(savedCourse);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto getCourseById(Long id) {
        return courseRepository.findById(id)
                .map(courseMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
