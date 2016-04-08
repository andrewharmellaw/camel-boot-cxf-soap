package com.capgemini.brahma;

import com.capgemini.jetty.logger.JettyServerCustomizer;
import com.capgemini.camel.metrics.publisher.configuration.MetricsServletConfiguration;

import org.apache.camel.spring.boot.FatJarRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.camel.spring.boot.FatJarRouter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({MetricsServletConfiguration.class,JettyServerCustomizer.class})
@SpringBootApplication
public class Application extends FatJarRouter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}