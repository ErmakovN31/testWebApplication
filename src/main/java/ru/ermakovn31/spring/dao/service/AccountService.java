package ru.ermakovn31.spring.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import ru.ermakovn31.spring.dao.repository.IAccountRepository;
import ru.ermakovn31.spring.model.Account;

import javax.transaction.Transactional;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    @Query("SELECT a FROM Account a WHERE a.login = :login")
    public Account findByLogin(String login) {
        return accountRepository.findByLogin(login);
    }

    @Override
    @Query("SELECT a FROM Account a WHERE a.email = :email")
    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    @Query("SELECT a FROM Account a WHERE a.login = :login AND a.password = :password")
    public Account findByLoginAndPassword(String login, String password) {
        return accountRepository.findByNameAndPassword(login, password);
    }

    @Override
    @Query("SELECT a FROM Account a LEFT JOIN FETCH a.role WHERE a.login=:login")
    public Account fetchFindByLogin(String login) {
        return accountRepository.fetchFindByLogin(login);
    }

    @Override
    @Transactional
    public <S extends Account> S save(S s) {
        return accountRepository.save(s);
    }

    @Override
    public void deleteById(Long aLong) {
        accountRepository.deleteById(aLong);
    }
}
