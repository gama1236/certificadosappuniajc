package com.uniajc.smartcampus.certificados.controllers.security.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {
	
	@Bean(name = "DSLogin")
	@ConfigurationProperties(prefix="spring.seconddatasource")
	public DataSource primaryDataSource() {
	    return DataSourceBuilder.create().build();
	}										

	@Bean(name = "DSCertificados")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource secondaryDataSource() {
	    return DataSourceBuilder.create().build();
	}

	@Bean("jdbcLogin")
	public JdbcTemplate createJdbcTemplateLogin(@Autowired @Qualifier("DSLogin") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean("jdbcCertificados")
	public JdbcTemplate createJdbcTemplateRestriccion(@Autowired @Qualifier("DSCertificados") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

}