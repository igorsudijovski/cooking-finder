package com.cooking.finder.configuration;

import com.cooking.finder.repository.CookingFinderRepositoryMarkerScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by Igor on 15.10.2016.
 */
@Configuration
@ComponentScan(basePackageClasses = CookingFinderRepositoryMarkerScanner.class)
@Import(FlywayConfiguration.class)
public class SpringRepositoryTestConfiguration {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .build();
    }
}
