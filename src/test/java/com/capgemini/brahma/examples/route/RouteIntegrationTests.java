package com.capgemini.brahma.examples.route;

import com.capgemini.brahma.Application;
import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class RouteIntegrationTests {

    @Before
    public void setUp() throws Exception {
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void soapHandCrankedTest() throws Exception {
        RestAssured.port = 9003;  // TODO  : this should be loaded from config
        when().post("/CamelContext/RouterPort").then().body(equalTo("<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body><soap:Fault><faultcode>soap:Client</faultcode><faultstring>Error reading XMLStreamReader: Unexpected EOF in prolog\n" +
                " at [row,col {unknown-source}]: [1,0]</faultstring></soap:Fault></soap:Body></soap:Envelope>"));
    }
}
