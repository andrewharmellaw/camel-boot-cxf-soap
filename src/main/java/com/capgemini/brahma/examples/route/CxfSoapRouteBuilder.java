package com.capgemini.brahma.examples.route;

import org.apache.camel.builder.RouteBuilder;

/**
 * A Route Builder class for SOAP communication using CXF
 *
 * @author - Nikhil Vibhav
 */
public abstract class CxfSoapRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("cxf:bean:routerEndpoint")
                .to("cxf:bean:serviceEndpoint");
    }
}
