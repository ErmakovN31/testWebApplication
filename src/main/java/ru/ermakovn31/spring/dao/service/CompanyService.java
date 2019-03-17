package ru.ermakovn31.spring.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ermakovn31.spring.dao.repository.ICompanyRepository;
import ru.ermakovn31.spring.model.Company;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private ICompanyRepository repository;

    @Override
    public List<Company> findAll() {
        return repository.findAll();
    }

    @Override
    public Company findById(Long id) {
        return repository.findById(id).orElse(new Company());
    }

    @Override
    @Transactional
    public void save(Company company) {
        repository.save(company);
    }

    @Override
    @Transactional
    public void remove(Company company) {
        repository.delete(company);
    }
}
