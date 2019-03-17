package ru.ermakovn31.spring.dao.service;

import ru.ermakovn31.spring.model.Company;

import java.util.List;

public interface ICompanyService {

    List<Company> findAll();

    Company findById(Long id);

    void save(Company company);

    void remove(Company company);
}
