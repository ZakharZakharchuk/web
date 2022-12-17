package com.example.backend.repository;

import com.example.backend.entity.News;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {

    List<News> findAll();

    News save(News news);

    void deleteById(Long newsId);
}
