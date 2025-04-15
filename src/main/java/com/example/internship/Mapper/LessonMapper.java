package com.example.internship.Mapper;



import com.example.internship.Dto.LessonDto;
import com.example.internship.Entity.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    @Mapping(source = "chapter.id", target = "chapterId")
    LessonDto toDto(Lesson lesson);

    @Mapping(source = "chapterId", target = "chapter.id")
    Lesson toEntity(LessonDto dto);
}

