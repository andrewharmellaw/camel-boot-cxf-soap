package com.capgemini.brahma.examples.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class ExampleRestDslRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        // TODO: this should be loaded from config
        Integer port = Integer.parseInt((System.getenv("PORT") != null ? System.getenv("PORT") : "10000"));

        restConfiguration()
                .component("netty4-http")
                .bindingMode(RestBindingMode.json)
                .dataFormatProperty("prettyPrint", "true")
                .host("0.0.0.0")
                .contextPath("/rest")
                .port(port)
                .apiContextPath("/api-doc")
                .apiProperty("api.title", "User API")
                .apiProperty("api.version", "1.2.3")
                .apiProperty("cors", "true");

        rest("/hello").description("Say hello.")
                .produces("application/json")
                .get().description("Get hello.").route().transform(constant("BOOOOOOOM!!!!!"));

    }
}
