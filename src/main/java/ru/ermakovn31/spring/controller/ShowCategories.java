package ru.ermakovn31.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.ermakovn31.spring.dao.service.ICategoryService;
import ru.ermakovn31.spring.model.Category;

import java.util.List;

@Controller
public class ShowCategories {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/showCategories")
    public String getCategories(final Model model) {
        final List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "categories/showCategories";
    }
}
