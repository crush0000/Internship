package com.example.internship.Controller;

import com.example.internship.Dto.CourseDto;
import com.example.internship.Service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Courses")
@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @ApiOperation(value = "Create a new course", notes = "This API creates a new course based on the provided data.")
    @PostMapping
    public CourseDto createCourse(
            @ApiParam(value = "Course data", required = true) @RequestBody CourseDto courseDto) {
        return courseService.createCourse(courseDto);
    }

}

