package ru.ermakovn31.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ermakovn31.spring.dao.service.IArticleService;
import ru.ermakovn31.spring.dao.service.ICategoryService;
import ru.ermakovn31.spring.dao.service.ICompanyService;
import ru.ermakovn31.spring.model.Article;
import ru.ermakovn31.spring.model.Category;
import ru.ermakovn31.spring.model.Company;

import java.util.List;

@Controller
public class ShowArticles {

    @Autowired
    private IArticleService articleService;

    @Autowired
    private ICompanyService companyService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/showArticles")
    public String getArticles(final Model model) {
        final List<Article> articles = articleService.fetchFindAll();
        model.addAttribute("articles", articles);
        return "articles/showArticles";
    }

    @GetMapping("/showArticles-{category}")
    public String getByCategory(@PathVariable("category") final Long category, final Model model) {
        final Category cat = categoryService.findById(category);
        final List<Article> articles = articleService.fetchFindByCategory(cat);
        model.addAttribute("articles", articles);
        return "articles/showArticles";
    }

    @GetMapping("/addArticle")
    public String addArticle(final Model model) {
        model.addAttribute("article", new Article());
        model.addAttribute("companies", companyService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "articles/createArticle";
    }

    @PostMapping("/saveArticle")
    public String saveArticle(@ModelAttribute("article") final Article article,
                              @Param("company_id") final Long company_id,
                              @Param("category_id") final Long category_id,
                              final BindingResult result) {
        if (!result.hasErrors()) {
            Article savedArticle = articleService.findById(article.getId()).orElse(new Article());
            Company company = companyService.findById(company_id);
            Category category = categoryService.findById(category_id);

            savedArticle.setName(article.getName());
            savedArticle.setContent(article.getContent());
            savedArticle.setPhone(article.getPhone());
            savedArticle.setCompany(company);
            savedArticle.setCategory(category);
            articleService.save(savedArticle);
        }
        return "redirect:/showArticles";
    }

    @GetMapping("/removeArticle/{id}")
    public String removeArticle(@PathVariable(value = "id") final Long id, final Model model) {
        articleService.findById(id).ifPresent(article -> articleService.remove(article));
        return "redirect:/showArticles";
    }

    @GetMapping("/editArticle{id}")
    public String editCompany(@PathVariable(value = "id") final Long id, final Model model) {
        model.addAttribute("article", articleService.fetchFindById(id));
        model.addAttribute("companies", companyService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "articles/createArticle";
    }
}
