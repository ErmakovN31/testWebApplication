package ru.ermakovn31.spring.dao.service;

import ru.ermakovn31.spring.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void remove(Category category);
}
