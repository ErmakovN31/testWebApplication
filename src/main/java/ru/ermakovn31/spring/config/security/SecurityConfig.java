package ru.ermakovn31.spring.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/removeArticle/*").hasRole("admin")
                .antMatchers(HttpMethod.GET,"/editArticle*").hasRole("admin")
                .antMatchers(HttpMethod.GET,"/addArticle").hasAnyRole("user", "admin")
                .and().formLogin().loginProcessingUrl("/j_spring_security_check").loginPage("/login").defaultSuccessUrl("/")
                .failureUrl("/loginFailed").usernameParameter("login").passwordParameter("password").permitAll()
                .and().logout().logoutSuccessUrl("/");
    }


}
