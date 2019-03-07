package ru.ermakovn31.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ermakovn31.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
