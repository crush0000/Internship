package com.example.internship.Mapper;



import com.example.internship.Dto.ChapterDto;
import com.example.internship.Entity.Chapter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChapterMapper {
    @Mapping(source = "course.id", target = "courseId")
    ChapterDto toDto(Chapter chapter);

    @Mapping(source = "courseId", target = "course.id")
    Chapter toEntity(ChapterDto dto);
}
