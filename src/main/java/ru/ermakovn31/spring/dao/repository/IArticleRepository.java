package ru.ermakovn31.spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ermakovn31.spring.model.Article;
import ru.ermakovn31.spring.model.Category;

import java.util.List;

@Repository
public interface IArticleRepository extends JpaRepository<Article, Long> {

    @Query("SELECT a FROM Article a WHERE a.category = :category")
    List<Article> findByCategory(@Param("category") Category category);

    @Query("SELECT a FROM Article a LEFT JOIN FETCH a.company LEFT JOIN FETCH a.category WHERE a.id = :id")
    Article fetchFindById(@Param("id") Long id);

    @Query("SELECT a FROM Article a LEFT JOIN FETCH a.company LEFT JOIN FETCH a.category WHERE a.category = :category")
    List<Article> fetchFindByCategory(@Param("category") Category category);
}
