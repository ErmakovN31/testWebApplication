package ru.ermakovn31.spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ermakovn31.spring.model.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT a FROM Account a WHERE a.login = :login")
    Account findByLogin(@Param("login") String login);

    @Query("SELECT a FROM Account a WHERE a.login = :login AND a.password = :password")
    Account findByNameAndPassword(@Param("login") String login,
                                  @Param("password") String password);

    @Query("SELECT a FROM Account a WHERE a.email = :email")
    Account findByEmail(@Param("email") String email);

    @Query("SELECT a FROM Account a LEFT JOIN FETCH a.role WHERE a.login=:login")
    Account fetchFindByLogin(@Param("login") String login);
}
