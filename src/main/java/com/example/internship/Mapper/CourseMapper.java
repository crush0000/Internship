package com.example.internship.Mapper;



import com.example.internship.Dto.CourseDto;
import com.example.internship.Entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDto toDto(Course course);
    Course toEntity(CourseDto dto);
}
