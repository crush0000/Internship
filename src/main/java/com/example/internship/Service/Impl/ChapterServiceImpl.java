package com.example.internship.Service.Impl;



import com.example.internship.Dto.ChapterDto;
import com.example.internship.Entity.Chapter;
import com.example.internship.Mapper.ChapterMapper;
import com.example.internship.Repository.ChapterRepository;
import com.example.internship.Service.ChapterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
@RequiredArgsConstructor
public class ChapterServiceImpl implements ChapterService {

    private final ChapterRepository chapterRepository;
    private final ChapterMapper chapterMapper;

    @Override
    public ChapterDto createChapter(ChapterDto dto) {
        log.info("Creating new chapter");
        log.debug("Chapter data: {}", dto);

        Chapter chapter = chapterMapper.toEntity(dto);
        chapter.setCreatedTime(LocalDateTime.now());
        chapter.setUpdatedTime(LocalDateTime.now());
        Chapter savedChapter = chapterRepository.save(chapter);
        return chapterMapper.toDto(savedChapter);
    }

    @Override
    public List<ChapterDto> getAllChapters() {
        return chapterRepository.findAll().stream()
                .map(chapterMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ChapterDto getChapterById(Long id) {
        return chapterRepository.findById(id)
                .map(chapterMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Chapter not found"));
    }

    @Override
    public void deleteChapter(Long id) {
        chapterRepository.deleteById(id);
    }
}
