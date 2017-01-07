package com.himanshu.cucumber.poc.spring.calculator;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features={"classpath:features/calculator.feature"}
    , plugin = { "pretty", "json:target/reports/json/spring-enabled-calculator.json" }
    , glue = {"com.himanshu.cucumber.poc.spring.calculator"}
    , monochrome = true
)
public class SpringEnabledCalculatorTest {
}
