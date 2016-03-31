package com.capgemini.brahma;

import org.apache.camel.spring.boot.FatJarRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.capgemini.brahma.config.JettyServerCustomizer;
import com.capgemini.camel.metrics.publisher.configuration.MetricsServletConfiguration;

@Import({MetricsServletConfiguration.class,JettyServerCustomizer.class})
@SpringBootApplication
public class Application extends FatJarRouter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

}