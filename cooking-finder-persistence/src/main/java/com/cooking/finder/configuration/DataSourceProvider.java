package com.cooking.finder.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by Igor on 15.10.2016.
 */
@Configuration
@Import(PropertyPlaceholderProvider.class)
public class DataSourceProvider {

    @Value("${db.dataSource}")
    private String jndiName;

    public DataSourceProvider() { }

    @Bean
    public DataSource dataSource() throws NamingException {
        return (new JndiDataSourceLookup()).getDataSource(this.jndiName);
    }
}
