package ru.ermakovn31.spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ermakovn31.spring.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT a FROM Role a WHERE a.name = :name")
    Role findByName(@Param("name") String name);

    Role getDefault();
}
