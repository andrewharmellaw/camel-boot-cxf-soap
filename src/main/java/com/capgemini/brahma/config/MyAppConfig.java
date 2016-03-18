package com.capgemini.brahma.config;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.capgemini.archaius.spring.ArchaiusBridgePropertyPlaceholderConfigurer;

@Configuration
@ImportResource("classpath:META-INF/spring/cxf-config.xml")
public class MyAppConfig {

    @Autowired
    CamelContext camelContext;

    @Bean
    CamelContextConfiguration contextConfiguration() {
        return new CamelContextConfiguration() {
            @Override
            public void beforeApplicationStart(CamelContext context) {
                System.out.println("your custom configuration goes here.");
            }
        };
    }

    @Bean
    public ArchaiusBridgePropertyPlaceholderConfigurer bridgePropertyPlaceholder() {

        ArchaiusBridgePropertyPlaceholderConfigurer configurer = new ArchaiusBridgePropertyPlaceholderConfigurer();

        configurer.setIgnoreResourceNotFound(true);
        configurer.setInitialDelayMillis(5000);
        configurer.setDelayMillis(5000);
        configurer.setIgnoreDeletesFromSource(true);
        Resource[] resources = new Resource[5];
        resources[0] = new FileSystemResource("config/camel.properties");
        resources[1] = new FileSystemResource("config/env.properties");
        resources[2] = new FileSystemResource("config/hystrix.properties");
        resources[3] = new FileSystemResource("config/metrics.properties");
        resources[4] = new FileSystemResource("config/application.properties");
        configurer.setLocations(resources);

        return configurer;
    }
    
    int loadOnStartup = 1;
    @Bean
    public ServletRegistrationBean cxfServlet(){
    	ServletRegistrationBean servlet = new ServletRegistrationBean(new CXFServlet(),"/services/");
    	servlet.setLoadOnStartup(loadOnStartup);
    	return servlet;
    }
}
