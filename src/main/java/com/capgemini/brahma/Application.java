package com.capgemini.brahma;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.camel.spring.boot.FatJarRouter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableAutoConfiguration
public class Application extends FatJarRouter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

//    /**
//     * Registers CXF Servlet that handles the REST requests with the Spring context
//     *
//     * @return ServletRegistrationBean
//     */
//    @Bean
//    public ServletRegistrationBean CXFServletRegistrationBean() {
//        CXFServlet cxfServlet = new CXFServlet();
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(cxfServlet, "/subscriptions/*");
//        LOGGER.info("CXFServlet registered");
//        return servletRegistrationBean;
//    }
}