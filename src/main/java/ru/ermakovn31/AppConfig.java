package ru.ermakovn31;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("ru.ermakovn31")
@EnableJpaRepositories("ru.ermakovn31.dao.repository")
@EnableTransactionManagement
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

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            final DataSource dataSource,
            @Value("${hibernate.dialect}") final String dialect,
            @Value("${hibernate.show_sql}") final boolean showSql,
            @Value("${hibernate.hbm2ddl.auto}") final String hbm2ddl
    ) {
        final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setPackagesToScan("ru.ermakovn31.model");
        final Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", dialect);
        jpaProperties.put("hibernate.show_sql", showSql);
        jpaProperties.put("hibernate.hbm2ddl.auto", hbm2ddl);
        factoryBean.setJpaProperties(jpaProperties);
        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(
            final LocalContainerEntityManagerFactoryBean entityManagerFactory
    ) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
        return transactionManager;
    }
}
