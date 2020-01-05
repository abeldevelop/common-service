package com.abeldevelop.architecture.services.common.integration;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        plugin = {
                "progress",
                "json:target/cucumber-report.json"
        },
        glue = {
                "com.abeldevelop.architecture.library.test.integration.cucumber",
                "com.abeldevelop.architecture.services.common.integration"
        }
)
public class CucumberTest {

}
