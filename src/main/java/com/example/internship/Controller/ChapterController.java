package com.example.internship.Controller;



import com.example.internship.Dto.ChapterDto;
import com.example.internship.Service.ChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Chapters")
@RestController
@RequestMapping("/chapters")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @ApiOperation(value = "Create a new chapter", notes = "This API creates a new chapter for a given course.")
    @PostMapping
    public ChapterDto createChapter(
            @ApiParam(value = "Chapter data", required = true) @RequestBody ChapterDto chapterDto) {
        return chapterService.createChapter(chapterDto);
    }

    // Добавьте другие методы для обновления, получения и удаления глав
}
