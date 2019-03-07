package ru.ermakovn31.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ermakovn31.dao.repository.ArticleRepository;
import ru.ermakovn31.model.Article;
import ru.ermakovn31.model.Category;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticleService implements IArticleService {

    @Autowired
    private ArticleRepository repository;

    @Override
    public List<Article> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Article article) {
        repository.save(article);
    }

    @Override
    public void remove(Article article) {
        repository.delete(article);
    }

    @Override
    public List<Article> findByCategory(Category category) {
        return repository.findByCategory(category);
    }

    @Override
    public Article fetchFindById(Long id) {
        return repository.fetchFindById(id);
    }

    @Override
    public Optional<Article> findById(Long id) {
        return repository.findById(id);
    }
}
