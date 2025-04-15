package com.example.internship.Controller;


import com.example.internship.Dto.LessonDto;
import com.example.internship.Service.LessonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Lessons")
@RestController
@RequestMapping("/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @ApiOperation(value = "Create a new lesson", notes = "This API creates a new lesson for a given chapter.")
    @PostMapping
    public LessonDto createLesson(
            @ApiParam(value = "Lesson data", required = true) @RequestBody LessonDto lessonDto) {
        return lessonService.createLesson(lessonDto);
    }


}
