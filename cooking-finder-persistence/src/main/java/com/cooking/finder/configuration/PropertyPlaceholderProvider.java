package com.cooking.finder.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Igor on 15.10.2016.
 */
@Configuration
@Slf4j
public class PropertyPlaceholderProvider {

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        Properties props = null;
        try {
            File configDir = new File(System.getProperty("catalina.base"), "conf");
            File configFile = new File(configDir, "context.xml");
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();

            Document doc = dBuilder.parse(configFile);
            NodeList nList = doc.getElementsByTagName("Parameter");
            props = new Properties();
            for (int i = 0; i < nList.getLength(); i++) {
                Element el = (Element) nList.item(i);
                String name = el.getAttribute("name");
                String value = el.getAttribute("value");
                props.put(name, value);
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }


        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        ClassPathResource[] resources = new ClassPathResource[] {
                new ClassPathResource("application.properties"),
        };
        if (props != null && props.size() > 0) {
            configurer.setProperties(props);
        }
        configurer.setLocations(resources);
        configurer.setIgnoreResourceNotFound(true);
        return configurer;
    }

}
