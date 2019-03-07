package ru.ermakovn31.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import ru.ermakovn31.dao.repository.CompanyRepository;
import ru.ermakovn31.model.Company;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyRepository repository;

    @Override
    public List<Company> findAll() {
        return repository.findAll();
    }

    @Override
    public Company findById(Long id) {
        return repository.findById(id).orElse(new Company());
    }

    @Override
    public void save(Company company) {
        repository.save(company);
    }

    @Override
    public void remove(Company company) {
        repository.delete(company);
    }
}
