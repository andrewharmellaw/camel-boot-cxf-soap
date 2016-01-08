package com.capgemini.brahma.examples.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExampleNettyRoute extends RouteBuilder {

    /**
     * Test this by running the app (e.g. ./gradlew bootRun) and hitting http://localhost:18080)
     * @throws Exception
     */
    @Override
    public void configure() throws Exception {

        from("netty4-http:http://0.0.0.0:18080"). // TODO: load this from properties, the hostname and the port (then use in tests)
                setBody().simple("helloWorld");
    }

}
