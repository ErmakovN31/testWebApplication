package ru.ermakovn31.spring.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import ru.ermakovn31.spring.dao.repository.IArticleRepository;
import ru.ermakovn31.spring.model.Article;
import ru.ermakovn31.spring.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements IArticleService {

    @Autowired
    private IArticleRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Article> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void save(Article article) {
        repository.save(article);
    }

    @Override
    @Transactional
    public void remove(Article article) {
        repository.delete(article);
    }

    @Override
    @Query("SELECT a FROM Article a WHERE a.category = :category")
    public List<Article> findByCategory(Category category) {
        return repository.findByCategory(category);
    }

    @Query("SELECT a FROM Article a LEFT JOIN FETCH a.company LEFT JOIN FETCH a.category WHERE a.id = :id")
    @Override
    public Article fetchFindById(Long id) {
        return repository.fetchFindById(id);
    }

    @Override
    public List<Article> fetchFindAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Article> criteriaQuery = cb.createQuery(Article.class);
        Root<Article> article = criteriaQuery.from(Article.class);
        article.fetch("company");
        article.fetch("category");
        criteriaQuery.select(article);
        TypedQuery<Article> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public Optional<Article> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Query("SELECT a FROM Article a LEFT JOIN FETCH a.company LEFT JOIN FETCH a.category WHERE a.category = :category")
    public List<Article> fetchFindByCategory(Category category) {
        return repository.fetchFindByCategory(category);
    }
}
