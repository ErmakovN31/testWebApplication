package ru.ermakovn31.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.ermakovn31.spring.dao.service.IArticleService;
import ru.ermakovn31.spring.dao.service.ICategoryService;
import ru.ermakovn31.spring.dao.service.ICompanyService;
import ru.ermakovn31.spring.model.Article;
import ru.ermakovn31.spring.model.Category;
import ru.ermakovn31.spring.model.Company;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
public class ShowArticles {

    @Autowired
    private MessageSource messageSource;

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
//        model.addAttribute("link", "showArticles");
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

    @GetMapping("/saveArticle")
    public String getSaveArticle() {
        return "redirect:/addArticle";
    }

    @PostMapping("/saveArticle")
    public String saveArticle(final Model model,
                              @ModelAttribute("article") @Valid final Article article,
                              final BindingResult result,
                              @Param("companyId") final Long companyId,
                              @Param("categoryId") final Long categoryId,
                              final Locale locale,
                              final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            final Company company = new Company();
            company.setId(companyId);
            final Category category = new Category();
            category.setId(categoryId);
            article.setCompany(company);
            article.setCategory(category);
            model.addAttribute("article", article);
            model.addAttribute("companies", companyService.findAll());
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("message",
                    messageSource.getMessage("article_create_fail", new Object[]{}, locale));
            return "articles/createArticle";
        }
        final Article savedArticle = articleService.findById(article.getId()).orElse(new Article());
        final Company company = companyService.findById(companyId);
        final Category category = categoryService.findById(categoryId);

        savedArticle.setName(article.getName());
        savedArticle.setContent(article.getContent());
        savedArticle.setPhone(article.getPhone());
        savedArticle.setCompany(company);
        savedArticle.setCategory(category);
        articleService.save(savedArticle);
        redirectAttributes.addFlashAttribute("message",
                messageSource.getMessage("article_create_success", new Object[]{}, locale));
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
