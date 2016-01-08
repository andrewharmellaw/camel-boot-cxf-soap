package com.capgemini.brahma.examples.route;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExampleCxfSoapRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

//        from("cxf:bean:subscriptionSOAPService")
//                .routeId(ExampleCxfSoapRoute.class.getSimpleName())
//                .onCompletion()
//                .log(LoggingLevel.INFO, "!!!!!!!!!!!!!!!!!" + ExampleCxfSoapRoute.class.getSimpleName() + " completed.")
//                .removeHeaders("*", Exchange.HTTP_RESPONSE_CODE)
//                .id("routeEnd")
//                .end()
//                .to("log:foo");
////                .choice()
////                    .when(header("soapOperationName").isEqualTo("GetStatus"))
////                        .to("direct:getSubscriptionStatus")
////                    .end()
////                .end();
    }
}
