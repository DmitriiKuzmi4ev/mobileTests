package helpers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.basic;

import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

public class RestAssuredSpec {
    private static final BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);

    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .log(io.restassured.filter.log.LogDetail.ALL)
                .addFilter(withCustomTemplates())
                .setAuth(basic(config.username(), config.accessKey()))
                .build();
    }
}