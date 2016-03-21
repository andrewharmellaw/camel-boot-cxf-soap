package com.capgemini.brahma.examples.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class ExampleCxfSoapRoute extends CxfSoapRouteBuilder {

	@Override
	public void configure() throws Exception {

		super.configure();

		from("cxf:bean:serviceEndpoint").to("log:info").process(new Processor() {
			@SuppressWarnings("unchecked")
			public void process(final Exchange exchange) throws Exception {
				exchange.getOut().setBody("THIS IS A CANNED RESPONSE PAYLOAD");
			}
		});
	}
}
