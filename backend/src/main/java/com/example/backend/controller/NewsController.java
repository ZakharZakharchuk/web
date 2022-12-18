package com.example.backend.controller;

import com.example.backend.dto.NewsDto;
import com.example.backend.service.impl.NewsServiceImpl;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
@AllArgsConstructor
public class NewsController {
    private final NewsServiceImpl newsService;

    @GetMapping("/getAll")
    public List<NewsDto> getAllGroups() {
        return newsService.getAllNews();
    }

    @PostMapping("/save")
    public NewsDto saveGroup(@RequestBody NewsDto newsDto) {
        return newsService.saveNews(newsDto);
    }

    @PostMapping("/update")
    public NewsDto updateGroup(@RequestBody NewsDto newsDto) {
        return newsService.updateNews(newsDto);
    }

    @PostMapping("/delete")
    public void deleteGroup(@RequestBody Long newsId) {
        newsService.deleteNewsById(newsId);
    }
}
