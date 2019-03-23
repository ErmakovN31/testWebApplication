package ru.ermakovn31.spring.dao.service;

import ru.ermakovn31.spring.model.Account;

public interface IAccountService {

    Account findByLogin(String login);

    Account findByEmail(String email);

    Account findByLoginAndPassword(String login, String password);

    <S extends Account> S save(S account);

    void deleteById(Long id);

    Account fetchFindByLogin(String login);
}
