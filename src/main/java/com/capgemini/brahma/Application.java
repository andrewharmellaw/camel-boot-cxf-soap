package com.capgemini.brahma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.camel.spring.boot.FatJarRouter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application extends FatJarRouter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

}