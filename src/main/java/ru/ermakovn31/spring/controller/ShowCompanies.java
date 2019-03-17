package ru.ermakovn31.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ermakovn31.spring.dao.service.ICompanyService;
import ru.ermakovn31.spring.model.Company;

import java.util.List;

@Controller
public class ShowCompanies {

    @Autowired
    private ICompanyService companyService;

    @GetMapping("/showCompanies")
    public String getCompanies(final Model model) {
        final List<Company> companies = companyService.findAll();
        model.addAttribute("companies", companies);
        return "companies/showCompanies";
    }

    @GetMapping("/addCompany")
    public String addCompany(final Model model) {
        model.addAttribute("company", new Company());
        return "companies/createCompany";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") final Company company, final BindingResult result) {
        if (!result.hasErrors()) {
            Company savedCompany = companyService.findById(company.getId());
            savedCompany.setName(company.getName());
            savedCompany.setAddress(company.getAddress());
            savedCompany.setDescription(company.getDescription());
            companyService.save(savedCompany);
        }
        return "redirect:/showCompanies";
    }

    @GetMapping("/removeCompany/{id}")
    public String removeCompany(@PathVariable(value = "id") final Long id, final Model model) {
        final Company company = companyService.findById(id);
        companyService.remove(company);
        return "redirect:/showCompanies";
    }

    @GetMapping("/editCompany{id}")
    public String editCompany(@PathVariable(value = "id") final Long id, final Model model) {
        final Company company = companyService.findById(id);
        model.addAttribute("company", company);
        return "companies/createCompany";
    }
}
