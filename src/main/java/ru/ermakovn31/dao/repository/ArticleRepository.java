package ru.ermakovn31.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ermakovn31.model.Article;
import ru.ermakovn31.model.Category;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("SELECT a FROM Article a WHERE a.category = :category")
    List<Article> findByCategory(@Param("category") Category category);

    @Query("SELECT a FROM Article a LEFT JOIN FETCH a.company WHERE a.id = :id")
    Article fetchFindById(@Param("id") Long id);
}
