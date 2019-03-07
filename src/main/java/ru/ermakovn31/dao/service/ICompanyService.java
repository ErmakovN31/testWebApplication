package ru.ermakovn31.dao.service;

import ru.ermakovn31.model.Company;

import java.util.List;

public interface ICompanyService {

    List<Company> findAll();

    Company findById(Long id);

    void save(Company company);

    void remove(Company company);
}
