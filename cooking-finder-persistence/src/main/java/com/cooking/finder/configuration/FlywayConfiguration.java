package com.cooking.finder.configuration;

import com.cooking.finder.services.CookingFinderServicesMarkerScanner;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 * Created by Igor on 15.10.2016.
 */
@Configuration
@ComponentScan(basePackageClasses = CookingFinderServicesMarkerScanner.class)
@Import(DataSourceProvider.class)
public class FlywayConfiguration {
    
    @Autowired
    private DataSource dataSource;

    private static final String[] DEFAULT_MIGRATION_PACKAGES = {
            "classpath:db/migration"
    };

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        Flyway flyway = new Flyway();
        flyway.setValidateOnMigrate(false);
        flyway.setBaselineOnMigrate(true);
        flyway.setLocations(DEFAULT_MIGRATION_PACKAGES);
        flyway.setDataSource(dataSource);
        return flyway;
    }
    
    
}
