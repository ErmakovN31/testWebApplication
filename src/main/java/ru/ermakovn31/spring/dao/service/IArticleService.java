package ru.ermakovn31.spring.dao.service;

import org.springframework.security.access.prepost.PreAuthorize;
import ru.ermakovn31.spring.model.Article;
import ru.ermakovn31.spring.model.Category;

import java.util.List;
import java.util.Optional;

public interface IArticleService {

    List<Article> findAll();

    Optional<Article> findById(Long id);

    @PreAuthorize("hasAuthority('admin') or hasAuthority('user')")
    void save(Article article);

    @PreAuthorize("hasAuthority('admin')")
    void remove(Article article);

    List<Article> findByCategory(Category category);

    Article fetchFindById(Long id);

    List<Article> fetchFindAll();

    List<Article> fetchFindByCategory(Category category);
}
