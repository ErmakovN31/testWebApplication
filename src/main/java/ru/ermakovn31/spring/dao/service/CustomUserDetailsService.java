package ru.ermakovn31.spring.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.ermakovn31.spring.model.Account;

import javax.transaction.Transactional;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IAccountService accountService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final Account account = accountService.fetchFindByLogin(s);
        if (account == null) throw new UsernameNotFoundException("User with this login doesn't exist");
        final User.UserBuilder builder = User.withUsername(account.getLogin());
        builder.password(account.getPassword());
        builder.roles(account.getRole().getName());
        return builder.build();
    }
}
