package ru.ermakovn31.dao.service;

import ru.ermakovn31.model.Article;
import ru.ermakovn31.model.Category;

import java.util.List;
import java.util.Optional;

public interface IArticleService {

    List<Article> findAll();

    Optional<Article> findById(Long id);

    void save(Article article);

    void remove(Article article);

    List<Article> findByCategory(Category category);

    Article fetchFindById(Long id);
}
