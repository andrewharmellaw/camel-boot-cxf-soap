package com.capgemini.brahma.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for publishing Hystrix metrics.
 *
 * @author Ganga Aloori
 *
 * TODO: MOVE THIS OUT TO A DEPENDENCY AND SPRING-IMPORT IT EXPLICITLY IN Application.java?
 */
@Configuration
public class HystrixMetricsStreamServletConfig {

    @Value("${hystrix.metrics.servlet.url:/hystrix.stream}")
    private String hystrixServletUrlMapping;

    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixMetricsStreamServletConfig.class);

    /**
     * Registers Hystrix Metrics Servlet with Spring application context.
     *
     * @return the Servlet registration bean for Hystrix Metrics servlet.
     */
    @Bean
    public ServletRegistrationBean hystrixServletRegistration() {

        final HystrixMetricsStreamServlet hystrixMetricsServlet = new HystrixMetricsStreamServlet();
        final ServletRegistrationBean servletRegistration = new ServletRegistrationBean(hystrixMetricsServlet);
        servletRegistration.addUrlMappings(hystrixServletUrlMapping);

        LOGGER.info("Hystrix Metrics Stream Servlet Registered");

        return servletRegistration;
    }

}
