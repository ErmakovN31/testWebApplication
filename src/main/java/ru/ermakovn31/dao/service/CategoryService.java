package ru.ermakovn31.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ermakovn31.dao.repository.CategoryRepository;
import ru.ermakovn31.model.Category;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return repository.findById(id).orElse(new Category());
    }

    @Override
    public void save(Category category) {
        repository.save(category);
    }

    @Override
    public void remove(Category category) {
        repository.delete(category);
    }
}
