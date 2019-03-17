package ru.ermakovn31.spring.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ermakovn31.spring.dao.repository.ICategoryRepository;
import ru.ermakovn31.spring.model.Category;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return repository.findById(id).orElse(new Category());
    }

    @Override
    @Transactional
    public void save(Category category) {
        repository.save(category);
    }

    @Override
    @Transactional
    public void remove(Category category) {
        repository.delete(category);
    }
}
