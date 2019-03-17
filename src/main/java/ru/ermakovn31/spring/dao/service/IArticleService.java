package ru.ermakovn31.spring.dao.service;

import ru.ermakovn31.spring.model.Article;
import ru.ermakovn31.spring.model.Category;

import java.util.List;
import java.util.Optional;

public interface IArticleService {

    List<Article> findAll();

    Optional<Article> findById(Long id);

    void save(Article article);

    void remove(Article article);

    List<Article> findByCategory(Category category);

    Article fetchFindById(Long id);

    List<Article> fetchFindAll();

    List<Article> fetchFindByCategory(Category category);
}
