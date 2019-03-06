package ru.ermakovn31;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ru.ermakovn31.beans")
@PropertySource("classpath:mysql.properties")
public class AppConfig {

    @Bean
    public DataSource dataSource(
            @Value("${mysql.user}") final String username,
            @Value("${mysql.server}") final String url,
            @Value("${mysql.driver}") final String driverClassName
    ) {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword("");
        return dataSource;
    }


}
