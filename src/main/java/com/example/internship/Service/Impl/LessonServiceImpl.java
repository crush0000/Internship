package com.example.internship.Service.Impl;



import com.example.internship.Dto.LessonDto;
import com.example.internship.Entity.Lesson;
import com.example.internship.Mapper.LessonMapper;
import com.example.internship.Repository.LessonRepository;
import com.example.internship.Service.LessonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    @Override
    public LessonDto createLesson(LessonDto dto) {

        log.info("Creating new lesson");
        log.debug("Lesson data: {}", dto);
        Lesson lesson = lessonMapper.toEntity(dto);
        lesson.setCreatedTime(LocalDateTime.now());
        lesson.setUpdatedTime(LocalDateTime.now());
        Lesson savedLesson = lessonRepository.save(lesson);
        return lessonMapper.toDto(savedLesson);
    }

    @Override
    public List<LessonDto> getAllLessons() {
        return lessonRepository.findAll().stream()
                .map(lessonMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LessonDto getLessonById(Long id) {
        return lessonRepository.findById(id)
                .map(lessonMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
    }

    @Override
    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }
}
