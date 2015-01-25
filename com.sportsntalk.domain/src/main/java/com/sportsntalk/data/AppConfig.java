package com.sportsntalk.data;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

/**
 * Provides bean definitions for a spring application.
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:app-config.properties")
@ComponentScan(basePackages = { "com.sportsntalk.data", "com.sportsntalk.services" })
@EnableJpaRepositories(basePackages = { "com.sportsntalk.repositories" })
public class AppConfig
{
	@Resource
	private Environment _environment;

	/**
	 * Configure the datasource.
	 *
	 * @see https://github.com/brettwooldridge/HikariCP for more info.
	 * @return DataSource
	 */
	@Bean(destroyMethod = "close")
	public DataSource dataSource()
	{
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
		dataSource.setJdbcUrl(_environment.getRequiredProperty("dataSource.url"));
		dataSource.setUsername(_environment.getRequiredProperty("dataSource.username"));
		dataSource.setPassword(_environment.getRequiredProperty("dataSource.password"));
		return dataSource;
	}

	/**
	 * Configure the entity manager factory.
	 *
	 * @param dataSource - the datasource (bean)
	 * @return LocalContainerEntityManagerFactoryBean
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource)
	{
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setPackagesToScan("com.sportsntalk.entities");
		factory.setPersistenceUnitName("persistenceUnit");
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factory.setJpaDialect(new HibernateJpaDialect());
		factory.setDataSource(dataSource);

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", _environment.getRequiredProperty("hibernate.dialect"));
		jpaProperties.put("hibernate.show_sql", _environment.getRequiredProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.format_sql", _environment.getRequiredProperty("hibernate.format_sql"));
		jpaProperties.put("hibernate.ejb.naming_strategy", _environment.getRequiredProperty("hibernate.ejb.naming_strategy"));
		factory.setJpaProperties(jpaProperties);

		return factory;
	}

	/**
	 * Configure the transaction manager.
	 *
	 * @param factory - the entity manager factory (bean)
	 * @param dataSource - the datasource (bean)
	 * @return JpaTransactionManager
	 */
	@Bean
	public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean factory, DataSource dataSource)
	{
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(factory.getObject());
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}

	/**
	 * Configure exception translation bean.
	 *
	 * @return PersistenceExceptionTranslationPostProcessor
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation()
	{
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
