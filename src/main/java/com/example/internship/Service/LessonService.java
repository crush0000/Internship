package com.example.internship.Service;


import com.example.internship.Dto.LessonDto;

import java.util.List;

public interface LessonService {
    LessonDto createLesson(LessonDto dto);
    List<LessonDto> getAllLessons();
    LessonDto getLessonById(Long id);
    void deleteLesson(Long id);
}
