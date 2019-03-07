package ru.ermakovn31.dao.service;

import ru.ermakovn31.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void remove(Category category);
}
