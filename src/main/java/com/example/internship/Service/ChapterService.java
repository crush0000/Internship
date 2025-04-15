package com.example.internship.Service;


import com.example.internship.Dto.ChapterDto;

import java.util.List;

public interface ChapterService {
    ChapterDto createChapter(ChapterDto dto);
    List<ChapterDto> getAllChapters();
    ChapterDto getChapterById(Long id);
    void deleteChapter(Long id);
}

