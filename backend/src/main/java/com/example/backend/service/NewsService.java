package com.example.backend.service;

import com.example.backend.dto.NewsDto;
import com.example.backend.mapper.NewsMapper;
import com.example.backend.repository.NewsRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;

    public List<NewsDto> getAllNews() {
        return newsRepository.findAll().stream()
            .map(newsMapper::newsToDto).collect(
                Collectors.toList());
    }

    public NewsDto saveNews(NewsDto groupDto) {
        return newsMapper.newsToDto(
            newsRepository.save(newsMapper.dtoToNews(groupDto)));
    }

    public NewsDto updateNews(NewsDto groupDto) {
        return newsMapper.newsToDto(
            newsRepository.save(newsMapper.dtoToNews(groupDto)));
    }

    public void deleteNewsById(Long newsId) {
        newsRepository.deleteById(newsId);
    }
}
