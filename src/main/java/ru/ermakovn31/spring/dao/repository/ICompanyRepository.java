package ru.ermakovn31.spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ermakovn31.spring.model.Company;

public interface ICompanyRepository extends JpaRepository<Company, Long> {
}
