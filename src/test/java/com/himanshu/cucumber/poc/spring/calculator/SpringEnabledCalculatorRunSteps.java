package com.himanshu.cucumber.poc.spring.calculator;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.himanshu.poc.cucumber.poc.calculator.Calculator;
import com.himanshu.poc.cucumber.poc.spring.SpringBeansConfig;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes={SpringBeansConfig.class})
public class SpringEnabledCalculatorRunSteps {
  
  private int total;
  
  @Autowired
  private Calculator calculator;
  private static Logger logger = LoggerFactory.getLogger(SpringEnabledCalculatorRunSteps.class);
  
  @Before
  private void init() {
    total = -999;
    
  }
  
  @Given("^I have a calculator$")
  public void i_have_a_calculator() throws Throwable {
    logger.info("Injected via spring, no need to initialise here.");
  }

  @When("^I add (-?\\d+) and (-?\\d+)$")
  public void i_add_and(int num1, int num2) throws Throwable {
    total = calculator.add(num1, num2);
  }

  @Then("^the result should be (-?\\d+)$")
  public void the_result_should_be(int result) throws Throwable {
    Assert.assertThat(total, Matchers.equalTo(result));
  }


}
