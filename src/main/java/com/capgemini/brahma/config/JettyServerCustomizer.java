package com.capgemini.brahma.config;

import ch.qos.logback.access.jetty.RequestLogImpl;
import com.netflix.config.DynamicPropertyFactory;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class for customizing jetty container and getting access logs based on existing logback-access.xml
 *
 * @author Amit Salvi
 * @author Az Madujibeya
 */
@Configuration
public class JettyServerCustomizer {

    private static final String ACCESS_LOG_FILE_PATH = "config/logback-access.xml";

    private static final Logger LOGGER = LoggerFactory.getLogger(JettyServerCustomizer.class);

    @Bean
    public EmbeddedServletContainerFactory jettyConfigBean() {

        DynamicPropertyFactory propertyFactory = DynamicPropertyFactory.getInstance();
        final String accessLogFilePath = propertyFactory.getStringProperty("server.accessLog.config.file", ACCESS_LOG_FILE_PATH).getValue();

        JettyEmbeddedServletContainerFactory jettyEmbeddedServletContainerFactory
                = new JettyEmbeddedServletContainerFactory();
        jettyEmbeddedServletContainerFactory.addServerCustomizers(new org.springframework.boot.context.embedded.jetty.JettyServerCustomizer() {
            public void customize(Server server) {
                HandlerCollection handlers = new HandlerCollection();
                for (Handler handler : server.getHandlers()) {
                    handlers.addHandler(handler);
                }
                RequestLogHandler requestLogHandler = new RequestLogHandler();
                RequestLogImpl requestLogImpl = new RequestLogImpl();
                requestLogImpl.setFileName(accessLogFilePath);
                requestLogHandler.setRequestLog(requestLogImpl);
                handlers.addHandler(requestLogHandler);
                server.setHandler(handlers);
                LOGGER.info("Jetty Server Customized. Access Log Configuration File - {}", accessLogFilePath);
            }
        });
        return jettyEmbeddedServletContainerFactory;
    }
}
