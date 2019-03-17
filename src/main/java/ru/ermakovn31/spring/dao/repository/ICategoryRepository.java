package ru.ermakovn31.spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ermakovn31.spring.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
