package com.capgemini.brahma.examples.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExampleCxfSoapRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        // TODO: Pull this bit into an abstract superclass - a CxfSoapRouteBuilder class
        from("cxf:bean:routerEndpoint")
                .to("cxf:bean:serviceEndpoint");

        from("cxf:bean:serviceEndpoint")
                .to("log:info")
                .process(new Processor() {
                    @SuppressWarnings("unchecked")
                    public void process(final Exchange exchange) throws Exception {
                        exchange.getOut().setBody("THIS IS A CANNED RESPONSE PAYLOAD");
                    }
                });

    }
}
