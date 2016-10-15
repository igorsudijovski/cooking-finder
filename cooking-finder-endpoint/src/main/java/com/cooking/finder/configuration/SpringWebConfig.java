package com.cooking.finder.configuration;

import com.cooking.finder.endpoint.CookingFinderEndPointMarkerScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Igor on 14.10.2016.
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = CookingFinderEndPointMarkerScanner.class)
@Import(FlywayConfiguration.class)
public class SpringWebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

}
