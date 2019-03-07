package ru.ermakovn31.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ermakovn31.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}